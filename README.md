![header](https://capsule-render.vercel.app/api?type=waving&height=300&color=gradient&text=Spring%20Scheuler)

# 🚀 STACK

Environment

![인텔리제이](   https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![깃허브](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![깃](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![POSTMAN](https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

Development

![자바](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![SPRING BOOT](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![SQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Gradle](https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

# ⚒️ API Table & Script
## [🖇️ Postman API Script](https://documenter.getpostman.com/view/37620136/2sA3s7hobk)

| 기능          | Method | URL                    | Request| Response|
| ----         |:----:  |:----:                  |:----:|:----:|
| 일정 작성      | Post  |/api/plan            |Body  | 등록정보
| 선택한 일정 조회 | Get   |/api/plan/{plan_id}  |Param |단건 응답 정보
| 일정 목록 조회  | Get   |/api/plan            |Body   |다건 응답 정보
| 선택한 일정 수정 | Put   |/api/plan/{plan_id}  |Body  |수정 정보
| 선택한 일정 삭제 | Delete|/api/plan/{plan_id}  |Body  |삭제 정보 

# 📚 ERD 
![Screenshot 2024-08-15 at 5 41 32 PM](https://github.com/user-attachments/assets/5d92f8d7-9c96-4c36-b1ad-64389e14fbd8)

# 📊 SQL 

    create table if not exists Plan
    (
    plan_id     int auto_increment comment 'plan_id' primary key,
    content     varchar(500)                        not null comment '내용',
    name        varchar(100)                        not null comment '관리자명',
    password    varchar(100)                        not null comment '비밀번호',
    create_date timestamp default CURRENT_TIMESTAMP null comment '생성일',
    edit_date   timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '수정일'
    );



# 📈 Diagram
![PlanRequestDtoimg](https://github.com/user-attachments/assets/b9896387-60c8-493b-bf60-e7bcbd7edef2)

# 🌲 Repository 
        
        ├── HELP.md
        ├── README.md
        ├── build
        │   ├── classes
        │   │   └── java
        │   │       └── main
        │   │           └── com
        │   │               └── sparta
        │   │                   └── springscheduler
        │   │                       ├── Controller
        │   │                       │   └── PlanController.class
        │   │                       ├── DTO
        │   │                       │   ├── PlanRequestDto.class
        │   │                       │   └── PlanResponseDto.class
        │   │                       ├── SpringSchedulerApplication.class
        │   │                       ├── entity
        │   │                       │   └── Plan.class
        │   │                       ├── repository
        │   │                       │   └── PlanRepository.class
        │   │                       └── service
        │   │                           └── PlanService.class
        │   ├── generated
        │   │   └── sources
        │   │       ├── annotationProcessor
        │   │       │   └── java
        │   │       │       └── main
        │   │       └── headers
        │   │           └── java
        │   │               └── main
        │   ├── resources
        │   │   └── main
        │   │       ├── application.properties
        │   │       ├── static
        │   │       └── templates
        │   └── tmp
        │       └── compileJava
        │           ├── compileTransaction
        │           │   ├── backup-dir
        │           │   └── stash-dir
        │           │       └── PlanController.class.uniqueId0
        │           └── previous-compilation-data.bin
        ├── build.gradle
        ├── gradle
        │   └── wrapper
        │       ├── gradle-wrapper.jar
        │       └── gradle-wrapper.properties
        ├── gradlew
        ├── gradlew.bat
        ├── settings.gradle
        └── src
            ├── main
            │   ├── java
            │   │   └── com
            │   │       └── sparta
            │   │           └── springscheduler
            │   │               ├── Controller
            │   │               │   └── PlanController.java
            │   │               ├── DTO
            │   │               │   ├── PlanRequestDto.java
            │   │               │   └── PlanResponseDto.java
            │   │               ├── SpringSchedulerApplication.java
            │   │               ├── entity
            │   │               │   └── Plan.java
            │   │               ├── repository
            │   │               │   └── PlanRepository.java
            │   │               └── service
            │   │                   └── PlanService.java
            │   └── resources
            │       ├── application.properties
            │       ├── static
            │       └── templates
            └── test
                └── java
                    └── com
                        └── sparta
                            └── springscheduler
                                └── SpringSchedulerApplicationTests.java




