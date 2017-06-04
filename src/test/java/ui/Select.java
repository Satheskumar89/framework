package ui;

import org.openqa.selenium.By;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class Select {
    public static final By formName = By.id("select_form");
    public static final By continueButton = By.id("continue");
    public static final By cancelButton = By.id("cancel");
    public static final By firstRow = By.cssSelector("input[name='radiobutton_0'");
    public static final By selectedHotelName = By.id("hotel_name_0");
    public static final By selectedLocation = By.id("location_0");
    public static final By selectedRoom = By.id("rooms_0");
    public static final By selectedArrivalDate = By.id("arr_date_0");
    public static final By selectedDepartureDate = By.id("dep_date_0");
    public static final By selectedNoDay = By.id("no_days_0");
    public static final By selectedRoomType = By.id("room_type_0");
    public static final By selectedPricePerNight = By.id("price_night_0");
    public static final By selectedTotalPrice = By.id("total_price_0");
    public static final By selectTable = By.xpath("//*[@id=\"select_form\"]/table/tbody/tr[2]/td/table/tbody");
}
