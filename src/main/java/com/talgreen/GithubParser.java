package com.talgreen;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GithubParser {

    private WebDriver driver;
    private String seleniumUrl = "localhost";
    private int seleiumPort = 4444;
    private Capabilities dc = new ChromeOptions();
    private String githubHomepage = "https://github.com/";



    public void openGithub() throws MalformedURLException {
        initDriver();
        driver.get(githubHomepage);
    }

    public void searchGithub(String textToSearch){
        driver.findElement(By.name("q")).sendKeys(textToSearch + "\n");

    }

    public void closeGithub(){
        driver.quit();
    }
    private void initDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(getSeleniumUrl()), dc);
    }

    private String getSeleniumUrl() {
        return "http://" + seleniumUrl + ":" + seleiumPort + "/wd/hub";
    }
}
