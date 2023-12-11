package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import okio.Timeout;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class imdbRating {
    WebDriver driver;
    public imdbRating(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public void movieRating()throws InterruptedException{

    // Navigate to URL  
    driver.get(" https://www.imdb.com/chart/top");

    // Find the highest rated movie on IMDb Using Locator "Link Text" link text | "/title/tt0111161/?ref_=chttp_t_1"
    String highestRated = driver.findElement(By.xpath("(//a[@class = 'ipc-title-link-wrapper'])[1]")).getText();
    System.out.println("Highest Rated Movie on List: " + highestRated);

    // Find the no. of movies included in the table using getSize method Using Locator "Class" Name class name | sc-14dd939d-0 fBusXE cli-children | getSize() method
    List<WebElement> moviesCount = driver.findElements(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']"));
    Thread.sleep(2000);
    int Size = moviesCount.size();
    System.out.println("No. of Movies on List: " + Size);

    // Change SortBy to release date by clicking the dropdown button and changing it to Release date Using Locator "ID" ID | "sort-by-selector" | click | //option[text()="Release date"] | click
    driver.findElement(By.id("sort-by-selector")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//option[text()='Release date']")).click();
    Thread.sleep(3000);

    // Change sortBy direction to view oldest movie on the top and get the oldest movie name Using Locator "ID" Id | "swap-sort-order-button" | click | //a[@href="/title/tt0012349/?ref_=chttp_t_1"] | getText
    driver.findElement(By.id("swap-sort-order-button")).click();
    Thread.sleep(3000);

    String oldestMovie = driver.findElement(By.xpath("(//a[@class = 'ipc-title-link-wrapper'])[1]")).getText();
    // WebElement oldest=moviesCount.get(0).findElement(By.tagName("h3"));
    // String oldestM = oldest.getText();
    System.out.println("Oldest Movie on List: " + oldestMovie);

    // Again change the sortBy direction by clicking on the icon and get the recent movie on the list Using Locator "XPath" Id | "swap-sort-order-button" | click | //a[@href="/title/tt0012349/?ref_=chttp_t_1"] | getText
    driver.findElement(By.id("swap-sort-order-button")).click();
    Thread.sleep(3000);
    

    String recentMovie = driver.findElement(By.xpath("(//a[@class = 'ipc-title-link-wrapper'])[1]")).getText();
    System.out.println("Recently Movie on List: " + recentMovie);

   // Finding movie having the most user ratings by changing sortBy to Number of Ratings  Using Locator "ID" ID | "sort-by-selector" | click | //option[text()="Number of ratings"] | click
   driver.findElement(By.id("sort-by-selector")).click();
    driver.findElement(By.xpath("//option[text()='Number of ratings']")).click();
    Thread.sleep(3000);

   // Getting the name of movie having most no.of user Ratings Using Locator "XPath" //a[@href="/title/tt0012349/?ref_=chttp_t_1"] | getText
   String highUserRated = driver.findElement(By.xpath("(//a[@class = 'ipc-title-link-wrapper'])[1]")).getText();
   System.out.println("Highest User Rated Movie: " + highUserRated);
    }
}