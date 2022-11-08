package com.ideas2it.training.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
public class LeaveRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer leaveId;

    private String fromDate;
    private String toDate;
    private String leaveType;
    private boolean isDeleted;
    private String createdAt;
    private String modifiedAt;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
   

    public LeaveRecords() {
    }

    public LeaveRecords(String fromDate, String toDate, String leaveType) {

        
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.leaveType = leaveType;
    }

    public LeaveRecords(Integer leaveId,String employeeId, String fromDate, String toDate, String leaveType) {
	this.leaveId = leaveId;
//        this.employeeId = employeeId;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.leaveType = leaveType;
    }


    public void setLeaveId(Integer leaveId) {
	this.leaveId = leaveId;
    }

//    public void setEmployeeId(String employeeId) {
//	this.employeeId = employeeId;
//    }

    public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
	this.toDate = toDate;
    }

    public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
    }

    public void setIsDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
	this.modifiedAt = modifiedAt;
    }

    public Integer getLeaveId() {
	return leaveId;
    }

//    public String getEmployeeId() {
//	    return employeeId;
//    }

    public String getToDate() {
	return toDate;
    }

    public String getFromDate() {
	return fromDate;
    }

    public String getLeaveType() {
	return leaveType;
    }

    public boolean getIsDeleted() {
	return isDeleted;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public String getModifiedAt() {
	return modifiedAt;
    }


    public void setEmployee(Employee employee) {
	this.employee = employee;
    }
		
    public Employee getEmployee() {
	return employee;
    }

    public String toString() {
    String result = "\nLeaveId           : "+getLeaveId()
		   +"\nStart date        : "+getFromDate()
		   +"\nTo Date           : "+getToDate()
		   +"\nLeave Type        : "+getLeaveType();
		   

    return result;
    }
}