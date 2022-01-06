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

import com.usecase.hospitalmgmt.hospital.model.AccountInfo;
import com.usecase.hospitalmgmt.hospital.model.HospitalInfo;
import com.usecase.hospitalmgmt.hospital.model.HospitalLoadData;
import com.usecase.hospitalmgmt.hospital.model.PatientsInfo;
import com.usecase.hospitalmgmt.hospital.model.StaffInfo;
import com.usecase.hospitalmgmt.hospital.repository.AccountInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.HospitalInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.PatientsInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.StaffInfoDao;
import com.usecase.hospitalmgmt.service.HospitalSearch;

@RestController
@RequestMapping("/admin/hospital")
public class AdminHospitalController {
	
private static final Logger logger = LoggerFactory.getLogger(AdminHospitalController.class);
	
	
	@Autowired
	HospitalSearch hospitalSearch;
	@Autowired
	AccountInfoDao accountInfoDao;
	@Autowired
	HospitalInfoDao hospitalInfoDao;
	@Autowired
	PatientsInfoDao patientsInfoDao;
	@Autowired
	StaffInfoDao staffInfoDao;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Hello Hospital";
	}	
	
	@GetMapping("/search/{hospitalId}")
	public HospitalLoadData searchByHospitals(@PathVariable int hospitalId) throws Exception {
		logger.info("Inside searchByHospitals() in AdminHospitalController.java");
		HospitalLoadData patientLoadData = hospitalSearch.searchHospitals(hospitalId);		
		return patientLoadData;
	}
	
	@PostMapping("/updateAccountInfo")
	public Integer updateAccountInfo(@RequestBody AccountInfo accountInfo) throws Exception {		
		return accountInfoDao.updateAccountInfo(accountInfo);
	}

	@DeleteMapping("/deleteAccountInfo/{hospitalId}")
	public Integer deleteAccountInfo(@PathVariable Integer hospitalId) throws Exception {		
		return accountInfoDao.deleteAccountInfo(hospitalId);
	}
	@PostMapping("/updateHospitalInfo")
	public Integer updateHospitalInfo(@RequestBody HospitalInfo hospitalInfo) throws Exception {		
		return hospitalInfoDao.updateHospitalInfo(hospitalInfo);
	}
	
	@DeleteMapping("/deleteHospitalInfo/{hospitalId}")
	public Integer deleteHospitalInfo(@PathVariable Integer hospitalId) throws Exception {	
		return hospitalInfoDao.deleteHospitalInfo(hospitalId);		
	}
	
	@PostMapping("/updatePatientsInfo")
	public Integer updatePatientsInfo(@RequestBody PatientsInfo patientsInfo) throws Exception {		
		return patientsInfoDao.updatePatientsInfo(patientsInfo);
	}
	
	@DeleteMapping("/deletePatientsInfo/{hospitalId}")
	public Integer deletePatientsInfo(@PathVariable Integer loggedInUser) throws Exception {	
		return patientsInfoDao.deletePatientsInfo(loggedInUser);		
	}
	
	@PostMapping("/updateStaffInfo")
	public Integer updateStaffInfo(@RequestBody StaffInfo staffInfo) throws Exception {		
		return staffInfoDao.updateStaffInfo(staffInfo);
	}
	
	@DeleteMapping("/deleteStaffInfo/{staffId}")
	public Integer deleteStaffInfo(@PathVariable Integer staffId) throws Exception {	
		return staffInfoDao.deleteStaffInfo(staffId);
		
	}


}
