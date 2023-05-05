package rest_api_23_marija_janeckaite.helpers;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import rest_api_23_marija_janeckaite.domain.Folder;
import rest_api_23_marija_janeckaite.domain.List;
import rest_api_23_marija_janeckaite.domain.Task;

public class TestCaseContext {
    @Setter @Getter
    private static Folder folder;
    @Setter @Getter
    private static List list;
    @Setter @Getter
    private static Task task;
    @Setter @Getter
    private static Scenario scenario;
    public static void init(){
        folder = null;
        list = null;
        task = null;
        scenario = null;
    }
}
