package org.example.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilesApplication {
	static final String MEM_TYPE = "mem";
	static final String DB_TYPE = "db";
	static String storageType = MEM_TYPE;

	public static void main(String[] args) {
		if (args.length >= 1) {
			storageType = args[0];
		}

		if (!storageType.equals(MEM_TYPE) && !storageType.equals(DB_TYPE)) {
			System.out.println("Invalid storage type: " + storageType);
			System.exit(1);
		} else {
			System.out.println("Storage type: " + storageType);
		}

		SpringApplication.run(FilesApplication.class, args);
	}

}