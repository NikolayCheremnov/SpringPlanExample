package org.top.springplanexample.api.middleware;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AdminBasicAuthFilter extends HttpFilter {

    // Тестовые учетные данные
    private static final String EXPECTED_USER = "admin";
    private static final String EXPECTED_PASS = "qwerty";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // если запрос не содержит в пути "admin" то просто пропустим дальше
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("admin")) {
            chain.doFilter(request, response);
            return;
        }

        // если содержит - то аутентифицируем
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            try {
                // Извлекаем и декодируем строку Credentials (base64)
                String base64Credentials = authHeader.substring("Basic ".length()).trim();
                byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
                String credentials = new String(credDecoded, StandardCharsets.UTF_8);

                // Строка имеет формат "username:password"
                String[] values = credentials.split(":", 2);

                if (values.length == 2 && EXPECTED_USER.equals(values[0]) && EXPECTED_PASS.equals(values[1])) {
                    // Если данные верны, пропускаем запрос дальше
                    chain.doFilter(request, response);
                    return;
                }
            } catch (IllegalArgumentException e) {
                // Ошибка декодирования Base64
            }
        }

        // Если заголовка нет или данные неверны — отправляем 401 и заголовок для вызова окна Basic Auth
        response.setHeader("WWW-Authenticate", "Basic realm=\"Admin Area\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("401 Unauthorized: Authentication required.");
    }
}
