FROM openjdk
COPY ./target/finalexam-1.0-SNAPSHOT.jar finalexam.jar
CMD ["java", "-jar", "/finalexam.jar"]
EXPOSE 8999