package br.com.companymanagement.common.client;

import static br.com.companymanagement.common.fixed.UrlUtils.GET_USER;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.common.exception.NotFoundException;

@Service
public class UserClient {

	public List<UserDTO> getUsers(String username){
		RestTemplate restTemplate = new RestTemplate();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("username", username);
		
		HttpEntity<?> requestEntity = new HttpEntity<Object>(getDefaultHeaders());
		URI uri = UriComponentsBuilder.fromHttpUrl(GET_USER).queryParams(parameters).build().toUri();
		
		ResponseEntity<List<UserDTO>> exchange = restTemplate.exchange(uri.toString(), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<UserDTO>>() {});
		
		List<UserDTO> users = exchange.getBody();
		if(exchange.getStatusCode().equals(HttpStatus.OK)){
			if(!CollectionUtils.isEmpty(users)){				
				return users;
			}
		}
		
		throw new NotFoundException("Not found no user.");
	}
	
	protected HttpHeaders getDefaultHeaders() {

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		return requestHeaders;
	}
}
