FROM java:8  
COPY . /
WORKDIR /  
RUN javac ConnectToSQL.java
CMD ["java", "-classpath", "mysql-connector-java-8.0.13.jar:.","ConnectToSQL"]

