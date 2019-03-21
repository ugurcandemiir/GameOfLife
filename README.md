# Lab 09 - The Game of Life

## Due Tuesday, Oct. 30 at 11:59 PM

## Background

Let's bring together the concept of two-dimenstional arrays with some of the GUI work we've been practicing in a simple but fascinating game, invented by the British mathematician [John Conway](https://en.wikipedia.org/wiki/John_Horton_Conway). There is a complete description of this game in the textbook, problem P7.10. There is also a Wikipedia [article on the Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

The Game of Life consists of a grid of cells in which each cell can either be *alive* (black) or *dead* (light gray). Each cell in the grid is referenced by its row index and column index in the grid. For isntance, ```cells[i][j]``` is the cell at row ```i``` and column ```j```. The grid starts at a specific state in which each cell in the grid is either alive or dead. 

In each turn of the game, each cell looks at all of it's neighboring cells. The concept of *neighbor* is defined as follows. For most cells, ```cells[i][j]``` has 8 neighbors, defined by the following table:

| | | |
| :-------------: | :--------------: | :--------------: |
| ```cells[i-1][j-1]``` | ```cells[i-1][j]``` | ```cells[i-1][j+1]``` |
| ```cells[i][j-1]``` | **target cell** | ```cells[i][j+1]``` |
| ```cells[i+1][j-1]``` | ``` cells[i+1][j]``` | ```cells[i+1][j+1]``` |

Note that cells in the top row don't have neighbors above them, so top row cells only have 5 neighbors. Similarly, cells in the bottom row have 5 neighbors because there are no lower neighbors, and cells in the leftmost column and rightmost columns have no left and right neighbors respectively, so also have only 5 neighbors. Cells in the corners have only 3 neighbors.

In each turn of the Game of Life, whether a specific cell in the grid lives or dies depends on the follwoing three rules:

1. If the cell is dead, but has exactly three neighbors which are alive, it comes to life (birth)
2. If the cell is alive, but has more than three live neighbors, then it dies (death from starvation)
3. If the cell is alive, but has less than two live neighbors, it dies (death from loneliness)

In all other situations, the cell stays alive if it was alive, or stays dead if it was dead.

John Conway came up with some fascinating results using the Game of Life. There are several intitial conditions which results in surprising animated behaviors. By the end of the lab, you should be able to observe some of these behaviors.

## Getting Started

The lab09 repository provided has most of the code required to play the Game of Life, including a complete Swing GUI to demonstrate how things work. The implementation provided models the Game of Life with a two-dimensional array of Boolean values which are "true" if the cell is alive, and "false" if the cell is dead. The current state of the ```cells``` array is displayed on the screen, with dark-black "live" cells, and light grey "dead" cells.

The GraphDialogSetup class has a main method which will start the GUI. When you run this method, it actually creates two windows - a main window that is just a big grid, and a "Control" window which allows you to control the game.

The Control window has four buttons. The first is a *Setup* button. When pressed, this gives you some options to intializing the game. The *Step* button runs one turn of the game (but doesn't work yet.) The *Pause/Run* button allows you to toggle between "Pause" mode in whcih nothing happens, and "Run" mode, in which the game runs turn after turn automatically. The *Exit* button is obvous.

Before we can play the game, we have to implement the one missing piece of code... the code which calculates the next state of the game, given the currnt state.  This code is in the ```CellGrid``` class in the ```applyUpdate``` method. Your assignment is to write the code for applyUpdate, based on the rules outlined above.

One important thing to remember is that it is not valid to update the ```cells``` array until we know the neighbors of all the surrounding cells. The easiest way to resolve this problem is to create a local ```neighbors``` array that is the same size as the cells array, and has the number of neighbors for each row/column position.  Then, once the neighbors value is known, you can update ```cells```.

## Extra Credit

There are two text files in the repository, brain.txt, ltwgtspaceship.txt, that describe some other interesting initial conditions. Can you add these to the game? There are some hints in the addingbutton2selectionlist.txt file.

## Using Eclipse to commit your results

This should be getting familiar. Switch to the Git perspective, select "lab09", then click the "Refresh" icon and stage all your changes. Select the "Git Staging" tab, and make sure all your modified files are in the "Staged Changes" window. Type a commit message in the "Commit Message" sub-window. Then "Commit and Push...", get through the commit wizard and you will get a pop-up that tells you that the commit was succesful. Now, click on the "Git Reflog" tab, select the final commit, and right click to copy the commit ID. This is the commit hash code that can now be pasted into myCourses.

## Grading Criteria

This lab is worth 10 points. If your code does not compile, you will get an 8 point deduction. If your code gets a compiler warning, you will get a 2 point deduction. The CA's will run your lab09.GraphDialogSetup main function. If the main method does not do everything requested with correct results (we're only grading the basic function - not the enhancements), you will get up to a 5 point deduction, depending on the severity of the problem. No points will be added or subtracted for extra enhancements *UNLESS* these enhancements inhibit the basic function of the GUI.
