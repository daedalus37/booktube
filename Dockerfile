FROM adoptopenjdk/openjdk11
MAINTAINER odyssey_codes
COPY target/booktube-0.0.1-SNAPSHOT.jar booktube-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/booktube-0.0.1-SNAPSHOT.jar"]