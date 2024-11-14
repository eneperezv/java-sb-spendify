package com.enp.spendify.api.service;

/*
 * @(#)CategoryService.java 1.0 13/11/2024
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
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.spendify.api.dto.BudgetDto;
import com.enp.spendify.api.dto.CategoryDto;
import com.enp.spendify.api.model.Budget;
import com.enp.spendify.api.model.Category;
import com.enp.spendify.api.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseService expenseService;
	
	public Category buildEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		//category.setExpenses(categoryDto.getExpenses());
		
		return category;
	}
	
	public CategoryDto buildDto(Optional<Category> optional) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(optional.get().getId());
		categoryDto.setName(optional.get().getName());
		categoryDto.setDescription(optional.get().getDescription());
		//categoryDto.setExpenses(optional.get().getExpenses());
		
		return categoryDto;
	}
	
	public CategoryDto buildDtoFromCategory(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		//categoryDto.setExpenses(category.getExpenses());
		
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
	*/
}
