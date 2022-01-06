package com.usecase.hospitalmgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.hospitalmgmt.exception.NoRecordFoundException;
import com.usecase.hospitalmgmt.patients.model.PatientCheckout;
import com.usecase.hospitalmgmt.patients.model.PatientLoadData;
import com.usecase.hospitalmgmt.patients.model.PatientRegistration;
import com.usecase.hospitalmgmt.patients.model.PatientRoomInfo;
import com.usecase.hospitalmgmt.patients.model.StaffInfo;
import com.usecase.hospitalmgmt.patients.repository.PatientCheckoutDao;
import com.usecase.hospitalmgmt.patients.repository.PatientRegistrationDao;
import com.usecase.hospitalmgmt.patients.repository.PatientRoomInfoDao;
import com.usecase.hospitalmgmt.patients.repository.PatientStaffInfoDao;

@Service
public class PatientsSearch {

	@Autowired
	PatientCheckoutDao patientCheckoutDao;
	@Autowired
	PatientRegistrationDao patientRegistrationDao;
	@Autowired
	PatientRoomInfoDao patientRoomInfoDao;
	@Autowired
	PatientStaffInfoDao patientStaffInfoDao;
	
	Logger logger = LoggerFactory.getLogger(PatientsSearch.class);
	
	/**
	 * @param  id: patients adhar id that needs to be searched
	 * @return Response: patients template received back from the application
	 * @throws ResourceNotFoundException: in case of invalid id, throws this exception
	 */
	public PatientLoadData searchPatients(int patientsAdharId)
			throws NoRecordFoundException, Exception {
		logger.info("Service: view all about patients in the database");
		PatientLoadData patientLoadData=new PatientLoadData();
		PatientRegistration searchPatients = patientRegistrationDao.findPatientRegistration(patientsAdharId);
				if (searchPatients.getIsDeleted() == 1)
				{
					logger.info("Service: Patients adhar is deleted: ");
					patientLoadData.setAvailableFlag(false);
					return new PatientLoadData();
				}
				else {
					logger.info("Service: Patients adhar found: ");
					patientLoadData.setAvailableFlag(true);
					PatientCheckout patientCheckout = patientCheckoutDao.findPatientCheckout(patientsAdharId);
					PatientRegistration patientRegistration = patientRegistrationDao.findPatientRegistration(patientsAdharId);
					PatientRoomInfo patientRoomInfo = patientRoomInfoDao.findPatientRoomInfo(patientsAdharId);
					StaffInfo staffInfo = patientStaffInfoDao.findStaffInfo(patientsAdharId);
					patientLoadData.setPatientCheckout(patientCheckout);
					patientLoadData.setPatientRegistration(patientRegistration);
					patientLoadData.setPatientRoomInfo(patientRoomInfo);
					patientLoadData.setStaffInfo(staffInfo);
					return patientLoadData;
	
				}
		
	}
	
	public Integer updatePatientCheckout(PatientCheckout patientCheckout) throws Exception {					
			return patientCheckoutDao.updatePatientCheckout(patientCheckout);
		}
	
	
	public Integer deletePatientCheckout(Integer loggedInUser) throws Exception {		
		return patientCheckoutDao.deletePatientCheckout(loggedInUser);
	}

	
	
}