# Git 사용하기
<br/>

## 1. GitHub 계정 생성
https://github.com/ 에서 GitHub 계정을 생성한다.<br/>
간단한 정보만 입력하면 계정을 생성할 수 있다.<br/>
<br/>

## 2. Git Repository(Git 저장소) 생성
Git 계정을 생성한 다음 우측상단의 프로필 아이콘 옆에있는 '+' 아이콘을 누른다.<br/>
New Repository 를 클릭하면 Create New Repository 라는 페이지로 이동한다<br/>
사용할 Repository 이름과 Description (Repository에 대한 설명) 을 작성한 다음 Create repository 버튼을 누른다.<br/>
Profile을 눌러서 Repository가 제대로 생성되었는지 확인한다.<br/>
<br/>


## 3. Git 설치
https://git-scm.com/downloads 페이지로 이동하여 OS에 맞는 Git을 다운받는다.<br/>
다운받은 Git 파일을 실행하여 Next를 누른다음 설치를 진행한다.<br/>
<br/>


## 4. Text Editor(Visual Studio Code) 설치
Repository 생성과 Git 설치가 모두 끝났다면 Editor를 설치하자.<br/>
Git Bash를 사용하여 Git을 사용할 수도 있지만, 파일생성과 수정을 용이하게 하기위해 Editor를 설치했다.<br/>
* VS Code<br/>
    https://code.visualstudio.com/ <br/>
    회사에서도 사용중인 Text Editor 이다. 유용한 플러그인도 많이있기도 하고 가장 익숙해서  이걸 사용하는것으로 했다.
<br/><br/>

