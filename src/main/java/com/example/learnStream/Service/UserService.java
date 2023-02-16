package com.example.learnStream.Service;


import com.example.learnStream.dto.UsersDto;
import com.example.learnStream.model.Users;
import com.example.learnStream.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    private ModelMapper modelMapper;
    public Users registerUser(@RequestBody Users user) {

        userRepository.save(user);
        return user;
    }

    public List<UsersDto> getUsers() {
        List<Users> users=userRepository.findAll();
        List<UsersDto> usersDtoList=users.stream().map(user->modelMapper.map(user,UsersDto.class)).collect(Collectors.toList());

        return usersDtoList;

    }

    public UsersDto createUser(UsersDto usersDto) {
        Users users=modelMapper.map(usersDto,Users.class);

        return modelMapper.map(userRepository.save(users),UsersDto.class);

    }

    public UsersDto getUserId(Long id) {

        return modelMapper.map(userRepository.findById(id),UsersDto.class);

    }

    public String deleteUserId(Long id) {

        userRepository.deleteById(id);
        return "deleted user id:"+id;

    }
}
