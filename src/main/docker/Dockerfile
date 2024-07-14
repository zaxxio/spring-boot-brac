FROM maven:3.9.8-amazoncorretto-17-al2023 as maven
WORKDIR app
COPY src ./src
COPY pom.xml .
RUN mvn clean compile package
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "target/application.jar"]

