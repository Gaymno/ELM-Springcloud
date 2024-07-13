package org.example.controller;

import java.util.List;


import org.example.po.Business;
import org.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


//I try
@RestController
@RequestMapping("/BusinessController")
@RefreshScope
public class BusinessController {
	@Value("${msg}")
	private String msg;
	@Autowired
	private BusinessService businessService;

	@PostMapping("/listBusinessByOrderTypeId")
	public List<Business> listBusinessByOrderTypeId(@RequestBody Business business) {
		System.out.println(msg);
		return businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
	}

	@PostMapping ("/getBusinessById")
	public Business getBusinessById(@RequestBody Business business) {
		return businessService.getBusinessById(business.getBusinessId());
	}

}
