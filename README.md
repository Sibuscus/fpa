# File Processing Application

----
## What is the FPA?

The FPA is a command-line application made in the Java language that allows the user to manipulate text files with numbers.
Program used to build and run: Intellij Community 

----
## Limits (*Incomplete*)
1. Each number is presented as a sequence of digits (0-9) and must not start with 0.
2. Each number in each line mustn't start with space or tab, but must be separated by one. There are no limits on how many numbers a line can hold.

numbers.txt example:
> 123232 3240230042340230803240 3240909
> 112312321525 12312312 5234234234 231321321312 123123 
> 9897823423975239 2342342 2131353453435345345

----
## Usage (*Incomplete*)
#### 1. The program asks the user to give a path to a text file.

#### 2. Menu Options

* Validate file contents

>Checks whether the numbers in the text file pass the **LIMITS** restrictions.

* Switch lines

>Swaps the two specified lines' place

* Switch indexes

> Switches the number at a specific index in a line with another number with a specific index and line.

* CRUD operations

> Read, insert, change and delete a specific number in a specific line.

* Save the file

>Saves the files, whilst validating the numbers as well. If there are invalid numbers, it will not save.