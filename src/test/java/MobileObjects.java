import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    private final AppiumDriver driver;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public MobileElement btnChange;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public MobileElement btnResult;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement btnUserInput;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public MobileElement btnActivity;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    public MobileElement btnText;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }
}
