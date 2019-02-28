package org.andestech.learning.rfb19.g3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class AppTest
{
    private WebDriver wd = null;

    @BeforeClass
    public void initData(){
    System.setProperty("webdriver.chrome.driver",
            "E:\\drivers\\selenium\\chromedriver.exe");
    System.out.println("+++ Class: " + this);

    }

    @Test
    public void testCaseChrome01() throws InterruptedException
    {
        wd = new ChromeDriver();
        wd.get("http://google.com");


       // 1.

//        WebElement element = wd.findElement(By.name("q"));
//        System.out.println(element);
//        element.sendKeys("кредит");
//
//
//        WebElement element2 = wd.findElement(By.name("btnK"));
//        System.out.println(element2);
//        element2.click();

      //2.

//        WebElement element = wd.findElement(By.cssSelector("[name=q]"));
////        element.sendKeys("кредит");
////        element.submit();
////
////        Thread.sleep(3000);

      //3
//        wd.findElement(By.xpath("//*[@name='q']")).sendKeys("debit");
//        wd.findElement(By.name("btnK")).click();
//        Thread.sleep(3000);


      //4
        WebElement el = wd.findElement(By.xpath("//*[@name='q']"));
        el.sendKeys("debit");

        wd.findElement(By.name("btnK")).click();
       // Thread.sleep(3000);

        List<WebElement> elements = wd.findElements(By.cssSelector(".srg .g"));
        List<String> webs = new ArrayList<>();

        for(WebElement element: elements)
        {
            WebElement link = element.findElement(By.cssSelector("a"));
            webs.add(link.getAttribute("href"));
        }


        //Thread.sleep(3000);

        int N = 5;
        for(int i =0; i<5; i++)
        {
            wd.findElement(By.id("pnnext")).click();
            elements = wd.findElements(By.cssSelector(".srg .g"));
            for(WebElement element: elements)
            {
                WebElement link = element.findElement(By.cssSelector("a"));
                webs.add(link.getAttribute("href"));
            }

        }

        int j=0;
        for(String web: webs)
        {
            System.out.printf("%2d --> %s\n", j, web);
            j++;
        }


    }


    @AfterClass
    public void tearDown()
    {
      if(wd != null) wd.quit();
      System.out.println("--- Class: " + this);
    }

}
