package tk.mybatis.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo-custom.xml")
public class GirlApplication {

	public static void main(String[] args) {

		SpringApplication.run(GirlApplication.class, args);
	}
}
