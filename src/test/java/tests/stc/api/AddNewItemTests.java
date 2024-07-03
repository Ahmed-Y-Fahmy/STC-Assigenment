package tests.stc.api;

import apis.AddNewItemAPI;
import com.shaft.validation.Validations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class AddNewItemTests {
    String id  ;
    String name  ;
    String createdDate  ;
    String year  ;
    String price ;
    String model  ;
    String diskSize  ;

    Map<String, String> addNewItemResponse;
    AddNewItemAPI addNewItemApi ;

    @BeforeMethod
    public void beforemethod(){
        addNewItemApi = new AddNewItemAPI();
    }


    @Test
    public void addNewItem(){
        addNewItemResponse =addNewItemApi.addNewItem("Apple Max Pro 1TB","2023" , "7999" , "Apple ARM A7" , "1 TB") ;
        id = addNewItemResponse.get("id");
        name = addNewItemResponse.get("name");
        createdDate = addNewItemResponse.get("createdAt");
        year = addNewItemResponse.get("year");
        price = addNewItemResponse.get("price");
        model = addNewItemResponse.get("model");
        diskSize = addNewItemResponse.get("diskSize");

        Validations.assertThat().object(id).isNotNull().withCustomReportMessage("The ID is Not Null").perform();
        Validations.assertThat().object(createdDate).isNotNull().withCustomReportMessage("The Created Date is Not Null").perform();



    }

}
