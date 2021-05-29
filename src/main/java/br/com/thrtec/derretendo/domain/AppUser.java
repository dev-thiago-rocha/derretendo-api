package br.com.thrtec.derretendo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "appUser")
public class AppUser {

    @Id
    public String id;
    public String username;
    public String password;

}
