package nlu.com.api_post.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    String id;
    String title;
    String content;
    boolean isApprove;
    LocalDate createdDate;
    LocalDate updatedDate;
    UserResponse user;
    TypeResponse type;
}
