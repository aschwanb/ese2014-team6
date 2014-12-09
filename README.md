Group Project for ESE: Introduction to Software Engineering 2014
----------------------------------------------------------------
Build instructions

1. You will need Apache, Jetty and MySQL to run the project.
2. Spring expects MySQL user and password to be "root". If you wandt, you can set your own user and password in springData.xml
3. Apache and MySQL must be running befor you start the project.
4. Build the project with "mvn jetty:run". If you wandt to be extra carefull, you can use the following command: "mvn clean jetty:stop jetty:run"
5. Find the project at localhost:8080 and start by creating your one user and ad.

To reinitialize the database browse to localhost:8080/resetDatabase and enter the Password "usethefork"