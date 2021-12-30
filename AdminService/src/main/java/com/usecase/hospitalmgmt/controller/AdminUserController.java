package com.usecase.hospitalmgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user/")
public class AdminUserController {
	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	
//	@Autowired
//	PatientCheckoutService service;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Hello User";
	}
	
//	@GetMapping("admin/user/search/{patientsAdhar}")
//	public PatientLoadData searchByPatients(@PathVariable Long patientsAdhar) throws Exception {
//		logger.info("Inside SearchByPatients() in AdminUserController.java");
//		PatientLoadData patientLoadData = service.searchPatients(patientsAdhar);		
//		return patientLoadData;
//	}

}
