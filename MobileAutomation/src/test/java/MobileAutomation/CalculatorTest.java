package MobileAutomation;

import io.appium.java_client.MobileElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

//This cannot be imported
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.net.URL;


public class CalculatorTest {

    static AppiumDriver<MobileElement> driver;
    //WebDriver driver;

    public static void main(String[] args) {
        try {
            openNotebook();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
         /*
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("9");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Plus");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
        el3.click();

        MobileElement result = driver.findElement(By.className("android.widget.TextView"));

        String rs = result.getText();
        System.out.println("\nResult : " + rs);

        System.out.println("Terminated");
        */
        //Assert.assertEquals(driver.findElementByAccessibilityId("Result preview").getText(),"11");
    }

    public static void openCalculator() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","SM-J330G/DS");
        cap.setCapability("udid","42002b4aaa7a64d1"); //get this id from adb devices
        cap.setCapability("platformName","Android");
        cap.setCapability("platfromVersion","9");

        cap.setCapability("appPackage","com.sec.android.app.popupcalculator");
        cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Starting Application...");

    }

    public static void openNotebook() throws Exception {
        DesiredCapabilities cap =  new DesiredCapabilities();

        cap.setCapability("deviceName","SM-J330G/DS");
        cap.setCapability("udid","42002b4aaa7a64d1"); //get this id from adb devices
        cap.setCapability("platformName","Android");
        cap.setCapability("platfromVersion","9");

        cap.setCapability("appPackage","free.programming.programming");
        cap.setCapability("appActivity","free.programming.programming.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Starting GEEKS Application...");

    }
}
