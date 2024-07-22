package com.example.haepari.Service;

import com.example.haepari.Entity.AvailableTime;
import com.example.haepari.Entity.Request;
import com.example.haepari.Entity.User;
import com.example.haepari.Repository.AvailableTimeRepository;
import com.example.haepari.Repository.RequestRepository;
import com.example.haepari.Repository.UserRepository;
import com.example.haepari.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");


    public int saveRequest(RequestDto dto,String username){
        Request request = new Request();
        User user = userRepository.findByUsername(username);
        request.setUser(user);
        request.setStore_address(dto.getStore_address());
        request.setDestination_address(dto.getDestination_address());
        request.set_subscribed(user.getIs_subscribed());
        request.setEnd_time(dto.getEnd_time());
        request.setDestination_time(dto.getDestination_time());
        request.setItem_price(dto.getItem_price());
        request.setDelivery_fee(dto.getDelivery_fee());
        request.setMenu(dto.getMenu());
        request.setContent(dto.getContent());

        requestRepository.save(request);

        return 1;
    }

    public List<Request> getRequestsInAvailableTime(String username) {

        User user = userRepository.findByUsername(username);
        List<Request> allRequests = requestRepository.findAllByUser(user);
        List<AvailableTime> availableTimes = availableTimeRepository.findAllByUser(user);

        List<Request> matchingRequests = new ArrayList<>();
        for (Request request : allRequests) {
            LocalDateTime destinationTime = request.getDestination_time().toLocalDateTime();
            DayOfWeek dayOfWeek = destinationTime.getDayOfWeek();
            String dayString = getDayString(dayOfWeek);
            String destinationTimeString = destinationTime.format(TIME_FORMATTER);

            for (AvailableTime availableTime : availableTimes) {
                if (availableTime.getDay().equals(dayString) &&
                        isTimeInRange(destinationTimeString, availableTime.getAvailable_time())) {
                    matchingRequests.add(request);
                    break;
                }
            }
        }

        return matchingRequests;
    }

    private String getDayString(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "mon";
            case TUESDAY:
                return "tue";
            case WEDNESDAY:
                return "wed";
            case THURSDAY:
                return "thu";
            case FRIDAY:
                return "fri";
            case SATURDAY:
                return "sat";
            case SUNDAY:
                return "sun";
            default:
                throw new IllegalArgumentException("Invalid DayOfWeek: " + dayOfWeek);
        }
    }

    private boolean isTimeInRange(String time, String availableTime) {
        String[] timeRanges = availableTime.split(",");
        for (String range : timeRanges) {
            String[] times = range.split("~");
            if (times.length == 2) {
                String startTime = times[0].trim();
                String endTime = times[1].trim();
                if (time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
