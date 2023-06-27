INSERT INTO "User" (login, password) VALUES
('Ruzel', '123'),
('Diana', '321qwe'),
('QWERTY', 'lol'),
('KEK', 'zxxc'),
('Axe', 'Axe');

INSERT INTO Chatroom (name, owner_id) VALUES
('school', 2),
('day2', 4),
('CS', 3),
('English', 1),
('Films', 5);

INSERT INTO Message (author_id, room_id, text) VALUES
(1, 2, 'Hello'),
(2, 1, 'Lol!'),
(3, 4, 'Go!'),
(4, 2, 'Yes!'),
(5, 3, 'No, no, no!!!');
