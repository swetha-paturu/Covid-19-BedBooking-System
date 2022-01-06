package com.usecase.hospitalmgmt.hospital.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.hospital.model.PatientsInfo;

@Repository
public class PatientsInfoDao {
private static final Logger logger = LoggerFactory.getLogger(PatientsInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PatientsInfo> findPatientsInfo(int hospitalId) throws Exception {
		logger.info("Inside findPatientsInfo() in HospitalInfo.java ");
		String sql = "select ActivityID,Title from tblHospitalInfo where IsDeleted=0";
		List<PatientsInfo> listPatientsInfo=new ArrayList<PatientsInfo>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			PatientsInfo patientsInfo=new PatientsInfo();
			if (null != row.get("hospitalId"))
				patientsInfo.setAddress((String) row.get("address"));
			if (null != row.get("adharId"))
				patientsInfo.setAdharId((String) row.get("adharId"));
			if (null != row.get("contactSecondary"))
				patientsInfo.setAge((Integer) row.get("age"));
			if (null != row.get("approvalStatus"))
				patientsInfo.setApprovalStatus((String) row.get("approvalStatus"));
			if (null != row.get("contact"))
				patientsInfo.setContact((String) row.get("contact"));
			if (null != row.get("nearByLandmark"))
				patientsInfo.setDiseaseType((String) row.get("diseaseType"));
			if (null != row.get("gender"))
				patientsInfo.setGender((String) row.get("gender"));
			if (null != row.get("hospitalId"))
				patientsInfo.setHospitalId((Integer) row.get("hospitalId"));
			if (null != row.get("patientName"))
				patientsInfo.setPatientName((String) row.get("patientName"));
			if (null != row.get("cost"))
				patientsInfo.setCost((Integer) row.get("cost"));
			if (null != row.get("roomType"))
				patientsInfo.setRoomType((String) row.get("roomType"));
			listPatientsInfo.add(patientsInfo);
		}
		return listPatientsInfo;
	}
	
	@Transactional
	public Integer updatePatientsInfo(PatientsInfo patientsInfo) throws Exception {
		logger.info("Inside updatePatientsInfo() in PatientsInfoDao.java ");
		String sql = "UPDATE tblPatientsInfo SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, patientsInfo);
	}
	
	@Transactional
	public Integer deletePatientsInfo(Integer loggedInUser) throws Exception {
		logger.info("Inside deletePatientsInfo() in PatientsInfoDao.java ");
		String sql = "UPDATE tblPatientsInfo SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}
}
