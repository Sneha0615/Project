package testcase;
import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.validation;

public class invalid_delete {
  @Test
  public void f() throws BiffException, IOException {
	    validation j=new validation();
	    j.open("C:\\Users\\Sneha M\\eclipse-workspace\\APIproject\\src\\test\\java\\testcase\\testdata.xls");
	    String baseURI = j.readexcel(1, 1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(7,22);
	    System.out.println(endpoint);
    RequestSpecification requestSpecification= RestAssured.given();
    Response response1 = requestSpecification.delete(endpoint);
    String responsestring = response1.asPrettyString();
    System.out.println(response1.getStatusCode());
    System.out.println(responsestring);
    if(response1.getStatusCode()==204)
    {
        j.writexcel("TestCase",10, 19, "passed");
    }
    else
    {
        j.writexcel("TestCase",10, 19, "failed");
    }
    
}
  }
