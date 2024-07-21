package com.example.haepari.Controller;

import com.example.haepari.Entity.Request;
import com.example.haepari.Service.RequestService;
import com.example.haepari.dto.RequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/delivery/request")
    public ResponseEntity<String> createRequest(@RequestBody RequestDto dto, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int status = requestService.saveRequest(dto,username);
        if (status == 1) {
            return ResponseEntity.ok("배송요청 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("배송요청 실패: 입력 값이 유효하지 않음");
        }
    }
}
