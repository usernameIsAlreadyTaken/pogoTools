package org.pogo.entity;

public class SHMDM extends MDM {

	public SHMDM(Integer epNumber, Integer itemNumber, String reqDate) {
		this.setItemNumber(itemNumber);
		this.setItemTitle("Sherlock Holmes - Episode " + epNumber);
		this.setItemShortTitle("Sherlock Holmes - Episode " + epNumber);
		this.setItemDescription("SHERLOCK HOLMES - EPISODE " + epNumber
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
