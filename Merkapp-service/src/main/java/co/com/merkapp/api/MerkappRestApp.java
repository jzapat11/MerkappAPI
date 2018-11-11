package co.com.merkapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"co.com.merkapp.api"})
//@ImportResource({"classpath* :application-context.xml"})
public class MerkappRestApp {

	public static void main(String[] args) {
		SpringApplication.run(MerkappRestApp.class, args);
	}
}
