import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import tests.DataFormatter;
import tests.XSSFCell;
import tests.XSSFCellStyle;
import tests.XSSFRow;
import tests.XSSFSheet;
import tests.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet; 
	public XSSFRow row; 
	public XSSFCell cell; 
	public XSSFCellStyle style ; 
	String path=".src\\test\\resources\\datafortesting\\Data.xlsx";

	XLutility(String path)
	{
		this.path=path;
	}
	@Test
	public void getRowcount(String sheetname) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		System.out.println("rowcount");
	}

	public int getCellcount(String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	public String  getCellData(String sheetname,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;    
		try {
			data=formatter.formatCellValue(cell);	
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();

	}
	public String  setCellData(String sheetname,int rownum,int colnum,String data) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);

		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellStyle(data);

		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
	}
	/*public String fillGreencolor(String sheetname,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);

		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);

		style=workbook.createCellStyle();
		style.setFillForegroundColor

 
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}*/


}
