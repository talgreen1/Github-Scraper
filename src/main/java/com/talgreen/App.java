package com.talgreen;

import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws MalformedURLException {
        GithubParser parser = new GithubParser();
        parser.openGithub();
        parser.searchGithub("Selenium");
        parser.parse(5);


        List<Repository> repositories = parser.getRepositories();

        repositories.forEach(System.out::println);
//        List<WebElement> repositoriesWebElements = parser.getRepositoriesWebElements();
//
//        Repository repository = new RepositoryBuilder().buildFromRepositoryWebElement(repositoriesWebElements.get(0));
//
//        System.out.println(repository);

        parser.closeGithub();


    }
}
