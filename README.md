# **Am01 Mediavault**

Am01 Mediavault is an application to backup all your media in cloud.
It is based on Java 17, Spring-boot, Docker and AWS. It uses microservices based architecture.

# Components
* **Spring Cloud API Gateway** based service to act as a single entry point for client requests and authentication. 
* **Spring-boot** based microservice to upload media files into cloud.

# CICD 
* **Dockerfile** for each microservice to build docker image of the microservices
* **Docker-compose** file to deploy the application locally or in Testing environment

# Steps to start application locally
* Clone the repository.
* Perform Maven build on each microservice.
* Build docker images of each microservice using included Dockerfiles.
* Use CICD/docker-compose.yml to deploy the application locally on Docker engine.
* OR alternatively start microservices using the IDE (Eclipse, Intellij etc).
