package stepdefs;

import io.cucumber.java.en.When;

public class FirstStepdefs {
    @When("we are printing welcome text")
    public void print_welcome_text() {
        System.out.println("all works fine");
    }
}
