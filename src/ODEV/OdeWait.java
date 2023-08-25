package ODEV;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;
import java.util.prefs.BackingStoreException;

public class OdeWait extends BaseDriver {
    @Test
    public void calc(){

        Random random=new Random();
        int sayi1=random.nextInt(100);
        int sayi2= random.nextInt(100);
        driver.get(" https://testsheepnz.github.io/BasicCalculator.html");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("number1Field")));
         WebElement num1= driver.findElement(By.id("number1Field"));
         num1.sendKeys(String.valueOf(sayi1));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("number2Field")));
        WebElement num2= driver.findElement(By.id("number2Field"));
        num2.sendKeys(String.valueOf(sayi2));
        MyFunc.Bekle(2);

        WebElement calc= driver.findElement(By.id("calculateButton"));
        calc.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        int calcSonuc = Integer.parseInt(result.getAttribute("value"));

      int expectedSonuc=sayi1+sayi2;
        int expectedSonuc1 = sayi1 - sayi2;
        int expectedSonuc2= sayi1 * sayi2;
        int expectedSonuc3 = sayi1 / sayi2;
        int expectedSonuc4 = (sayi1+sayi2 );

        switch (expectedSonuc){
            case 1:  expectedSonuc1=calcSonuc; break;
            case 2:  expectedSonuc2 = calcSonuc; break;
            case 3:  expectedSonuc3 = calcSonuc; break;
            case 4:  expectedSonuc4 = calcSonuc; break;
            default:
                System.out.println((sayi1)+(sayi2));

        }




        System.out.println("Calc Sonucu= "+calcSonuc);
        System.out.println("Beklenenen sonuc= "+ expectedSonuc);


        Assert.assertTrue( "Sonuc Eslesmedi",calcSonuc ==expectedSonuc);
        Assert.assertTrue( "Sonuc Eslesmedi",calcSonuc ==expectedSonuc1);
        Assert.assertTrue( "Sonuc Eslesmedi",calcSonuc ==expectedSonuc2);
        Assert.assertTrue( "Sonuc Eslesmedi",calcSonuc ==expectedSonuc3);
        Assert.assertTrue( "Sonuc Eslesmedi",calcSonuc ==expectedSonuc4);






    }
}
/*
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki her işlemi 5 kez tekrar ettiriniz.
 */
