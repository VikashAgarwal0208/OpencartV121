package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="logindata")
	public String[][] LoginData() throws IOException
	{
		String path = "./testData//data.xlsx";
		ExcelUtils ex=new ExcelUtils();
		int rows=ex.rownum(path,"Sheet1");
		int columns=ex.colnum(path,"Sheet1");
		String[][] data=new String[rows][columns];
		for(int i=1;i<=rows;i++) 
		{
			for(int j=0;j<columns;j++)
			{
				data[i-1][j]=ex.data(path, i, j,"Sheet1");
			}
		}
		
		return data;
	}
}
