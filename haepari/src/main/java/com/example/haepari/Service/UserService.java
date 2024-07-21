package com.example.haepari.Service;

import com.example.haepari.Entity.AvailableTime;
import com.example.haepari.Entity.User;
import com.example.haepari.Repository.AvailableTimeRepository;
import com.example.haepari.Repository.UserRepository;
import com.example.haepari.dto.JoinDto;
import com.example.haepari.dto.LoginDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    public int login(LoginDto loginDto){
        Boolean user = userRepository.existsByUsername(loginDto.getUsername());
        int status;
        if(user!=true){
            status=0;
            return status;
        }
        else{
            status = 1;
            return status;
        }
    }

    public String join(JoinDto joinDto){
        if (joinDto.getUsername() == null || joinDto.getUsername().isEmpty() ||
                joinDto.getPassword() == null || joinDto.getPassword().isEmpty() ||
                joinDto.getNickname() == null || joinDto.getNickname().isEmpty() ||
                joinDto.getPhone() == null || joinDto.getPhone().isEmpty()) {
            return "모두 입력하세요";
        }
        if (userRepository.existsByUsername(joinDto.getUsername())) {
            return "중복된 아이디입니다";
        }



        User user = new User();
        user.setUsername(joinDto.getUsername());
        user.setPassword(joinDto.getPassword());
        user.setNickname(joinDto.getNickname());
        user.setPhone(joinDto.getPhone());
        userRepository.save(user);
        for(String day: joinDto.getTimeTable().keySet()){
            AvailableTime availableTime = new AvailableTime();
            List<Integer> times = joinDto.getTimeTable().get(day);
            String availableTimeStr = convertTimesToString(times);
            availableTime.setUser(user);
            availableTime.setDay(day);
            availableTime.setAvailable_time(availableTimeStr);

            availableTimeRepository.save(availableTime);
        }


        return "가입 성공";

    }

    private static String convertTimesToString(List<Integer> times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.size(); i += 2) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(times.get(i) + ":00~" + times.get(i + 1) + ":00");
        }
        return sb.toString();
    }

}
