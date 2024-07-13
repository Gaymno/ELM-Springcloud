package org.example.controller;

import java.util.List;

import org.example.po.Food;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/FoodController")
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	@PostMapping("/listFoodByBusinessId")
	public List<Food> listFoodByBusinessId(@RequestBody Food food) throws Exception{
		return foodService.listFoodByBusinessId(food.getBusinessId());
	}
}
