package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.response.PermissionResponse;
import nlu.com.api_post.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    PermissionResponse create(@RequestBody @Valid PermissionRequest request) {
        PermissionResponse permissionResponse = permissionService.create(request);
        return permissionResponse;
    }

    @GetMapping
    List<PermissionResponse> getAll() {
        var permissions = permissionService.getAll();
        return permissions;
    }

    @DeleteMapping("/{permission}")
    void delete(@PathVariable String permission) {
        permissionService.delete(permission);
    }
}
