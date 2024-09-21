# leenda
# With File Based System (FBS). Values are stored in a comma seperated value file (csv), and they are read by splitting the values at the comma, the user email is always at index 0 and password at index 1, comparissions can be made to these index positions to authenticate the user 
SQL 

--create database to store the tables
create database leenda
use leenda
--create tables
#
--AppUser
#
create table AppUser(
userID INT PRIMARY KEY ,
firstName VARCHAR (45) NOT NULL,
lastName VARCHAR (45) NOT NULL,
email VARCHAR (254) UNIQUE,
userPassword CHAR (60) NOT NULL,
dateOfBirth DATE NOT NULL CHECK (dateOfBirth < GETDATE()),
driverLicenseNumber VARCHAR (20) NOT NULL,
profilePictureURL VARCHAR (2048),
dateCreated DATE NOT NULL,
userType VARCHAR(10),
verificationStatus VARCHAR(10) CHECK (verificationStatus IN ('verified', 'pending',
'rejected')),
phoneNumber VARCHAR(20) NOT NULL CHECK (phoneNumber LIKE '+%' AND
LEN(phoneNumber) BETWEEN 10 AND 20))
; -- Constraint for verification status;
#
--HouseAddress
#
CREATE TABLE HouseAddress(
houseAddressID INT PRIMARY KEY ,
country NVARCHAR(100) NOT NULL,
town NVARCHAR(100),
addressLocation NVARCHAR(100)NOT NULL,
region NVARCHAR(100),
street NVARCHAR(150)NOT NULL,
erf NVARCHAR(50) NOT NULL CHECK (LEN(erf) <= 50), -- Limit length of erf to
50 characters
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES appUser(userID)
);
#
--DriverLicenseExpiryDate
# 
CREATE TABLE DriverLicenseExpiryDate(
driverLicenseExpiryDateID INT PRIMARY KEY,
driverLicenseExpiryDate DATE,
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES appUser(userID),
driverLicenseExpiryDate DATE NOT NULL CHECK (driverLicenseExpiryDate >
GETDATE()) -- Expiry date must be in the future
);
#
--Review
CREATE TABLE Review(
reviewID INT PRIMARY KEY,
rating DECIMAL(3,1) NOT NULL CHECK (rating BETWEEN 0.0 AND 5.0), --
Rating between 0.0 and 5.0
comment VARCHAR(8000),
datePosted DATE NOT NULL,
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES AppUser(userID)
);
#
--Vehicle
CREATE TABLE Vehicle (
vehicleIdentificationNumber CHAR(17) PRIMARY KEY,
make NVARCHAR(50) NOT NULL,
model VARCHAR(50)NOT NULL,
vehicleYear INT NOT NULL,
colour VARCHAR(20),
licensePlateNumber VARCHAR(10) NOT NULL,
odometerReading INT NOT NULL,
fuelType VARCHAR(20) NOT NULL CHECK (fuelType IN ('Petrol', 'Diesel', 'Electric',
'Hybrid')), -- Valid fuel types
transmission VARCHAR(20) NOT NULL,
numberOfSeats TINYINT NOT NULL CHECK (numberOfSeats > 0), -- Must have at
least 1 seat
pricePerDay DECIMAL(10, 2) NOT NULL CHECK (pricePerDay > 0), -- Positive
price per day
pricePerWeek DECIMAL(10, 2) NOT NULL CHECK (pricePerWeek > 0), -- Positive
price per week
lastMaintenanceDate DATE,
vehicleStatus VARCHAR(20)NOT NULL CHECK (vehicleStatus IN ('available',
'booked', 'maintenance', 'unavailable')),-- vehicle status
userID INT,
FOREIGN KEY (userID) REFERENCES AppUser(userID)
);
#
--Maintenance
CREATE TABLE Maintenance (
maintenanceID INT PRIMARY KEY ,
maintenanceType VARCHAR(40)NOT NULL,
maintainanceDescription VARCHAR(8000) NOT NULL,
maintainanceDate DATE NOT NULL CHECK (maintainanceDate <= GETDATE()), --
Maintenance date should not be in the future
vehicleIdentificationNumber CHAR(17) NOT NULL,
FOREIGN KEY (vehicleIdentificationNumber) REFERENCES
Vehicle(vehicleIdentificationNumber)
);
#
--Booking
CREATE TABLE Booking(
bookingID INT PRIMARY KEY,
startDate DATE NOT NULL,
endDate DATE NOT NULL ,
bookingStatus VARCHAR(10) NOT NULL CHECK (bookingStatus IN ('confirmed',
'pending', 'canceled', 'completed')), -- Valid booking statuses
CONSTRAINT chk_endDate CHECK (endDate > startDate),
vehicleIdentificationNumber CHAR(17) NOT NULL,
FOREIGN KEY (vehicleIdentificationNumber) REFERENCES
Vehicle(vehicleIdentificationNumber),
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES appUser(userID)
);
#
--Booking location
CREATE TABLE BookingLocation(
bookingLocationID INT PRIMARY KEY,
country NVARCHAR (100),
town NVARCHAR (100),
region NVARCHAR (100),
street NVARCHAR (100),
erf NVARCHAR (50),
locationType VARCHAR (15),
bookingID INT NOT NULL,
FOREIGN KEY (bookingID) REFERENCES Booking(bookingID)
);
#
--payment
CREATE TABLE Payment (
paymentID INT PRIMARY KEY,
amount DECIMAL(10,2) NOT NULL CHECK (amount > 0), -- Positive payment
amount,
paymentMethod VARCHAR(20) NOT NULL,
paymentStatus VARCHAR(20) NOT NULL CHECK (paymentStatus IN ('paid',
'pending', 'failed')), -- Valid payment statuses
paymentDate DATE NOT NULL NOT NULL CHECK (paymentDate <= GETDATE()),
-- Payment date cannot be in the future
bookingID INT NOT NULL,
FOREIGN KEY (bookingID) REFERENCES Booking (bookingID),
);
