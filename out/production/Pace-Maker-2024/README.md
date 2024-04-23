
## USE CASE
This is the readme for my Olympus Surgical Technologies America (OSTA) Value Thunderbeat Type-S Production Beeper. The function is for it to be displayed on the screen near the production line, and updated at the sealer to reflect each unit sealed. 


## FUNCTION
It will have a variable countdown, which will depend on the inputted takt time, and increase a counted once it hits zero. After it hits zero, it will play a beep and restart. 

This function will continue to repeat until it is paused using a pause button. 

At the same time, there will be a counter function that is increased or decreased manually via either a button that is displayed on the screen, using the up and down arrow keys or using an external button that simulates an arrow up key.

The program will compare the value of completed / manually input units to the ideal number based on takt time. If the difference is more than 30, the smily face will turn to a frown and the icon will turn red. IF it is 15-29, the smily face will remain smiling, but turn yellow. If the difference is less than 15 including negative numbers, the smily face will be green. See the attached image.
![[Pasted image 20240419090757.png]]


## LIMITS:
There is no data reporting expected out of this tool. It is a visual aid for both the production operators to use to keep pace/ see where they stand and for engineers outside of the clean room to see how the line is running.

The original excel file was written by Kazuko Burnside, and has been used for years. The reason for the upgrade is that the old laptop drivers are not working and it is a good opportunity for me to learn python. 
