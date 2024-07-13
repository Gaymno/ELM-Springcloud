package org.example.service;



import org.example.po.Food;

import java.util.List;

public interface FoodService {

	public List<Food> listFoodByBusinessId(Integer businessId);
}
