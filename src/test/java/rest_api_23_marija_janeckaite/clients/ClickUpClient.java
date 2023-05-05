package rest_api_23_marija_janeckaite.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static rest_api_23_marija_janeckaite.constants.ProjectConstants.API_TOKEN;
import static rest_api_23_marija_janeckaite.constants.ProjectConstants.SPACE_ID;

public class ClickUpClient{
    private static RequestSpecification clickUpSpecs(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN);
    }

    public static Response createFolder(JSONObject obj){
        return RestAssured
                .given(clickUpSpecs())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createList(JSONObject obj, String folderId){
        return RestAssured
                .given(clickUpSpecs())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + folderId + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(JSONObject obj, String listId){
        return RestAssured
                .given(clickUpSpecs())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + listId + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTask(String taskId){
        return RestAssured
                .given(clickUpSpecs())
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + taskId)
                .then().log().all()
                .statusCode(204) // in the documentation it's 200, but then the step fails (although in UI the task gets deleted), because Expected status code <200> but was <204>
                .extract().response();
    }

    public static Response deleteFolder(String folderId){
        return RestAssured
                .given(clickUpSpecs())
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + folderId)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
