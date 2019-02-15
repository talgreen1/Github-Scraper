package com.talgreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    public static final int SELENIUM_PORT;
    public static final String SELENIUM_URL;
    public static final String GITHUB_HOMEPAGE;

    static {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        //String catalogConfigPath = rootPath + "catalog";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SELENIUM_URL = appProps.getProperty("seleniumUrl");
        SELENIUM_PORT=Integer.parseInt(appProps.getProperty("seleiumPort"));
        GITHUB_HOMEPAGE = appProps.getProperty("githubHomepage");
    }

}
