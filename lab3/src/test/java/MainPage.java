import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

  @FindBy(xpath = "//a[text() = 'Sign in']")
  private WebElement signInButton;

  @FindBy(xpath = "//button[@class = 'nav-popover-items-toggler']")
  private WebElement navItemsToggler;

  @FindBy(xpath = "//a[text() = 'Profile']")
  private WebElement profileLink;

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void pressSignInButton() {
    this.signInButton.click();
  }

  public void goToProfile() {
    this.navItemsToggler.click();
    this.profileLink.click();
  }
}
