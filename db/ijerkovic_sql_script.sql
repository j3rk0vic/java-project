CREATE DATABASE MOVIES
GO
USE MOVIES
GO

CREATE TABLE Movie
(
	IDMovie INT PRIMARY KEY IDENTITY,
	Title NVARCHAR(300),
	Link NVARCHAR(300),
	Description NVARCHAR(900),
	PicturePath NVARCHAR(90),
	PublishedDate NVARCHAR(90)
)
GO

CREATE TABLE Actor 
(
	IDActor INT PRIMARY KEY IDENTITY,
	FirstName NVARCHAR(150),
	LastName NVARCHAR(150)
)
GO

CREATE TABLE Director 
(
	IDDirector INT PRIMARY KEY IDENTITY,
	FirstName NVARCHAR(150),
	LastName NVARCHAR(150)
)
GO

CREATE TABLE Genre 
(
	IDGenre INT PRIMARY KEY IDENTITY,
	Name NVARCHAR(150)
)
GO

-- Movie-Actor relationship (mtm)
CREATE TABLE MovieActor 
(
	IDMovie INT FOREIGN KEY REFERENCES Movie(IDMovie),
	IDActor INT FOREIGN KEY REFERENCES Actor(IDActor),
	PRIMARY KEY(IDMovie, IDActor)
)
GO

-- Movie-Director relationship (otm || mtm)
CREATE TABLE MovieDirector 
(
	IDMovie INT FOREIGN KEY REFERENCES Movie(IDMovie),
	IDDirector INT FOREIGN KEY REFERENCES Director(IDDirector),
	PRIMARY KEY(IDMovie, IDDirector)
)
GO

-- Movie-Genre relationship (mtm)
CREATE TABLE MovieGenre
(
	IDMovie INT FOREIGN KEY REFERENCES Movie(IDMovie),
	IDGenre INT FOREIGN KEY REFERENCES Genre(IDGenre),
	PRIMARY KEY(IDMovie, IDGenre)
)
GO



-- stored procs:

CREATE PROCEDURE createMovie
	@Title NVARCHAR(300),
	@Description NVARCHAR(900),
	@Link NVARCHAR(300),
	@PicturePath NVARCHAR(90),
	@PublishedDate NVARCHAR(90)
	@IDMovie INT OUTPUT
AS 
BEGIN 
	INSERT INTO Movie (Title, Link, Description, PicturePath, PublishedDate)
	VALUES (@Title, @Link, @Description, @PicturePath, @PublishedDate)

	SET @IDMovie = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateMovie
	@IDMovie INT,
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@PublishedDate NVARCHAR(90)
	 
AS 
BEGIN 
	UPDATE Article SET 
		Title = @Title,
		Link = @Link
		Description = @Description,
		PicturePath = @PicturePath
		PublishedDate = @PublishedDate
	WHERE 
		IDMovie = @IDMovie
END
GO


CREATE PROCEDURE deleteMovie
	@IDMovie INT	 
AS 
BEGIN 
	DELETE  
	FROM 
			Movie
	WHERE 
		IDMovie = @IDMovie
END
GO

CREATE PROCEDURE selectMovie
	@IDMovie INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		Movie
	WHERE 
		IDMovie = @IDMovie
END
GO

CREATE PROCEDURE selectMovies
AS 
BEGIN 
	SELECT * FROM Movie
END
GO