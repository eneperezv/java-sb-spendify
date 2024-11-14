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
	private ExpenseService expenseService;
	
	public Category buildEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		category.setExpenses(categoryDto.getExpenses());
		
		return category;
	}
	
	public CategoryDto buildDto(Optional<Category> optional) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(optional.get().getId());
		categoryDto.setName(optional.get().getName());
		categoryDto.setDescription(optional.get().getDescription());
		categoryDto.setExpenses(optional.get().getExpenses());
		
		return categoryDto;
	}
	
	public CategoryDto buildDtoFromCategory(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		categoryDto.setExpenses(category.getExpenses());
		
		return categoryDto;
	}
	
	/*
	public List<Category> getCategoryList(List<CategoryDto> categoryListaDto){
		List<Category> categoryListas = new ArrayList<Category>();
		
		for(CategoryDto categoryDto : categoryListaDto){
			categoryListas.add(buildDtoFromCategory(category));
		}

		return categoryListaDto;
	}
	
	public List<ExpenseDto> getCategoryListDto(List<Expense> categoryLista){
		List<ExpenseDto> expenseListaDto = new ArrayList<ExpenseDto>();
		
		for(Category category : categoryLista){
			categoryListaDto.add(buildDtoFromCategory(category));
		}

		return categoryListaDto;
	}
	*/
}
