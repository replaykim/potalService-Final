package kr.ac.jejunu.interceptor;

import kr.ac.jejunu.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by replay on 2017. 6. 9..
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null){
            response.sendRedirect("/login");
            return false;
        }

        String email = (String) session.getAttribute("email");

        if (email ==null) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
