package org.pogo.entity;

public class CHMDM extends MDM {

	public CHMDM(Integer epNumber, Integer itemNumber, String reqDate) {
		this.setItemNumber(itemNumber);
		this.setItemTitle("Haunted Hog - Episode " + epNumber);
		this.setItemShortTitle("Haunted Hog - Episode " + epNumber);
		this.setItemDescription("HAUNTED HOG - EPISODE " + epNumber + " BROWSER NA DG MICRO CON");
		this.setItemType("Microcontent");
		this.setProjectNumber(304972);
		this.setProjectType("Development");
		this.setPrimaryLanguage("NA - Not Applicable");
		this.setApproverList("");
		this.setRequestedDate(reqDate);
		this.setTransactionType("CREATE");
	}
	
}
