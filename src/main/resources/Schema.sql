-- CREATE TABLE IF NOT EXISTS students(
--                                       student_id SERIAL PRIMARY KEY,
--                                       student_name VARCHAR(100) NOT NULL,
--                                       email VARCHAR(100) NOT NULL,
--                                       phone_number VARCHAR(20)
-- );
-- CREATE TABLE IF NOT EXISTS instructors (
--                                            instructor_id SERIAL PRIMARY KEY,    -- Matches Long instructorId
--                                            instructor_name VARCHAR(100) NOT NULL, -- Matches String instructorName
--                                            email VARCHAR(100) NOT NULL UNIQUE   -- Matches String email
-- );
-- CREATE TABLE IF NOT EXISTS courses (
--                                        course_id SERIAL PRIMARY KEY,      -- Matches Long courseId
--                                        course_name VARCHAR(100) NOT NULL, -- Matches String courseName
--                                        description TEXT                   -- Matches String description
-- );
--



CREATE TABLE IF NOT EXISTS instructors (
                                           instructor_id   SERIAL       PRIMARY KEY,
                                           instructor_name VARCHAR(100) NOT NULL,
                                           email  VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
                                       course_id     SERIAL       PRIMARY KEY,
                                       course_name   VARCHAR(150) NOT NULL,
                                       description   TEXT,
                                       instructor_id INT  NOT NULL REFERENCES instructors(instructor_id)
);

CREATE TABLE IF NOT EXISTS students (
                                        student_id   SERIAL       PRIMARY KEY,
                                        student_name VARCHAR(100) NOT NULL,
                                        email  VARCHAR(150) NOT NULL UNIQUE,
                                        phone_number VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS student_course (
                                              student_id INT NOT NULL REFERENCES students(student_id),
                                              course_id  INT NOT NULL REFERENCES courses(course_id),
                                              PRIMARY KEY (student_id, course_id)
);

ALTER TABLE courses
    DROP CONSTRAINT courses_instructor_id_fkey,
    ADD CONSTRAINT courses_instructor_id_fkey
        FOREIGN KEY (instructor_id)
            REFERENCES instructors(instructor_id)
            ON DELETE CASCADE;

ALTER TABLE student_course
    DROP CONSTRAINT student_course_course_id_fkey,
    ADD CONSTRAINT student_course_course_id_fkey
        FOREIGN KEY (course_id)
            REFERENCES courses(course_id)
            ON DELETE CASCADE;

ALTER TABLE student_course
    DROP CONSTRAINT student_course_course_id_fkey,
    ADD CONSTRAINT student_course_course_id_fkey
        FOREIGN KEY (course_id)
            REFERENCES courses(course_id)
            ON DELETE CASCADE;