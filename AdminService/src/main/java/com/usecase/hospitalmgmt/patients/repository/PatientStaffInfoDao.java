package com.usecase.hospitalmgmt.patients.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.patients.model.StaffInfo;

@Repository
public class PatientStaffInfoDao {
	
private static final Logger logger = LoggerFactory.getLogger(PatientStaffInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StaffInfo findStaffInfo(int patientId) throws Exception {
		logger.info("Inside findStaffInfo() in StaffInfoDao.java ");
		String sql = "select ActivityID,Title from tblStaffInfo where IsDeleted=0";
		StaffInfo staffInfo=new StaffInfo();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			
			if (null != row.get("contact"))
				staffInfo.setContact((String) row.get("contact"));
			if (null != row.get("gender"))
				staffInfo.setGender((String) row.get("gender"));
			if (null != row.get("hospitalName"))
				staffInfo.setHospitalName((String) row.get("hospitalName"));
			if (null != row.get("patientId"))
				staffInfo.setPatientId((Integer) row.get("patientId"));
			if (null != row.get("hospitalName"))
				staffInfo.setHospitalName((String) row.get("hospitalName"));
			
			if (null != row.get("position"))
				staffInfo.setPosition((String) row.get("position"));
			if (null != row.get("staffId"))
				staffInfo.setStaffId((Integer) row.get("staffId"));
			if (null != row.get("staffName"))
				staffInfo.setStaffName((String) row.get("staffName"));							
			
		}
		return staffInfo;
	}
	
	@Transactional
	public Integer updateStaffInfo(StaffInfo staffInfo) throws Exception {
		logger.info("Inside updateStaffInfo() in StaffInfoDao.java ");
		String sql = "UPDATE tblStaffInfo SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, staffInfo);
	}
	
	@Transactional
	public Integer deleteStaffInfo(Integer loggedInUser) throws Exception {
		logger.info("Inside deleteStaffInfo() in StaffInfoDao.java ");
		String sql = "UPDATE tblStaffInfo SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}

}
