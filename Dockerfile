FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./target/user-friends-1.0.0.jar /app

EXPOSE 8086

CMD ["java", "-jar", "user-friends-1.0.0.jar"]
