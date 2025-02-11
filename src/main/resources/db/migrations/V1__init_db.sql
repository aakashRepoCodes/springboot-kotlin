-- Drop tables if they exist (safe migration)
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS author CASCADE;

-- Create Author Table with Explicit Primary Key Chunking
CREATE TABLE author (
                        id BIGSERIAL PRIMARY KEY, -- Uses BIGSERIAL for automatic and scalable PK assignment
                        name VARCHAR(255) NOT NULL,
                        age INT NOT NULL,
                        description TEXT NOT NULL,
                        image_url TEXT NOT NULL
);

-- Create Book Table with Foreign Key Constraint
CREATE TABLE book (
                      isbn VARCHAR(255) PRIMARY KEY, -- ISBN is unique and a good natural key
                      title VARCHAR(255) NOT NULL,
                      description TEXT NOT NULL,
                      image TEXT NOT NULL,
                      published_date TIMESTAMP NOT NULL,
                      author_id BIGINT NOT NULL,
                      CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);
