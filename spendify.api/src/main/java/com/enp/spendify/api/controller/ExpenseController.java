package com.enp.spendify.api.controller;

/*
 * @(#)ExpenseController.java 1.0 14/11/2024
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.spendify.api.dto.ExpenseDto;
import com.enp.spendify.api.model.ErrorDetails;
import com.enp.spendify.api.model.ResponseDetails;
import com.enp.spendify.api.service.ExpenseService;

@RestController
@RequestMapping("/api/v1/spendify/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/create")
	public ResponseDetails<?> createExpense(@RequestBody ExpenseDto expenseDto){
		ExpenseDto savedExpenseDto;
		try{
			savedExpenseDto = expenseService.createExpense(expenseDto);
			if(savedExpenseDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Expense <"+savedExpenseDto+"> not created");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<ExpenseDto>("OK",new Date(),new ResponseEntity<ExpenseDto>(savedExpenseDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/find-by-user/{userid}")
	public ResponseDetails<?> getExpensesFromUser(@PathVariable Long userid){
		List<ExpenseDto> listaExpenseDto = new ArrayList<ExpenseDto>();
		try {
			expenseService.fidnAllExpensesByUserId(userid).forEach(listaExpenseDto::add);
			if(listaExpenseDto.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"No expenses associated with the user were found.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<List<ExpenseDto>>("OK",new Date(),new ResponseEntity<List<ExpenseDto>>(listaExpenseDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
