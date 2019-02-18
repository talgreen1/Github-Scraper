FROM maven:3.6.0-jdk-8-alpine
RUN apk add git

WORKDIR /app

RUN git clone https://github.com/talgreen1/Github-Scraper.git

WORKDIR /app/Github-Scraper

#RUN mvn dependency:go-offline
RUN mvn install

#CMD mvn exec:java -Dexec.mainClass="com.talgreen.App" -o
ENTRYPOINT ["mvn", "exec:java", "-Dexec.mainClass=com.talgreen.App"]

