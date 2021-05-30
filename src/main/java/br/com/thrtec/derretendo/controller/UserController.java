package br.com.thrtec.derretendo.controller;

import br.com.thrtec.derretendo.dtos.user.InsertUserRequestDto;
import br.com.thrtec.derretendo.dtos.user.InsertUserResponseDto;
import br.com.thrtec.derretendo.dtos.user.LoginUserRequestDto;
import br.com.thrtec.derretendo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public InsertUserResponseDto insertUser(@Valid @RequestBody InsertUserRequestDto requestDto) {
        return userService.insertUser(requestDto);
    }

    @PostMapping("/login")
    public String insertUser(@Valid @RequestBody LoginUserRequestDto requestDto) {
        return userService.authenticateUser(requestDto);
    }

}
