package HOGtools;

import org.pogo.entity.BCABadge;

public class BadgePrinter {

	private Integer startEpisode = 85;
	private Integer startId = 5805;
	private String city = "Rio";

	public static void main(String[] args) {
		BadgePrinter bp = new BadgePrinter();
		bp.printBCA();
	}

	public void printBCA() {
		for (int i = 1; i <= 12; i++) {
			BCABadge bb = new BCABadge(city, startEpisode + i - 1, i, startId
					+ i - 1);
			System.out.println(bb.toString());
			System.out.println();
		}
	}

}
