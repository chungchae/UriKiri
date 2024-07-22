package com.example.haepari.Controller;

import com.example.haepari.Entity.Request;
import com.example.haepari.Service.RequestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryListController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/delivery/list")
    public ResponseEntity<List> requestList(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        List<Request>  requestList = requestService.getRequestsInAvailableTime(username);

        return ResponseEntity.ok(requestList);
    }

}
