# Selenium-Scraper

This project is a Selenium based html scraper with MySQL based on docker.

Instructions:
* Clone the repository.
* Run the docker-compose file. This will create:
    * A container for Selenium Standalone with Chrome
    * A container for MySQL.
    
 Run the command `docker-compose up`
* Build the image file for the Java code. 
 Run the command `docker build -t <ImageName> .`
