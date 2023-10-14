import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class GroupCreationTests {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    var service = ChromeDriverService.createDefaultService();
    service.setExecutable("c:/windows/system32/chromedriver.exe");
    driver = new ChromeDriver(service);

  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test() {
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1918, 1040));
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    driver.findElement(By.id("header")).click();
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys("test1");
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys("group header");
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys("group footer");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("group page")).click();
    driver.findElement(By.linkText("Logout")).click();
  }
}
