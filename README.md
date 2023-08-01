# 재고 관리 서비스[Inventory]
## 소개
입출고 재고 관리 시스템을 구현하여 관리자가 효율적으로 운영할 수 있도록 돕고, 재고 관리 시스템은 물류나 유통 등 다양한 산업에서 많이 사용되는데, 이를 위해 필요한 기능들이 무엇인지 고민하고 개발 하였습니다.

## 목차
- [개발 환경](#환경)
- [기술 세부 스택](#스택)
  + [spring boot](#spring)
  + [기타 기술](#기타)
- [주요내용](#내용)
- [패키징구조](#패키징)
- [다이어그램](#다이어)
- [유스케이스](#케이스)
- [API](#API)
- [실행화면](#실행)
- [핵심기능](#핵심)
- [개발 후기](#후기)
## <div id="환경">개발 환경</div>

* Intellij IDEA Ultimate 2022.2.2
* Java 11
* Gradle 7.6.1
* Spring Boot 2.7.10
* Postman 10.14.9
* vue 3.34

## <div id="스택">기술 세부 스택</div>

<div id="spring">Spring Boot</div>

* Spring Web
* Spring Data JPA
* Lombok
* h2
* ModelMapper

<div id="기타">기타 기술</div>

* vue.js
* element-plus
* MariaDB

## <div id="내용">주요 내용</div>

* 재고관리(전체 테이블, 부족 물품 확인)
* 입/출고 관리(입고요청, 상품등록, 상품 분류 추가, 발요청)
* 지점관리

## <div id="패키징">패키징 구조</div>
<img width="50%" src=""/>

## <div id="다이어">ERD</div>
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/27f7a76c-c1f2-42d3-8903-8c7d5242a094"/>

## <div id="API">API 설계</div>
<img width="80%" src=""/>

## <div id="케이스">유스케이스</div>

<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/e47c2e48-67c0-483c-bf71-c12e0fdafc29"/>

## <div id="실행">실행 화면</div>
### 1. 재고관리
#### 1-1 전체 테이블 조회
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/f62cb58c-dc99-4c85-a641-408c788ec717"/>

#### 1-2 부족 물품 조회
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/c46a5759-77f4-492c-857b-72816280dcff"/>

### 2. 입·출고 관리
#### 2-1 상품 타입 등록
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/3e89f181-b911-4bc0-9f47-6c011c8d6c70"/>

#### 2-2 상품 등록
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/5fa18b50-f738-40c9-80c1-7b057ee8640e"/>

#### 2-1 입고 요청
<img width="80%" src="https://github.com/noeseungmin/project-loan/assets/106221717/e6c452ed-8b16-4812-8c41-06ae3c6d3a2f"/>

#### 2-1 발주 요
<img width="80%" src=" "/>
