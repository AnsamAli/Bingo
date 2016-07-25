# Bingo#

##Purpose ##
This project is a gui representation of a bingo game using a server with multiple clients. The purpose was to gain a better understanding of sockets in java and client-server protocols

##Running the Code ##
`git clone https://github.com/tkadima/Bingo.git`

to run server run `./server`
to connect a client run `./client localhost 9001`


## Code Overview ##
###Client-Server Protocol ###
Server --> Client

Server waits for more than two players to signup. There is no maximum amount of players. After one minute, the game starts. Dealer creates boards for each player. Then generates "drawings" that correspond to spaces on a board in the string format "I9"  When a player get's bingo, server sends a message to the winner stating that they won and a losing message to the remaining players. 

Client --> Server 

User is presented with a gui that shows their board and the drawing that is being announced. The client returns an onclick listener which is parsed into a response with the space new Space(0, 2, 5, true).This changes the state of the space to being marked.  If the player believes they have bingo, they can declare "Bingo" and then wins the game if they didn't cheat.  

### Internal Protocol ###
Dealer 
* distributes cards or boards to each player 
* broadcasts each drawing 
* when a player declares bingo, they review the marked spaces of the alleged winner to confirm they have bingo 

Player 
* clicks on one space during each drawing 
* declares bingo when there are 5 marked spaces in a row 

BoardGui 
* displays the players board and the drawings 
* user-interface allows the 

### Game Rules ###
A Bingo board contains 25 spaces with 1 free space.
The spaces have a unique id which is an int from 1 to 75
The player/client is assigned 24 random spaces that are all unmarked
There are at least 2 players
BingoServer distributes the spaces, saves the spaces into cards and displays them randomly 1 by 1

The numbers in the **B** column are between 1 and 15,

in the **I** column between 16 and 30,

in the **N** column between 31 and 45 plus a free space in the second row,

in the **G** column between 46 and 60, and

in the **O** column between 61 and 75.

if the player has the spaces specified by the card, mark that space.

Bingo is achieved:
horizontally: 5 cards of the same row number
vertically:  5 cards of the same column letter
diagonally: [column, row]: {[0, 0] [1, 1] [2, 2] [3,3] [4,4]} or
                           {[0, 4] [1, 3] [2, 2] [3, 1] [4,0]}

Cheating occurs if the user marks a space that was not drawn or declares bingo when they do not have it. 
Cheaters are removed from the game. 


