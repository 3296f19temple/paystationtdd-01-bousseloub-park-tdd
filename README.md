Paystation

* Add a method int empty() that returns the total amount of money collected by the paystation since the last call and empties it, setting the total to zero. 

* Change cancel() to return a Map defining the coins returned to the user. 

Apply the following test cases:

* Call to empty returns the total amount entered.
* Canceled entry does not add to the amount returned by empty.
* Call to empty resets the total to zero.
* Call to cancel returns a map containing one coin entered.
* Call to cancel returns a map containing a mixture of coins entered. ( Entering 10c, 10c and 5c then pressing cancel is returning 2x10c and 1x5c and really not returning 1x25c)
* Call to cancel returns a map that does not contain a key for a coin not entered.
* Call to cancel clears the map.
* Call to buy clears the map.

Team Members: 

Maamar Bousseloub

Christopher Park