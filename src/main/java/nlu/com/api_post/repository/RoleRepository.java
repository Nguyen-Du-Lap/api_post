package nlu.com.api_post.repository;

import nlu.com.api_post.model.entity.Post;
import nlu.com.api_post.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
