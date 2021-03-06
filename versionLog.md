# Version Log

## V0.1
* Added Menu and Filework Class. User gets immediatelly transfered from Main class to Menu class.
* Added a simple welcoming message.
* Planned out the structure of the menu.
* Created a method to check whether the file's path is valid or not.

## V0.2
* Foolproofed the menu
* Added a simple file reader that stores numbers.txt lines into an ArrayList.
* Split the ArrayList with the .get() method to get the indexes. 
* Added zero checker, to check if the number starts with a zero.

## V0.3
* Changed List<String> to List<String[]>
* Improved menu and made it working differently
* Improved and fixed validation method by correcting the line reader
* Added a line switcher and a currentList 
> The line switcher only works If the Menu's choice 1 has been chosen. Otherwise it will throw up an exception [Will look into it in later versions]
> The line switcher's first line's index starts from 0.
> currentList keeps track of the current CHANGED list, so if the user doesn't choose to save, it won't. [Not implemented]

## V0.4
* Made it so the file isn't read everytime, it's put in an ArrayList instead at the beginning
* Fixed currentList and V0.3's error throwing if option 1 is not selected first

## V0.5
* Added a number switcher

## V0.6
* Added a file saver
> Appender is a comma instead of white space for testing purposes

## V0.7
* Added a saving system
> Corrected the appender
* Added checker for inputting out of bounds lines/numbers
> So no longer an exception will be thrown, but the user can correct
> Started adding specific exception handlers
* File path input now asks for a file repeatedly until a correct path is input
* File will not save if the text file is Invalid.

## V0.8
* Created a new separate menu for CRUD operations
* Added CRUD operations: read & modify a number from a line
* Optimization & readability notes:
> Removed while loops
> New method for printing file contents
> New method for changing isSaved boolean for saving files 
* Improved file saving

## V0.8 update
* Readded while loops with a different and a better structure
* Optimization & readability notes:
> New method for checking if something is out of array's bounds (Used in while loop)

## V0.9
* Added CRUD operations: Add/Remove a number at a custom position in a line

* Misc:
> Added while loops for CRUD operations
> Edited isInRange method to be able to rezise lines accordingly

## All version from here on now will be bug fixes until a stable version (V1.0) is reached

## V0.9a
* Fixed a couple of bugs and the saving system
* Cleaned the code up a bit