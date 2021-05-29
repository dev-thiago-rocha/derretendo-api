package br.com.thrtec.derretendo.mapper;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.domain.Post;
import br.com.thrtec.derretendo.dtos.post.InsertPostRequestDto;
import br.com.thrtec.derretendo.dtos.post.InsertPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class PostMapper {

    public Post mapDtoToModel(InsertPostRequestDto requestDto, AppUser appUser) {
        return Post.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .link(requestDto.getLink())
                .price(requestDto.getPrice())
                .creationUserName(appUser.getUsername())
                .creationDateTime(LocalDateTime.now())
                .build();
    }

    public InsertPostResponseDto mapModelToDto(Post post) {
        return InsertPostResponseDto.builder()
                .id(post.getId())
                .build();
    }

}
