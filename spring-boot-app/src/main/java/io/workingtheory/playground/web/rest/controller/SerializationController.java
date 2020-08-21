package io.workingtheory.playground.web.rest.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/serialization")
public class SerializationController
{
	private static final Logger logger = LogManager.getLogger(SerializationController.class);

	@PostMapping(value = "/test-hibernate-validation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validate(final @RequestBody @Validated List<UUID> list, final BindingResult bindingResult)
	{
		logger.info("List : {}", list);

		for (final ObjectError error : bindingResult.getAllErrors())
		{
			logger.info("Error : {} : {}", error.getDefaultMessage(), error.getArguments());
		}

		return ResponseEntity.ok().build();
	}

}
