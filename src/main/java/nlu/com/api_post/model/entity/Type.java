package nlu.com.api_post.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Type {
    @Id
    String name;
    String description;

    @OneToMany(mappedBy = "type")
    Set<Post> posts;
}
