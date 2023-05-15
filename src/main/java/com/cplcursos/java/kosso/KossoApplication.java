package com.cplcursos.java.kosso;

import com.cplcursos.java.kosso.services.FileSystemStorageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KossoApplication {

	@Autowired
	FileSystemStorageService fileSystemStorageService;
	public static void main(String[] args) {
		SpringApplication.run(KossoApplication.class, args);
	}

	@PostConstruct
	public void init() {fileSystemStorageService.init();
	}

}
