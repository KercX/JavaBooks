@echo off
title JavaBooks Launcher

echo Compiling JavaBooks...
javac com/javabooks/*.java

if %errorlevel% neq 0 (
    echo Compile error!
    pause
    exit
)

echo Running JavaBooks...
java com.javabooks.Main

pause
