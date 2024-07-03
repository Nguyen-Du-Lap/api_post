package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.response.ApiResponse;
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
    ApiResponse<PermissionResponse> create(@RequestBody @Valid PermissionRequest request) {
        PermissionResponse permissionResponse = permissionService.create(request);
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionResponse)
                .message("Permission created successfully")
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        var permissions = permissionService.getAll();
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissions)
                .message("List of permissions")
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete(@PathVariable String permission) {
        permissionService.delete(permission);
        return ApiResponse.<Void>builder()
                .message("Permission deleted successfully")
                .build();
    }
}
