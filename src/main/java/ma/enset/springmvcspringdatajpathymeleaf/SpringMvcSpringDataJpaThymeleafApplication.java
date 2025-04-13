package ma.enset.springmvcspringdatajpathymeleaf;

import ma.enset.springmvcspringdatajpathymeleaf.entities.Patient;
import ma.enset.springmvcspringdatajpathymeleaf.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class SpringMvcSpringDataJpaThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSpringDataJpaThymeleafApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder()
                            .nom("Moanim")
                            .dateNaissance(new Date())
                            .malade(true)
                            .score(122)

                    .build());
            patientRepository.save(Patient.builder()
                    .nom("Amine")
                    .dateNaissance(new Date())
                    .malade(true)
                    .score(45)

                    .build());
            patientRepository.save(Patient.builder()
                    .nom("Mouad")
                    .dateNaissance(new Date())
                    .malade(true)
                    .score(11)

                    .build());
        };
    }
    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails u1 = jdbcUserDetailsManager.loadUserByUsername("Ahmed");
                if(u1 == null)
                jdbcUserDetailsManager.createUser(
                        User.withUsername("Ahmed").password(passwordEncoder.encode("111111")).roles("USER").build());
                UserDetails u2 = jdbcUserDetailsManager.loadUserByUsername("Ismail");
                if(u2 == null)
                jdbcUserDetailsManager.createUser(
                        User.withUsername("Ismail").password(passwordEncoder.encode("22222")).roles("USER").build());
            UserDetails u3 = jdbcUserDetailsManager.loadUserByUsername("Monaim");
            if(u3 == null)
                jdbcUserDetailsManager.createUser(
                        User.withUsername("Monaim").password(passwordEncoder.encode("monaim11")).roles("USER","ADMIN").build());
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
