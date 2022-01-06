package com.usecase.hospitalmgmt.patients.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.patients.model.PatientCheckout;

@Repository
public class PatientCheckoutDao {
private static final Logger logger = LoggerFactory.getLogger(PatientCheckoutDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PatientCheckout findPatientCheckout(int patientId) throws Exception {
		logger.info("Inside findPatientCheckout() in PatientCheckoutDao.java ");
		String sql = "select ActivityID,Title from tblPatientCheckout where IsDeleted=0";
		PatientCheckout patientCheckout=new PatientCheckout();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			
			if (null != row.get("address"))
				patientCheckout.setAddress((String) row.get("address"));
			if (null != row.get("patientId"))
				patientCheckout.setPatientId((Integer) row.get("patientId"));
			if (null != row.get("patientName"))
				patientCheckout.setPatientName((String) row.get("patientName"));
			if (null != row.get("adharId"))
				patientCheckout.setAdharId((String) row.get("adharId"));
			if (null != row.get("paymentType"))
				patientCheckout.setAge((int) row.get("age"));
			if (null != row.get("buildingName"))
				patientCheckout.setBuildingName((String) row.get("buildingName"));
			if (null != row.get("contact"))
				patientCheckout.setContact((String) row.get("contact"));
			if (null != row.get("dateIn"))
				patientCheckout.setDateIn((String) row.get("dateIn"));
			if (null != row.get("dateOut"))
				patientCheckout.setDateOut((String) row.get("dateOut"));
			if (null != row.get("diseaseType"))
				patientCheckout.setDiseaseType((String) row.get("diseaseType"));
			if (null != row.get("gender"))
				patientCheckout.setGender((String) row.get("gender"));
			if (null != row.get("hospitalName"))
				patientCheckout.setHospitalName((String) row.get("hospitalName"));
			if (null != row.get("medicinePrice"))
				patientCheckout.setMedicinePrice((Integer) row.get("medicinePrice"));
			if (null != row.get("price"))
				patientCheckout.setPrice((Integer) row.get("price"));
			if (null != row.get("roomNumber"))
				patientCheckout.setRoomNumber((Integer) row.get("roomNumber"));
			if (null != row.get("roomType"))
				patientCheckout.setRoomType((String) row.get("roomType"));
			if (null != row.get("status"))
				patientCheckout.setStatus((String) row.get("status"));
			
			if (null != row.get("total"))
				patientCheckout.setTotal((Integer) row.get("total"));
			
		}
		return patientCheckout;
	}
	
	@Transactional
	public Integer updatePatientCheckout(PatientCheckout patientCheckout) throws Exception {
		logger.info("Inside PatientCheckout() in PatientCheckoutDao.java ");
		String sql = "UPDATE tblPatientCheckout SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, patientCheckout);
	}
	
	@Transactional
	public Integer deletePatientCheckout(Integer loggedInUser) throws Exception {
		logger.info("Inside deletePatientCheckout() in PatientCheckoutDao.java ");
		String sql = "UPDATE tblPatientCheckout SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}

}
