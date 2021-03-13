FROM adoptopenjdk/openjdk11:alpine-slim AS BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0
COPY ./src ./src
RUN ./gradlew build

FROM adoptopenjdk/openjdk11:alpine-slim
WORKDIR /root/
COPY --from=BUILD_IMAGE /usr/app/build/libs/spring-boot-rabbitmq-consumer-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","spring-boot-rabbitmq-consumer-0.0.1-SNAPSHOT.jar"]
