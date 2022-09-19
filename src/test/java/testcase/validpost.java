package testcase;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.validation;

public class validpost {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	    validation j=new validation();
	    j.open("C:\\Users\\Sneha M\\eclipse-workspace\\APIproject\\src\\test\\java\\testcase\\testdata.xls");
	    String baseURI = j.readexcel(1, 1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(7,7);
	    System.out.println(endpoint);
	    String name = j.readexcel(2,7);
	    System.out.println(name);
	    String job = j.readexcel(3,7);
	    System.out.println(job);  
             String jsonString = "{\n"
                  + "    \"name\": \""+ name +"\",\n"
                  + "    \"job\": \""+ job + "\"\n"
                  + "}";
            RequestSpecification requestSpecification= RestAssured.given();
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(jsonString);
            Response response1 = requestSpecification.post(endpoint);
            String responsestring = response1.asPrettyString();
            System.out.println(response1.getStatusCode());
            System.out.println(responsestring);
            if(response1.getStatusCode()==201)
            {
                j.writexcel("TestCase",10, 10, "passed");
            }
            else
            {
                j.writexcel("TestCase",10, 10, "failed");
            }
  }
}
