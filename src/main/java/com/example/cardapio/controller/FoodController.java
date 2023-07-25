package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

@RestController // Essa anotação indica que a classe é um controlador REST, 
//o que significa que ele irá responder a solicitações HTTP e retornar dados em um formato adequado.

@RequestMapping("food") // Essa anotação especifica o caminho da URL que o controlador irá tratar. 
//Nesse caso, quando a URL tiver "/food", as solicitações serão direcionadas para este controlador.

public class FoodController {
	
	@Autowired
	private FoodRepository repository;
	
	@CrossOrigin(origins =  "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
		return;
	}
	
	@CrossOrigin(origins =  "*", allowedHeaders = "*")
	@GetMapping // quando chamar um get na classe food, vai retorna esse metodo
	public List<FoodResponseDTO> getAll() {
			
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		
		return foodList;
		
	}
}
