package org.example.controller;

import java.util.List;


import org.example.po.DeliveryAddress;
import org.example.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {

	@Autowired
	private DeliveryAddressService deliveryAddressService;
	
	@PostMapping("/listDeliveryAddressByUserId")
	public List<DeliveryAddress> listDeliveryAddressByUserId(@RequestBody DeliveryAddress deliveryAddress) {
		return deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
	} 
	
	@PostMapping("/getDeliveryAddressById")
	public DeliveryAddress getDeliveryAddressById(@RequestBody DeliveryAddress deliveryAddress) {
		return deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
	} 
	
	@PostMapping("/saveDeliveryAddress")
	public int saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
		return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
	} 
	
	@PostMapping("/updateDeliveryAddress")
	public int updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
		return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
	} 
	
	@PostMapping ("/removeDeliveryAddress")
	public int removeDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
		return deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
	} 
}
