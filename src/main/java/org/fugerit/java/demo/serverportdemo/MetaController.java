package org.fugerit.java.demo.serverportdemo;

import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/meta")
@Slf4j
public class MetaController {

	@GetMapping("/version")
	public ResponseEntity<Properties> getList() {
		ResponseEntity<Properties> response = null;
		try {
			Properties props = new Properties();
			props.setProperty( "version" , "0.0.1-SNAPSHOT" );
			props.setProperty( "revision" , "NA" );
			response = new ResponseEntity<>(props, HttpStatus.OK);
		} catch (Exception e) {
			log.error( "Error : "+e, e );
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
}
