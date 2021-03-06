package com.springboot.bankingApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

@ToString
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	@NotNull
	@NonNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@NonNull
	@Column(name = "username", nullable = false)
	private String username;
	
	@NotNull
	@NonNull
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@NonNull
	@Column(name = "address", nullable = false)
	private String address;
	
	@NotNull
	@NonNull
	@Column(name = "designation", nullable = false)
	private String designation;
	
	@NotNull
	@NonNull
	@Column(name = "updat", nullable = false)
	private final String update="Update";
	
	@NotNull
	@NonNull
	@Column(name = "delet", nullable = false)
	private final String delete="Delete";
	
}
