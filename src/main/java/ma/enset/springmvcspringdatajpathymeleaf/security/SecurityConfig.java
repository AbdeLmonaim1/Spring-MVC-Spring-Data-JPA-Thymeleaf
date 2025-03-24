package ma.enset.springmvcspringdatajpathymeleaf.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private PasswordEncoder passwordEncoder;
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("Monaim").password(passwordEncoder.encode("monaim123")).roles("USER", "ADMIN").build(),
                User.withUsername("Mouad").password(passwordEncoder.encode("mouad123")).roles("USER").build(),
                User.withUsername("Amine").password(passwordEncoder.encode("amine123")).roles("USER").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(ar -> ar.requestMatchers("/user/**").hasRole("USER"));
        httpSecurity.authorizeHttpRequests(ar -> ar.requestMatchers("/admin/**").hasRole("ADMIN"));
        httpSecurity.exceptionHandling(ex -> ex.accessDeniedPage("/notAuthorized"));
        httpSecurity.authorizeHttpRequests(ar -> ar.anyRequest().authenticated());

        return httpSecurity.build();
//        return httpSecurity
//                .formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(ar->ar.requestMatchers("/deletePatient/**").hasRole("ADMIN"))
//                .authorizeHttpRequests(ar->ar.requestMatchers("/admin/**").hasRole("ADMIN"))
//                .authorizeHttpRequests(ar->ar.requestMatchers("/user/**").hasRole("USER"))
//                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
//                .build();
    }
}
