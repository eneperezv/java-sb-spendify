package com.enp.spendify.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseDto {
	
	private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
    private UserDto user;
    private CategoryDto category;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ExpenseDto [id=" + id + ", description=" + description + ", amount=" + amount + ", date=" + date
				+ ", user=" + user + "]";
	}

}
