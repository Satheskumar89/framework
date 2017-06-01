package ui;

import org.openqa.selenium.By;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class Search {
    public static final By displayUserName = By.id("username_show");
    public static final By locationField = By.id("location");
    public static final By hotelsField = By.id("hotels");
    public static final By roomTypeField = By.id("room_type");
    public static final By noOfRoomsField = By.id("room_nos");
    public static final By checkInDateField = By.id("datepick_in");
    public static final By checkOutDateField = By.id("datepick_out");
    public static final By adultsPerRoomField = By.id("adult_room");
    public static final By childrenPerRoomField = By.id("child_room");
    public static final By submitButton = By.id("Submit");
    public static final By resetButton = By.id("Reset");
    public static final By checkOutDateError = By.id("checkout_span");
    public static final By checkInDateError = By.id("checkin_span");
}
