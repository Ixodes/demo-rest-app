CREATE TABLE univer(
  id SERIAL PRIMARY KEY,
  name VARCHAR(10)
);

CREATE TABLE student(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  univer_id INT NOT NULL,
  FOREIGN KEY (univer_id) REFERENCES univer (id)
);

CREATE TABLE bottle(
  id SERIAL PRIMARY KEY,
  vol INT,
  student_id INT NOT NULL,
  FOREIGN KEY (student_id) REFERENCES student (id)
);
