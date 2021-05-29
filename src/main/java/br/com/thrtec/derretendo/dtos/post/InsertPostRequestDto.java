package br.com.thrtec.derretendo.dtos.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertPostRequestDto {

    @NotEmpty
    @Size(max = 100)
    private String title;

    @NotEmpty
    @Size(max = 500)
    private String description;

    @NotEmpty
    @Size(max = 100)
    private String link;

    @NotEmpty
    private BigDecimal price;

}
