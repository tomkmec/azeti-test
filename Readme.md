# The game of score

## run

* Option 1: 'dev mode' : node and JDK runtimes installed => 
  * backend => gradlew bootRun
  * frontend => yarn install && yarn start
  * http://localhost:3000
* Option 2: 'prod mode' : docker installed =>
  * `docker build -t gos .`
  * `docker run -p 8080:8080 --rm gos`
  * http://localhost:8080

## notes

* No cache or optimalizations to the dockerfile, build is terribly slow with each change. Also the image is both, for build and runtime, so it's not really "prod"
* 
