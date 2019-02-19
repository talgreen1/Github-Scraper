package com.talgreen;

import java.net.MalformedURLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws MalformedURLException {
        DAO dao = new DAO();
        GithubParser parser = new GithubParser();
        parser.openGithub();
        parser.searchGithub("Selenium");
        parser.parse(5);


        List<Repository> repositories = parser.getRepositories();

        repositories.forEach(System.out::println);

        dao.save(parser);

        parser.closeGithub();
    }
}
