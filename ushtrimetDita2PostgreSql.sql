DITA E 2 USHTRIMET E REJA 

funksionet count, avg, sum, group by, order by
beni select duke bere join mes 2 tabelave te ushtrimeve te djeshme

	INSERT INTO kursi(emri_kursit , kohezgjatja) VALUES 
	('Internship' , 60) ; 
	INSERT INTO student(emri , pike) VALUES 
	('Mark' , 100)
	
	SELECT emri_kursit, create_date ,  COUNT(kohezgjatja) AS numri_i_rrshtave_per_kurs
	FROM kursi
	GROUP BY emri_kursit , create_date
	ORDER BY (create_date);

piket e studentave bazuar nga emri 

	SELECT emri , AVG(pike) 
	FROM student
	GROUP  BY emri 

lidhja e 2 tabelave me join 

	SELECT s.emri,  s.emaili, s.phone_number, k.emri_kursit,  k.kohezgjatja
	FROM kursi k
	JOIN student s ON k.id = s.student_key;
	
	
	
Shtoni nje tabele tjeter qe ta lidhni me foreign key 
	
	ALTER TABLE student 
	ADD COLUMN trajner_id int
	
	CREATE TABLE trajner (
	  trajner_id SERIAL PRIMARY KEY,
	  emri_trajner VARCHAR(100),
	  id_departamentit INT
	);
	INSERT INTO trajner (emri_trajner, id_departamentit)
	VALUES
	  ('John Doe', 1),
	  ('Jane Smith', 2),
	  ('Mark Johnson', 1),
	  ('Sara Clark', 3),
	  ('Emily Davis', 2);



	ALTER TABLE student
	ADD CONSTRAINT trajneret_e_studenteve
	    FOREIGN KEY (trajner_id)
	    REFERENCES trajner(trajner_id);

po heq constraint 

	ALTER TABLE student
		DROP CONSTRAINT trajneret_e_studenteve

	UPDATE student
	SET trajner_id = 1
	WHERE emri = 'Mirsalda';

	UPDATE student
	SET trajner_id = 1
	WHERE emri = 'Sara';
	
	UPDATE student
	SET trajner_id = 2
	WHERE emri = 'Blerina';


//te bej proven 

	SELECT s.emri , s.emaili , t.emri_trajner 
	FROM student s
	JOIN trajner t ON s.trajner_id = t.trajner_id ;


	
	

Ushtrim extra: feel free te krijoni 4 tabelave. 
Tabelat te lidhen me nj-tj me foregin key. Te kete te pakten 1 lidhje shume me shume me tabelat.
Perdoni funksionet count, sum, avg, order by


//tabela e liderave ne dev 

		CREATE TABLE teamLeaderDev (
	    team_leader_id SERIAL PRIMARY KEY, 
	    emri VARCHAR(100),
	    mbiemri VARCHAR(100),
	    telefoni VARCHAR(100),
	    
	    department_id INT,
	    FOREIGN KEY (department_id) REFERENCES departamenti(departament_id)
	);

//tabela e interns ne dev 

		CREATE TABLE internDev (
	    intern_id SERIAL PRIMARY KEY, 
	    emri VARCHAR(100), 
	    universiteti VARCHAR(100), 
	    vleresimi INT
	);


//join table per many to many relationship ems teamLeaderDEV dhe internDEV 

	  CREATE TABLE team_leader_intern (
	    team_leader_id INT, 
	    intern_id INT, 
	    PRIMARY KEY (team_leader_id, intern_id), 
	    FOREIGN KEY (team_leader_id) REFERENCES teamLeaderDev(team_leader_id) ON DELETE CASCADE,
	    FOREIGN KEY (intern_id) REFERENCES internDev(intern_id) ON DELETE CASCADE
	);
	
		CREATE TABLE departamenti (
	    departament_id SERIAL PRIMARY KEY, 
	    lloji VARCHAR(100),
	    vendodhja VARCHAR(100), 
	    location_id INT
	);



INSERT INTO departamenti (lloji, vendodhja, location_id) VALUES
('Zhvillim Softueri', 'Tiranë', 101),
('Rrjete & Siguri', 'Durrës', 102),
('Analizë Biznesi', 'Vlorë', 103),
('Menaxhim Projektesh', 'Shkodër', 104);

 INSERT INTO teamLeaderDev (emri, mbiemri, telefoni, department_id) VALUES
('Endra', 'unknown', '0681112233', 1),
('Arildo', 'unknown', '0699998877', 2),
('Egel', 'unknown', '0672233445', 1),
('Yllka', 'unknown', '0687755443', 3);

INSERT INTO internDev (emri, universiteti, vleresimi) VALUES
('Mirsalda', 'Universiteti i Tiranës', 9),
('Gerald', 'Universiteti Politeknik', 8),
('Morena', 'Universiteti i Shkodrës', 10),
('Daniel', 'Universiteti Europian', 7);

INSERT INTO team_leader_intern (team_leader_id, intern_id) VALUES
(1, 1),   --Endra me Mirsalda   ketu pershkruhet lidhja mes nje team leader me disa intern dhe anasjellta
(1, 2),   --Endra me Gerald
(2, 1),   --Arildo me Mirsalda
(2, 3),   --Arildo me Morena
(3, 4),   --Egel me Daniel 
(4, 4);   --Yllka me Daniel 


--TE PERDOR SELECT PER TE MARRE MANY TO MANY 

SELECT 
  t.emri AS team_leader, 
  i.emri AS intern
FROM team_leader_intern tli 
JOIN teamLeaderDev t ON tli.team_leader_id = t.team_leader_id
JOIN internDev i ON tli.intern_id = i.intern_id;


-- sa intern ka cdo team lider 
SELECT t.emri AS team_leader  ,  COUNT (tli.intern_id) AS numri_intern
FROM teamLeaderDev t  
JOIN team_leader_intern tli ON t.team_leader_id = tli.team_leader_id
GROUP BY t.team_leader_id ; 

--mesatarja e vleresimit te teamLeader bazuar ne vleresimet qe kane marre intern-et e tyre 

SELECT t.emri AS team_leader  , SUM(i.vleresimi) AS shuma_e_vleresimeve 
FROM teamLeaderDev t 
JOIN team_leader_intern tli ON t.team_leader_id = tli.team_leader_id
JOIN internDev i on tli.intern_id = i.intern_id
GROUP BY t.team_leader_id 
ORDER BY shuma_e_vleresimeve DESC; 