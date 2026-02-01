### Quarkus Continuous Testing
Quarkus automatically hot-reloads your application and keeps running your tests with every code change.

This provides a great development workflow for fast iteration in Java.

The source code does not depend on Quarkus; you can use plain Java code.

### Getting Started
```bash
mvn quarkus:dev
```
Press `r` in the dev console to start continuous testing.

### Packaging and running the application
```shell script
mvn package
java -jar target/quarkus-app/quarkus-run.jar
```
Dependencies are copied to `target/quarkus-app/lib/`.

### Build and run an _über-jar_
```shell script
mvn package -Dquarkus.package.jar.type=uber-jar
java -jar target/*-runner.jar
```

### Creating a native executable
```shell script
mvn package -Dnative
```