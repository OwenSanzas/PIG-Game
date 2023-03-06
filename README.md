# Pig Game
Made by Ze Sheng


## All Source Files:
### Controller File 
* GameControl.java

### Player File
* Human.java

### AI File
* Computer.java

### Unit Test Files
* ComputerTest.java
* GameControlTest.java

## Progress
* ✓ - Finished
* O - In progess
* ? - Have problem
* blank - Not started

Section | State
:----: |:----:
Basic Logic |   ✓
Construct Human| ✓
Construct Computer | ✓
All Functions Test | ✓
Corner cases check | ✓
Upgrade AI | ✓

## Overview of work accomplished
* This is a simple dices game called PIG.
* ````
    -----------------------------------------
    Game Description:
    -----------------------------------------
    Pig is a very simple game. Two players take turns; on each turn, a player rolls a six-sided die
    ("die" is the singular of "dice") as many times as she wishes, or until she rolls a 6. Each number
    she rolls, except a 6, is added to her score this turn; but if she rolls a 6, her score for this turn is
    zero, and her turn ends. At the end of each turn, the score for that turn is added to the player's
    total score. The first player to reach or exceed 50 wins.
    
    -----------------------------------------
    Game Demo:
    -----------------------------------------
    ● Alice rolls 3, 5, 3, 1, and stops. Her score is now 12.
    ● Bob rolls 5, 4, 1, 1, 2, and stops. His score is now 13.
    ● Alice rolls 5, 3, 3, 5, 4, and stops. Her score is now 32 (12 + 20).
    ● Bob rolls 4, 6. He has to stop, and his score is still 13 (13 + 0).
    ● etc.
    ````
## Challenges
* The logic of this game is not very hard. However, how to make computer cleverer is a big problem. Here I tried to give computer a good strategy. For example, when computer gets more than 12 score, it won't roll again since this is a fair enough score.
    
