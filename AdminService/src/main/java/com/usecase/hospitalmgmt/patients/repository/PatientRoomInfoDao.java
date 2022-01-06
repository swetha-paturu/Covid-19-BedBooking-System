package com.usecase.hospitalmgmt.patients.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.patients.model.PatientRoomInfo;

@Repository
public class PatientRoomInfoDao {
private static final Logger logger = LoggerFactory.getLogger(PatientRoomInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PatientRoomInfo findPatientRoomInfo(int patientId) throws Exception {
		logger.info("Inside findPatientRoomInfo() in PatientRoomInfoDao.java ");
		String sql = "select ActivityID,Title from tblPatientRoomInfo where IsDeleted=0";
		PatientRoomInfo patientRoomInfo=new PatientRoomInfo();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			
			if (null != row.get("adharId"))
				patientRoomInfo.setAdharId((String) row.get("adharId"));
			if (null != row.get("buildingName"))
				patientRoomInfo.setBuildingName((String) row.get("buildingName"));
			if (null != row.get("diseaseType"))
				patientRoomInfo.setDiseaseType((String) row.get("diseaseType"));
			if (null != row.get("gender"))
				patientRoomInfo.setGender((String) row.get("gender"));
			if (null != row.get("hospitalName"))
				patientRoomInfo.setHospitalName((String) row.get("hospitalName"));
			
			if (null != row.get("noOfBed"))
				patientRoomInfo.setNoOfBed((Integer) row.get("noOfBed"));
			if (null != row.get("patientId"))
				patientRoomInfo.setPatientId((Integer) row.get("patientId"));
			if (null != row.get("patientName"))
				patientRoomInfo.setPatientName((String) row.get("patientName"));
			if (null != row.get("price"))
				patientRoomInfo.setPrice((Integer) row.get("price"));
			if (null != row.get("roomType"))
				patientRoomInfo.setRoomType((String) row.get("roomType"));
			
			if (null != row.get("roomNumber"))
				patientRoomInfo.setRoomNumber((Integer) row.get("roomNumber"));
			if (null != row.get("isDeleted"))
				patientRoomInfo.setStatus((String) row.get("status"));
					
			
		}
		return patientRoomInfo;
	}
	
	@Transactional
	public Integer updatePatientRoomInfo(PatientRoomInfo patientRoomInfo) throws Exception {
		logger.info("Inside updatePatientRoomInfo() in PatientRoomInfoDao.java ");
		String sql = "UPDATE tblPatientRoomInfo SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, patientRoomInfo);
	}
	
	@Transactional
	public Integer deletePatientRoomInfo(Integer loggedInUser) throws Exception {
		logger.info("Inside deletePatientRoomInfo() in PatientRoomInfoDao.java ");
		String sql = "UPDATE tblPatientRoomInfo SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}

}
