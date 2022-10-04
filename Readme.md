# Quiz Aggregator Service

This is a SpringBoot sample microservice application that focuses calling another microservice called Quiz Service in order to demonstrate the canary release mechanism.

## Prerequisites

You need to have a Database  with a schema (tables, views, ..) ready. So use the project [quiz-db](https://github.com/cpruvost/quiz-db) for that. With this project you have a schema in two versions (V1 and V1POINT2).

You need to have deployed Quiz Service microservices. So use the project [quiz-service](https://github.com/cpruvost/quiz-service) for that. With this project you have 2 version of the microservie (V1 = v1.0.4 and V1.2 = v1.2.0)

You need to have a kubernetes cluster (with istio installed and with argocd) if you want to deploy this microservice on kube.

## Look at the code

Looking at the code you will see that we are using the Feign Client to call the microservice Quiz Service. And if you know Jaeger you will see that we propagates all the headers in order to follow the execution time of each service. 

## Deploy with argocd
to be done

