package com.springboot.bankingApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Withdraw {
	@NotNull(message = "Field should not be blank")
	private Long fromAccId;

	@NotNull(message = "Amount should not be blank")
	@Min(value = 10, message = "Transaction must be of atleast 10")
	@Max(value = 100000, message = "Transaction must not be greater than 100000")
	private Long amount;
}
