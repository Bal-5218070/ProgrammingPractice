package com.ninja.hrm.api.pojoclass;

public class ProjectPojo {
String projectName;
String status;
String createdBy;
int teamSize;

public ProjectPojo() {}

public ProjectPojo(String projectName, String status, String createdBy, int teamSize) {
	super();
	this.projectName = projectName;
	this.status = status;
	this.createdBy = createdBy;
	this.teamSize = teamSize;
}
/**
 * @return the projectName
 */
public String getProjectName() {
	return projectName;
}
/**
 * @param projectName the projectName to set
 */
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
/**
 * @return the createdBy
 */
public String getCreatedBy() {
	return createdBy;
}
/**
 * @param createdBy the createdBy to set
 */
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
/**
 * @return the teamSize
 */
public int getTeamSize() {
	return teamSize;
}
/**
 * @param teamSize the teamSize to set
 */
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}


}
