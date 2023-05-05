package rest_api_23_marija_janeckaite.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import rest_api_23_marija_janeckaite.helpers.TestCaseContext;

import static rest_api_23_marija_janeckaite.clients.ClickUpClient.deleteFolder;

public class Hooks {
    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook(){
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}