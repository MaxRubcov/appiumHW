import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class appTest {

    Platform platform = Platform.Android;
    private AppiumDriver driver;
    private MobileObjects mobileObjects;


    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "someName");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        mobileObjects = new MobileObjects(driver);

    }

    @Test
    public void shouldBeText() {
        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();

        mobileObjects.btnResult.isDisplayed();
        Assertions.assertEquals("Привет, UiAutomator!", mobileObjects.btnResult.getText());
    }

    @Test
    public void shouldOpenTextNewActivity() {
        mobileObjects.btnUserInput.isDisplayed();
        mobileObjects.btnUserInput.sendKeys("app");

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();


        mobileObjects.btnText.isDisplayed();
        Assertions.assertEquals("app", mobileObjects.btnText.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    enum Platform {Android}
}
