FROM openjdk
WORKDIR usr/lib
ADD ./target/customer-0.0.1-SNAPSHOT.jar /usr/lib/customer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","customer-0.0.1-SNAPSHOT.jar"]
