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

import com.usecase.hospitalmgmt.hospital.model.StaffInfo;

@Repository
public class StaffInfoDao {
	
private static final Logger logger = LoggerFactory.getLogger(StaffInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<StaffInfo> findStaffInfo(int hospitalId) throws Exception {
		logger.info("Inside findStaffInfo() in StaffInfo.java ");
		String sql = "select ActivityID,Title from tblStaffInfo where IsDeleted=0";
		List<StaffInfo> listStaffInfo=new ArrayList<StaffInfo>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			StaffInfo staffInfo=new StaffInfo();
			if (null != row.get("address"))
				staffInfo.setAddress((String) row.get("address"));
			if (null != row.get("contact"))
				staffInfo.setContact((String) row.get("contact"));
			if (null != row.get("gender"))
				staffInfo.setGender((String) row.get("gender"));
			
			if (null != row.get("hospitalId"))
				staffInfo.setHospitalId((Integer) row.get("hospitalId"));
			if (null != row.get("position"))
				staffInfo.setPosition((String) row.get("position"));
			if (null != row.get("staffName"))
				staffInfo.setStaffName((String) row.get("staffName"));
			listStaffInfo.add(staffInfo);
		}
		return listStaffInfo;
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
