package nlu.com.api_post.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nlu.com.api_post.mapper.TypeMapper;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.request.TypeRequest;
import nlu.com.api_post.model.dto.response.PermissionResponse;
import nlu.com.api_post.model.dto.response.TypeResponse;
import nlu.com.api_post.model.entity.Permission;
import nlu.com.api_post.model.entity.Type;
import nlu.com.api_post.repository.TypeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class TypeService {
    TypeRepository typeRepository;

    TypeMapper typeMapper;

    @PreAuthorize("hasRole('ADMIN')")
    public TypeResponse create(TypeRequest request) {
        Type entity = typeMapper.toEntity(request);
        entity = typeRepository.save(entity);
        return typeMapper.toResponse(entity);
    }

    public List<TypeResponse> getAll() {
        var types = typeRepository.findAll();
        return types.stream().map(typeMapper::toResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(String permission) {
        typeRepository.deleteById(permission);
    }
}
