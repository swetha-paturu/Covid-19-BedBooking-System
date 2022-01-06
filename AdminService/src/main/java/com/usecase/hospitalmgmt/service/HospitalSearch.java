package com.usecase.hospitalmgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.hospitalmgmt.exception.NoRecordFoundException;
import com.usecase.hospitalmgmt.hospital.model.AccountInfo;
import com.usecase.hospitalmgmt.hospital.model.HospitalInfo;
import com.usecase.hospitalmgmt.hospital.model.HospitalLoadData;
import com.usecase.hospitalmgmt.hospital.model.PatientsInfo;
import com.usecase.hospitalmgmt.hospital.model.StaffInfo;
import com.usecase.hospitalmgmt.hospital.repository.AccountInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.HospitalInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.PatientsInfoDao;
import com.usecase.hospitalmgmt.hospital.repository.StaffInfoDao;

@Service
public class HospitalSearch {

	@Autowired
	AccountInfoDao accountInfoDao;
	@Autowired
	HospitalInfoDao hospitalInfoDao;
	@Autowired
	PatientsInfoDao patientsInfoDao;
	@Autowired
	StaffInfoDao staffInfoDao;
	
	Logger logger = LoggerFactory.getLogger(HospitalSearch.class);
	
	/**
	 * @param  id: Hospital info that needs to be searched
	 * @return Response: Hospital template received back from the application
	 * @throws ResourceNotFoundException: in case of invalid id, throws this exception
	 */
	public HospitalLoadData searchHospitals(int hospitalId)
			throws NoRecordFoundException, Exception {
		logger.info("Service: view all about hospital in the database");
		HospitalLoadData hospitalLoadData=new HospitalLoadData();
		HospitalInfo searchHospital = hospitalInfoDao.findHospitalInfo(hospitalId);
				if (searchHospital.getIsDeleted() == 1)
				{
					logger.info("Service: Hospital id not found ");
					hospitalLoadData.setAvailableFlag(false);
					return hospitalLoadData;
				}
				else {
					logger.info("Service: Hospital id found ");
					hospitalLoadData.setAvailableFlag(true);
					AccountInfo accountInfo = accountInfoDao.findAccountInfo(hospitalId);
					HospitalInfo hospitalInfo = hospitalInfoDao.findHospitalInfo(hospitalId);
					List<PatientsInfo> patientsInfo = patientsInfoDao.findPatientsInfo(hospitalId);
					List<StaffInfo> staffInfo = staffInfoDao.findStaffInfo(hospitalId);
					hospitalLoadData.setAccountInfo(accountInfo);
					hospitalLoadData.setHospitalInfo(hospitalInfo);
					hospitalLoadData.setPatientsInfo(patientsInfo);
					hospitalLoadData.setStaffInfo(staffInfo);
					return hospitalLoadData;
				}
		
	}



	
}
