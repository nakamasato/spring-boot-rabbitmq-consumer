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
    docker-compose up
    ```

### local Java

1. Run RabbitMQ with docker

    ```
    docker-compose up rabbitmq
    ```

1. Run

    ```
    ./gradlew bootRun
    ```
