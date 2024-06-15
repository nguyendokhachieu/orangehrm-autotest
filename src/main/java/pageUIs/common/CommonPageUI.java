package pageUIs.common;

import java.util.HashMap;

public class CommonPageUI {
    public static final HashMap<String, String> SIDEBAR_LINK_TEXT = new HashMap<String, String>() {{
        put("Admin", "Admin");
        put("PIM", "PIM");
        put("Leave", "Leave");
        put("Time", "Time");
        put("Recruitment", "Recruitment");
        put("My Info", "My Info");
        put("Performance", "Performance");
        put("Dashboard", "Dashboard");
        put("Directory", "Directory");
        put("Maintenance", "Maintenance");
        put("Claim", "Claim");
        put("Buzz", "Buzz");
    }};
    public static final String FM_XPATH_LEFT_SIDEBAR_LINK = "xpath=//span[text()='%s']//parent::a";
    public static final String XPATH_LOADING_ICON = "xpath=//div[@class='oxd-loading-spinner']";
    public static final String FM_XPATH_TOAST_MESSAGE = "xpath=//p[contains(@class,'oxd-text--toast-message') and text()='%s']";
}
