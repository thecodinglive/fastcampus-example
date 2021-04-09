package info.thecodinglive.photoapp.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class MDCLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String requestId = UUID.randomUUID().toString();
        String requestUrl = req.getRequestURI();
        String userAgent = req.getHeader("User-Agent");
        String clientIP = getClientIP(req);

        MDC.put("requestId", requestId);
        MDC.put("requestUrl", requestUrl);
        MDC.put("userAgent", userAgent);
        MDC.put("clientIP", clientIP);

        chain.doFilter(req, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("MDC filter initialize");
    }

    @Override
    public void destroy() {
        MDC.clear();
    }


    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        LOG.info("ip: {}", ip);

        if(!StringUtils.hasLength(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
