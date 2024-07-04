package nlu.com.api_post.mapper;

import nlu.com.api_post.model.dto.request.PostRequest;
import nlu.com.api_post.model.dto.response.PostResponse;
import nlu.com.api_post.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "type", ignore = true)
    Post toEntity(PostRequest request);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "type", ignore = true)
    PostResponse toResponse(Post post);

    @Mapping(target = "type", ignore = true)
    void updatePost(@MappingTarget Post post, PostRequest request);

}
