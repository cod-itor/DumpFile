-- INSERT INTO students (student_name, email, phone_number) VALUES
--                                                              ('James Smith', 'james.smith@gmail.com', '012445566'),
--                                                              ('Maria Garcia', 'maria.garcia@gmail.com', '010778899'),
--                                                              ('Robert Johnson', 'robert.johnson@gmail.com', '017223344'),
--                                                              ('Linda Williams', 'linda.williams@gmail.com', '016556677'),
--                                                              ('Michael Brown', 'michael.brown@gmail.com', '070889900'),
--                                                              ('Elizabeth Jones', 'elizabeth.jones@gmail.com', '012112233'),
--                                                              ('David Miller', 'david.miller@gmail.com', '010334455'),
--                                                              ('Jennifer Davis', 'jennifer.davis@gmail.com', '061667788'),
--                                                              ('William Rodriguez', 'william.rodriguez@gmail.com', '017990011'),
--                                                              ('Susan Martinez', 'susan.martinez@gmail.com', '070223344');
-- INSERT INTO instructors (instructor_name, email) VALUES
--                                                      ('Alice Thompson', 'alice.t@university.edu'),
--                                                      ('Bob Richards', 'bob.richards@techprep.com'),
--                                                      ('Catherine Lee', 'c.lee@academy.org'),
--                                                      ('David Miller', 'david.m@studiopro.io'),
--                                                      ('Elena Rodriguez', 'elena.rod@learning.net'),
--                                                      ('Franklin Foster', 'f.foster@webdev.edu'),
--                                                      ('Gloria Chen', 'gloria.chen@codeschool.com'),
--                                                      ('Henry Wilson', 'h.wilson@it-training.org'),
--                                                      ('Isabella Kwok', 'isabella.k@dev-mastery.com'),
--                                                      ('Jameson Burke', 'j.burke@engineers.edu');
-- INSERT INTO courses (course_name, description) VALUES
--                                                    ('Java Programming I', 'Introduction to Java syntax and OOP principles.'),
--                                                    ('Advanced Spring Boot', 'Building REST APIs and mastering Dependency Injection.'),
--                                                    ('Database Systems', 'Deep dive into PostgreSQL and relational modeling.'),
--                                                    ('Web Frontend Basics', 'Learning HTML, CSS, and basic JavaScript.'),
--                                                    ('React Development', 'Building dynamic user interfaces with React hooks.'),
--                                                    ('Data Structures', 'Focusing on arrays, stacks, and queues in Java.'),
--                                                    ('Software Engineering', 'Overview of the SDLC and agile methodologies.'),
--                                                    ('Computer Networks', 'Understanding TCP/IP, DNS, and HTTP protocols.'),
--                                                    ('Operating Systems', 'Learning about processes, threads, and memory.'),
--                                                    ('Cloud Computing', 'Introduction to AWS, Docker, and deployment.');



INSERT INTO instructors (instructor_name, email) VALUES
                                                     ('Seng Rotha', 'seng.rotha@university.edu.kh'),
                                                     ('Noun Sopheak', 'noun.sopheak@university.edu.kh'),
                                                     ('Chea Boravy', 'chea.boravy@university.edu.kh'),
                                                     ('Lay Sivheng', 'lay.sivheng@university.edu.kh'),
                                                     ('Pich Somnang', 'pich.somnang@university.edu.kh'),
                                                     ('Khem Dara', 'khem.dara@university.edu.kh'),
                                                     ('Ouk Samath', 'ouk.samath@university.edu.kh'),
                                                     ('Ros Phalla', 'ros.phalla@university.edu.kh'),
                                                     ('San Kimlong', 'san.kimlong@university.edu.kh'),
                                                     ('Thul Rithy', 'thul.rithy@university.edu.kh');
INSERT INTO courses (course_name, description, instructor_id) VALUES
                                                                  ('Khmer Culture and Traditions', 'Exploring the customs of the Khmer people.', 1),
                                                                  ('Hospitality Management', 'Tourism industry standards in Cambodia.', 2),
                                                                  ('Business Law', 'Legal frameworks for entrepreneurs in Cambodia.', 3),
                                                                  ('Economic Development', 'Post-conflict economic growth in SE Asia.', 4),
                                                                  ('Agro-Industry', 'Focusing on sustainable farming in rural provinces.', 5),
                                                                  ('Environmental Science', 'Protecting the Tonle Sap ecosystem.', 6),
                                                                  ('Microfinance', 'Study of the Cambodian financial sector.', 7),
                                                                  ('Digital Marketing', 'Strategies for the Cambodian social media market.', 8),
                                                                  ('Civil Engineering', 'Urban planning for Phnom Penh development.', 9),
                                                                  ('Human Resources', 'Managing talent in the local workforce.', 10);

INSERT INTO students (student_name, email, phone_number) VALUES
                                                             ('Bun Thoeun', 'bun.thoeun@gmail.com', '012111222'),
                                                             ('Chhim Sreyneang', 'chhim.sreyneang@gmail.com', '010333444'),
                                                             ('Em Chantha', 'em.chantha@gmail.com', '097555666'),
                                                             ('Hou Vathanak', 'hou.vathanak@gmail.com', '081777888'),
                                                             ('Im Socheata', 'im.socheata@gmail.com', '015999000'),
                                                             ('Ken Raksmey', 'ken.raksmey@gmail.com', '077123456'),
                                                             ('Lim Heng', 'lim.heng@gmail.com', '085234567'),
                                                             ('Mom Piseth', 'mom.piseth@gmail.com', '093345678'),
                                                             ('Nget Sovann', 'nget.sovann@gmail.com', '069456789'),
                                                             ('Phuong Malis', 'phuong.malis@gmail.com', '088567890');

INSERT INTO student_course (student_id, course_id) VALUES
   (1, 1),
   (2, 2),
   (3, 3),
   (4, 4),
   (5, 5),
   (6, 6),
   (7, 7),
   (8, 8),
   (9, 9),
   (10, 10);