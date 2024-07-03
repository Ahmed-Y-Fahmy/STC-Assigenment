package apis;

import com.shaft.api.RestActions;
import data.LoadProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class AddNewItemAPI {

    private String addNewItemApi = "/objects";

    public Map<String, String> addNewItem(String name, String year, String price , String cpu , String deskSize) {

        Map<String, String> responseData = new HashMap<>();

        Response response;

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("data.year", year);
        requestBody.put("data.price", price);
        requestBody.put("data.CPU model", cpu);
        requestBody.put("data.Hard disk size", deskSize);

        response = RestActions.buildNewRequest(LoadProperties.userData.getProperty("API_BaseURL"), addNewItemApi, RestActions.RequestType.POST)
                .setRequestBody(requestBody)
                .setContentType(ContentType.JSON)
                .addHeader("User-Agent", "PostmanRuntime/7.28.4")
                .performRequest();
        responseData.put("id",RestActions.getResponseJSONValue(response, "id"));
        responseData.put("name",RestActions.getResponseJSONValue(response, "name"));
        responseData.put("createdAt",RestActions.getResponseJSONValue(response, "createdAt"));
        responseData.put("Year",RestActions.getResponseJSONValue(response,"data.year"));
        responseData.put("price",RestActions.getResponseJSONValue(response,"data.price"));
        responseData.put("model",RestActions.getResponseJSONValue(response, "data.CPU model"));
        responseData.put("diskSize",RestActions.getResponseJSONValue(response, "data.Hard disk size"));
        return responseData  ;

    }


}
