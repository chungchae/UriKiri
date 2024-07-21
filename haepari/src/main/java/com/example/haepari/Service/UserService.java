package com.example.haepari.Service;

import com.example.haepari.Entity.User;
import com.example.haepari.Repository.UserRepository;
import com.example.haepari.dto.JoinDto;
import com.example.haepari.dto.LoginDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

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

        if (userRepository.existsByPassword(joinDto.getPassword())) {
            return "중복된 비밀번호입니다";
        }

        User user = new User();
        user.setUsername(joinDto.getUsername());
        user.setPassword(joinDto.getPassword());
        user.setNickname(joinDto.getNickname());
        user.setPhone(joinDto.getPhone());

        userRepository.save(user);
        return "가입 성공";

    }

}
