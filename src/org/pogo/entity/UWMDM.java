package org.pogo.entity;

public class UWMDM extends MDM {
	
	public UWMDM(Integer epNumber, Integer itemNumber, String reqDate) {
		this.setItemNumber(itemNumber);
		this.setItemTitle("Undiscovered World - Chapter " + epNumber);
		this.setItemShortTitle("Undiscovered World - Chapter " + epNumber);
		this.setItemDescription("UNDISCOVERED WORLD - CHAPTER " + epNumber
				+ " BROWSER NA DG MICRO CON");
		this.setItemType("Microcontent");
		this.setProjectNumber(310354);
		this.setProjectType("Development");
		this.setPrimaryLanguage("NA - Not Applicable");
		this.setApproverList("");
		this.setRequestedDate(reqDate);
		this.setTransactionType("CREATE");
	}
	
}
