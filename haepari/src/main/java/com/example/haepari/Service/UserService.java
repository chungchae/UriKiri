package com.example.haepari.Service;

import com.example.haepari.Entity.User;
import com.example.haepari.Repository.UserRepository;
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

}
