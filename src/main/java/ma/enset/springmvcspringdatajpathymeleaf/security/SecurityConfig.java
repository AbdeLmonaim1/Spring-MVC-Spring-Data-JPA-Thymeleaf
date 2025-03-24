package ma.enset.springmvcspringdatajpathymeleaf.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    private PasswordEncoder passwordEncoder;
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("Monaim").password(passwordEncoder.encode("monaim123")).roles("USER", "ADMIN").build(),
                User.withUsername("Mouad").password(passwordEncoder.encode("mouad123")).roles("USER").build(),
                User.withUsername("Amine").password(passwordEncoder.encode("amine123")).roles("USER").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.build();
    }
}
