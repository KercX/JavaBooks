@echo off
color 0A
title JavaBooks PRO Launcher

:menu
cls
echo ===============================
echo       JavaBooks SYSTEM
echo ===============================
echo 1. Compile project
echo 2. Run program
echo 3. Compile + Run
echo 4. Clean (.class files)
echo 0. Exit
echo ===============================
set /p choice=Choose option: 

if "%choice%"=="1" goto compile
if "%choice%"=="2" goto run
if "%choice%"=="3" goto both
if "%choice%"=="4" goto clean
if "%choice%"=="0" exit

goto menu

:compile
echo Compiling...
javac com/javabooks/*.java
pause
goto menu

:run
echo Running...
java com.javabooks.Main
pause
goto menu

:both
echo Compiling...
javac com/javabooks/*.java
if %errorlevel% neq 0 (
    echo ERROR!
    pause
    goto menu
)
echo Running...
java com.javabooks.Main
pause
goto menu

:clean
echo Cleaning...
del /s /q com\javabooks\*.class
echo Done!
pause
goto menu
