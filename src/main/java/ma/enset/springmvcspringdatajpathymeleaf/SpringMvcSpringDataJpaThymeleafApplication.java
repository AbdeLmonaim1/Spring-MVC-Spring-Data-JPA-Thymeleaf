package ma.enset.springmvcspringdatajpathymeleaf;

import ma.enset.springmvcspringdatajpathymeleaf.entities.Patient;
import ma.enset.springmvcspringdatajpathymeleaf.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
