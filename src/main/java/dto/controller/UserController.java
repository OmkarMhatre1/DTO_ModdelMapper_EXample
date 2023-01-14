package dto.controller;

import dto.dto.UserDto;
import dto.entity.User;
import dto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDto> getAllUser(){
        return service.getAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id){
        return service.getById(id);
    }

}
