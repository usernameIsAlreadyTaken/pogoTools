package org.pogo.hogs;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.pogo.entity.BCAMDM;
import org.pogo.entity.CHMDM;
import org.pogo.entity.MDM;
import org.pogo.entity.UWMDM;
import org.pogo.info.Base;

public class MDM2Excel {

	private static BufferedReader in;
	private static FileOutputStream out;

	public static void main(String[] args) {
		try {
			export2Excel("BCA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void export2Excel(String game) throws IOException {
		String path = Base.toolPath + "\\files\\MDM.txt";
		String line = null;
		Integer rownum = 1;
		MDM mdm = new MDM();
		if (game.equals("CH") || game.equals("UW") || game.equals("BCA")) {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet s = wb.createSheet();
			HSSFRow r = null;
			{
				r = s.createRow(0);
				r.createCell(0).setCellValue("Item Number");
				r.createCell(1).setCellValue("Item Title");
				r.createCell(2).setCellValue("Item Short Title");
				r.createCell(3).setCellValue("Item Description");
				r.createCell(4).setCellValue("Item Type");
				r.createCell(5).setCellValue("Project Number");
				r.createCell(6).setCellValue("Project Type");
				r.createCell(7).setCellValue("Primary Language");
				r.createCell(8).setCellValue("Approver List");
				r.createCell(9).setCellValue("Requested Date");
				r.createCell(10).setCellValue("Transaction Type");
			}

			try {
				in = new BufferedReader(new FileReader(path));
				while ((line = in.readLine()) != null) {
					r = s.createRow(rownum);
					String[] item = line.split(" ");
					if (item[0].equals("##")) {
						continue;
					}
					Integer episodeNumber = Integer.parseInt(item[0]);
					Integer ItemTitle = Integer.parseInt(item[1]);
					String RequestedDate = item[2].toString();
					if (game.equals("CH")) {
						mdm = new CHMDM(episodeNumber, ItemTitle, RequestedDate);
					} else if (game.equals("UW")) {
						mdm = new UWMDM(episodeNumber, ItemTitle, RequestedDate);
					} else if (game.equals("BCA")) {
						mdm = new BCAMDM(episodeNumber, ItemTitle,
								RequestedDate);
					}
					r.createCell(0).setCellValue(mdm.getItemNumber());
					r.createCell(1).setCellValue(mdm.getItemTitle());
					r.createCell(2).setCellValue(mdm.getItemShortTitle());
					r.createCell(3).setCellValue(mdm.getItemDescription());
					r.createCell(4).setCellValue(mdm.getItemType());
					r.createCell(5).setCellValue(mdm.getProjectNumber());
					r.createCell(6).setCellValue(mdm.getProjectType());
					r.createCell(7).setCellValue(mdm.getPrimaryLanguage());
					r.createCell(8).setCellValue(" ");
					r.createCell(9).setCellValue(mdm.getRequestedDate());
					r.createCell(10).setCellValue(mdm.getTransactionType());
					rownum++;
				}

				out = new FileOutputStream(
						"C:\\Users\\JunZhou\\Desktop\\MDM.xls");
				wb.write(out);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				in.close();
				out.close();
			}
		} else {
			System.err.println("Can't accept arg:" + game);
			return;
		}
	}

}
