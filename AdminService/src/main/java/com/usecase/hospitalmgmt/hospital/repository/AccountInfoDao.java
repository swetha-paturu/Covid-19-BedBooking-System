package com.usecase.hospitalmgmt.hospital.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usecase.hospitalmgmt.hospital.model.AccountInfo;

@Repository
public class AccountInfoDao {

private static final Logger logger = LoggerFactory.getLogger(AccountInfoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AccountInfo findAccountInfo(int hospitalId) throws Exception {
		logger.info("Inside findAccountInfo() in LoadDataDao.java ");
		String sql = "select ActivityID,Title from tblAccountInfo where IsDeleted=0";
		AccountInfo accountInfo=new AccountInfo();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			
			if (null != row.get("hospitalId"))
				accountInfo.setHospitalId((Integer) row.get("hospitalId"));
			if (null != row.get("patientId"))
				accountInfo.setPatientId((Integer) row.get("patientId"));
			if (null != row.get("patientName"))
				accountInfo.setPatientName((String) row.get("patientName"));
			if (null != row.get("paymentStatus"))
				accountInfo.setPaymentStatus((String) row.get("paymentStatus"));
			if (null != row.get("paymentType"))
				accountInfo.setPaymentType((String) row.get("paymentType"));
			if (null != row.get("staffName"))
				accountInfo.setStaffName((String) row.get("staffName"));
			
		}
		return accountInfo;
	}
	
	@Transactional
	public Integer updateAccountInfo(AccountInfo accountInfo) throws Exception {
		logger.info("Inside deactivateMultipleUsers() in RolesPermissionsDao.java ");
		String sql = "UPDATE tblAccountInfo SET paymentStatus = ?, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, accountInfo);
	}
	
	@Transactional
	public Integer deleteAccountInfo(Integer loggedInUser) throws Exception {
		logger.info("Inside deactivateMultipleUsers() in RolesPermissionsDao.java ");
		String sql = "UPDATE tblAccountInfo SET IsActive = 0, UpdatedBy = ?, UpdatedDate = GETDATE() WHERE UserID=?";
		return jdbcTemplate.update(sql, loggedInUser, loggedInUser);
	}
}
