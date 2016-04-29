# Bingo

##Client-Server Protocol 
Server --> Client

The Bingo Client is multi-threaded. When a client is connect to the socket,  Server sends a "WELCOME" message. Server waits for more than two players to signup. There is no maximum amount of players. After one minute, the game starts. Dealer creates boards for each player. Then generates "drawings" that correspond to spaces on a board in the Json format
{"column" : "I", "number" : 18}. When a player get's bingo, server sends a message to the winner stating that they won and a losing message to the loser. 

Client --> Server 

User is presented with a gui that shows their board and the drawing that is being announced. The client returns an onclick listener which is parsed into a Json response with this format {"column": "B", "Row": 2, "number": 5} changes the state of the space to being marked.  If the player believes they have bingo, they can declare "Bingo" and then win the game if they didn't cheat.  

## Internal Protocol 
Dealer 
* distributes cards or boards to each player 
* broadcasts each drawing 
* when a player declares bingo, they review the marked spaces of the alleged winner to confirm they have bingo 

Player 
* clicks on one space during each drawing 
* declares bingo when there are 5 marked spaces in a row 


## Game Rules 
A Bingo board contains 25 spaces with 1 free space
The spaces have a unique id which is an int from 1 to 75
The player/ client is assigned 24 random spaces that are all unmarked
There are at least 2 players
BingoServer distributes the spaces, saves the spaces into cards and displays them randomly 1 by 1
if the player has the spaces specified by the card, mark that space.

Bingo is achieved:
horizontally: 5 cards of the same row number
vertically:  5 cards of the same column letter
diagonally: [column, row]: {[0, 0] [1, 1] [2, 2] [3,3] [4,4]} or
                           {[0, 4] [1, 3] [2, 2] [3, 1] [4,0]}

The numbers in the B column are between 1 and 15, in the I column between 16 and 30, in the N column
(containing four numbers and the free space) between 31 and 45, in the G column between 46 and 60, and
in the O column between 61 and 75.


