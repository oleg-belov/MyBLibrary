DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book_category;

------ Cteate Table for books category --------
CREATE TABLE book_category (
	category_id integer PRIMARY KEY,
	category_name varchar(20) NOT NULL
)

WITH (
  OIDS=FALSE
);

ALTER TABLE public.book_category
  OWNER TO blibrary;
------ Insert into book category table --------
INSERT INTO book_category (category_id, category_name)
VALUES (1, 'Core');

INSERT INTO book_category (category_id, category_name)
VALUES (2, 'Generics');

INSERT INTO book_category (category_id, category_name)
VALUES (3, 'Web - services');

INSERT INTO book_category (category_id, category_name)
VALUES (4, 'Servlets, Jsp, Jstl');

INSERT INTO book_category (category_id, category_name)
VALUES (5, 'Jsf');

INSERT INTO book_category (category_id, category_name)
VALUES (6, 'Jaas');

INSERT INTO book_category (category_id, category_name)
VALUES (7, 'Spring framework');

INSERT INTO book_category (category_id, category_name)
VALUES (8, 'Jdbc');

INSERT INTO book_category (category_id, category_name)
VALUES (9, 'Log4j');

INSERT INTO book_category (category_id, category_name)
VALUES (10, 'JUnit');

INSERT INTO book_category (category_id, category_name)
VALUES (11, 'Concurrensy');

INSERT INTO book_category (category_id, category_name)
VALUES (12, 'EJB');

INSERT INTO book_category (category_id, category_name)
VALUES (13, 'Hibernate, Jpa');

INSERT INTO book_category (category_id, category_name)
VALUES (14, 'JavaFx');

INSERT INTO book_category (category_id, category_name)
VALUES (15, 'Swing');

INSERT INTO book_category (category_id, category_name)
VALUES (16, 'Postgre SQL');

INSERT INTO book_category (category_id, category_name)
VALUES (17, 'MySQL');

INSERT INTO book_category (category_id, category_name)
VALUES (18, 'Oracle DB');

INSERT INTO book_category (category_id, category_name)
VALUES (19, 'Microsoft SQL');

INSERT INTO book_category (category_id, category_name)
VALUES (20, 'DB2');

INSERT INTO book_category (category_id, category_name)
VALUES (21, 'HTML');

INSERT INTO book_category (category_id, category_name)
VALUES (22, 'Css');

INSERT INTO book_category (category_id, category_name)
VALUES (23, 'JavaScript');

------ Cteate Table for authors --------
CREATE TABLE author (
	author_id SERIAL PRIMARY KEY,
	author_img bytea,
	author_name varchar(30) NOT NULL,
	author_date_of_birth date 
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.author
  OWNER TO blibrary;
  
------ Insert into author table --------
INSERT INTO author (author_name, author_date_of_birth)
VALUES ('������� �����', '23/2/1951');

INSERT INTO author (author_name)
VALUES ('��� ���������');

INSERT INTO author (author_name)
VALUES ('���� �������');

------ Cteate table for book --------
CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	book_name varchar(100) NOT NULL,
	book_descr text,
	book_pages int ,
	book_img bytea,
	book_date int ,
	book_language varchar(10),
	category_id int NOT NULL,
	book_tupe varchar(5),
	book_pdf bytea		
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO blibrary;

------ Add foreign key constraint for book table references  book_category--------
ALTER TABLE book ADD CONSTRAINT book_category_id_fk FOREIGN KEY (category_id) REFERENCES book_category (category_id);

------ Insert into book table --------
INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java 8. ������ �����������', 
'����� Java 8. ������ ����������� �������� ������������� 		������������ �� ���������������� �� ����� Java.  � ���� ���������� �������, ��������� ����������� � ������ ��������� ������ Java SE 8, ����������, ��� �������������, �������������, ���������� � ��������� ��������� �� ����� ���������������� Java. ����� �������� ��������� �������, ������� ���������� �� ���� ���� ���� �� ������ ����������������, ����� �������, ����� �������� ��� �������� �������� Java, ������� ���������, �������� �����, �������� �������� ��������-���������������� ����������������, ������������ ����� ����������� ������������ ���������� Java API, ���������� �������, ������ � ��������, ���������� JavaBeans, ���������� AWT � Swing, � ����� ������������������ �� ���������� �� ������� � ��������� ��������. � ����� �Java 8. ������ ����������� �� �������� ��������� � ����� ��������, ����������� � ������ Java SE 8, � ��� ����� ������-���������, ����������� ������������ ������, ���������� ������� �����-������, � ����� ���������� JavaFX.', 
1377, 2015, '�������', 1, 'pdf');

INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java. ���������� �������������, ��� 1. ������. 9-� �������', 
'��� ��������� ����������� � ������ ������ Java SE 7 ������� ������������ ����� �������� ���������� ����������� �� ����� ���������������� Java ��� ���, ��� ������������� ��������� ������� �� ��������� Java.<br> � ���� �������� � �������� ������������ ����������� ������� ������ �������� �������� � ����������, ������������������� ��������� ������������ � ������������ ��������� �� �������� ���������������� �� Java. ����������� ������� ������ ��� ��������� � ����������� ������� � �������� �������� ��������� ������ ��� ��������� ������������ ����.', 
855,2014, '�������', 1, 'pdf');

INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java. ���������� �������������, ��� 2. ����������� �������� ����������������, 9-� �������', 
'��� ��������� ����������� � ������ ������ Java SE 7 ������� ������������ ����� �������� ���������� ����������� �� ����� ���������������� Java ��� ���, ��� ������������� ��������� ������� �� ��������� Java.<br> � ���� �������� � �������� ������������ ����������� ������� ������ �������� �������� � ����������, ������������������� ��������� ������������ � ������������ ��������� �� �������� ���������������� �� Java. ����������� ������� ������ ��� ��������� � ����������� ������� � �������� �������� ��������� ������ ��� ��������� ������������ ����.', 
993, 2014, '�������', 1, 'pdf');

------ Cteate table to link authors and books --------
CREATE TABLE book_author (
	book_id int,
	author_id int	
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.book_author
  OWNER TO blibrary;
  
------ Add foreign key constraint for book_author table references  book --------
------ Add foreign key constraint for book_author table references  author --------
ALTER TABLE book_author ADD CONSTRAINT book_author_book_id_fk FOREIGN KEY (book_id) REFERENCES book (book_id);
ALTER TABLE book_author ADD CONSTRAINT book_author_author_id_fk FOREIGN KEY (author_id) REFERENCES author (author_id);

------ Insert into book_author table --------
INSERT INTO book_author (book_id, author_id)
VALUES (1, 1);

INSERT INTO book_author (book_id, author_id)
VALUES (2, 2);

INSERT INTO book_author (book_id, author_id)
VALUES (2, 3);

INSERT INTO book_author (book_id, author_id)
VALUES (3, 2);

INSERT INTO book_author (book_id, author_id)
VALUES (3, 3);