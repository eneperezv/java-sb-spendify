package com.enp.spendify.api.controller;

/*
 * @(#)CategoryController.java 1.0 14/11/2024
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

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.spendify.api.dto.CategoryDto;
import com.enp.spendify.api.model.ErrorDetails;
import com.enp.spendify.api.model.ResponseDetails;
import com.enp.spendify.api.service.CategoryService;

@RestController
@RequestMapping("/api/v1/spendify/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseDetails<?> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto savedCategoryDto;
		try{
			savedCategoryDto = categoryService.createCategory(categoryDto);
			if(savedCategoryDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Category <"+savedCategoryDto+"> not created");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<CategoryDto>("OK",new Date(),new ResponseEntity<CategoryDto>(savedCategoryDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
