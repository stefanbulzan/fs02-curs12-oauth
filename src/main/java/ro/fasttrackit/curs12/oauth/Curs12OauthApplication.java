package ro.fasttrackit.curs12.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class Curs12OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs12OauthApplication.class, args);
    }

}


@RestController
@RequestMapping("students")
class StudentController {
    @GetMapping
    List<Student> getAll() {
        return List.of(
                new Student("Ana", 23),
                new Student("Mihai", 25),
                new Student("George", 43),
                new Student("Dorina", 13),
                new Student("Marian", 33)
        );
    }

    @GetMapping("me")
    SecurityContext me() {
        return SecurityContextHolder.getContext();
    }
}


record Student(String name, int age) {
}