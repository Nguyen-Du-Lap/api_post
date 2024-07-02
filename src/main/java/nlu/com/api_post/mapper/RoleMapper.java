package nlu.com.api_post.mapper;

import nlu.com.api_post.model.dto.request.RoleRequest;
import nlu.com.api_post.model.dto.response.RoleResponse;
import nlu.com.api_post.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role role);
}
