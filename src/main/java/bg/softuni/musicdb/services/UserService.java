package bg.softuni.musicdb.services;

import bg.softuni.musicdb.models.dto.LoginUserDTO;
import bg.softuni.musicdb.models.dto.RegisterUserDTO;
import bg.softuni.musicdb.models.entities.User;
import bg.softuni.musicdb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public void registerUser(RegisterUserDTO userDTO) {
        userRepository.saveAndFlush(mapper.map(userDTO, User.class));
    }

    public Optional<User> loginUser(LoginUserDTO userDTO) {
        return userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }
}
