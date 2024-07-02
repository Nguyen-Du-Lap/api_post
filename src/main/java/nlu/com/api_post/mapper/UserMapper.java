package nlu.com.api_post.mapper;

import nlu.com.api_post.model.dto.request.UserCreationRequest;
import nlu.com.api_post.model.dto.response.UserResponse;
import nlu.com.api_post.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreationRequest request);

    UserResponse toUserResponse(User user);
}
