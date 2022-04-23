import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

  @FindBy(xpath = "//input[@id=\"login\"]")
  private WebElement loginField;

  @FindBy(xpath = "//input[@type=\"password\"]")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@type=\"submit\"]")
  private WebElement continueButton;

  public SignInPage(WebDriver driver) {
    super(driver);
  }

  public void enterLogin(String login) {
    this.loginField.sendKeys(login);
  }

  public void enterPassword(String password) {
    this.passwordField.sendKeys(password);
  }

  public void pressContinueButton() {
    this.continueButton.click();
  }
}
