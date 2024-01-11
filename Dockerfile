FROM openjdk:17
WORKDIR /app
COPY build/libs/*.jar client-service.jar
LABEL authors="AleksaPancic"

EXPOSE 5050 8080 8500

ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n"

ENTRYPOINT ["java", "-jar", "client-service.jar"]