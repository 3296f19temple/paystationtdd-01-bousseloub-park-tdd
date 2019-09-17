This project simulates a paystation where a coin is entered into the paystation, which then allots a certain amount of time for allowed parking.

One of the main goals of this project is how well the team members are able to work together adding code to a main repository and have it work. While we did run into some occasional merge errors, overall the experience has been succesful.

Another requirement of this project was for us to follow test-driven development. Quick tests were to be created to test our code's functionality. The process is to create tests that result in failure, then create tests that result in success. Then refractor our code and repeat the process.

The coding objectives of this project were:

* Add a method int empty() that returns the total amount of money collected by the paystation since the last call and empties it, setting the total to zero. 

* Change cancel() to return a Map defining the coins returned to the user. 

and apply the following test cases:

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
* Contributions:
  * - Created tests 1-4
  * - Created int empty()
  * - Helped with code for cancel() to return a map
  * - prepared README file

Christopher Park
* Contributions: 
  * - Created tests 5-8
  * - Ran later stages of TDD cycles for tests
  * - Created contents of switch statements under addPayment()
  * - Added coinCount variable reset to reset()
