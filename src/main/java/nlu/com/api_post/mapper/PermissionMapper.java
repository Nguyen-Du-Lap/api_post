package nlu.com.api_post.mapper;

import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.response.PermissionResponse;
import nlu.com.api_post.model.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PermissionMapper {

    Permission toEntity(PermissionRequest request);

    PermissionResponse toResponse(Permission permission);
}
