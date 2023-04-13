package CookieClicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class CookieClicker {
    private WebDriver driver;

    public CookieClicker(){
        try{
            System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }catch (Exception e){
            System.out.println("Error[0]: create driver.");
        }
    }

    public void open_site(){
        try{
            String url = "https://orteil.dashnet.org/cookieclicker/";
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }catch (Exception e){
            System.out.println("Error[1]: Open site.");
        }
    }

    public void select_language(){
        try{
            driver.findElement(By.id("langSelect-EN")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }catch (Exception e){
            System.out.println("Error[2]: Select language.");
        }
    }

    public void cookie_click(){
        try{
            driver.findElement(By.id("bigCookie")).click();
        }catch (Exception e){
            System.out.println("Error[3]: Cookie click");
        }
    }

    public void cookie_upgrade(){
        try{
            boolean found = false;
            int index = 0;
            while(!found){
                String product = (driver.findElement(By.id("product" + index))).getAttribute("class");
                if (product.contains("disabled")){
                    found = true;
                    driver.findElement(By.id("product" + (index - 1))).click();
                }else{
                    index++;
                }
            }
        }catch (Exception e){
            System.out.println("Error[4]: Upgrade cookie.");
        }
    }
}
