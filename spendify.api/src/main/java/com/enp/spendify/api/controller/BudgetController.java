package com.enp.spendify.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.spendify.api.service.BudgetService;

@RestController
@RequestMapping("/api/v1/spendify/budget")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	
	

}
