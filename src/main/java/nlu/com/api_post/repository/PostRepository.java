package nlu.com.api_post.repository;

import nlu.com.api_post.model.entity.Post;
import nlu.com.api_post.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Page<Post> findAllByType_Name(String type, Pageable pageable);
}
