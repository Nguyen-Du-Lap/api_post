package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PostRequest;
import nlu.com.api_post.model.dto.request.UserCreationRequest;
import nlu.com.api_post.model.dto.request.UserUpdateRequest;
import nlu.com.api_post.model.dto.response.ApiResponse;
import nlu.com.api_post.model.dto.response.PostResponse;
import nlu.com.api_post.model.dto.response.UserResponse;
import nlu.com.api_post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PostController {

    PostService postService;

    @PostMapping
    ApiResponse<PostResponse> create(@RequestBody @Valid PostRequest request) {
        PostResponse postResponse = postService.create(request);
        return ApiResponse.<PostResponse>builder()
                .result(postResponse)
                .message("Post created successfully")
                .build();
    }

//    @GetMapping
//    ApiResponse<List<UserResponse>> getUsers() {
//        var users = userService.getAllUsers();
//        return ApiResponse.<List<UserResponse>>builder()
//                .result(users)
//                .message("List of users")
//                .build();
//    }

//    @GetMapping("/{userId}")
//    ApiResponse<UserResponse> getUser(@PathVariable String userId) {
//        var user = userService.getUser(userId);
//        return ApiResponse.<UserResponse>builder()
//                .result(user)
//                .message("User get successfully")
//                .build();
//    }
//
//    @PutMapping("/{userId}")
//    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody @Valid UserUpdateRequest request ) {
//        var user = userService.updateUser(userId, request);
//        return ApiResponse.<UserResponse>builder()
//                .result(user)
//                .message("Update user successfully")
//                .build();
//    }
//
//    @DeleteMapping("/{userId}")
//    ApiResponse<Void> deleteUser(@PathVariable String userId) {
//        userService.deleteUser(userId);
//        return ApiResponse.<Void>builder()
//                .message("User deleted successfully")
//                .build();
//    }
}
