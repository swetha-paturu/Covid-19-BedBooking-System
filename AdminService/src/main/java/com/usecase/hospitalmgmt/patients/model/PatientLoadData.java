package com.usecase.hospitalmgmt.patients.model;

public class PatientLoadData {
	
	private PatientCheckout patientCheckout;
	private PatientRegistration patientRegistration;
	private PatientRoomInfo patientRoomInfo;
	private StaffInfo staffInfo;
	private boolean availableFlag;
	
	
	public boolean isAvailableFlag() {
		return availableFlag;
	}
	public void setAvailableFlag(boolean availableFlag) {
		this.availableFlag = availableFlag;
	}
	public PatientCheckout getPatientCheckout() {
		return patientCheckout;
	}
	public void setPatientCheckout(PatientCheckout patientCheckout) {
		this.patientCheckout = patientCheckout;
	}
	public PatientRegistration getPatientRegistration() {
		return patientRegistration;
	}
	public void setPatientRegistration(PatientRegistration patientRegistration) {
		this.patientRegistration = patientRegistration;
	}
	public PatientRoomInfo getPatientRoomInfo() {
		return patientRoomInfo;
	}
	public void setPatientRoomInfo(PatientRoomInfo patientRoomInfo) {
		this.patientRoomInfo = patientRoomInfo;
	}
	public StaffInfo getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}
	

}
