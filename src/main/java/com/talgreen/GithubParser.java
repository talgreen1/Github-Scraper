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
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "parsing")
public class GithubParser {

    @Transient
    private WebDriver driver;
    @Transient
    private String seleniumUrl = "192.168.99.100";
//    private String seleniumUrl = "localhost";
    @Transient
    private int seleiumPort = 4444;
    @Transient
    private Capabilities dc = new ChromeOptions();
    @Transient
    private String githubHomepage = "https://github.com/";


    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    //    private List<WebElement> repositories;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Repository> repositories;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private Date created;


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

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='repo-list']/li"));
        elements = elements.subList(0, numOfRepositories - 1);
        repositories = convertElementsToRepositories(elements);

    }

    private List<Repository> convertElementsToRepositories(List<WebElement> elements) {
        RepositoryBuilder repositoryBuilder = new RepositoryBuilder();

        return elements.stream()
                .map(repositoryBuilder::buildFromRepositoryWebElement)
                .collect(Collectors.toList());
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
}
