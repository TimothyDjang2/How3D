@echo off
rmdir /q /s bin\how3d
javac -sourcepath ./src -d ./bin ./src/how3d/Core.java
java -cp ./bin how3d.Core