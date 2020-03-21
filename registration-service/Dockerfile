# STEP 1 : BUILD PROJECT
FROM openjdk:8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
RUN rm -rf $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle

RUN chmod +x ./gradlew && ./gradlew build || return 0
COPY src src
RUN ls $APP_HOME
RUN ./gradlew clean build -x test

# STEP 2 : DEPLOY PROJECT
FROM openjdk:8-jre-alpine
LABEL maintainer="mail2kumar.2021@gmail.com"
COPY --from=0 /usr/app/build/libs/*.jar app.jar
EXPOSE 7777
RUN apk add --no-cache bash
RUN apk add --no-cache tzdata
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]