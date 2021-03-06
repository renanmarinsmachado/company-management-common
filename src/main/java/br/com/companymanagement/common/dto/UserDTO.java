package br.com.companymanagement.common.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.companymanagement.common.enums.Role;
import br.com.companymanagement.common.serialization.DateDeserializer;
import br.com.companymanagement.common.serialization.DateSerializer;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

	private Long cpf;

	private String name;
	
	private String username;
	
	private String password;
	
    private Role role;
    
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date birthdate;
	
	private Double salary;

    public UserDTO() {
		// TODO Auto-generated constructor stub
	}
    
	public UserDTO(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(Long cpf, String name, String username, String password, Role role, Date birthdate, Double salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.birthdate = birthdate;
		this.salary = salary;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
