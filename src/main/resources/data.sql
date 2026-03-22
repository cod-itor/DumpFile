
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