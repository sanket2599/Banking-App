package com.springboot.bankingApp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AddCustomer {
	
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
	@Column(name = "balance", nullable = false)
	private long balance;
	
	@NotNull
	@Column(name = "updat", nullable = false)
	private final String update="Update";
	
	@NotNull
	@Column(name = "delet", nullable = false)
	private final String delete="Delete";
}
