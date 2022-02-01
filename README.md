# ClassLoaderSample

This project create to reproduce classGraph scan issue for war files with a wildcard inside a package name set for acceptedPackages() method
Its required to have Docker Desktop to run this application. Below steps should be followed to set up workspace

## Build Docker Image

Execute docker build from project root folder
````
docker build -t open-liberty:full .
````

## Start Docker Container
Start docker container from project root folder
````
docker-compose up
````

## Build application
Since it's a Gradle project you just execute ear task to build the project and ear application
will deploy directly after build into liberty server since it's already configured.