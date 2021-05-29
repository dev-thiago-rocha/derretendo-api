package br.com.thrtec.derretendo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "post")
public class Post {

    @Id
    private String id;
    private String title;
    private String description;
    private String link;
    private BigDecimal price;
    private String creationUserName;
    private LocalDateTime creationDateTime;

}
