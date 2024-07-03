package nlu.com.api_post.mapper;

import nlu.com.api_post.model.dto.request.TypeRequest;
import nlu.com.api_post.model.dto.response.TypeResponse;
import nlu.com.api_post.model.entity.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    Type toEntity(TypeRequest request);

    TypeResponse toResponse(Type type);
}
