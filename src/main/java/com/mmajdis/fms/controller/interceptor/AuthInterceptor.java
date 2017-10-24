package com.mmajdis.fms.controller.interceptor;

import com.mmajdis.fms.Utils.FMSHeader;
import com.mmajdis.fms.dto.FeedbackDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request interceptor for authorization-related functionality.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    /**
     * Interceptor before every request used for validation of authorization token.
     * Token needs to be specified in X-FMS-Token header.
     * <p>
     * Important:
     * Currently there is no authorization system described.
     * Valid tokens are mocked by "validTokenMock" value of X-FMS-Token header.
     *
     * @return true if valid token is provided in request header, false otherwise.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(FMSHeader.X_FMS_TOKEN.getName());

        if (token != null && token.equals("validTokenMock")) {
            return true;
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
