FROM timbru31/java-node:11-jdk

COPY . /usr/app
WORKDIR /usr/app/frontend

ENV BACKEND_ROOT=/api
RUN yarn install && yarn build
#RUN mkdir ../backend/src/public && cp -r build/* ../backend/src/public
RUN mkdir ../backend/src/main/resources/resources && cp -r build/* ../backend/src/main/resources/resources

WORKDIR /usr/app/backend

RUN ./gradlew build

EXPOSE 8080

CMD java -jar build/libs/*
