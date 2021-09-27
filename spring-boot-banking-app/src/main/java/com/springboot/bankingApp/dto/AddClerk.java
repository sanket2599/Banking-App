package com.springboot.bankingApp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AddClerk {
	
	@NonNull
	@NotNull(message = "Field should not be blank")
	@Column(name = "name", nullable = false)
	private String name;
	
	@NonNull
	@NotNull(message = "Field should not be blank")
	@Column(name = "address", nullable = false)
	private String address;
	
	@NonNull
	@NotNull(message = "Field should not be blank")
	@Column(name = "username", nullable = false)
	private String username;
	
	@NonNull
	@NotNull(message = "Field should not be blank")
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@Column(name = "designation", nullable = false)
	private final String designation="Clerk";
	
	@NotNull
	@Column(name = "updat", nullable = false)
	private final String update="Update";
	
	@NotNull
	@Column(name = "delet", nullable = false)
	private final String delete="Delete";

}
