CREATE PROCEDURE validateElectionClerk(
    IN usernameValue CHAR(12),
    IN passwordValue CHAR(64),
  	OUT result INT
)
BEGIN
    SELECT COUNT(*) INTO result
    FROM Election_Clerk
    WHERE usernameValue = username
    AND passwordValue = password;
END;

DROP PROCEDURE validateElectionClerk;

CALL validateElectionClerk("aaabbb", "111222", @result);

CREATE PROCEDURE saveOpeningTime(
    IN idValue INT
)
BEGIN
		SET time_zone = 'America/Argentina/Buenos_Aires';
		UPDATE Election_Clerk
    SET opening_time = NOW( )
    WHERE id = idValue;
END;

DROP PROCEDURE saveOpeningTime;

CALL saveOpeningTime(1);

CREATE PROCEDURE saveClosingTime(
    IN idValue INT
)
BEGIN
		SET time_zone = 'America/Argentina/Buenos_Aires';
		UPDATE Election_Clerk
    SET closing_time = NOW( )
    WHERE id = idValue;
END;

DROP PROCEDURE saveClosingTime;

CALL saveClosingTime(1);

CREATE PROCEDURE getVoter(
    IN documentValue INT,
  	OUT idValue INT,
  	OUT fn VARCHAR(45),
  	OUT ln VARCHAR(45),
  	OUT bd DATE,
  	OUT ad VARCHAR(45)
)
BEGIN
		SELECT id, first_name, last_name, birthdate, address
    INTO idValue, fn, ln, bd, ad
    FROM Voter
    WHERE documentValue = document;
END;

DROP PROCEDURE getVoter;

CALL getVoter(43716112, @id, @fn, @ln, @bd, @ad);
