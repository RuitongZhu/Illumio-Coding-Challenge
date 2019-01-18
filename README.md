# Illumio-Coding-Challenge
Code for the coding challenge provided by Illumio

My main focus while approaching this coding challenge was to come up with a solution which solves the basic problem statement
by writing code which can be extended further and modified easily for performance improvements.

In the given time limit, I was able to solve the given problem statement. The explanation for my code is as below:

```Firewall.java``` The main class with a constructor that takes in a file path for the input rules. It reads the CSV file
line by line and creates a rule by leveraging the ```Rule.java``` and store the rule in a HashSet

```Rule.java``` This class takes in the 4 parameters of a CSV line and creates a rule based upon that. As the ```Port``` and
```IP``` have both the cases of a single unit and a range, the Rule needs to be modified accordingly. For this purpose ```Port.java```
and ```IpAddress.java``` is present which takes care of the above scenario. An equals method is present which checks whether two 
given rules are equal or not.

There is a JUnit test for testing the basic functionality of the program

#### Improvements suggested
Right now I am iterating through a set of loops every time I want to check whether a given packet is valid or not. I would rather 
like to design a data structure where a certain rule corresponds to a specific value and a given packet can be matched against it in 
order to improve linear time complexity 