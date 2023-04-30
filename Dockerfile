FROM openjdk:17

COPY target/Doctorservice-0.0.1-SNAPSHOT.jar Doctorservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/Doctorservice-0.0.1-SNAPSHOT.jar"]