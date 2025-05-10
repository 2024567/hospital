Algorithms & Constructs Report
Recursive Sorting algorithm – MergeSort
	For this project I used the merge sort algorithm in Sorter.java class to sort a list of employee names.
Merge sort is a method splits a list into 2 parts, sort each part, and then joins them back together in correct order. It is a recursive algorithm, meaning it calls itself again and again until list is sorted.
I chose merge sort because it is fast and works well even when the list is very long. It is a time complexity of O(n log n), which is better than bubble sort or insertion sort for large data. Merge sort keeps the original order of names if they are the same which is useful when sorting names. Quick sort wasn’t used because its wors-case performance is slower(O(n2)).
	MergeSort method use a helper method called merge to join 2 sorted list. After sorting only first 20 names are show so output is easy to read.
Searching algorithm – binarySearch
	Search for an employee by name I use binary search in the Searcher.java class. Since list is already sorted with merge sort, binary search is good choice. It is very fast, with a time complexity of O(log n).
Binary search work by checking the middle of the lost. If the name is not there, it check either the left or right half and keeps going until it find the name or finish search. Program ignores uppercase and lowercase letters, so it’s easier for users to search.
If name is found , program show full details of that employee, including department and manger type. This help users get the information they need quickly.
Input validation and Menu System
	Program has a menu in terminal, built in Hospital.java class. It use an enum called MenuOption to control the different options. This make code more organized and easier to change later.
	User can choose to sort, search , add a new employee , or create random employees. When adding an employee, user give a name and select things like department, job title , manager type, and position level. All inputs are checked to make sure they are correct. This help protect the data from error.
Generating random employees
 	Program can a create random employees. This feature is in Hospital.java. It give each random employee a name like “emp77” and picks random values for department, manager type, job title, and position level using enum values. Random class use for this.
	New employees are added to list and printed on screen along with any employees the user added. This is helpful for testing and reviewing full list.


Code Structure and Quality
	All code is inside the CA_2 package. The classes hac=ve clear names and are short and easy to undersrand. Each class has comment to explain that it does. For example, Sorter.java and Searcher.java both have comments above method.
	Menu use Enums, sorting uses recursion, and searching is done with custion binary search code. These features show a good understanding of algorithms and clean code. Program is easy to read, good-commented, and simple to maintain
