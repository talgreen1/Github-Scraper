package com.talgreen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class App {

//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        GithubParser parser = new GithubParser();
//
//        List<Repository> repos = new ArrayList<>();
//        repos.add(new Repository("A", "AA"));
//        repos.add(new Repository("B", "BB"));
//        repos.add(new Repository("C", "CC"));
//
//        parser.setRepositories(repos);
//        dao.save(parser);
//    }
    public static void main(String[] args) throws MalformedURLException {
        DAO dao = new DAO();
        GithubParser parser = new GithubParser();
        parser.openGithub();
        parser.searchGithub("Selenium");
        parser.parse(5);


        List<Repository> repositories = parser.getRepositories();

        repositories.forEach(System.out::println);

        dao.save(parser);
        //parser.saveRepositoriesToDb();
//        List<WebElement> repositoriesWebElements = parser.getRepositoriesWebElements();
//
//        Repository repository = new RepositoryBuilder().buildFromRepositoryWebElement(repositoriesWebElements.get(0));
//
//        System.out.println(repository);

        parser.closeGithub();


    }
}
