package br.com.thrtec.derretendo.mapper;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.dtos.user.InsertUserRequestDto;
import br.com.thrtec.derretendo.dtos.user.InsertUserResponseDto;
import br.com.thrtec.derretendo.dtos.user.LoginUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    public AppUser mapDtoToModel(InsertUserRequestDto requestDto) {
        return AppUser.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .build();
    }

    public AppUser mapDtoToModel(LoginUserRequestDto requestDto) {
        return AppUser.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .build();
    }

    public InsertUserResponseDto mapModelToDto(AppUser appUser) {
        return InsertUserResponseDto.builder()
                .id(appUser.getId())
                .build();
    }

}
