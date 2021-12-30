package com.usecase.hospitalmgmt.patients.model;

public class PatientRoomInfo {
	
	private int patientId;
	private String patientName;
	private String gender;
	private String diseaseType;
	private String roomType;
	private int price;
	private String buildingName;
	private int roomNumber;
	private String status;
	private int noOfBed;
	private String adharId;	
	private String hospitalName;
	
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getAdharId() {
		return adharId;
	}
	public void setAdharId(String adharId) {
		this.adharId = adharId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}	
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoOfBed() {
		return noOfBed;
	}
	public void setNoOfBed(int noOfBed) {
		this.noOfBed = noOfBed;
	}
	
	
	
}
