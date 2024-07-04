package nlu.com.api_post.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.api_post.model.dto.request.PostRequest;
import nlu.com.api_post.model.dto.response.ApiResponse;
import nlu.com.api_post.model.dto.response.PageResponse;
import nlu.com.api_post.model.dto.response.PostResponse;
import nlu.com.api_post.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{postId}")
    ApiResponse<PostResponse> get(@PathVariable String postId) {
        var post = postService.getPost(postId);
        return ApiResponse.<PostResponse>builder()
                .result(post)
                .message("Post get successfully")
                .build();
    }

    @PutMapping("/{postId}")
    ApiResponse<PostResponse> update(@PathVariable String postId, @RequestBody @Valid PostRequest request ) {
        var user = postService.update(postId, request);
        return ApiResponse.<PostResponse>builder()
                .result(user)
                .message("Update post successfully")
                .build();
    }

    @GetMapping
    ApiResponse<PageResponse<PostResponse>> getAll(
            @RequestParam String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort)

    {
        var posts = postService.getAll(type, page, size, sort);
        return ApiResponse.<PageResponse<PostResponse>>builder()
                .result(posts)
                .message("List post get successfully")
                .build();
    }
}
