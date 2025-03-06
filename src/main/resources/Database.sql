Create database OffreEmploi;
use OffreEmploi;
CREATE TABLE users (
   user_id      INT AUTO_INCREMENT PRIMARY KEY,
   nom          VARCHAR(100) NOT NULL,
   email        VARCHAR(100) NOT NULL UNIQUE,
   password     VARCHAR(100) NOT NULL,
   user_type  ENUM('CANDIDATE','RECRUITER') NOT NULL
);
CREATE TABLE candidates (
    candidate_id INT PRIMARY KEY,
    tel          VARCHAR(20),
    cv           TEXT,
    FOREIGN KEY (candidate_id) REFERENCES users(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE recruteur (
   recruiter_id INT PRIMARY KEY,
   attribut1    VARCHAR(100),
   FOREIGN KEY (recruiter_id) REFERENCES users(user_id)
       ON DELETE CASCADE
       ON UPDATE CASCADE
);
CREATE TABLE offre_emploi (
  offre_id         INT AUTO_INCREMENT PRIMARY KEY,
  titre            VARCHAR(200) NOT NULL,
  description      TEXT,
  date_publication DATE,
  recruiter_id     INT NOT NULL,
  FOREIGN KEY (recruiter_id) REFERENCES recruteur(recruiter_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE TABLE candidature (
     candidature_id   INT AUTO_INCREMENT PRIMARY KEY,
     status           VARCHAR(50),
     candidate_id     INT NOT NULL,
     offre_id         INT NOT NULL,
     FOREIGN KEY (candidate_id) REFERENCES candidates(candidate_id)
         ON DELETE CASCADE
         ON UPDATE CASCADE,
     FOREIGN KEY (offre_id) REFERENCES offre_emploi(offre_id)
         ON DELETE CASCADE
         ON UPDATE CASCADE
);
