package nlu.com.api_post.repository;

import nlu.com.api_post.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Page<Post> findAllByType_NameAndIsApprove(String type, boolean isApprove, Pageable pageable);

    Optional<Post> findByIdAndIsApprove(String id, boolean b);

    Page<Post> findAllByIsApprove(boolean b, Pageable pageable);
}
