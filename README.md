As a developer we needs to follow below project structure and code reviewer needs to ensure that same is being followed.



No IDE specific folder/file should be checked-in into repo for example .idea.
.mvn folder shouldn't be checked-in
It should have project structure similar to below. Package name should be in lower case.
            



    4. Sample readme.md 

       

# Point Ledger API App #

## Version ##

`0.0.1`

## Summary ##

This application help in fetching the redemption points.

* [Prerequisites](#markdown-header-prerequisites)
* [Build](#markdown-header-build)
* [Run](#markdown-header-run)
* [Test](#markdown-header-test)
* [Change log](#markdown-header-author)
* [Author](#markdown-header-author)

## Prerequisites ##

Ensure local installation of following softwares/tools:

* JDK - 1.8
* Git (2.9.0 or higher) - only for cloning project from repository
* Apache Maven (3.3.9 or higher)

---

## Build

Open your command/shell terminal

Clone locally, an appropriate version of point ledger api from [git](https://git.epam.com/bayc-loy/point-ledger-api).

Execute standard maven command to build and install library:

~~~bash
# CD into project folder

# Build package(downloading dependencies)
mvn clean install
~~~
Verify that it generates below artifacts:

* ./target/point-ledger-api-*.jar

---

## Run

Local

```
# java -jar <JAR_NAME>.jar

java -jar ../target/point-ledger-api-0.0.1-SNAPSHOT.jar

```
---

## Test

This api can be tested using below url.

`http://localhost:8080/redemption-points`

---

## Change Logs ##

0.0.1- Added the initial code (BAYCLOY-63)

---

## Author ##

Meraj Ahmad
