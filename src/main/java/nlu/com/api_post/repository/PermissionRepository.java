package nlu.com.api_post.repository;

import nlu.com.api_post.model.entity.Permission;
import nlu.com.api_post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
