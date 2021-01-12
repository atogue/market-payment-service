# market-payment-service
This spring boot application is a Microservice architecture Proof Of Concept applied in a business market platform online: payment service

##Note: 
requirements: maven3 and java 15 (also java 11) or higher.

It also requires to run the following 2 services:
- market-order-service
- market-user-service

##H2 console - testing on Mac OS:
Remember to set datasource url into application.properties or application.yml and also change it, if not already loaded, onto login console (JDBC URL):
- spring.datasource.url=jdbc:h2:mem:testdb
