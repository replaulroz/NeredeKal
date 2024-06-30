CREATE DATABASE mydatabase;

USE mydatabase;

-- 1
CREATE TABLE Person (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100),
    BIRTH_DATE DATE
);

INSERT INTO Person (NAME, BIRTH_DATE) VALUES
    ('Kemal Sunal', '1944-11-11'),
    ('Şener Şen', '1941-12-26'),
    ('Adile Naşit', '1930-06-17'),
    ('Tarık Akan', '1949-07-13'),
    ('Emel Sayın', '1945-02-20'),
    ('Münir Özkul', '1925-08-15'),
    ('Ayşen Gruda', '1944-10-22'),
    ('İhsan Yüce', '1930-09-22'),
    ('Halit Akçatepe', '1938-01-01'),
    ('Müjde Ar', '1954-06-21');
-- 1
CREATE TABLE Movie (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100),
    YEAR INT,
    DIRECTOR VARCHAR(100)
);

INSERT INTO Movie (NAME, YEAR, DIRECTOR) VALUES
    ('Neşeli Günler', 1978, 'Orhan Aksoy'),
    ('Canım Kardeşim', 1973, 'Ertem Eğilmez'),
    ('Mavi Boncuk', 1975, 'Ertem Eğilmez'),
    ('Arabesk', 1988, 'Ertem Eğilmez'),
    ('Çiçek Abbas', 1982, 'Sinan Çetin');


CREATE TABLE Cast (
    MOVIE_ID INT,
    PERSON_ID INT,
    ACTING_AS VARCHAR(100),
    PRIMARY KEY (MOVIE_ID, PERSON_ID),
    FOREIGN KEY (MOVIE_ID) REFERENCES Movie(ID),
    FOREIGN KEY (PERSON_ID) REFERENCES Person(ID)
);

INSERT INTO Cast (MOVIE_ID, PERSON_ID, ACTING_AS) VALUES
    (1, 8, 'Nazif'),
    (1, 6, 'Kazım'),
    (1, 2, 'Ziya'),
    (1, 7, 'Nilgün'),
    (1, 3, 'Saadet'),
    (2, 4, 'Murat'),
    (2, 9, 'Halit'),
    (2, 3, 'Öğretmen'),
    (2, 1, 'Yolcu'),
    (3, 5, 'Emel Sayın'),
    (3, 4, 'Necmi'),
    (3, 9, 'Mıstık'),
    (3, 3, 'Adile'),
    (4, 2, 'Şener'),
    (4, 10, 'Müjde'),
    (5, 2, 'Şakir'),
    (5, 7, 'Şükriye');



-- 2
SELECT NAME AS Film, YEAR AS Yapım_Yılı
FROM Movie
ORDER BY YEAR ASC
LIMIT 1;

-- 3
SELECT NAME AS Oyuncu, BIRTH_DATE AS 'Doğum Yılı', YEAR(CURDATE()) - YEAR(BIRTH_DATE) AS Yaş
FROM Person
ORDER BY BIRTH_DATE ASC
LIMIT 1;

-- 4
SELECT m.NAME AS Film, m.YEAR AS Yapım_Yılı, p.NAME AS Oyuncu
FROM Movie m
JOIN Cast c ON m.ID = c.MOVIE_ID
JOIN Person p ON c.PERSON_ID = p.ID
WHERE m.YEAR = (SELECT MAX(YEAR) FROM Movie);

-- 5
SELECT DIRECTOR AS Yönetmen, COUNT(*) AS 'Film Sayısı'
FROM Movie
GROUP BY DIRECTOR;

-- 6
SELECT p.NAME AS Oyuncu, COUNT(*) AS 'Film Sayısı'
FROM Person p
JOIN Cast c ON p.ID = c.PERSON_ID
GROUP BY p.NAME
ORDER BY COUNT(*) DESC
LIMIT 1;

-- 7
SELECT NAME AS Film, YEAR AS Yapım_Yılı
FROM Movie
WHERE DIRECTOR = 'Ertem Eğilmez';

-- 8
SELECT p.NAME AS Oyuncu, p.BIRTH_DATE AS 'Doğum Yılı'
FROM Person p
JOIN Cast c ON p.ID = c.PERSON_ID
JOIN Movie m ON c.MOVIE_ID = m.ID
WHERE m.DIRECTOR = 'Orhan Aksoy'
ORDER BY p.BIRTH_DATE ASC
LIMIT 1;

