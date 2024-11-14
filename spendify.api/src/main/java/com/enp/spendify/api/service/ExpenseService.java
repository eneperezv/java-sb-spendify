package com.enp.spendify.api.service;

/*
 * @(#)ExpenseService.java 1.0 13/11/2024
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
import java.util.ArrayList;
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
	
	public ExpenseDto buildDtoFromExpense(Expense expense) {
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setId(expense.getId());
		expenseDto.setDescription(expense.getDescription());
		expenseDto.setAmount(expense.getAmount());
		expenseDto.setDate(expense.getDate());
		expenseDto.setUser(userService.buildDtoFromUser(expense.getUser()));
		expenseDto.setCategory(categoryService.buildDtoFromCategory(expense.getCategory()));
		
		return expenseDto;
	}
	
	public List<Expense> setListaFromListaDto(List<ExpenseDto> listaDto){
		List<Expense> lista = new ArrayList<Expense>();
		for(ExpenseDto expenseDto : listaDto){
			lista.add(buildEntity(expenseDto));
		}
		
		return lista;
	}
	
	public List<ExpenseDto> setListaDtoFromLista(List<Expense> lista){
		List<ExpenseDto> listaDto = new ArrayList<ExpenseDto>();
		for(Expense expense : lista){
			listaDto.add(buildDtoFromExpense(expense));
		}
		
		return listaDto;
	}

	public ExpenseDto createExpense(ExpenseDto expenseDto) {
		return buildDto(Optional.of(expenseRepository.save(buildEntity(expenseDto))));
	}

	public List<ExpenseDto> fidnAllExpensesByUserId(Long userid) {
		return setListaDtoFromLista(expenseRepository.fidnAllExpensesByUserId(userid));
	}
	
}
