
CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) ,
    text VARCHAR(1000) NOT NULL
);

INSERT INTO comments (name, text) VALUES ('דני', 'אני מאוד התחברתי לסיפור, תודה ששיתפת 🙏');
INSERT INTO comments (name, text) VALUES ('אנונימי', 'האתר הזה נותן לי הרבה כוח 💙');
INSERT INTO comments (name, text) VALUES (NULL, 'גם לי היה קשה אבל זה נותן לי תקווה');

