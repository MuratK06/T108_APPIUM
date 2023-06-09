package tests;
import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;
public class KiwiTest {

    // uygulamanin yuklendigi dogrulanir
// uygulamanin basariyla acildigi dogrulanir
// misafir olarak devam et e tiklanir
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();

    KiwiPage page=new KiwiPage();
    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"),"uygulama yuklenemedi");
        // uygulamanin basariyla acildigi dogrulanir
        String yaziTextActual= page.asAGuest.getText();
        String yaziTextExpected="Continue as a guest";
        Assert.assertEquals(yaziTextActual,yaziTextExpected,"uygulama basarili bir sekilde baslatilamadi");
        // misafir olarak devam et e tiklanir
        page.asAGuest.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        page.ucButtonTiklama(0,3,500,1678,500);//492 1812 550 2030
        Thread.sleep(5000);
        // Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.kalkisButonu.click();
        page.defaultUlkeSILME.click();
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("izmir");
        Thread.sleep(3000);
        page.izmir.click();
        page.choose.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        page.istanbul.click();
        Thread.sleep(3000);
        driver.getKeyboard().pressKey("istanbul");
        Thread.sleep(3000);
        page.istanbul2.click();
        page.choose.click();
        // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        page.time.click();
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(828,1121)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform();
        page.saveDate.click();
        Thread.sleep(5000);
        // search butonuna tiklanir
        action.press(PointOption.point(538,1184)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }
}
