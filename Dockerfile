FROM openjdk:8

EXPOSE 2234

ADD target/docker-tes.jar docker-test.jar

ENTRYPOINT ["java","-jar","docker-test.jar"]