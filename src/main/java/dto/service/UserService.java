package dto.service;

import dto.dto.UserDto;
import dto.entity.User;
import dto.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final ModelMapper modelMapper;

    private UserDto entityToDto(User user){
        UserDto userDto=this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private User dtoToEntity(UserDto userDto){
        User user=this.modelMapper.map(userDto,User.class);
        return user;
    }


    public User saveUser(User user){
        return repository.save(user);
    }

    public List<UserDto> getAllUser(){
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(String id){
        return repository.findById(id)
                .map(this::entityToDto).get();
    }

}
