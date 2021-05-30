package br.com.thrtec.derretendo.validator;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class AppUserValidator {

    private final AppUserRepository appUserRepository;

    public void validateCreateNewUser(AppUser appUser) {

        try {
            if (nonNull(appUserRepository.findByUsername(appUser.getUsername()))) {
                throw new RuntimeException("O usuário já existe na base de dados.");
            }
        } catch (IncorrectResultSizeDataAccessException ex) {
            throw new RuntimeException("O usuário já existe na base de dados.");
        }
    }

}
