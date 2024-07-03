package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.RoleRequest;
import nlu.com.api_post.model.dto.response.ApiResponse;
import nlu.com.api_post.model.dto.response.RoleResponse;
import nlu.com.api_post.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody @Valid RoleRequest roleRequest) {
        RoleResponse roleResponse = roleService.create(roleRequest);
        return ApiResponse.<RoleResponse>builder()
                .result(roleResponse)
                .message("Create Role successfully")
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> findAll() {
        var roles = roleService.findAll();
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roles)
                .message("Find all Roles successfully")
                .build();
    }

    @DeleteMapping("/{name}")
    ApiResponse<Void> delete(@PathVariable String name) {
        roleService.delete(name);
        return ApiResponse.<Void>builder()
                .message("Delete Role successfully")
                .build();
    }

}
