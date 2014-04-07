package excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelRead {

	public static void main(String[] args) {
		try{
			//Assuming that the excel has only one sheet Sales
			//This code will work only with older version of excel
			
			File Excel= new File("C:\\Users\\indu\\Documents\\Testdata\\Indu_Test_data.xls");
			FileInputStream fis= new FileInputStream(Excel);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet ws = wb.getSheet("Sales");
			
			int rownum= ws.getLastRowNum()+1;
			int colnum=ws.getRow(0).getLastCellNum();
			
			String[][] data = new String[rownum][colnum];
			
			//Reading data from Excel and storing into an Array data
			
			
			for (int i=0;i<rownum;i++){
				HSSFRow row= ws.getRow(i);
				for (int j=0;j<colnum;j++){
					HSSFCell cell=row.getCell(j);
					String value = cell.toString();
					data[i][j]=value;
				}
			
			}
			
			//Identifying the max value
			String MaxSalesRep="";
			float  MaxRevenue=0;
			
			for (int i=1;i<rownum;i++){
				float currSales=Float.parseFloat(data[i][1]);
				if (MaxRevenue < currSales) {
					MaxSalesRep=data[i][0];
					MaxRevenue= currSales;
				}
			}
			System.out.print("Sales Rep "+MaxSalesRep+" has "+MaxRevenue);
		} catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
	}

}
