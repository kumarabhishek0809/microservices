# STEP 1 : BUILD PROJECT
FROM openjdk:15
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew /usr/app/
COPY gradle $APP_HOME/gradle

RUN chmod +x ./gradlew && ./gradlew build --stacktrace || return 0
COPY src src
RUN ./gradlew build -x test

# STEP 2 : DEPLOY PROJECT
FROM openjdk:15-alpine
LABEL maintainer="mail2kumar.2021@gmail.com"
COPY --from=0 /usr/app/build/libs/*.jar app.jar
EXPOSE 8761
RUN apk add --no-cache bash
RUN apk add --no-cache tzdata
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]