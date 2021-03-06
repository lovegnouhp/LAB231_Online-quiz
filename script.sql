USE [master]
GO
/****** Object:  Database [J3.L.P0001_Quiz-online]    Script Date: 07/21/2021 10:23:50 ******/
CREATE DATABASE [J3.L.P0001_Quiz-online] ON  PRIMARY 
( NAME = N'J3.L.P0001_Quiz-online', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\J3.L.P0001_Quiz-online.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'J3.L.P0001_Quiz-online_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\J3.L.P0001_Quiz-online_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3.L.P0001_Quiz-online].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ANSI_NULLS OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ANSI_PADDING OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ARITHABORT OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET  DISABLE_BROKER
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET  READ_WRITE
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET RECOVERY SIMPLE
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET  MULTI_USER
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [J3.L.P0001_Quiz-online] SET DB_CHAINING OFF
GO
USE [J3.L.P0001_Quiz-online]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 07/21/2021 10:23:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[isTeacher] [bit] NOT NULL,
	[email] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'admin', N'admin', 1, N'admin@gmail.com')
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'HangNTT', N'123', 1, N'HangNTT@fpt.edu.vn')
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'mrA', N'123', 0, N'mra@email.com')
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'mrB', N'123', 1, N'mrb@email.com')
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'phuong', N'123', 1, N'PhuongNVHE140784@fpt.edu.vn')
INSERT [dbo].[Account] ([username], [password], [isTeacher], [email]) VALUES (N'phuong123', N'123', 0, N'phuong@gmail.com')
/****** Object:  Table [dbo].[Question]    Script Date: 07/21/2021 10:23:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](500) NOT NULL,
	[option1] [nvarchar](300) NOT NULL,
	[option2] [nvarchar](300) NOT NULL,
	[option3] [nvarchar](300) NOT NULL,
	[option4] [nvarchar](300) NOT NULL,
	[solution] [nvarchar](10) NOT NULL,
	[dateCreated] [date] NOT NULL,
	[createdBy] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Quiz] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Question] ON
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (1, N'What type of animal is a seahorse?', N'Crustacean', N'Arachnid', N'Fish', N'Shell', N'3', CAST(0xC4420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (2, N'Which of the following dog breeds is the smallest?', N'Dachshund', N'Poodle', N'Pomeranian', N'Chihuahua', N'4', CAST(0xC4420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (3, N'The name of capital of VietNam after year of 1975?', N'Sai Gon', N'Ho Chi Minh', N'Ha Noi', N'Ha Tay', N'3', CAST(0x493B0B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (4, N'What color are zebras?', N'White with black stripes', N'Black with white stripes', N'Both of the above', N'None of the above', N'2', CAST(0xC4420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (5, N'What existing bird has the largest wingspan?', N'Stork', N'Swan', N'Condor', N'Albatross', N'4', CAST(0xC4420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (6, N'What is the biggest animal that has ever lived?', N'Blue whale', N'African elephant', N'Apatosaurus (aka Brontosaurus)', N'Spinosaurus', N'1', CAST(0xC3420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (7, N'Fill in the blank: Out of these pets, there are the most pet _____ in the U.S.', N'Birds', N'Cats', N'Dogs', N'Horses', N'2', CAST(0xC2420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (8, N'Which of these animals lives the longest?', N'Ocean quahog (clam)', N'Red sea urchin', N'Galapagos tortoise', N'Rougheye rockfish', N'1', CAST(0xC3420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (9, N'What are female elephants called?', N'Mares', N'Sows', N'Cows', N'Dams', N'3', CAST(0xC4420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (10, N'Which of the following animals sleeps standing up?', N'Gorillas', N'Flamingos', N'Hedgehogs', N'Ravens', N'2', CAST(0xC4420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (11, N'What is the fastest water animal?', N'Porpoise', N'Sailfish', N'Flying fish', N'Tuna', N'2', CAST(0xC4420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (12, N'1+3 = ?', N'4', N'0', N'2+2', N'6', N'13', CAST(0xC5420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (13, N'6 + 2 = ?', N'2 + 4 + 2', N'8', N'7', N'3 + 5', N'124', CAST(0xC5420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (14, N'6 + 6 = ?', N'12', N'13', N'8 + 4', N'5 + 7', N'134', CAST(0xC5420B00 AS Date), N'admin')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (15, N'12 + 5', N'17', N'16', N'10 + 7', N'2', N'13', CAST(0xC7420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (16, N'1 + 10 = ?', N'5 + 6', N'11', N'100', N'2', N'12', CAST(0xC7420B00 AS Date), N'phuong')
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [solution], [dateCreated], [createdBy]) VALUES (17, N'30 + 3 = ?', N'33', N'12', N'15 + 18', N'1', N'13', CAST(0xC7420B00 AS Date), N'admin')
SET IDENTITY_INSERT [dbo].[Question] OFF
/****** Object:  ForeignKey [FK_Question_Account]    Script Date: 07/21/2021 10:23:50 ******/
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [FK_Question_Account] FOREIGN KEY([createdBy])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [FK_Question_Account]
GO
