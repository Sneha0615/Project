package testcase;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.validation;

public class validget {
	
  @Test
  public void f() throws BiffException, IOException {
	    validation j=new validation();
	    j.open("C:\\Users\\\\Sneha M\\eclipse-workspace\\APIproject\\src\\test\\java\\testcase\\testdata.xls");
	    String baseURI = j.readexcel(1, 1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(7,1);
	    System.out.println(endpoint);
	    Response response = RestAssured.get(endpoint);
	    System.out.println(response.getStatusCode());
	    System.out.println(response.getStatusLine());
	    System.out.println(response.getTime());
	    System.out.println(response.getBody().asPrettyString());
	    if(response.getStatusCode()==200)
        {
            j.writexcel("TestCase",10, 4, "passed");
        }
        else
        {
            j.writexcel("TestCase",10, 4, "failed");
        }
  }
}
