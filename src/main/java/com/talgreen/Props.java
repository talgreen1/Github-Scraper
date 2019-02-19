package com.talgreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    public static final int SELENIUM_PORT;
    public static final String SELENIUM_URL;
    public static final String GITHUB_HOMEPAGE;

    private static final String SELENIUM_URL_KEY = "seleniumUrl";
    private static final String SELENIUM_PORT_KEY = "seleiumPort";
    private static final String GITHUB_HOMEPAGE_KEY = "githubHomepage";

    static {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SELENIUM_URL = System.getProperty(SELENIUM_URL_KEY, appProps.getProperty(SELENIUM_URL_KEY));;
        SELENIUM_PORT=Integer.parseInt(
                System.getProperty(SELENIUM_PORT_KEY, appProps.getProperty(SELENIUM_PORT_KEY)));
        GITHUB_HOMEPAGE = System.getProperty(GITHUB_HOMEPAGE_KEY, appProps.getProperty(GITHUB_HOMEPAGE_KEY));
    }

}
