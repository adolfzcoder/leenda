# leenda
# With File Based System (FBS). Values are stored in a comma seperated value file (csv), and they are read by splitting the values at the comma, the user email is always at index 0 and password at index 1, comparissions can be made to these index positions to authenticate the user 

# Split By Index Method

This method accepts a user email, and index you would like the obtain the the line from the file. Example, provide userEmail and index 3, By convention, index 3 in the file userDetails.csv contains the phone number of the user.

# userDetails.csv

email:index=0  

password:index=1 

phone number:index=2

user type:index=3

# cars.csv

userEmail:index=0

carID:index=1

carName:index=2

carYear:index=3

carType:index=4

dailyRate:index=5

status (booked available):index=6

carImageUrl:index=7

VIN:index=8

carOwnerEmail:index=9


dailyRate:index=4

status:index=5

#

