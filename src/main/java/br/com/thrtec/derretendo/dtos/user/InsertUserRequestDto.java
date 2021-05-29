package br.com.thrtec.derretendo.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertUserRequestDto {

    @NotEmpty
    @Size(max = 100)
    private String username;

    @NotEmpty
    @Size(max = 100)
    private String password;

}
