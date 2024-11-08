package com.enp.spendify.api.dto;

/*
 * @(#)BudgetDto.java 1.0 07/11/2024
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
