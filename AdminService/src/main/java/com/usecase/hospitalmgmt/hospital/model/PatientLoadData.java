package com.usecase.hospitalmgmt.hospital.model;

import java.util.List;

import com.usecase.hospitalmgmt.patients.model.PatientCheckout;
import com.usecase.hospitalmgmt.patients.model.PatientRegistration;
import com.usecase.hospitalmgmt.patients.model.PatientRoomInfo;

public class PatientLoadData {
	
	private List<PatientCheckout> patientCheckout;
	public List<PatientCheckout> getPatientCheckout() {
		return patientCheckout;
	}
	public void setPatientCheckout(List<PatientCheckout> patientCheckout) {
		this.patientCheckout = patientCheckout;
	}
	public List<PatientRegistration> getPatientRegistration() {
		return patientRegistration;
	}
	public void setPatientRegistration(List<PatientRegistration> patientRegistration) {
		this.patientRegistration = patientRegistration;
	}
	public List<PatientRoomInfo> getPatientRoomInfo() {
		return patientRoomInfo;
	}
	public void setPatientRoomInfo(List<PatientRoomInfo> patientRoomInfo) {
		this.patientRoomInfo = patientRoomInfo;
	}
	public List<StaffInfo> getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(List<StaffInfo> staffInfo) {
		this.staffInfo = staffInfo;
	}
	private List<PatientRegistration> patientRegistration;
	private List<PatientRoomInfo> patientRoomInfo;
	private List<StaffInfo> staffInfo;

}
