FROM openjdk:17
ADD build/libs/*.jar client-service.jar
LABEL authors="AleksaPancic"

EXPOSE 5100

ENTRYPOINT ["java", "-jar", "client-service.jar"]