@echo off
REM %DATE:~0,10%  2017/07/06
set dd=%DATE:~0,10%
set tt=%time:~0,8%
set hour=%tt:~0,2%
echo =======================================================
echo          Starting autoCommit.bat
echo =======================================================
REM change file directory
cd C:\Users\yh\Desktop\Programming\mdFile
REM start git script 
echo %~dp0
git status
if %hour% EQU 17 (
    git commit -m "autoCommit %dd:/=-% %tt%"
    git push origin master
) else (
    echo "=====> It's not time yet"
)

pause