package com.soapboot.SoapBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soap.peiky.client.UserLoginResponse;
import com.soapboot.SoapBoot.soap.client.UserClient;

@SpringBootApplication
public class SoapBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapBootApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(UserClient userClient) {
		return args -> {
			UserLoginResponse response = userClient.login("karen", "karen2");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(response.getUser());
			System.out.println("response service ::::: " + json);
		};
	}

}
