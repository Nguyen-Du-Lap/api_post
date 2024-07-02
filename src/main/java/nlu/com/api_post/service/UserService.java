package nlu.com.api_post.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nlu.com.api_post.mapper.UserMapper;
import nlu.com.api_post.model.constant.PredefinedRole;
import nlu.com.api_post.model.dto.request.UserCreationRequest;
import nlu.com.api_post.model.dto.response.UserResponse;
import nlu.com.api_post.model.entity.Role;
import nlu.com.api_post.model.entity.User;
import nlu.com.api_post.repository.RoleRepository;
import nlu.com.api_post.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;

    RoleRepository roleRepository;

    UserMapper userMapper;


    public UserResponse createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) throw new RuntimeException("Username already exists");

        User user = userMapper.toEntity(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefinedRole.USER_ROLE).ifPresent(roles::add);

        user.setRoles(roles);

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
