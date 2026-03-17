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