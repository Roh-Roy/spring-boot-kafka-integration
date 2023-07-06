Sample code to integrate Spring Boot application with Kafka


1) First we have to install Kafka in our local. I referred to below youtube and medium link.

Install Kafka Guide in Linux-- https://www.youtube.com/watch?v=Pty5BWJUwMU

https://medium.com/@sabinbogati1/how-to-install-apache-kafka-in-ubuntu-or-any-linux-o-s-c9ba7905d5c7

2) Create a sample spring boot repo with necessary dependencies(check the pom.xml). 

Reference -- Spring Boot with Kafka integration reference -- https://www.youtube.com/watch?v=fCt0L4LwB9w

Github - https://github.com/shameed1910/springboot-kafka

3) After cloning/copying the code make sure to run Kafka service in local before running and testing the spring boot app.

4) Below command needs to be executed in the root directory where Kafka is installed, we can see folders/files like bin,config,libs,release etc.

   After the service starts, we can hit our controller and see the application in action.

bin/kafka-server-start.sh config/server.properties
 
5) Below command is optional, we can run it in terminal to run the consumer,regardless of our consumer code is written or not, we can see messages consumed in this terminal if we push to Kafka. 

This should also be executed ar the same location/root where kafka is installed

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic java_in_use_topic --from-beginning  ----> Start a kafka consumer from terminal but this is optional


6) We can notice I send a Java custom POJO to Kafka. Sending only a string is simple and it's present in 1st commit.

Things to notice -

--- Using GSON instead of ObjectMapper of Jackson as I faced issue while deserializing the LocalDateTime to Java POJO during consuming the message. Not sure why

--- Default format of localdatetime is not deserialized using GSON/ObjectMapper. Not sure why. Hence I gave a dateformatter while sending/publishing the message. Still this approach only worked with GSON, with ObjectMapper still it was not working.
