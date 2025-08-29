# Am01 Mediavault  

**Am01 Mediavault** is a hands-on project I’m building to deepen my expertise in **cloud-native architecture**.  
The goal: a secure, scalable application to back up and archive media in the cloud — using modern practices like **microservices, OAuth2 security, and serverless deployments**.  

This project also serves as a real-world sandbox to practice with **Google Cloud Platform (GCP)**, **AWS**, and **AI-assisted development** (ChatGPT + GitHub Copilot as coding partners).  

---

## 🚀 Overview  
- **Purpose:** Secure media backup and archival in the cloud.  
- **Architecture:** Microservices + API Gateway pattern.  
- **Focus Areas:** OAuth2 authentication, secure storage, containerization, and CI/CD pipelines.  

---

## 🏗️ Components  

- **API Gateway**  
  - Built with Spring Cloud Gateway.  
  - Acts as a single entry point for clients.  
  - Enforces authentication via OAuth2 (Google ID tokens).  

- **Media Upload Service**  
  - Spring Boot microservice.  
  - Handles secure upload of media files into cloud storage (GCP/AWS).  

- **CI/CD**  
  - Dockerfiles for each microservice.  
  - `docker-compose.yml` for local and test deployments.  
  - Ready for integration with GCP Cloud Run and Artifact Registry.  

---

## 🛠️ Tech Stack  

- **Backend:** Java 17, Spring Boot, Spring Cloud Gateway  
- **Security:** OAuth2, Google Identity Platform  
- **Frontend:** Angular (deployed as static site on GCP Storage)  
- **Containerization:** Docker, Docker Compose  
- **Cloud:** GCP (Cloud Run, Storage, IAM), AWS (future support)  
- **AI Pair Programming:** ChatGPT (GPT-5) + GitHub Copilot  

---

## ▶️ Running Locally  

1. Clone the repository.  
2. Run a Maven build for each microservice.  
3. Build Docker images using included Dockerfiles.  
4. Deploy locally using:  

   ```bash
   docker-compose -f CICD/docker-compose.yml up
