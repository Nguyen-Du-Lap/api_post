package nlu.com.api_post.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nlu.com.api_post.mapper.PermissionMapper;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.response.PermissionResponse;
import nlu.com.api_post.model.entity.Permission;
import nlu.com.api_post.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PermissionService {
    PermissionRepository permissionRepository;

    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toEntity(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
