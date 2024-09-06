package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public FileInputStream file;
	public XSSFWorkbook workbook;
	public XSSFRow row;
	public XSSFSheet sheet;
	
	public int colnum(String path, String shet) throws IOException
	{
		file= new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(shet);
		return (sheet.getRow(0).getLastCellNum());
			
	}
	public int rownum(String path, String shet) throws IOException
	{
		file= new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(shet);
		return (sheet.getLastRowNum());
			
	}
	public String data(String path, int i, int j, String shet) throws IOException
	{
		file= new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(shet);
		row=sheet.getRow(i);
		return (row.getCell(j).toString());
		
	}
	
	
	

}
