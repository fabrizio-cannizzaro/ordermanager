# ordermanager

Open one terminal and give the following commands:
> mvn clean install
> cd OrderManagerRest/target/
> java -jar OrderManagerRest-1.0-SNAPSHOT.jar

after, in another terminal
> ./loaddata.sh

You can investigate the data in the db until the application is running:

jdbc:hsqldb:hsql://localhost:9001/testdb

You can also run the reports with the following urls:

http://localhost:8080/fetch-statistics

http://localhost:8080/fetch-processed-statistics

http://localhost:8080/fetch-order/?id=1
