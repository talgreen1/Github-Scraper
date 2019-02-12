package com.talgreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepositoryBuilder {
    public Repository buildFromRepositoryWebElement(WebElement repo){
        Repository result = new Repository();

        result.setTitle(repo.findElement(By.xpath("//h3/a")).getText());
        result.setDescription(repo.findElement(By.xpath(".//p")).getText());
        // get tag:        repo.findElement(By.xpath(".//a[contains(@class, 'topic-tag')]")).getText()
        return result;
    }

}
