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