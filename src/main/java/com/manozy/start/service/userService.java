package com.manozy.start.service;

import com.manozy.start.dto.userDto;
import com.manozy.start.entity.user;
import com.manozy.start.repo.userRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class userService {
    @Autowired
    private userRepo userrepo;
    @Autowired
    private ModelMapper modelMapper;

    public userDto saveUser(userDto userdto) {
        userrepo.save(modelMapper.map(userdto, user.class));
        return userdto;
    }

}
