package br.com.thrtec.derretendo.repository;


import br.com.thrtec.derretendo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
