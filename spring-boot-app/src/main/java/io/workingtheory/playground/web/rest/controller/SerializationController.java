package io.workingtheory.playground.web.rest.controller;

import io.workingtheory.playground.web.rest.SerializationRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/serialization")
public class SerializationController
{
	private static final Logger logger = LogManager.getLogger(SerializationController.class);

	@PostMapping(value = "/test-hibernate-validation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validate(final @RequestBody @Validated SerializationRequest request, final BindingResult bindingResult)
	{
		logger.info("Request : {}", request);

		bindingResult.getGlobalErrors().forEach(error -> logger.info("Global Error : {} : {}", error.getDefaultMessage(), error.getArguments()));
		bindingResult.getAllErrors().forEach(error -> logger.info("All Error : {} : {}", error.getDefaultMessage(), error.getArguments()));
		bindingResult.getFieldErrors().forEach(error -> logger.info("Field Error : {} : {}", error.getDefaultMessage(), error.getArguments()));

		return ResponseEntity.ok().build();
	}


}
