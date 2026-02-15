INSERT INTO patient (name, birth_date, email, blood_group, age, created_at)
VALUES
    ('Rahul Sharma', '2000-01-15', 'rahul@gmail.com', 'A_POS', 25, NOW()),
    ('Neha Patil', '2003-11-22', 'neha@gmail.com', 'B_POS', 21, NOW()),
    ('Amit Verma', '1998-06-10', 'amit@gmail.com', 'O_POS', 27, NOW());


INSERT INTO doctors (name, specialization, email)
VALUES
    ('Dr. Anil Deshmukh', 'Cardiology', 'anil.deshmukh@gmail.com'),
    ('Dr. Priya Kulkarni', 'Neurology', 'priya.kulkarni@gmail.com'),
    ('Dr. Rohit Patil', 'Orthopedics', 'rohit.patil@gmail.com');
