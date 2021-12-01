FROM gradle:7.3-jdk11 AS build

WORKDIR /project

COPY src ./src
COPY *.gradle.kts ./

RUN gradle shadowJar

# execution stage
FROM openjdk:11

WORKDIR /app

COPY --from=build /project/build/libs/*.jar ./application.jar

CMD ["java", "-jar", "application.jar"]
