package parentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BonusManagementPage;
import pages.BonusSetupPage;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {

    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected BonusManagementPage bonusPage;
    protected BonusSetupPage setupPage;

    public AbstractParentTest() {
        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        bonusPage = new BonusManagementPage(webDriver);
        setupPage = new BonusSetupPage(webDriver);
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public void tearDown() {
        webDriver.quit();
    }
}
