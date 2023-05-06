package utils_Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

public class GestureUtils {
    public static void elementTap (AndroidDriver driver, WebElement element){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }

}
