FROM openjdk:11-slim
WORKDIR /usr/app
COPY . /usr/app
RUN ./gradlew build
EXPOSE 8080
CMD java -jar build/libs/*

