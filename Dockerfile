FROM openjdk:17
LABEL \
    maintainer = "Cristian Giovanny Sánchez Pineda harmaharcri@hotmail.com" \
    org.label-schema.name = "Employee Management" \
    org.label-schema.description = "This service manage employees"

EXPOSE 8080
WORKDIR /usr/local/bin/
COPY ./ms-luncher/target/ms-luncher-0.0.1-SNAPSHOT.jar employee_management.jar
ENTRYPOINT ["java", "-jar", "employee_management.jar"]