## 5. Git Clone 하기
작업할 Workspace 폴더를 생성한다.<br/>
VS Code를 실행해서 파일>폴더 열기 로 해당 Workspace 폴더를 오픈한다.<br/>
Ctrl + ` 키를 누르면 터미널 창이 열린다.<br/>
아래의 과정을 통해 Git Clone한다.

* ### 5.1 git init을 통한 git 디렉토리 생성
    ```
    C:\Workspace> git init
    ```
    git init을 하게되면 이 디렉토리에서 git 명령어들을 사용할 수 있게 초기화 해준다.<br/>
    물론 Git 초기화를 행한 디렉토리의 하위 디렉토리들도 모두 포함된다.

* ### 5.2 Git Repository Clone 생성
    자신의 계정에 생성한 GitHub Repository 로 페이지로 이동한다.<br/>
    우측의 'Clone or Download' 라는 녹색 버튼을 클릭하게되면 Url 주소가 나온다.<br/>
    Url 주소를 직접 복사하거나 문서모양의 버튼을 눌러서 클립보드로 복사해준다.<br/>
    복사한 주소를 아래 명령어 CopiedUrl 부분에 넣어준다

    ```
    C:\Workspace> git clone CopiedUrl
    ```
<br/><br/>

## 6. Git Branch 생성
Repository를 클론받았으면 branch를 생성해야한다.<br/>
branch를 생성하게되면 master를 기반으로한 Working Directory(별도의 작업 영역)이 생기게 되는데, 
branch를 사용하는것으로 master 즉 원본이 오염되는 일을 방지할 수 있다.<br/>
안전한 작업 영역을 만들기 위한 필수 절차이다.<br/>
아래 명령어의 myBranchName 부분에 자신이 원하는 branch 이름을 적으면 된다.
```
C:\Workspace> git checkout -b myBranchName
```
<br/><br/>

## 7. Git Add 실행
git init을 실행한 작업 영역에서 파일을 생성하거나 수정하게되면 변경한 현재 상태를 저장하기위해 git commit을 실행해야한다.<br/>
하지만 그 전에 해야할 것이 무엇의 변경된 사항을 저장할 것인가? 에 대하여 정의를 해야한다.<br/>
예를 들면 A.txt, B.txt 두 파일을 생성했다고 가정하자.<br/>
A.txt는 작업을 모두 마친 상태이고 B.txt 는 아직 작업중인 파일이다.<br/>
A.txt는 작업이 끝났으므로 Commit을 해도 되지만, B.txt는 아직 완벽한 결과물이 나오지 않아서 제외해야하는 상황이다.<br/>
이러한 경우가 발생할 수 있으므로 Git에서는 Index(Stage) 라는 개념이 있다.<br/>
Commit 하기를 원하는 파일들을 올려놓는 Index인 것이다.<br/>
그리고 파일을 Index에 올려놓는 명령어가 git add 이다.
아래 명령어의 myFileName 부분에 파일명(확장자 포함)을 입력하면 된다.
```
C:\Workspace>git add myFileName
```
<br/><br/>

## 8. Git Commit 실행
git add 명령어를 통해 Stage에 파일을 올려놓았다면 이제 Commit을 실행해서 스냅샷을 만들 수 있다. <br/>
Head 라는 영역에 본인이 작업한 것들이 반영되는것이다.<br/>
게임에서 Save Point를 만드는것과 같다고 생각하면 쉽다.<br/>
아래 명령어를 통해 Stage에 있는 파일들을 Commit할 수 있다.<br/>
myCommitMessage 위치에 Commit 시점에 대한 메세지 적는다.<br/>
본인이 기억하기 편한 의미있는 내용을 짧은글로 적어놓는것이 좋다.<br/>
여기까지가 Working Directory(branch 생성) > Stage(git add) > Head(git commit) 순서로 진행한것이며, Git을 사용하기 위한 기본 절차인 것이다.
```
git commit -m "myCommitMessage"
```
<br/><br/>

## 9. Git Push 실행
앞서 진행한 git commit은 내 로컬에서의 상태를 저장하기 위한 명령이었다.<br/>
Commit을 하더라도 GitHub 서버의 Repository 는 현재 나의 작업상황을 알 턱이 없다.<br/>
git push를 통해 GitHub 서버에 내 작업결과를 발행해야 GitHub에서 내가 생성한 branch의 작업물을 확인할 수 있다.<br/>
아래 명령어의 myBranch 부분에 자신의 branch를 넣으면 된다.
```
C:\Workspace>git push origin myBranch
```
<br/><br/>

## 10. Git Merge 실행
어느정도 원하는 작업수준에 도달했으면 이제는 원본인 master에 병합을 시켜야한다.<br/>
궁극적인 목표는 GitHub의 remote/origin(원격저장소의 master) 에 병합을 하는것이다.<br/>
원격저장소의 master에 병합하는 방법은 2가지가 있다.<br/>

* ### 10.1 로컬 master에 merge 후 push
    현재 작업중인 로컬 myBranch를 로컬 master에 병합한 다음 로컬 master를 push 하는 방법이다.<br/>
    이렇게 할 경우에 GitHub웹 페이지 내에서 별도로 조작할 필요가 없이 바로 Repository에 반영되게 된다.<br/>
    이 방법으로 push를 하게되면 별도의 myBranch가 생기지 않고 masterh만 존재하게된다.<br/>
    혼자 사용한다면 이 방법으로 하는게 편한 것 같다...
    
    ```
    C:\Workspace>git checkout master
    C:\Workspace>git pull
    C:\Workspace>git merge myBranch
    C:\Workspace>git push origin master
    ```
* ### 10.2 로컬 branch를 push한 다음 remote/origin 에서 merge
    로컬 branch를 push 하는 방법이다.<br/>
    ```
    C:\Workspace>git push origin myBranch
    ```
    이 방법으로 push를 하게 되면 GitHub Repository에 myBranch가 생기게된다.<br/>
    GitHub Repository로 이동해서 Pull Request를 누르면 Example Comparisons 라는 박스 안에 방금 push한 myBranch가 보인다.<br/>
    myBranch를 클릭하게되면 수정된부분을 확인할 수 있다.<br/>
    수정한 부분을 remote/origin 에 병합하려면 Create Pull Request라는 녹색 버튼을 클릭해서 추가할 코멘트가 있다면 작성하고 Create Pull Request를 다시 눌러주면 끝이다.<br/>
    잠시 기다리면 Merge Pull Request 버튼이 활성화 되어있는 페이지로 이동한다.<br/>
    다른 작업자와 같이 개발하는 경우에는 여기서 변경된 부분을 같이 확인한 다음 이상이 없다면 merge 권한이 있는 사람이 Merge를 허용하면 된다.<br/>
    지금은 혼자 사용하는것이므로 Confirm Merge를 누르면 되겠다.<br/>
<br/><br/>

## Summary
* 게임에서의 Save 와 비슷하다
* 1번 슬롯 SaveData(master)에서 2번, 3번, 4번...슬롯(branch)로 저장하면서 다른 루트를 시도하는것    
* 만족스러운 결과는 1번 슬롯에 덮어쓰기(merge)
* 공통점은 원본을 훼손시키지 않고 다른 시도를 할 수 있다는 부분
<br/><br/>

## Review
직장에서 항상 습관적으로 사용하던 Git을 다시 개념을 정리해 놓으니 이해도가 높아진 기분이다.<br/>
직장에서 사용하는 GitLab이나 GitHub이나 한 뿌리여서 그런지 이해하기는 수월했다.
<br/><br/>

## Reference
* git 간편안내서 - http://rogerdudler.github.io/git-guide/index.ko.html
* git 가이드 - https://git-scm.com/book/ko/v1

