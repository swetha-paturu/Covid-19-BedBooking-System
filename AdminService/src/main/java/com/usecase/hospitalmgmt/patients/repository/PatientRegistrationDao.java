package com.usecase.hospitalmgmt.patients.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.patients.model.PatientRegistration;

@Repository
public class PatientRegistrationDao {
private static final Logger logger = LoggerFactory.getLogger(PatientRegistrationDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PatientRegistration findPatientRegistration(int patientId) throws Exception {
		logger.info("Inside findPatientRegistration() in PatientRegistrationDao.java ");
		String sql = "select ActivityID,Title from tblPatientRegistration where IsDeleted=0";
		PatientRegistration patientRegistration=new PatientRegistration();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			
			if (null != row.get("address"))
				patientRegistration.setAddress((String) row.get("address"));
			if (null != row.get("patientName"))
				patientRegistration.setPatientName((String) row.get("patientName"));
			if (null != row.get("adharId"))
				patientRegistration.setAdharId((String) row.get("adharId"));
			if (null != row.get("paymentType"))
				patientRegistration.setAge((int) row.get("age"));
			if (null != row.get("contact"))
				patientRegistration.setContact((String) row.get("contact"));
			
			if (null != row.get("diseaseType"))
				patientRegistration.setDiseaseType((String) row.get("diseaseType"));
			if (null != row.get("gender"))
				patientRegistration.setGender((String) row.get("gender"));
			if (null != row.get("hospitalName"))
				patientRegistration.setPrice((Integer) row.get("price"));
			if (null != row.get("price"))
				patientRegistration.setPrice((Integer) row.get("price"));
			if (null != row.get("roomType"))
				patientRegistration.setRoomType((String) row.get("roomType"));
			
			if (null != row.get("age"))
				patientRegistration.setAge((Integer) row.get("age"));
			if (null != row.get("isDeleted"))
				patientRegistration.setIsDeleted((Integer) row.get("isDeleted"));
			if (null != row.get("patientId"))
				patientRegistration.setPatientId((Integer) row.get("patientId"));
			
			
		}
		return patientRegistration;
	}
	
	@Transactional
	public Integer updatePatientRegistration(PatientRegistration patientRegistration) throws Exception {
		logger.info("Inside PatientRegistration() in PatientRegistrationDao.java ");
		String sql = "UPDATE tblPatientRegistration SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, patientRegistration);
	}
	
	@Transactional
	public Integer deletePatientRegistration(Integer loggedInUser) throws Exception {
		logger.info("Inside deletePatientRegistration() in PatientRegistrationDao.java ");
		String sql = "UPDATE tblPatientRegistration SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}
}
