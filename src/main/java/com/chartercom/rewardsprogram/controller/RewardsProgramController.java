package com.chartercom.rewardsprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chartercom.rewardsprogram.service.RewardsProgramService;
import com.chartercom.rewardsprogram.vo.CustomerPointsResponse;
import com.chartercom.rewardsprogram.vo.ServiceResponse;

@RestController
public class RewardsProgramController {
	@Autowired
	private RewardsProgramService rewardsProgramService;

	@GetMapping("/customer/{id}")
	public ResponseEntity<ServiceResponse<CustomerPointsResponse>> getCustomers(@PathVariable Integer id) {
		CustomerPointsResponse customerPointsResponse=rewardsProgramService.getCustomerPoints(id);		
		return new ResponseEntity<>(new ServiceResponse<>(customerPointsResponse,null),HttpStatus.OK);
	}
}
