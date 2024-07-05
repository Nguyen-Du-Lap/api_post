package nlu.com.api_post.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    CANNOT_CREATE_TOKEN(1009, "Cannot create token", HttpStatus.UNAUTHORIZED),
    PATH_NOT_EXISTED(1010, "Path not existed", HttpStatus.NOT_FOUND),
    TYPE_NOT_EXISTED(1011, "Type not existed", HttpStatus.BAD_REQUEST),
    TITLE_BLANK_INVALID(1012, "Title is not blank", HttpStatus.BAD_REQUEST),
    CONTENT_BLANK_INVALID(1013, "Content is not blank", HttpStatus.BAD_REQUEST),
    TYPE_BLANK_INVALID(1014, "Type is not blank", HttpStatus.BAD_REQUEST),
    TITLE_INVALID(1015, "Title must be at less {max} characters", HttpStatus.BAD_REQUEST),
    CONTENT_INVALID(1016, "Content must be at less {max} characters", HttpStatus.BAD_REQUEST),
    NAME_BLANK_INVALID(1017, "Name is not blank", HttpStatus.BAD_REQUEST),
    DESCRIPTION_BLANK_INVALID(1018, "Description is not blank", HttpStatus.BAD_REQUEST),
    DATE_INVALID(1019, "Date is not in correct format", HttpStatus.BAD_REQUEST),
    POST_NOT_EXISTED(1020, "Post not existed", HttpStatus.NOT_FOUND),
    PARAMETER_NOT_CORRECT(1021, "Parameter not correct", HttpStatus.BAD_REQUEST),
            ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
