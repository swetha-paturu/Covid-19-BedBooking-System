package com.usecase.hospitalmgmt.hospital.model;

import java.util.List;

public class HospitalLoadData {
	
	private AccountInfo accountInfo;
	private HospitalInfo hospitalInfo;
	private List<PatientsInfo> patientsInfo;
	private List<StaffInfo> staffInfo;
	private boolean availableFlag;
	
	
	public boolean isAvailableFlag() {
		return availableFlag;
	}
	public void setAvailableFlag(boolean availableFlag) {
		this.availableFlag = availableFlag;
	}
	public List<PatientsInfo> getPatientsInfo() {
		return patientsInfo;
	}
	public void setPatientsInfo(List<PatientsInfo> patientsInfo) {
		this.patientsInfo = patientsInfo;
	}
	public List<StaffInfo> getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(List<StaffInfo> staffInfo) {
		this.staffInfo = staffInfo;
	}
	
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	public HospitalInfo getHospitalInfo() {
		return hospitalInfo;
	}
	public void setHospitalInfo(HospitalInfo hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}
	
	

}
