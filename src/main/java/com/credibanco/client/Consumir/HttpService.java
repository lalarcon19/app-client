package com.credibanco.client.Consumir;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import static com.credibanco.dependencia.Http.HttpService.getHttpEntity;
import com.credibanco.dependencia.dto.UserDTORequest;
import com.credibanco.dependencia.dto.UserDTOResponse;

public class HttpService {
	@Value("${variable}")
	String variable;
	
	@Autowired
	private static UserDTORequest userDTORequest;

	private static final Logger logger = LoggerFactory.getLogger(HttpService.class);

	public static String consumirService() {
		UserDTOResponse userDTOResponse = new UserDTOResponse();
		userDTOResponse.setId(55L);
		userDTOResponse.setPassword("17868");
		userDTOResponse.setUserName("mariana");
		ResponseEntity<String> response = new RestTemplate().exchange("http://localhost:8081/users/create",
				HttpMethod.POST, getHttpEntity(userDTORequest), String.class);

		if (response.getStatusCode() == HttpStatus.OK) {

			logger.info(response.getBody());

		}
		return null;

	}



}
