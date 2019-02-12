package com.talgreen;

import java.net.MalformedURLException;

public class App {

    public static void main(String[] args) throws MalformedURLException {
        GithubParser parser = new GithubParser();
        parser.openGithub();
        parser.searchGithub("Selenium");
        parser.closeGithub();


    }
}
