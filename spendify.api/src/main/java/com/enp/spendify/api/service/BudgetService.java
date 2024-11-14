package com.enp.spendify.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.spendify.api.dto.BudgetDto;
import com.enp.spendify.api.dto.CategoryDto;
import com.enp.spendify.api.model.Budget;
import com.enp.spendify.api.model.Category;
import com.enp.spendify.api.repository.BudgetRepository;

@Service
public class BudgetService {
	
	/*
	 *	private Long id;
    private BigDecimal totalAmount;
    private BigDecimal amountSpent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UserDto user;
	 */
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private UserService userService;
	
	public Budget buildEntity(BudgetDto budgetDto) {
		Budget budget = new Budget();
		budget.setId(budgetDto.getId());
		budget.setTotalAmount(budgetDto.getTotalAmount());
		budget.setAmountSpent(budgetDto.getAmountSpent());
		budget.setStartDate(budgetDto.getStartDate());
		budget.setEndDate(budgetDto.getEndDate());
		budget.setUser(userService.buildEntity(budgetDto.getUser()));
		
		return budget;
	}
	
	public BudgetDto buildDto(Optional<Budget> optional) {
		BudgetDto budgetDto = new BudgetDto();
		budgetDto.setId(optional.get().getId());
		budgetDto.setTotalAmount(optional.get().getTotalAmount());
		budgetDto.setAmountSpent(optional.get().getAmountSpent());
		budgetDto.setStartDate(optional.get().getStartDate());
		budgetDto.setEndDate(optional.get().getEndDate());
		budgetDto.setUser(userService.buildDtoFromUser(optional.get().getUser()));
		
		return budgetDto;
	}
	
	public BudgetDto buildDtoFromCategory(Budget budget) {
		BudgetDto budgetDto = new BudgetDto();
		budgetDto.setId(budget.getId());
		budgetDto.setTotalAmount(budget.getTotalAmount());
		budgetDto.setAmountSpent(budget.getAmountSpent());
		budgetDto.setStartDate(budget.getStartDate());
		budgetDto.setEndDate(budget.getEndDate());
		budgetDto.setUser(userService.buildDtoFromUser(budget.getUser()));
		
		return budgetDto;
	}

}
