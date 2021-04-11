package MobileAutomation;

//Appium Library & Dependencies
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//

public class Clock {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {
            openClock();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Add alarm");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/duration_layout3");
        el3.click();
        driver.navigate().back();
        */
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/alarm_tone_layout");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/read_time_aloud_switch");
        el6.click();
        driver.navigate().back();
        driver.navigate().back();
        MobileElement el7 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/alarm_name");
        el7.click();
        el7.sendKeys("Good Morning");
        driver.navigate().back();

        MobileElement el9 = (MobileElement) driver.findElementById("android:id/numberpicker_input");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/numberpicker_input");
        el10.click();
        el10.sendKeys("05");

        MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TimePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText");
        el11.sendKeys("30");
        driver.navigate().back();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TimePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TimePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText");
        el13.sendKeys("30");
        MobileElement el14 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/smallLabel");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/alarm_app_bar_title");
        //el15.click();
        System.out.println(el15.getText());




    }
    public static void openClock() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","SM-J330G/DS");
        cap.setCapability("udid","42002b4aaa7a64d1");
        cap.setCapability("platformName","Android");
        cap.setCapability("platfromVersion","9");

        cap.setCapability("appPackage","com.sec.android.app.clockpackage");
        cap.setCapability("appActivity","com.sec.android.app.clockpackage.ClockPackage");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Starting Application...");

    }
}
