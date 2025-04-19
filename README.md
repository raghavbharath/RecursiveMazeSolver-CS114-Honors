# Recursive Maze Traverser 

### Raghav Bharath  
### Course: CS114H02 – Honors Data Structures  
### Professor: Kapleau  
### File: `RecursiveMazeSolver.java`
### Assignment: Project 1 – Maze Solver
### Grade: 100/100

---
##  Project Overview

I wrote this program in Java. The project implements a **recursive backtracking algorithm** to solve a maze read from a file. The maze consists of walls (`#`), paths (` `), a start (`+`), and an end (`-`). To find a valid path, track that path, and mark the visited paths in the maze, I used depth-first search (DFS). 


The first line of the maze file represents the number of rows and columns, respectively. As the program moves through the maze, the current path is also marked with the + character. Any path leading to a dead end is also marked with the "." character.

Upon reaching the end of the maze, the program will print a message to the screen stating "the maze has been solved."
After the message has been printed, the path will be shown with the use of the described characters. 

## Features

- Parses maze input from a file  
- Recursively explores directions: right, down, left, up  
- Tracks visited paths with backtracking  
- Replaces failed paths with `.` for visualization  
- Handles unsolvable mazes with exception handling  
- Shows completed maze with solved path

## Concepts Practiced

- Recursive Backtracking  
- 2D Array Maze Traversal  
- String Manipulation  
- Stack-Like Recursion with Path Memory  
- File I/O using `Scanner`  
- Defensive Programming & Exception Handling 

## Instructions

To run the program, simply download the ZIP file onto your computer and add it to your preferred code editor's workspace

cd to the src folder by entering "cd src" in your terminal

After you're in the src folder, to run the program, enter these two lines of code:
- javac RecursiveMazeSolver.java
- java RecursiveMazeSolver


Alternatively, if you're using VSCode: 
- Install the Code Runner extension from VSCode marketplace, then right-click your .java file → Run Code.

The maze file should be structured as follows:

```
<rows> <columns>
##########
#+#    # #
# ## # # #
#    #   -
##########
```

- `+` → Start  
- `-` → End  
- `#` → Wall  
- ` ` → Open path
