package com.usecase.hospitalmgmt.model;

public class HospitalSearch {

private int hospitalId;
private String hospitalName;
private String doctorName;
private int isDeleted;

public int getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(int isDeleted) {
	this.isDeleted = isDeleted;
}
public int getHospitalId() {
	return hospitalId;
}
public void setHospitalId(int hospitalId) {
	this.hospitalId = hospitalId;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}

	
}
