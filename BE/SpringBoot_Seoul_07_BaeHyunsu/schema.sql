DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test;
USE spring_test;

CREATE TABLE specialty (
/* 의사의 전문의 학과를 고유번호로 저장하여 Primary key로 사용*/
    specialty_code INT PRIMARY KEY, 
/* 의사의 전문의 학과의 이름을 저장하는 컬럼명으로 100자 이내로 제한하며, Null 하용하지않는다*/
    specialty_name VARCHAR(100) NOT NULL  
);

CREATE TABLE doctor (
/* 의사 개인의 고유번호로 Primary key로 사용 */
    doctor_id INT PRIMARY KEY, 
/* 의사 개인의 이름으로 100자 제한이 있고, NUll을 허용하지않는다.*/
    name VARCHAR(100) NOT NULL, 
/* 의사 개인의 나이(정수 int형)로 NUll을 허용하지않는다.*/
    age INT NOT NULL, 
/* 의사의 전문의 학과의 번호(정수 int형)로 specialty 테이블의 고유키를 가져와 외래키로 연결한다. 그렇기에 NULL허용이 되지않으며, 
specialty에 없는 specialty_code는 입력할 수 없다.*/
    specialty_code INT, 
/* 의사 개인의 근속년수(정수 int형)로 NUll을 허용한다. 그렇기에 꼭 입력받지 않아도 된다.*/
    experience_years INT, 
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) 
);

commit;
