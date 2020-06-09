insert into user_table(user_table_id, login, password, role)
VALUES (1, 'Admin@login.com', 'password', 'Admin');

insert into user_table(user_table_id, login, password, role)
VALUES (2, 'Teacher@login.com', 'password', 'Teacher');
insert into user_table(user_table_id, login, password, role)
VALUES (3, 'Teacher1@login.com', 'password', 'Teacher');
insert into user_table(user_table_id, login, password, role)
VALUES (4, 'Teacher2@login.com', 'password', 'Teacher');

insert into user_table(user_table_id, login, password, role)
VALUES (5, 'Student@login.com', 'password', 'Student');
insert into user_table(user_table_id, login, password, role)
VALUES (6, 'Student1@login.com', 'password', 'Student');
insert into user_table(user_table_id, login, password, role)
VALUES (7, 'Student2@login.com', 'password', 'Student');



insert into teacher(teacher_id, teacher_name, teacher_second_name, user_table_id)
VALUES (1, 'Alexander', 'Ivanov', 2);
insert into teacher(teacher_id, teacher_name, teacher_second_name, user_table_id)
VALUES (2, 'Igor', 'Petrov', 3);
insert into teacher(teacher_id, teacher_name, teacher_second_name, user_table_id)
VALUES (3, 'Daniil', 'Zevcon', 4);


insert into student(student_id, student_name, student_second_name, user_table_id)
VALUES (1, 'Vasilii', 'Dmitrov', 5);
insert into student(student_id, student_name, student_second_name, user_table_id)
VALUES (2, 'Arkadii', 'Ignatik', 6);
insert into student(student_id, student_name, student_second_name, user_table_id)
VALUES (3, 'Sirik', 'Pavel', 7);


insert into course(course_id, course_name, teacher_id, course_start_date, course_end_date)
VALUES (1, 'English', 1, '2020-01-01', '2020-02-01');
insert into course(course_id, course_name, teacher_id, course_start_date, course_end_date)
VALUES (2, 'French', 2, '2020-01-01', '2020-02-01');
insert into course(course_id, course_name, teacher_id, course_start_date, course_end_date)
VALUES (3, 'Polish', 3, '2020-01-01', '2020-02-01');

insert into course_students(student_id, mark, course_id)
VALUES (1, '0', 1);
insert into course_students(student_id, mark, course_id)
VALUES (2, '0', 2);
insert into course_students(student_id, mark, course_id)
VALUES (3, '0', 3);