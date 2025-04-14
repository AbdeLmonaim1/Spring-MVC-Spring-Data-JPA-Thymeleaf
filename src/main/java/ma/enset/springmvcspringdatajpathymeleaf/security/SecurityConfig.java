package ma.enset.springmvcspringdatajpathymeleaf.security;


import ma.enset.springmvcspringdatajpathymeleaf.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private PasswordEncoder passwordEncoder;
    private UserDetailServiceImpl userDetailServiceImpl;
    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailServiceImpl userDetailServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailServiceImpl = userDetailServiceImpl;
    }
//    @Bean
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
        //il faut specifie le dataSource Oui se trouve les utilisateurs et les roles
        return new JdbcUserDetailsManager(dataSource);
    }
//    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("Monaim").password(passwordEncoder.encode("monaim123")).roles("USER", "ADMIN").build(),
                User.withUsername("Mouad").password(passwordEncoder.encode("mouad123")).roles("USER").build(),
                User.withUsername("Amine").password(passwordEncoder.encode("amine123")).roles("USER").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(fl -> fl.loginPage("/login").defaultSuccessUrl("/").permitAll());
        httpSecurity.authorizeHttpRequests(ar -> ar.requestMatchers("/user/**").hasRole("USER"));
        httpSecurity.authorizeHttpRequests(ar -> ar.requestMatchers("/admin/**").hasRole("ADMIN"));
        httpSecurity.authorizeHttpRequests(ar -> ar.requestMatchers("/webjars/**").permitAll());
        httpSecurity.exceptionHandling(ex -> ex.accessDeniedPage("/notAuthorized"));
        //Ce ligne la c'est pout utiliser la strategie de UserDetailsService
        httpSecurity.userDetailsService(userDetailServiceImpl);
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
