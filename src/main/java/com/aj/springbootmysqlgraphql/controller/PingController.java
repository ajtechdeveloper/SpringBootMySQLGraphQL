package com.aj.springbootmysqlgraphql.controller;

import com.aj.springbootmysqlgraphql.domain.PingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @RequestMapping(value = "ping", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> ping() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "pong");
        return new ResponseEntity<>(response, HttpStatus.OK);
	}


    @RequestMapping(value = "ping", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> send(@RequestBody PingRequest pingRequest) {
        logger.info("Request received is: " + pingRequest );
        Map<String, String> response = new HashMap<>();
        response.put("message", "");
        if("ping".equalsIgnoreCase(pingRequest.getInput())) {
            response.put("message", "pong");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
