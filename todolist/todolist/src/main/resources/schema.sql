CREATE TABLE IF NOT EXISTS Task(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id)
);






-- CREATE TABLE IF NOT EXISTS Run (
--     id INT NOT NULL AUTO_INCREMENT,
--     title VARCHAR(250) NOT NULL,
--     started_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     completed_on TIMESTAMP NULL DEFAULT NULL, -- Allow NULL if the run isn't completed yet
--     miles INT NOT NULL,
--     location VARCHAR(10) NOT NULL,
--     PRIMARY KEY (id)
-- );