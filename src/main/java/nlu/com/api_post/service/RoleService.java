package nlu.com.api_post.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nlu.com.api_post.mapper.RoleMapper;
import nlu.com.api_post.model.dto.request.RoleRequest;
import nlu.com.api_post.model.dto.response.RoleResponse;
import nlu.com.api_post.model.entity.Role;
import nlu.com.api_post.repository.PermissionRepository;
import nlu.com.api_post.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    RoleRepository roleRepository;

    PermissionRepository permissionRepository;

    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toEntity(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        roleRepository.save(role);
        return roleMapper.toResponse(role);
    }
}