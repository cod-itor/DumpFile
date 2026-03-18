CREATE TABLE IF NOT EXISTS students(
                                      student_id SERIAL PRIMARY KEY,
                                      student_name VARCHAR(100) NOT NULL,
                                      email VARCHAR(100) NOT NULL,
                                      phone_number VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS instructors (
                                           instructor_id SERIAL PRIMARY KEY,    -- Matches Long instructorId
                                           instructor_name VARCHAR(100) NOT NULL, -- Matches String instructorName
                                           email VARCHAR(100) NOT NULL UNIQUE   -- Matches String email
);
CREATE TABLE IF NOT EXISTS courses (
                                       course_id SERIAL PRIMARY KEY,      -- Matches Long courseId
                                       course_name VARCHAR(100) NOT NULL, -- Matches String courseName
                                       description TEXT                   -- Matches String description
);

CREATE TABLE IF NOT EXISTS course_instructors (
    course_id INTEGER NOT NULL REFERENCES courses(course_id) ON DELETE CASCADE,
    instructor_id INTEGER NOT NULL REFERENCES instructors(instructor_id) ON DELETE CASCADE,
    PRIMARY KEY(course_id, instructor_id)
);

CREATE TABLE IF NOT EXISTS student_courses (
    student_id INTEGER NOT NULL REFERENCES students(student_id) ON DELETE CASCADE,
    course_id INTEGER NOT NULL REFERENCES courses(course_id) ON DELETE CASCADE,
    PRIMARY KEY(student_id, course_id)
);