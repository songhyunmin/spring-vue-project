## Description

 .NET Framework 프로그램을 Spring Boot 으로 개발 (기존 스마트요람이라는 프로그램)
 
(기존 프로그램 환경. ASP.NET, Razor구문, MS-SQL, 하이드리드웹)
<br><br>


## Environment

### 1. Frontend
  - Framework : Vue.js 2.0
  - Development Tools : Visual Studio Code
    - vue 2.5.2
    - vue cli 4.5.15
    - babel-core 6.22.1
    - eslint 4.15.0

### 2. Backend
  - Framework : Spring Boot 2.5
  - Development Tools : IntelliJ IDEA
    - Java Version : jdk 11.0.10
    - Build : Gradle (gradle-7.2)

### 3. Database
  - DB : MySQL
  - Framework : JdbcTemplate
  - Development Tools : HeidiSQL
<br><br>


## User Interface

### 1. 메인화면
  - 모바일에 맞게 디자인된 UI라서 PC에는 넓게 보임.
  - 각 메뉴는 vue.js axios를 Spring Rest API를 호출하여 MySQL 'Menu' TABLE의 메뉴 데이터를 불러와서 보여줌.
  - 각 메뉴 링크는 location.href 가 아닌 vue-router를 이용하여 새로고침 없이 페이지 전환되도록 구현.
<img src="https://user-images.githubusercontent.com/45454552/141891720-ea0fc1de-9614-4af2-8d69-452aa4233827.png">
<img src="https://user-images.githubusercontent.com/45454552/141910595-b48caa7a-016f-4329-a955-a11bfba7e951.png">

### 2. 검색화면
  - 사진 파일 존재여부나 네이버맵 함수는 Vue.prototype 전역함수로 지정하여 공통 library로 모아놓음
<img src="https://user-images.githubusercontent.com/45454552/141923461-dd585a5d-f32f-4b44-b29f-d4de805103ed.png">

### 3. 보기화면
<img src="https://user-images.githubusercontent.com/45454552/141923399-4203186d-dcee-4922-bb89-a4342570782f.png">
<img src="https://user-images.githubusercontent.com/45454552/141923401-2ffcb5a9-4e10-4ad6-b84e-ae102fd75dca.png">

### 4. 직분별메뉴
<img src="https://user-images.githubusercontent.com/45454552/141923563-28e2cefe-2add-40b3-ae63-c7a6662809f9.png">
<br><br>


## Development Source Architecture

### 1. Frontend
  - 공통적으로 include하는 Top, Bottom, Search영역은 /components/layout/ 밑에 배치시킴.
  - 전환되는 메뉴 페이지들은 /views/ 에 구성하고, css, image들은 /assets/ 밑에 구성함.
<img src="https://user-images.githubusercontent.com/45454552/141923309-7a4a0e07-0f87-4491-9ad9-a296725fddbb.png">

### 2. Backend
  - Menu를 호출하는 MenuController와 각 교인 데이터를 불러오는 PersonController를 구성하고, 각 컨트롤러의 Service를 구현함.
<img src="https://user-images.githubusercontent.com/45454552/141923348-573a081f-fbd1-48ba-bc6a-4d9ad77c8c2f.png">
