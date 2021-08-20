package utils;

import io.cucumber.java8.Scenario;

public class
CucumberScenarioHelper {

    private static Scenario scenario;

    public static void setScenario(Scenario scenario){
        CucumberScenarioHelper.scenario = scenario;}

    public static Scenario getScenario(){
        return scenario;
    }
}
