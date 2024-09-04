FROM maven:3-eclipse-temurin-17 AS build
COPY ./ /home/app
RUN cd /home/app && mvnw clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-alpine
COPY --from=build /home/app/target/*-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
