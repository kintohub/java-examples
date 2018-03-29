# KintoHub Java Examples

This repository has a basic example of creating an HTTP server with java that is compatible on KintoHub.

The requirements are as follows:

* Need to use the exact docker file provided in this repository. (Java8 Alpine3)
* Must listen to port 80 on hostname 0.0.0.0
* Write an apidoc comment for each of your endpoints

The example written uses Jetty to serve the HTTP endpoint. You can run the example with:

mvn jetty:run -Djetty.http.port=80 -Djetty.http.host=0.0.0.0

OR

docker build -t kinto-javahttp-example .
docker run kinto-javahttp-example