package nlu.com.api_post.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class AuthenticationUtils {

    private AuthenticationUtils(){}

    static Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    public static String extractUserId() {
        if(authentication.isAuthenticated()) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            return jwt.getClaimAsString("user_id");
        }
        return null;

    }

}
