package pageobject;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import pageobject.pages.SeatsPage;
import pageobject.pages.SeccessfulRegistrationPage;

public class TicketsTestsOnPages {
    private final String URL = "qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        Passenger passenger = new Passenger("TestName", "TestSuname", "CCC", 2,
                1, 4, "16-05-2018");
        int seatNr = RandomUtils.nextInt(1, 35);

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(passenger);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFirstFromAirport(), "Error msg");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getSecondFromAirport(), "Error msg");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getFirstToAirport(), "Error msg");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getSecondToAirport(), "Error msg");

        Assertions.assertTrue(infoPage.getPrice().length() > 0, "Error msg");

        infoPage.book();

        SeatsPage seatsPage = new SeatsPage(baseFunc);
        seatsPage.selectSeat(seatNr);

        int selectedSeat = seatsPage.getSelectedSeatNr();
        Assertions.assertEquals(seatNr, selectedSeat, "Wrong seat selected");

        seatsPage.book();

        SeccessfulRegistrationPage seccessfulRegistrationPage = new SeccessfulRegistrationPage(baseFunc);
        Assertions.assertTrue(seccessfulRegistrationPage.isSuccessfulRegistrationTextAppears(), "Wrong test");
    }
}