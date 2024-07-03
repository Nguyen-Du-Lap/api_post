package nlu.com.api_post.mapper;

import nlu.com.api_post.model.dto.request.PostRequest;
import nlu.com.api_post.model.dto.request.RoleRequest;
import nlu.com.api_post.model.dto.response.PostResponse;
import nlu.com.api_post.model.dto.response.RoleResponse;
import nlu.com.api_post.model.entity.Post;
import nlu.com.api_post.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "type", ignore = true)
    Post toEntity(PostRequest request);

    PostResponse toResponse(Post post);
}
