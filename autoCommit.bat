@echo off
REM %DATE:~0,10%  2017/07/06
set dd=%DATE:~0,10%
set tt=%time:~0,8%
set hour=%tt:~0,2%
echo =======================================================
echo          Starting autoCommit.bat
echo =======================================================
cd C:\Users\yh\Desktop\Programming\mdFile
echo %~dp0
git status
git add .
git commit -m "autoCommit %dd:/=-% %tt%"
git push origin master 

pause