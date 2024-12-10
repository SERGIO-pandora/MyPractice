CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          candidate_name VARCHAR(255) NOT NULL,
                          meeting_number_in_day INT NOT NULL,
                          meeting_date DATE NOT NULL,
                          candidate_specialization VARCHAR(255) NOT NULL,
                          meeting_location VARCHAR(255) NOT NULL
);
