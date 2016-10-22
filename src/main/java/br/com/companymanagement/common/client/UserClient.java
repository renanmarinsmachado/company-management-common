package br.com.companymanagement.common.client;

import static br.com.companymanagement.common.fixed.UrlUtils.GET_USER;
import static br.com.companymanagement.common.fixed.UrlUtils.POST_USER_FILTER;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.companymanagement.common.dto.UserDTO;

@Service
public class UserClient {

	@SuppressWarnings("unchecked")
	public List<UserDTO> getUsers(){
		RestTemplate restTemplate = new RestTemplate();
		return (List<UserDTO>) restTemplate.getForObject(GET_USER, UserDTO.class);
	}
	
	public UserDTO getUserByUsername(String username){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(POST_USER_FILTER, new UserDTO("", username, ""), UserDTO.class);
	}
}
