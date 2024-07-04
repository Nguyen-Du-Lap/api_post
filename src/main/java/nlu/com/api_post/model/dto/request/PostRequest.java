package nlu.com.api_post.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRequest {
    @Size(max = 1000, message = "TITLE_INVALID")
    @NotBlank(message = "TITLE_BLANK_INVALID")
    String title;

    @Size(max = 1000, message = "CONTENT_INVALID")
    @NotBlank(message = "CONTENT_BLANK_INVALID")
    String content;

    @NotBlank(message = "TYPE_BLANK_INVALID")
    String type;
}
