## labourstat_docker

This is a nice template to understand basics about API call, docker and Automation testing

#### Steps to create and run the docker image
First: build the service to get the latest jar 
```
mvn clean install
```
Then: build the docker to create the images for the update jar	
##### Note:- Don't  forget the dot at the end of the below command
```
docker build -f Dockerfile -t <imageName> . 
Example: docker build -f Dockerfile -t labourstat-image .
```
You can check the created image using
```
docker images
```
Then: run the image using:
```
docker run -p 5000:8080 <imagesName>
Example: docker run -p 8080:8080 labourstat-image
```
##### Note:- 5000 is a port that is exposed to call externally and 8000 is a port exposed for inside a container
Check the [DockerFile](Dockerfile) for the exact EXPOSE 
##### Validate from POSTMAN using the docker ip address
```
http://192.168.99.100:5000/
```
##### check docker log
```
docker logs -f dab957d62527
```
### Contributing
Pull requests are welcome but Please update the readme file before. 
Semtehal

### Tips

## Generate serialVersionUID
File -> Settings -> Editor -> Inspections -> Java -> Serialization issues : Find serialization class without serialVersionUID and check it. Back to the editor, clicks on the class name, ALT + ENTER (Windows), it will prompts the Add serialVersionUID field option.

## Contract test
Test Source directory: D:\CleanFolder\laborstats\target\generated-test-sources\contracts added.
When we build the service, the plugin will automatically generates a test EmployeeTest class that extends from BaseTestClass 
 
## Generate from Swagger yaml
Go to the "swagger-codegen-cli-2.2.3.jar" directory and run the below command
```
java -jar swagger-codegen-cli-2.2.3.jar generate -i employee-swagger.yaml --api-package com.restapi.laborstats.api --model-package com.restapi.laborstats.mode
l --group-id com.restapi.laborstats --artifact-id spring-swagger-codegen-employee --artifact-version 0.0.1-SNAPSHOT -l spring -o spring-swagger-codegen-employee
```

Error:Cannot compile Groovy files: no Groovy library is defined for module ''
Solution: delete .idea folder and mvn clean install
https://www.digitalocean.com/community/questions/how-to-ping-docker-container-from-another-container-by-name

@Copyright : belew wegegna
