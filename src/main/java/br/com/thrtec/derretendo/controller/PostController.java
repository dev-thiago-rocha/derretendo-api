package br.com.thrtec.derretendo.controller;

import br.com.thrtec.derretendo.domain.Post;
import br.com.thrtec.derretendo.dtos.post.InsertPostRequestDto;
import br.com.thrtec.derretendo.dtos.post.InsertPostResponseDto;
import br.com.thrtec.derretendo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @PostMapping
    public InsertPostResponseDto insertPost(@RequestBody @Valid InsertPostRequestDto requestDto) {
        return postService.insertPost(requestDto);
    }

}
