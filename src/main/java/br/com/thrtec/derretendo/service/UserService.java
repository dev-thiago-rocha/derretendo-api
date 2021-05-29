package br.com.thrtec.derretendo.service;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.dtos.user.InsertUserRequestDto;
import br.com.thrtec.derretendo.dtos.user.InsertUserResponseDto;
import br.com.thrtec.derretendo.mapper.UserMapper;
import br.com.thrtec.derretendo.repository.AppUserRepository;
import br.com.thrtec.derretendo.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final AppUserRepository userRepository;
    private final EncryptUtil encryptUtil;

    public InsertUserResponseDto insertUser(InsertUserRequestDto requestDto) {
        AppUser user = userMapper.mapDtoToModel(requestDto);

        user.setPassword(encryptUtil.hashPassword(user.getPassword()));

        user = userRepository.insert(user);

        return userMapper.mapModelToDto(user);
    }

}
