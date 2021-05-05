package com.soulmate.soulmateapp;

import com.soulmate.soulmateapp.seeddata.SeedDataClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class SoulmateAppApplication{

	public static void main(String[] args) {

		SpringApplication.run(SoulmateAppApplication.class, args);
	}

}
