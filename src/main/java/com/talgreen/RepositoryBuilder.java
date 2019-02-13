package com.talgreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepositoryBuilder {
    public Repository buildFromRepositoryWebElement(WebElement repo){
        Repository result = new Repository();


        result.setTitle(repo.findElement(By.xpath(".//h3/a")).getText());
        result.setDescription(repo.findElement(By.xpath(".//p")).getText());
        result.setLanguage(repo.findElement(By.xpath(".//span[contains(@class, 'language')]/..")).getText());
        // Todo: Get tags
        // todo: get stars
        // todo: get last update
        return result;
    }

}
