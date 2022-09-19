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
public class invalidGet_single {
  @Test
  public void f() throws BiffException, IOException {
	    validation j=new validation();
	    j.open("C:\\Users\\Sneha M\\eclipse-workspace\\APIproject\\src\\test\\java\\testcase\\testdata.xls");
	    String baseURI = j.readexcel(1, 1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(7,3);
	    System.out.println(endpoint);
  Response response = RestAssured.get(endpoint);
  String responseBody = response.getBody().prettyPrint();
  System.out.println("Response Body is =>  " + responseBody);
  int responseStatusCode = response.getStatusCode();
  System.out.println("Status Code => "+ responseStatusCode);
  if(response.getStatusCode()==404)
  {
      j.writexcel("TestCase",10, 6, "passed");
  }
  else
  {
      j.writexcel("TestCase",10, 6, "failed");
  }
}
}
