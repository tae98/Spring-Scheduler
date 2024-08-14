![header](https://capsule-render.vercel.app/api?type=waving&height=300&color=gradient&text=Spring%20Scheuler)

# 🚀STACK

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

# ⚒️API

| 기능          | Method | URL                    | Request| Response|
| ----         |:----:  |:----:                  |:----:|:----:|
| 일정 작성      | Post  |/api/schedule            |Body  | 등록정보
| 선택한 일정 조회 | Get   |/api/schedule/{eventid}  |Param |단건 응답 정보
| 일정 목록 조회  | Get   |/api/schedule            |Body   |다건 응답 정보
| 선택한 일정 수정 | Put   |/api/schedule/{eventid}  |Body  |수정 정보
| 선택한 일정 삭제 | Delete|/api/schedule/{eventid}  |Body  |삭제 정보 

# 📊SQL

    CREATE TABLE IF EVENT(
    event_id INT KEY AUTO_INCREMENT PRIMARY KEY COMMENT 'event_id',
    content VARCHAR(500) NOT NULL COMMENT '내용',
    name VARCHAR(100) NOT NULL COMMENT '관리자명',
    password VARCHAR(100) NOT NULL COMMENT '비밀번호',
    create_date DATE NOT NULL COMMENT '생성일',
    edit_date DATE NOT NULL COMMENT '수정일'
    );
