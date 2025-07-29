@echo off
set gradle_cmd=gradle
if not "%GRADLE_HOME%"=="" set gradle_cmd=%GRADLE_HOME%\bin\gradle
%gradle_cmd% %*
