package br.com.thrtec.derretendo.repository;

import br.com.thrtec.derretendo.domain.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

    AppUser findByUsername(String username);

}
