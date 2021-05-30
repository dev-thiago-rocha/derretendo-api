package br.com.thrtec.derretendo.service;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.dtos.user.InsertUserRequestDto;
import br.com.thrtec.derretendo.dtos.user.InsertUserResponseDto;
import br.com.thrtec.derretendo.dtos.user.LoginUserRequestDto;
import br.com.thrtec.derretendo.mapper.UserMapper;
import br.com.thrtec.derretendo.repository.AppUserRepository;
import br.com.thrtec.derretendo.util.EncryptUtil;
import br.com.thrtec.derretendo.validator.AppUserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final AppUserRepository userRepository;
    private final EncryptUtil encryptUtil;
    private final AppUserValidator appUserValidator;

    public InsertUserResponseDto insertUser(InsertUserRequestDto requestDto) {

        AppUser user = userMapper.mapDtoToModel(requestDto);

        appUserValidator.validateCreateNewUser(user);

        user.setPassword(encryptUtil.hashPassword(user.getPassword()));

        user = userRepository.insert(user);

        return userMapper.mapModelToDto(user);
    }

    public String authenticateUser(LoginUserRequestDto requestDto) {

        AppUser user = userMapper.mapDtoToModel(requestDto);
        AppUser userOnRepository = userRepository.findByUsername(user.getUsername());

        if (nonNull(userOnRepository) && BCrypt.checkpw(requestDto.getPassword(), userOnRepository.getPassword())) {
            return "Logado com sucesso";
        }

        throw new RuntimeException("Login invalido");
    }
}
