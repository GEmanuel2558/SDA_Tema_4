package sda.tema.SDA_Tema_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan("sda.tema.SDA_Tema_4.*")
public class SdaTema4Application {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GTB Standard Time"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SdaTema4Application.class, args);
	}

}
