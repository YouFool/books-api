# Alpine Linux with OpenJDK JRE
FROM openjdk:8-alpine

# Copy JAR into image
COPY target/*.jar app.jar

# Change TimeZone
ENV TZ=America/Sao_Paulo

# Run application with this command line
EXPOSE 8085
CMD /usr/bin/java -Xms256m -Xmx512m -jar /app.jar