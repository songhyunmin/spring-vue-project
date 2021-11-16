## Description

 .NET Framework 프로그램을 Spring Boot 으로 개발 (기존 스마트요람이라는 프로그램)
 
(기존 프로그램 환경. ASP.NET, Razor구문, MS-SQL, 하이드리드웹)
<br><br>


## Environment

### 1. Frontend
  - Development Tools : Visual Studio Code
  - Framework : Vue.js 2.0
    - vue 2.5.2
    - vue cli 4.5.15
    - babel-core 6.22.1
    - eslint 4.15.0

### 2. Backend
  - Development Tools : IntelliJ IDEA
  - Framework : Spring Boot 2.5
   - Java Version : jdk 11.0.10
   - Build : Gradle (gradle-7.2)

### 3. Database
  - MySQL
  - Development Tools : HeidiSQL
<br><br>


## User Interface

### 1. 메인화면
  - 모바일에 맞게 디자인된 UI라서 PC에는 넓게 보임.
  - 각 메뉴는 vue.js axios를 Spring Rest API를 호출하여 MySQL 'Menu' TABLE의 메뉴 데이터를 불러와서 보여줌.
  - 각 메뉴 링크는 location.href 가 아닌 vue-router를 이용하여 새로고침 없이 페이지 전환되도록 구현.
<img src="https://user-images.githubusercontent.com/45454552/141891720-ea0fc1de-9614-4af2-8d69-452aa4233827.png">
<img src="https://user-images.githubusercontent.com/45454552/141910595-b48caa7a-016f-4329-a955-a11bfba7e951.png">
