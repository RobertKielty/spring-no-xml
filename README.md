This is a project that demonstrates spring web application with no xml. A war is created in the target directory.
Jax-rs annotations are used for the mvc framework the same as dropwizard.

There is a property placeholder seen in `resources/app.properties` simply to demonstrate this.

There is a jetty plugin to run the project from maven
`mvn jetty:run` 

There is also a tomcat plugin, this is used in integration-tests as to demonstrate both jetty and tomcat.

Cucumber `.feature` files are executed in the integration-test phase. Embedded Tomcat plugin starts on port 8181 before this.

Unlike dropwizard there is no embedded jetty, that means the war would have to be deployed to tomcat. This is not to say that we can embed a jetty server and jar it up.
Looking online tomcat seems to have better latency but jetty is better for scalability. I'm still trying to find a good article that compares both using java 7.

There are a lot more features, such as filters (again no xml as servlets 3.0 is used), shiro/spring security, Argument resolvers, AOP, profiles (mock, prod etc)
and so on. To keep this as minimal as possible I ommited these as there is no content in the application except the /healthcheck endpoint

There are two ways to build

- maven
  make sure maven 3.0.5 is installed
  mvn clean install

- gradle
  in the root directory execute
  ./gradlew wrapper (to use the gradle version in script)
  ./gradlew init (Downloads the gradle version in script)
  ./gradlew build (compiles, creates the war, assembles, testcomile, runs tests)
  ./gradlew idea (generates idea files)
  ./gradlew eclipse (generates the eclipse files)
  ./gradlew acceptanceTestsLocal (starts application, runs cucumber tests)


 
