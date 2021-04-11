package MobileAutomation;

//Excel Library & Dependencies
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//

//Appium Library & Dependencies
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//

public class Zalo {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws IOException{
        Mes newMes[] = new Mes[3];
        newMes[0] = new Mes();
        newMes[1] = new Mes();
        newMes[2] = new Mes();
        try
        {
            File file = new File("D:\\SOFTWARE_TESTING\\MobileAutomation\\testdata.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file

            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

            int i = 0; // Iterate Array of Mes Object
            while (i<3)
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                int count = 0;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (count){
                        case 0:
                            newMes[i].getPhoneNum(cell.getStringCellValue());
                            break;
                        case 1:
                            newMes[i].getParentName(cell.getStringCellValue());
                            break;
                        case 2:
                            newMes[i].getStudentName(cell.getStringCellValue());
                            break;
                        case 3:
                            newMes[i].getStudentID(cell.getStringCellValue());
                            break;
                        case 4:
                            newMes[i].getScore(cell.getStringCellValue());
                            break;
                        default:
                    }
                    count = count + 1;
                }
                i = i + 1;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //open Zalo App
        try {
            openZalo();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        el1.click();

        for (int i = 0;i<3;i++){
            MobileElement el2 = (MobileElement) driver.findElementById("com.zing.zalo:id/search_src_text");
            el2.click();
            el2.sendKeys(newMes[i].givePhoneNum());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.View");
            el3.click();

            try{
                MobileElement el4 = (MobileElement) driver.findElementById("com.zing.zalo:id/btn_send_message");
                el4.click();
            }catch (Exception exp){
                System.out.println("Already Friend");
            }

            MobileElement el5 = (MobileElement) driver.findElementById("com.zing.zalo:id/chatinput_text");
            el5.click();
            el5.sendKeys("The score of " + newMes[i].giveStudentName() + " ID: " + newMes[i].giveStudentID() + " is " +newMes[i].giveScore());
            MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Gửi tin nhắn đi");
            el6.click();
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }
    public static void openZalo() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","SM-J330G/DS");
        cap.setCapability("udid","42002b4aaa7a64d1");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","9");

        cap.setCapability("appPackage","com.zing.zalo");
        cap.setCapability("appActivity","com.zing.zalo.ui.ZaloLauncherActivity");
        cap.setCapability("noReset",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Starting Application...");

    }
}
