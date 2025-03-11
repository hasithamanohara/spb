package com.manozy.start.service;

import com.manozy.start.dto.userDto;
import com.manozy.start.entity.user;
import com.manozy.start.repo.userRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class userService {
    @Autowired
    private userRepo userrepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private com.manozy.start.repo.userRepo userRepo;

    public userDto saveUser(userDto userdto) {
        userrepo.save(modelMapper.map(userdto, user.class));
        return userdto;
    }

//    public List<userDto> getAllUsersOne() {
//        List<user> users_list = userRepo.findAll();
//        Type listType = new TypeToken<List<userDto>>() {
//        }.getType();
//        return modelMapper.map(users_list, listType);
//    }


    public List<userDto> getAllUsers() {
        List<user> usersList = userRepo.findAll();

        // Convert List<User> to List<UserDto>
        return usersList.stream()
                .map(user -> modelMapper.map(user, userDto.class))
                .collect(Collectors.toList());
    }

//    public void updateUser(int id, userDto userdto) {
//        userrepo.save(modelMapper.map(userdto, user.class));
//    }

    public userDto updateUser(int id, userDto userdto){
        if (!userrepo.existsById(id)){
            return null;
        }
        user user = modelMapper.map(userdto, user.class);
        user.setId(id);
        user updatedUSer = userrepo.save(user);
        userDto userMapped = modelMapper.map(updatedUSer, userDto.class);
        return userdto;
    }

    public boolean deleteUser(userDto userdto){
        userrepo.delete(modelMapper.map(userdto, user.class));
        return true;
    }
    

}
