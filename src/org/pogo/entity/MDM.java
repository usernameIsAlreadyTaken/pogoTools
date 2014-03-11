package org.pogo.entity;

public class MDM {

	private Integer itemNumber;
	private String itemTitle;
	private String itemShortTitle;
	private String itemDescription;
	private String itemType;
	private Integer projectNumber;
	private String projectType;
	private String primaryLanguage;
	private String approverList;
	private String requestedDate;
	private String transactionType;

	public MDM() {}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemShortTitle() {
		return itemShortTitle;
	}

	public void setItemShortTitle(String itemShortTitle) {
		this.itemShortTitle = itemShortTitle;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	public String getApproverList() {
		return approverList;
	}

	public void setApproverList(String approverList) {
		this.approverList = approverList;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
