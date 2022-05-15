import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestPlan {
  private static RemoteWebDriver driver;

  @BeforeAll
  static void setup() {
    System.setProperty(Configuration.getProperty("firefox_driver"), Configuration.getProperty("firefox_driver_file"));
    System.setProperty(Configuration.getProperty("chrome_driver"), Configuration.getProperty("chrome_driver_file"));
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  public void signInTest() {
    driver.get(Configuration.getProperty("url"));

    MainPage page = new MainPage(driver);
    page.pressSignInButton();

    SignInPage signInPage = new SignInPage(driver);
    signInPage.enterLogin(Configuration.getProperty("username"));
    signInPage.enterPassword(Configuration.getProperty("password"));
    signInPage.pressContinueButton();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    page.goToProfile();

    ProfilePage profilePage = new ProfilePage(driver);
    Assertions.assertEquals(profilePage.getUserName(), Configuration.getProperty("username"));
  }

  @AfterAll
  public static void cleanup() {
    driver.manage().deleteAllCookies();
    driver.close();
  }
}
