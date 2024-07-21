package com.example.haepari.Controller;


import com.example.haepari.Repository.UserRepository;
import com.example.haepari.Service.UserService;
import com.example.haepari.dto.JoinDto;
import com.example.haepari.dto.LoginDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        int status = userService.login(loginDto);

        session.setAttribute("username",loginDto.getUsername());

        if(status==1){
            return ResponseEntity.ok("로그인 성공");
        }else{
            return ResponseEntity.status(404).body("아이디 혹은 비밀번호가 틀립니다.");
        }

    }
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto){
        String status = userService.join(joinDto);
        if(status=="모두 입력하세요"){
            return ResponseEntity.ok("정보를 모두 입력하세요");
        }else if(status=="중복된 아이디입니다"){
            return ResponseEntity.status(404).body("아이디가 중복됩니다. 다시 입력하세요");
        }


        else
            return ResponseEntity.ok("회원가입 성공!");
    }
}
