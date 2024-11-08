package com.enp.spendify.api.dto;

/*
 * @(#)CategoryDto.java 1.0 07/11/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.List;

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
