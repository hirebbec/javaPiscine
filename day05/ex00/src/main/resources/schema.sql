DROP TABLE IF EXISTS "User";
DROP TABLE IF EXISTS Chatroom;
DROP TABLE IF EXISTS Message;

CREATE TABLE User (
id SERIAL PRIMARY KEY,
login varchar(80) NOT NULL,
password varchar(80) NOT NULL);

CREATE TABLE Chatroom (
id SERIAL PRIMARY KEY,
name varchar(80),
owner_id INTEGER);

CREATE TABLE Message (
id SERIAL PRIMARY KEY,
author_id INTEGER,
room_id INTEGER,
text varchar(1024),
date DATE);