package com.talgreen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GithubParser {

    private WebDriver driver;
    private String seleniumUrl = "localhost";
    private int seleiumPort = 4444;
    private Capabilities dc = new ChromeOptions();
    private String githubHomepage = "https://github.com/";
    private List<WebElement> repositories;


    public void openGithub() throws MalformedURLException {
        initDriver();
        driver.get(githubHomepage);
        driver.manage().window().maximize();
    }

    public void searchGithub(String textToSearch) {
        driver.findElement(By.name("q")).sendKeys(textToSearch + "\n");

    }

    public void closeGithub() {
        driver.quit();
    }

    private void initDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(getSeleniumUrl()), dc);
    }

    private String getSeleniumUrl() {
        return "http://" + seleniumUrl + ":" + seleiumPort + "/wd/hub";
    }

    public void parse(int numOfRepositories) {
        repositories = driver.findElements(By.xpath("//ul[@class='repo-list']/li"));
        repositories = repositories.subList(0, numOfRepositories - 1);
    }

    public List<Repository> getRepositories() {
        RepositoryBuilder repositoryBuilder = new RepositoryBuilder();

        return this.getRepositoriesWebElements().stream()
                .map(repositoryBuilder::buildFromRepositoryWebElement)
                .collect(Collectors.toList());
    }

    public void saveRepositoriesToDb() {
        Configuration con = new Configuration().configure().addAnnotatedClass(Repository.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(getRepositories().get(0));

        tx.commit();
    }

    public List<WebElement> getRepositoriesWebElements() {
        return this.repositories;
    }
}
