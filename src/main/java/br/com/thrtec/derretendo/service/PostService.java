package br.com.thrtec.derretendo.service;

import br.com.thrtec.derretendo.domain.AppUser;
import br.com.thrtec.derretendo.domain.Post;
import br.com.thrtec.derretendo.dtos.post.InsertPostRequestDto;
import br.com.thrtec.derretendo.dtos.post.InsertPostResponseDto;
import br.com.thrtec.derretendo.mapper.PostMapper;
import br.com.thrtec.derretendo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AuthenticationService authenticationService;

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    public InsertPostResponseDto insertPost(InsertPostRequestDto requestDto) {
        AppUser appUser = authenticationService.getLoggedUserInfo();
        Post post = postMapper.mapDtoToModel(requestDto, appUser);

        post = postRepository.insert(post);

        return postMapper.mapModelToDto(post);
    }

}
