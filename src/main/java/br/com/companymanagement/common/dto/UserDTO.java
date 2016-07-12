package br.com.companymanagement.common.dto;

import br.com.companymanagement.common.enums.Role;

public class UserDTO {

	private Long id;

	private String name;
	
	private String username;
	
	private String password;
	
    private Role role;

    public UserDTO() {
		// TODO Auto-generated constructor stub
	}
    
	public UserDTO(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
}
