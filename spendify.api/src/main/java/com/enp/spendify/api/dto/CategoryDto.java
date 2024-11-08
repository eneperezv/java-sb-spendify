package com.enp.spendify.api.dto;

import java.util.List;

import com.enp.spendify.api.model.Expense;

public class CategoryDto {
	
	private Long id;
    private String name;
    private String description;
    private List<ExpenseDto> expenses;
    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ExpenseDto> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseDto> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", description=" + description + ", expenses=" + expenses
				+ "]";
	}

}
