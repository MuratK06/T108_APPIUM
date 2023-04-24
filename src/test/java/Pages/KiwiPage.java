package Pages;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.net.PortUnreachableException;
import java.time.Duration;
public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath ="//*[@text='One way']" )
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement kalkisButonu;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSILME;

    @FindBy(xpath = "//*[@text='İzmir, Turkey']")
    public WebElement izmir;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "//*[@text='Anywhere']")
    public WebElement istanbul;

    @FindBy(xpath = "//*[@text='Istanbul, Turkey']")
    public WebElement istanbul2;

    @FindBy(xpath = "//*[@text='Anytime']")
    public WebElement time;

    @FindBy(xpath = "//*[@text='Set date']") // tarih 828 1121
    public WebElement saveDate;

  // @FindBy(xpath = "//*[@text='Anytime']")//  search 538 1184
  // public WebElement time;

  // @FindBy(xpath = "//*[@text='Anytime']")
  // public WebElement time;




    public static void ucButtonTiklama(int baslangic,int bitis,int xCoordinat,int yCoordinat,int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i=baslangic; i<bitis; i++){
            action.press(PointOption.point(xCoordinat,yCoordinat)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release().
                    perform();
        }
    }


}
