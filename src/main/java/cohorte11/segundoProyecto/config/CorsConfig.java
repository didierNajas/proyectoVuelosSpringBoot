package cohorte11.segundoProyecto.config;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig
{

    private static final List<String> BASE_ORIGIN_PATTERNS = List.of(
            "http://localhost:*",
            "http://127.0.0.1:*",
            "https://*.github.io"
    );

    @Value("${app.cors.allowed-origin-patterns:}")
    private String allowedOriginPatterns;

    @Bean
    public CorsFilter corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        Set<String> patterns = new LinkedHashSet<>(BASE_ORIGIN_PATTERNS);
        if (allowedOriginPatterns != null && !allowedOriginPatterns.isBlank())
        {
            Arrays.stream(allowedOriginPatterns.split(","))
                    .map(String::trim)
                    .filter((pattern) -> !pattern.isEmpty())
                    .forEach(patterns::add);
        }

        patterns.forEach(config::addAllowedOriginPattern);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
