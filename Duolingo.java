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
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//

public class Duolingo {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws IOException {
        Account newAccount = new Account();
        try
        {
            File file = new File("D:\\SOFTWARE_TESTING\\MobileAutomation\\testdata.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file

            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

            while (itr.hasNext())
            {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                            //System.out.print(cell.getStringCellValue() + "\t\t\t");
                            newAccount.getUsername(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            //System.out.print(String.valueOf((int)cell.getNumericCellValue()) + "\t\t\t");
                            newAccount.getPassword(String.valueOf((int)cell.getNumericCellValue()));
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        try {
            openDuo();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

        try{
            //wait until element appear
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            MobileElement el1 = (MobileElement) driver.findElementById("com.duolingo:id/introFlowLoginButton");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementById("com.duolingo:id/loginView");
            el2.click();
            el2.sendKeys(newAccount.giveUsername());
            MobileElement el3 = (MobileElement) driver.findElementById("com.duolingo:id/passwordView");
            el3.click();
            el3.sendKeys(newAccount.givePassword());
            MobileElement el4 = (MobileElement) driver.findElementById("com.duolingo:id/signinButton");
            el4.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement el5 = (MobileElement) driver.findElementById("com.duolingo:id/homeMessageSecondaryButton");
            el5.click();

            System.out.println("PASSED...");

        }catch(Exception exp){
            System.out.println("FAILED...");
        }


    }
    public static void openDuo() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","SM-J330G/DS");
        cap.setCapability("udid","42002b4aaa7a64d1");
        cap.setCapability("platformName","Android");
        cap.setCapability("platfromVersion","9");

        cap.setCapability("appPackage","com.duolingo");
        cap.setCapability("appActivity","com.duolingo.splash.LaunchActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Starting Application...");

    }

}
