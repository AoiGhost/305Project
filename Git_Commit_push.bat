@echo off

REM Set the path to your local repository
set REPO_PATH=C:\Users\zezox\Documents\GitHub\305Project

REM Navigate to the repository
cd /d %REPO_PATH%

REM Add all changes to the staging area
git add .

REM Commit changes with a commit message
git commit -m "Automated commit via script"

REM Push changes to the remote repository (assuming origin and main branch)
git push origin main
