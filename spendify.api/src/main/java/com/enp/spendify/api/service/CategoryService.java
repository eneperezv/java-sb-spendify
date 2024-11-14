package com.enp.spendify.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.LikeDto;
import com.enp.blabber.api.model.Like;
import com.enp.spendify.api.dto.BudgetDto;
import com.enp.spendify.api.dto.CategoryDto;
import com.enp.spendify.api.model.Budget;
import com.enp.spendify.api.model.Category;
import com.enp.spendify.api.repository.CategoryRepository;

@Service
public class CategoryService {
	
	/*
	private Long id;
    private String name;
    private String description;
    private List<ExpenseDto> expenses;
    */
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserService userService;
	
	public Category buildEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		category.setExpenses(getCategoryListDto(categoryDto.getExpenses()));
		
		return category;
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
	
	public List<Category> getCategoryList(List<CategoryDto> categoryListaDto){
		List<Category> categoryListas = new ArrayList<Category>();
		
		for(CategoryDto categoryDto : categoryListaDto){
			categoryListas.add(buildDtoFromCategory(category));
		}

		return categoryListaDto;
	}
	
	public List<CategoryDto> getCategoryListDto(List<Category> categoryLista){
		List<CategoryDto> categoryListaDto = new ArrayList<CategoryDto>();
		
		for(Category category : categoryLista){
			categoryListaDto.add(buildDtoFromCategory(category));
		}

		return categoryListaDto;
	}

}
