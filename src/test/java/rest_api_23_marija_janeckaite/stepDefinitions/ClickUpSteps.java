package rest_api_23_marija_janeckaite.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import rest_api_23_marija_janeckaite.domain.Folder;
import rest_api_23_marija_janeckaite.domain.List;
import rest_api_23_marija_janeckaite.domain.Task;
import rest_api_23_marija_janeckaite.helpers.TestCaseContext;
import org.apache.commons.lang3.RandomStringUtils;

import static rest_api_23_marija_janeckaite.clients.ClickUpClient.*;

public class ClickUpSteps {
    public String taskName = RandomStringUtils.randomAlphabetic(2) + System.currentTimeMillis();

    @Given("I create a ClickUp folder named {string} and verify that the name is correct")
    public void iCreateNewFolder(String folderName){
        JSONObject obj = new JSONObject();
        obj.put("name", folderName);
        Response response = createFolder(obj);
        Folder folder = response.as(Folder.class);
        TestCaseContext.setFolder(folder);

        Assertions.assertThat(TestCaseContext.getFolder().getName())
                .as("We check that the folder was created with correct name")
                .isEqualTo(folderName);
    }

    @And("I create a new list named {string} in the folder")
    public void iCreateNewList(String listName){
        JSONObject obj = new JSONObject();
        obj.put("name", listName);
        Response response = createList(obj, TestCaseContext.getFolder().getId());
        List list = response.as(List.class);
        TestCaseContext.setList(list);
    }

    @And("I verify that the name of the list is {string}")
    public void iVerifyThatTheListNameIs(String listName) {
        Assertions.assertThat(TestCaseContext.getList().getName())
                .as("We check that the list name is correct")
                .isEqualTo(listName);

//        Assertions.assertThat(TestCaseContext.getFolder().getId())
//                .as("We check that the list is added to the correct folder")
//                .contains(TestCaseContext.getFolder().getLists());
    }

    @And("In the list I create one task")
    public void iCreateTaskInTheList(){
        JSONObject obj = new JSONObject();
        obj.put("name", taskName);
        Response response = createTask(obj, TestCaseContext.getList().getId());
        Task task = response.as(Task.class);
        TestCaseContext.setTask(task);
    }

    @And("I check that the name of the task is correct")
    public void iVerifyTheNameOfTheTaskIsCorrect(){
        Assertions.assertThat(TestCaseContext.getTask().getName())
                .as("We check that the task name is correct")
                .isEqualTo(taskName);
    }

    @When("I remove the task from the list")
    public void iRemoveTheTaskFromTheList(){
        deleteTask(TestCaseContext.getTask().getId());
    }

//    @Then("I verify that the task is not in the list anymore")
//    public void iVerifyThatTheTaskIsNotInTheList(){
//        Assertions.assertThat(TestCaseContext.getTask().getId())
//                .as("We check that the task is not in the list")
//                .contains(TestCaseContext.getTask().getList().getId());
//    }
}
