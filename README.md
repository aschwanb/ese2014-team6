Group Project for ESE: Introduction to Software Engineering 2014
----------------------------------------------------------------
Build instructions

1. You will need Apache, Jetty and MySQL to run the project.
2. Spring expects MySQL user and password to be "root". If you wandt, you can set your own user and password in springData.xml
3. Apache and MySQL must be running befor you start the project.
4. The calendar plugin does not support Maven and you have to ad it manually to your repository. To do this, download the jar file and use the following command:

mvn install:install-file -Dfile={Path}/javaplanner-1.5.jar -DgroupId=com.javaplanner.code -DartifactId=javaplanner -Dversion=1.5 -Dpackaging=jar
(For an example, see http://www.mkyong.com/maven/how-to-include-library-manully-into-maven-local-repository/)

6. Build the project with "mvn jetty:run". If you wandt to be extra carefull, you can use the following command: "mvn clean jetty:stop jetty:run"
7. Find the project at localhost:8080 and start by creating your one user and ad.

Thanks to team 1 for reminding us to write these first steps.
