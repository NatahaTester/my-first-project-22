package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnore;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import model.Reservation;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import pageobject.pages.SeatsPage;
import pageobject.pages.SeccessfulRegistrationPage;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private FlightInfo flightInfo;
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;
    private BaseFunc baseFunc = new BaseFunc();

    int seatNr = RandomUtils.nextInt(1, 35);
    SeatsPage seatsPage = new SeatsPage(baseFunc);

    private final String URL = "http://www.qaguru.lv:8089/tickets/";

    @Given("flight info:")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"),
                params.get("discount"), Integer.parseInt(params.get("adults")),
                Integer.parseInt(params.get("children")), Integer.parseInt(params.get("bag")),
                params.get("flight_date"), Integer.parseInt(params.get("seat")));
    }

    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void check_airports() {
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFirstFromAirport(), "Error msg");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getFirstToAirport(), "Error msg");
    }

    @When("we are filling in passenger registration form")
    public void fill_registration_form() {
        infoPage.fillInPassengerInfo(flightInfo);
    }

    @Then("requesting price")
    public void price_button() {

    }

    @Then("passenger name and airports appears")
    public void check_name_airports() {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getSecondFromAirport(), "Error msg");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getSecondToAirport(), "Error msg");
    }

    @Then("price is 500 EUR")
    public void check_price() {
        Assertions.assertTrue(infoPage.getPrice().length() > 0, "Error msg");
    }

    @When("we are pressing book button")
    public void book_button() {
        infoPage.book();
    }

    @Then("selecting seat")
    public void select_seat() {
       seatsPage.selectSeat(seatNr);
    }

    @Then("correct seat number appears")
    public void check_seat() {
       int selectedSeat = seatsPage.getSelectedSeatNr();
       Assertions.assertEquals(seatNr, selectedSeat, "Wrong seat selected");
    }

    @Then("we are booking selected ticket")
    public void press_button() {
        seatsPage.book();
    }

    @Then("successful registration message appears")
    public void check_successful_registration() {
      SeccessfulRegistrationPage seccessfulRegistrationPage = new SeccessfulRegistrationPage(baseFunc);
      Assertions.assertTrue(seccessfulRegistrationPage.isSuccessfulRegistrationTextAppears(), "Wrong test");
    }

    @When("we are requesting reservations data")
    public void check_reservation_data() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation is in the list")
    public void find_reservation() {for (Reservation r: reservations) {
        if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
            reservationFromApi = r;
            break;
        }
    }
    Assertions.assertNotNull(reservationFromApi, "reservation is not found");
    }

    @Then("all reservation data is correct")
    public void check_all_data() {
        Assertions.assertEquals(reservations.get(0), reservationFromApi, "wrong reservation data");
    }
}
