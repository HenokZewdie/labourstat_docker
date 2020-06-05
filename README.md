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
```
You can check the created image using
```
docker images
```
Then: run the image using:
```
docker run -p 5000:8080 <imagesName>
```
##### Note:- 5000 is a port that is exposed to call externally and 8000 is a port exposed for inside a container
##### Validate from POSTMAN using the docker ip address
```
http://192.168.99.100:5000/
```

### Contributing
Pull requests are welcome but Please update the readme file before. 
Semtehal

@Copyright : belew wegegna
