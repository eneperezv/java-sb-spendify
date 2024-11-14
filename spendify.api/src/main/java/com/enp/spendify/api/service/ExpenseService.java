package com.enp.spendify.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.spendify.api.dto.ExpenseDto;
import com.enp.spendify.api.model.Expense;
import com.enp.spendify.api.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	public Expense buildEntity(ExpenseDto expenseDto) {
		Expense expense = new Expense();
		expense.setId(expenseDto.getId());
		expense.setDescription(expenseDto.getDescription());
		expense.setAmount(expenseDto.getAmount());
		expense.setDate(expenseDto.getDate());
		expense.setUser(userService.buildEntity(expenseDto.getUser()));
		expense.setCategory(categoryService.buildEntity(expenseDto.getCategory()));
		
		return expense;
	}
	
	public ExpenseDto buildDto(Optional<Expense> optional) {
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setId(optional.get().getId());
		expenseDto.setDescription(optional.get().getDescription());
		expenseDto.setAmount(optional.get().getAmount());
		expenseDto.setDate(optional.get().getDate());
		expenseDto.setUser(userService.buildDtoFromUser(optional.get().getUser()));
		expenseDto.setCategory(categoryService.buildDtoFromCategory(optional.get().getCategory()));
		
		return expenseDto;
	}
	
	public ExpenseDto buildDtoFromCategory(Expense expense) {
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setId(expense.getId());
		expenseDto.setDescription(expense.getDescription());
		expenseDto.setAmount(expense.getAmount());
		expenseDto.setDate(expense.getDate());
		expenseDto.setUser(userService.buildDtoFromUser(expense.getUser()));
		expenseDto.setCategory(categoryService.buildDtoFromCategory(expense.getCategory()));
		
		return expenseDto;
	}
	
}
