# leenda
# With File Based System (FBS). Values are stored in a comma seperated value file (csv), and they are read by splitting the values at the comma, the user email is always at index 0 and password at index 1, comparissions can be made to these index positions to authenticate the user 

# Split By Index Method

This method accepts a user email, and index you would like the obtain the the line from the file. Example, provide userEmail and index 3, By convention, index 3 in the file userDetails.csv contains the phone number of the user.
#
email,    password,  phone number,   user type
index=0   index=1    index=2         index=3
#
