package com.example.haepari.Controller;


import com.example.haepari.Repository.UserRepository;
import com.example.haepari.Service.UserService;
import com.example.haepari.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        int status = userService.login(loginDto);
        if(status==1){
            return ResponseEntity.ok("로그인 성공");
        }else{
            return ResponseEntity.status(404).body("아이디 혹은 비밀번호가 틀립니다.");
        }

    }
}
