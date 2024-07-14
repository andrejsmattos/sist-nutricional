package senai.sistemaDeSaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"senai.sistemaDeSaude"})
public class SistemaDeSaudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeSaudeApplication.class, args);

    }
}
