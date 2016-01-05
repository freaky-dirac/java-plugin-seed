# Java plugin system prototype

## Introduction
Simple plugin system prototype for java

## Requirement
 - Java 1.7 
 - Maven >= 3.2.5 


## Build modules
```
cd <cloned_project_path>
cd ConverterServiceProvider/
mvn install
cd ..
cd GeneralConverter/
mvn clean package
cd ExtendedConverter/
mvn clean package
cd Application
mvn clean package

```

## Run the application

```
$ chmod +x run.sh
$ ./run.sh

```

## How to add an extention
 1. copy the extention to the folder: ```<cloned_project_path>/Application/target/lib ``` 
 2. run the application
