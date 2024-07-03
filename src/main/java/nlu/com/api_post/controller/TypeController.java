package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PermissionRequest;
import nlu.com.api_post.model.dto.request.TypeRequest;
import nlu.com.api_post.model.dto.response.ApiResponse;
import nlu.com.api_post.model.dto.response.PermissionResponse;
import nlu.com.api_post.model.dto.response.TypeResponse;
import nlu.com.api_post.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TypeController {
    TypeService typeService;

    @PostMapping
    ApiResponse<TypeResponse> create(@RequestBody @Valid TypeRequest request) {
        TypeResponse typeResponse = typeService.create(request);
        return ApiResponse.<TypeResponse>builder()
                .result(typeResponse)
                .message("Type created successfully")
                .build();
    }

    @GetMapping
    ApiResponse<List<TypeResponse>> getAll() {
        var types = typeService.getAll();
        return ApiResponse.<List<TypeResponse>>builder()
                .result(types)
                .message("List of types")
                .build();
    }

    @DeleteMapping("/{name}")
    ApiResponse<Void> delete(@PathVariable String name) {
        typeService.delete(name);
        return ApiResponse.<Void>builder()
                .message("Type deleted successfully")
                .build();
    }
}
