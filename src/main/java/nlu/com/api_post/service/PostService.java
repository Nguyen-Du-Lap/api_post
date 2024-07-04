package nlu.com.api_post.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nlu.com.api_post.exception.AppException;
import nlu.com.api_post.exception.ErrorCode;
import nlu.com.api_post.mapper.PostMapper;
import nlu.com.api_post.mapper.TypeMapper;
import nlu.com.api_post.mapper.UserMapper;
import nlu.com.api_post.model.dto.request.PostRequest;
import nlu.com.api_post.model.dto.response.PostResponse;
import nlu.com.api_post.model.entity.Post;
import nlu.com.api_post.model.entity.Type;
import nlu.com.api_post.model.entity.User;
import nlu.com.api_post.repository.PostRepository;
import nlu.com.api_post.repository.TypeRepository;
import nlu.com.api_post.repository.UserRepository;
import nlu.com.api_post.util.AuthenticationUtils;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PostService {

    PostRepository postRepository;

    TypeRepository typeRepository;

    UserRepository userRepository;

    PostMapper postMapper;

    UserMapper userMapper;

    TypeMapper typeMapper;

    public PostResponse create(PostRequest request) {
        Post post = postMapper.toEntity(request);
        User user = userRepository.findById(AuthenticationUtils.extractUserId())
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        Type type = typeRepository.findById(request.getType())
                .orElseThrow(()-> new AppException(ErrorCode.TYPE_NOT_EXISTED));

        post.setType(type);
        post.setCreatedDate(LocalDate.now());
        post.setUpdatedDate(LocalDate.now());
        post.setUser(user);
        return toPostResponse(postRepository.save(post));
    }

    public PostResponse getPost(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        return toPostResponse(post);
    }

    @PostAuthorize("returnObject.user.username == authentication.name or hasAuthority('ADMIN')")
    public PostResponse updatePost(String postId, PostRequest request) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));

        Type type = typeRepository.findById(request.getType())
                .orElseThrow(()-> new AppException(ErrorCode.TYPE_NOT_EXISTED));

        //update post
        post.setUpdatedDate(LocalDate.now());
        postMapper.updatePost(post, request);
        post.setType(type);

        return  toPostResponse(postRepository.save(post));

    }

    private PostResponse toPostResponse(Post post) {
        PostResponse postResponse = postMapper.toResponse(post);
        postResponse.setType(typeMapper.toResponse(post.getType()));
        postResponse.setUser(userMapper.toUserResponse(post.getUser()));
        return postResponse;
    }
}
