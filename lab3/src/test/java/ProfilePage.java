import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject {

  @FindBy(xpath = "//div[@class = 'username-line']")
  private WebElement usernameLine;

  public ProfilePage(WebDriver driver) {
    super(driver);
  }

  public String getUserName() {
    return usernameLine.getText();
  }
}
