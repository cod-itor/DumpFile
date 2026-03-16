CREATE TABLE IF NOT EXISTS students(
                                      student_id SERIAL PRIMARY KEY,
                                      student_name VARCHAR(100) NOT NULL,
                                      email VARCHAR(100) NOT NULL,
                                      phone_number VARCHAR(20)
);