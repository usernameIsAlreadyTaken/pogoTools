package org.pogo.entity;

public class BCAMDM extends MDM {

	public BCAMDM(Integer epNumber, Integer itemNumber, String reqDate) {
		this.setItemNumber(itemNumber);
		this.setItemTitle("Big City Adventure - Episode " + epNumber);
		this.setItemShortTitle("Big City Adventure - Episode " + epNumber);
		this.setItemDescription("BIG CITY ADVENTURE - EPISODE " + epNumber
				+ " BROWSER NA DG MICRO CON");
		this.setItemType("Microcontent");
		this.setProjectNumber(307219);
		this.setProjectType("Development");
		this.setPrimaryLanguage("NA - Not Applicable");
		this.setApproverList("");
		this.setRequestedDate(reqDate);
		this.setTransactionType("CREATE");
	}

}
