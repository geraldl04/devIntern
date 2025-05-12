CREATE TABLE kursi (
id serial PRIMARY KEY 
emri_kursit VARCHAR(100) ,
kohezgjatja int , 
create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

INSERT INTO kursi (emri_kursit, kohezgjatja) VALUES
('Java Programming', 40),
('Web Development', 45),
('Data Science', 50),
('Machine Learning', 35),
('Database Management', 60),
('Cybersecurity', 30),
('Digital Marketing', 25),
('Artificial Intelligence', 40),
('Cloud Computing', 50);

ALTER TABLE kursi
ADD COLUMN programming_language VARCHAR(100) ; 


UPDATE kursi 
SET programming_language ='Java'
WHERE id = 1 ; 

UPDATE kursi
SET programming_language = 'Unknown'
WHERE id >= 2;

DELETE FROM kursi WHERE id = 9 ; 

 Shtoni nje tabele student m fushat: id, emri, email, birth date, phone number, pike dhe 
foreign key id e tabeles internship. 

CREATE TABLE student (

id serial PRIMARY KEY , 
emri Varchar(100)  ,
email Varchar(100) , 
birth_date TIMESTAMP , 
phone_number Varchar(100) , 
pike int  , 
student_key int , 
FOREIGN KEY (student_key) REFERENCES kursi (id)

);
DROP TABLE Student ;

INSERT INTO student (emri , emaili , birth_date , phone_number , pike  , student_key) VALUES 
('Mirsalda' , 'mirsaldaMrekullia@gmail.com' , '2020-03-09' , '087657890' , 10 , 1 ) , 
('Dorian', 'dorian@example.com', '2002-07-15', '087612345', 15, 3),
    ('Sara', 'sara@example.com', '2000-06-18', '087623456', 20, 4),
    ('Lucas', 'lucas@example.com', '1999-11-02', '087634567', 25, 5),
    ('Blerina', 'blerina@example.com', '2003-09-11', '087645678', 30, 5),
    ('Elira', 'elira@example.com', '2001-01-22', '087656789', 35, 7),
    ('Mark', 'mark@example.com', '2000-10-29', '087667890', 40, 8),
    ('Eva', 'eva@example.com', '1999-12-10', '087678901', 45, 4),
	  ('Armela', 'eva@example.com', '1999-12-10', '087678901', 45, 4),
    ('Leon', 'leon@example.com', '2002-05-16', '087689012', 50, 3);


SELECT * FROM kursi
ALTER TABLE student 
RENAME COLUMN  email to emaili   


SELECT * FROM student 
WHERE emri LIKE 'A%'

Listoni kurset qe kane ndodhur mes vitit 2023- 2025.

SELECT * FROM kursi
WHERE create_date BETWEEN '2023-01-01' AND '2025-12-31';

SELECT emri , EXTRACT(YEAR FROM AGE(birth_date)) AS mosha_vite
FROM student
WHERE EXTRACT(YEAR FROM AGE(birth_date)) > 15;



