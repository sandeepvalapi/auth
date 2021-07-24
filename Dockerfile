FROM openjdk:11-slim

ADD target/auth-0.0.1-SNAPSHOT.jar auth.jar
COPY run-java.sh run-java.sh
ENTRYPOINT JAVA_APP_JAR=auth.jar ./run-java.sh