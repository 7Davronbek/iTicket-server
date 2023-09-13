package com.example.iticket.user.service;

import com.example.iticket.common.CommonService;
import com.example.iticket.user.dto.UserResponseDto;
import com.example.iticket.user.dto.UserUpdateDto;
import com.example.iticket.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements CommonService<UUID, UserResponseDto, UserUpdateDto> {

    private final LinkedHashMap<UUID, User> users = new LinkedHashMap<>();


    @Override
    public UserResponseDto findById(UUID uuid) {
        User user = users.get(uuid);
        if(user == null) return null;
//     TODO ADD AUTO DTO METHODS
        return null;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return null;
    }

    @Override
    public UserResponseDto update(UUID uuid, UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public UserResponseDto add(UserResponseDto userResponseDto) {
        return null;
    }
}


/**
 * package com.example.demo.user;
 *
 * import com.example.demo.user.dto.UserCreateDTO;
 * import com.example.demo.user.dto.UserResponseDTO;
 * import com.example.demo.user.dto.UserUpdateDTO;
 * import com.example.demo.user.entity.User;
 * import org.springframework.stereotype.Service;
 *
 * import java.util.LinkedHashMap;
 * import java.util.List;
 * import java.util.UUID;
 *
 * @Service
 * public class UserService {
 *     private final LinkedHashMap<UUID, User> users = new LinkedHashMap<>();
 *
 *     public void create(UserCreateDTO userCreateDTO) {
 *
 *         User user = new User();
 *
 *         user.setId(UUID.randomUUID());
 *         user.setName(userCreateDTO.getName());
 *         user.setUsername(userCreateDTO.getUsername());
 *         user.setSurname(userCreateDTO.getSurname());
 *         user.setEmail(userCreateDTO.getEmail());
 *         user.setPassword(userCreateDTO.getPassword());
 *
 *         users.put(user.getId(), user);
 *     }
 *
 *     public List<UserResponseDTO> getUsers() {
 *         return users.values()
 *                 .stream()
 *                 .map(user -> {
 *                     UserResponseDTO userResponseDTO = new UserResponseDTO();
 *
 *                     userResponseDTO.setId(user.getId());
 *                     userResponseDTO.setName(user.getName());
 *                     userResponseDTO.setSurname(user.getSurname());
 *                     userResponseDTO.setUsername(user.getUsername());
 *                     userResponseDTO.setEmail(user.getEmail());
 * //                    new ResponseEntity<>("User updated successfully", HttpStatus.CREATED);
 *                     return userResponseDTO;
 *                 }).toList();
 *     }
 *
 *     public UserResponseDTO getUser(UUID id) {
 *         User user = users.get(id);
 *         if (user == null) return null;
 *
 *         UserResponseDTO userResponseDTO = new UserResponseDTO();
 *
 *         userResponseDTO.setEmail(user.getEmail());
 *         userResponseDTO.setSurname(user.getSurname());
 *         userResponseDTO.setUsername(user.getUsername());
 *         userResponseDTO.setName(user.getName());
 *         userResponseDTO.setId(user.getId());
 *
 *         return userResponseDTO;
 *     }
 *
 *     public void update(UUID id, UserUpdateDTO userUpdateDTO) {
 *         User user = users.get(id);
 *         if (user == null) {
 *             return;
 *         }
 *
 *         user.setEmail(userUpdateDTO.getEmail());
 *         user.setSurname(userUpdateDTO.getSurname());
 *         user.setUsername(userUpdateDTO.getUsername());
 *         user.setName(userUpdateDTO.getName());
 *         user.setPassword(userUpdateDTO.getPassword());
 *
 *         users.put(id, user);
 * //        new ResponseEntity<>("User updated successfully", HttpStatus.CREATED);
 *     }
 *
 *     public void delete(UUID id) {
 *         users.remove(id);
 *     }
 * }
 * */