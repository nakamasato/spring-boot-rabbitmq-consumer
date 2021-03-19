# Spring Boot RabbitMQ Consumer

## Overview

This application simply consumes RabbitMQ messages.

## Versions
- Java 11
- Spring Boot: 2.5.0

## How to run

### Docker

1. Run

    ```
    docker-compose up --build
    ```

1. Produce a RabbitMQ message

    ```
    docker exec -it $(docker ps | grep spring-boot-rabbitmq-consumer_rabbitmq_1 | awk '{print $1}') rabbitmqadmin publish exchange="spring-boot-exchange" routing_key="foo.bar.baz" payload="hello, world"
    Message published
    ```

### local Java

1. Run RabbitMQ with docker

    ```
    docker-compose up rabbitmq
    ```

1. Run (need to privde environment variables)

    ```
    ./gradlew bootRun
    ```
