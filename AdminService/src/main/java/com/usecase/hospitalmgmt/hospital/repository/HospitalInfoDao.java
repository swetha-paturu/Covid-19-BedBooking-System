package com.usecase.hospitalmgmt.hospital.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.hospital.model.HospitalInfo;

@Repository
public class HospitalInfoDao {
private static final Logger logger = LoggerFactory.getLogger(HospitalInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public HospitalInfo findHospitalInfo(int hospitalId) throws Exception {
		logger.info("Inside findHospitalInfo() in HospitalInfo.java ");
		String sql = "select ActivityID,Title from tblHospitalInfo where IsDeleted=0";
//		List<HospitalInfo> listHospitalInfo=new ArrayList<HospitalInfo>();
		HospitalInfo hospitalInfo=new HospitalInfo();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {			
			if (null != row.get("hospitalId"))
				hospitalInfo.setAddress((String) row.get("address"));
			if (null != row.get("contactPrimary"))
				hospitalInfo.setContactPrimary((String) row.get("contactPrimary"));
			if (null != row.get("contactSecondary"))
				hospitalInfo.setContactSecondary((String) row.get("contactSecondary"));
			if (null != row.get("hospitalName"))
				hospitalInfo.setHospitalName((String) row.get("hospitalName"));
			if (null != row.get("hospitalType"))
				hospitalInfo.setHospitalType((String) row.get("hospitalType"));
			if (null != row.get("nearByLandmark"))
				hospitalInfo.setNearByLandmark((String) row.get("nearByLandmark"));
			if (null != row.get("noOfBeds"))
				hospitalInfo.setNoOfBeds((Integer) row.get("noOfBeds"));
			if (null != row.get("noOfDoctors"))
				hospitalInfo.setNoOfDoctors((Integer) row.get("noOfDoctors"));
			if (null != row.get("noOfRooms"))
				hospitalInfo.setNoOfRooms((Integer) row.get("noOfRooms"));
			if (null != row.get("noOfStaff"))
				hospitalInfo.setNoOfStaff((Integer) row.get("noOfStaff"));
			if (null != row.get("hospitalType"))
				hospitalInfo.setRoomType((String) row.get("roomType"));
//			listHospitalInfo.add(hospitalInfo);
		}
		return hospitalInfo;
	}
	
	@Transactional
	public Integer updateHospitalInfo(HospitalInfo hospitalInfo) throws Exception {
		logger.info("Inside updateHospitalInfo() in HospitalInfoDao.java ");
		String sql = "UPDATE tblHospitalInfo SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, hospitalInfo);
	}
	
	@Transactional
	public Integer deleteHospitalInfo(Integer loggedInUser) throws Exception {
		logger.info("Inside deleteHospitalInfo() in HospitalInfoDao.java ");
		String sql = "UPDATE tblHospitalInfo SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}

}
