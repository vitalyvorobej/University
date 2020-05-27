CREATE TABLE "course"
(
    "course_id"         serial                NOT NULL,
    "course_name"       character varying(20) NOT NULL,
    "teacher_id"        integer               NOT NULL,
    "course_start_date" DATE                  NOT NULL,
    "course_end_date"   DATE                  NOT NULL,
    CONSTRAINT "course_pk" PRIMARY KEY ("course_id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "teacher"
(
    "teacher_id"          serial                NOT NULL,
    "teacher_name"        character varying(20) NOT NULL,
    "teacher_second_name" character varying(20) NOT NULL,
    "user_table_id"       integer               NOT NULL,
    CONSTRAINT "teacher_pk" PRIMARY KEY ("teacher_id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "student"
(
    "student_id"          serial                NOT NULL,
    "student_name"        character varying(20) NOT NULL,
    "student_second_name" character varying(20) NOT NULL,
    "user_table_id"       integer               NOT NULL,
    CONSTRAINT "student_pk" PRIMARY KEY ("student_id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "course_students"
(
    "student_id" integer              NOT NULL,
    "mark"       character varying(3) NOT NULL,
    "course_id"  integer              NOT NULL
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "user_table"
(
    "user_table_id" serial                NOT NULL,
    "login"         character varying(40) NOT NULL,
    "password"      character varying(20) NOT NULL,
    "role"          character varying(10) NOT NULL,
    CONSTRAINT "user_table_pk" PRIMARY KEY ("user_table_id")
) WITH (
      OIDS= FALSE
    );



ALTER TABLE "course"
    ADD CONSTRAINT "course_fk0" FOREIGN KEY ("teacher_id") REFERENCES "teacher" ("teacher_id");

ALTER TABLE "teacher"
    ADD CONSTRAINT "teacher_fk0" FOREIGN KEY ("user_table_id") REFERENCES "user_table" ("user_table_id");

ALTER TABLE "student"
    ADD CONSTRAINT "student_fk0" FOREIGN KEY ("user_table_id") REFERENCES "user_table" ("user_table_id");

ALTER TABLE "course_students"
    ADD CONSTRAINT "course_students_fk0" FOREIGN KEY ("student_id") REFERENCES "student" ("student_id");
ALTER TABLE "course_students"
    ADD CONSTRAINT "course_students_fk1" FOREIGN KEY ("course_id") REFERENCES "course" ("course_id");


