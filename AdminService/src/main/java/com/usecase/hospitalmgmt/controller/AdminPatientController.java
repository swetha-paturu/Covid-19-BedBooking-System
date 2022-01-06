package com.usecase.hospitalmgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.hospitalmgmt.patients.model.PatientCheckout;
import com.usecase.hospitalmgmt.patients.model.PatientLoadData;
import com.usecase.hospitalmgmt.patients.model.PatientRegistration;
import com.usecase.hospitalmgmt.patients.model.PatientRoomInfo;
import com.usecase.hospitalmgmt.patients.model.StaffInfo;
import com.usecase.hospitalmgmt.patients.repository.PatientCheckoutDao;
import com.usecase.hospitalmgmt.patients.repository.PatientRegistrationDao;
import com.usecase.hospitalmgmt.patients.repository.PatientRoomInfoDao;
import com.usecase.hospitalmgmt.patients.repository.PatientStaffInfoDao;
import com.usecase.hospitalmgmt.service.PatientsSearch;

@RestController
@RequestMapping("/admin/patients")
public class AdminPatientController {
	private static final Logger logger = LoggerFactory.getLogger(AdminPatientController.class);
	
	@Autowired
	PatientsSearch patientsSearch;
	@Autowired
	PatientCheckoutDao patientCheckoutDao;
	@Autowired
	PatientRegistrationDao patientRegistrationDao;
	@Autowired
	PatientRoomInfoDao patientRoomInfoDao;
	@Autowired
	PatientStaffInfoDao patientStaffInfoDao;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Hello User";
	}	
	
	@GetMapping("/search/{patientsAdhar}")
	public PatientLoadData searchByPatients(@PathVariable int patientsAdhar) throws Exception {
		logger.info("Inside SearchByPatients() in AdminUserController.java");
		PatientLoadData patientLoadData = patientsSearch.searchPatients(patientsAdhar);		
		return patientLoadData;
	}
	
		
	@PostMapping("/updateCheckout")
	public Integer updatePatientCheckout(@RequestBody PatientCheckout patientCheckout) throws Exception {		
		return patientCheckoutDao.updatePatientCheckout(patientCheckout);
	}

	@DeleteMapping("/deleteCheckout/{loggedInUser}")
	public Integer deletePatientCheckout(@PathVariable Integer loggedInUser) throws Exception {		
		return patientCheckoutDao.deletePatientCheckout(loggedInUser);
	}
	@PostMapping("/updatePatientRegistration")
	public Integer updatePatientRegistration(@RequestBody PatientRegistration patientRegistration) throws Exception {		
		return patientRegistrationDao.updatePatientRegistration(patientRegistration);
	}
	
	@DeleteMapping("/deletePatientRegistration/{loggedInUser}")
	public Integer deletePatientRegistration(@PathVariable Integer loggedInUser) throws Exception {	
		return patientRegistrationDao.deletePatientRegistration(loggedInUser);		
	}
	
	@PostMapping("/updatePatientRoomInfo")
	public Integer updatePatientRoomInfo(@RequestBody PatientRoomInfo patientRoomInfo) throws Exception {		
		return patientRoomInfoDao.updatePatientRoomInfo(patientRoomInfo);
	}
	
	@DeleteMapping("/deletePatientRoomInfo/{loggedInUser}")
	public Integer deletePatientRoomInfo(@PathVariable Integer loggedInUser) throws Exception {	
		return patientRoomInfoDao.deletePatientRoomInfo(loggedInUser);		
	}
	
	@PostMapping("/updateStaffInfo")
	public Integer updatePatientRoomInfo(@RequestBody StaffInfo staffInfo) throws Exception {		
		return patientStaffInfoDao.updateStaffInfo(staffInfo);
	}
	
	@DeleteMapping("/deleteStaffInfo/{loggedInUser}")
	public Integer deleteStaffInfo(@PathVariable Integer loggedInUser) throws Exception {	
		return patientStaffInfoDao.deleteStaffInfo(loggedInUser);
		
	}

}
