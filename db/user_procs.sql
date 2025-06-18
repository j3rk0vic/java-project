CREATE TABLE AppUser
(
    IDUser INT PRIMARY KEY IDENTITY,
    Username NVARCHAR(150) NOT NULL UNIQUE,
    UserPassword NVARCHAR(150) NOT NULL,
    UserRole NVARCHAR(20) NOT NULL
)
GO

CREATE OR ALTER PROCEDURE registerUser
    @Username NVARCHAR(150),
    @UserPassword NVARCHAR(150),
	@Salt NVARCHAR(150),
    @UserRole NVARCHAR(20),
    @IDUser INT OUTPUT
AS
BEGIN
    INSERT INTO AppUser (Username, UserPassword, Salt, UserRole)
    VALUES (@Username, @UserPassword, @Salt, @UserRole)

    SET @IDUser = SCOPE_IDENTITY()
END
GO

CREATE OR ALTER PROCEDURE loginUser
    @Username NVARCHAR(150)
AS
BEGIN
    SELECT * FROM AppUser
    WHERE Username = @Username AND UserPassword = @UserPassword
END
GO





ALTER TABLE AppUser
ADD Salt NVARCHAR(150) NOT NULL DEFAULT '';
