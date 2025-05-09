package br.com.goldform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

	@GetMapping
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok("Hello, World!");
	}

	@GetMapping("/protegido")
	public ResponseEntity<?> helloProtegido() {
		return ResponseEntity.ok("Hello, World!");
	}
}
