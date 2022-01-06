package com.usecase.hospitalmgmt.hospital.model;

public class HospitalInfo {
	
	private Long hospitalId;	
	private int isDeleted;
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	private String hospitalName;
	private String hospitalType;
	private int noOfBeds;
	private int noOfDoctors;
	private int noOfStaff;
	private int noOfRooms;
	private String roomType;
	private String contactPrimary;
	private String contactSecondary;	
	private String address;
	private String nearByLandmark;
	
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public int getNoOfDoctors() {
		return noOfDoctors;
	}
	public void setNoOfDoctors(int noOfDoctors) {
		this.noOfDoctors = noOfDoctors;
	}
	public int getNoOfStaff() {
		return noOfStaff;
	}
	public void setNoOfStaff(int noOfStaff) {
		this.noOfStaff = noOfStaff;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getContactPrimary() {
		return contactPrimary;
	}
	public void setContactPrimary(String contactPrimary) {
		this.contactPrimary = contactPrimary;
	}
	public String getContactSecondary() {
		return contactSecondary;
	}
	public void setContactSecondary(String contactSecondary) {
		this.contactSecondary = contactSecondary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNearByLandmark() {
		return nearByLandmark;
	}
	public void setNearByLandmark(String nearByLandmark) {
		this.nearByLandmark = nearByLandmark;
	}
	
	
}
