package com.springboot.bankingApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cusId;
	
	@NotNull
	@NonNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@NonNull
	@NotNull
	@Column(name = "address", nullable = false)
	private String address;

	@NonNull
	@NotNull
	@Column(name = "balance", nullable = false)
	private long balance;
	
	@NonNull
	@NotNull
	@Column(name = "updat", nullable = false)
	private String update;
	
	@NonNull
	@NotNull
	@Column(name = "delet", nullable = false)
	private String delete;
}
