package com.enp.spendify.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BudgetDto {
	
	private Long id;
    private BigDecimal totalAmount;
    private BigDecimal amountSpent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UserDto user;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(BigDecimal amountSpent) {
		this.amountSpent = amountSpent;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BudgetDto [id=" + id + ", totalAmount=" + totalAmount + ", amountSpent=" + amountSpent + ", startDate="
				+ startDate + ", endDate=" + endDate + ", user=" + user + "]";
	}

}
