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
public class validget_listresource {
  @Test
  public void f() throws BiffException, IOException {
		    validation j=new validation();
		    j.open("C:\\Users\\Sneha M\\eclipse-workspace\\APIproject\\src\\test\\java\\testcase\\testdata.xls");
		    String baseURI = j.readexcel(1, 1);
		    RestAssured.baseURI = baseURI;
		    String endpoint = j.readexcel(7,4);
		    System.out.println(endpoint);
  Response response = RestAssured.get(endpoint);
  String responseBody = response.getBody().prettyPrint();
  System.out.println("Response Body is =>  " + responseBody);
  int responseStatusCode = response.getStatusCode();
  System.out.println("Status Code => "+ responseStatusCode);
  if(response.getStatusCode()==200)
  {
      j.writexcel("TestCase",10, 7, "passed");
  }
  else
  {
      j.writexcel("TestCase",10, 7, "failed");
  }
  }
}
