package br.com.thrtec.derretendo.service;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepository appUserRepository;

    public AppUser getLoggedUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return appUserRepository.findByUsername(auth.getName());
    }

}
