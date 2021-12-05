# Poop Code Why

## Summary 

Our team's project is to take the implementation of a simple chess board, and modify it so the game instead follows two new rules.

1. Once selecting a piece, you must move it.

1. The moveset of each piece may not match its rank. (E.g. A pawn may look like a pawn but moves like a bishop.)

Additionally, based off of the starting code, we must implement the following logic, 

1. Identifying Checkmate and ending the game.
2. Identifying Check. Make King transparent on check.
3. Implement Random chess.
4. Starting the game as white.
5. Fixing the moveset of pawn, (allows perpendicular capture) 

Link to 1 min ad video: https://www.youtube.com/watch?v=5Mprv3HX-Mw

Link to Agile Video: https://www.youtube.com/watch?v=h4EcFGi0l5Q

Link to Demo :https://youtu.be/Li0dghR3p4I

Link to Scrum Task Sheet: https://docs.google.com/spreadsheets/d/16X595I1W2CUnZ0AWi9XeW3bKKq2QJ96TZxYEfOSBH2E/edit?usp=sharing

## Team Member Journals:

* Chinmay Shukla: https://docs.google.com/document/d/1hJMsJwp5Xlyywy-onqwICOrtpbDtYrHZYfIUAjbDRoQ/edit?usp=sharing

* Muhammmed Mahmood: https://docs.google.com/document/d/1OIwvsKmLpW2Pc0GV55G3Gw_0hWcfRI1yykBY_kX0wZQ/edit?usp=sharing

* Parmeet Singh: https://docs.google.com/document/d/1mTYzsSg6dEoM-nRt_nIEjZhkx56JWAxNDi5SLKIIucs/edit#heading=h.5o2fqzsgwrzz

* Pratik Kasle: https://docs.google.com/document/d/1GwsSLKxkEtjYEYjZaAHFsPTI5SQPiBy5Arp-FFRsN5k/edit?usp=sharing

## Architecture Diagrams:

### Starting Architecture Diagram

This is the design of the source code we started this project with.

![Old Diagram](/diagrams/old-design.png)

### New Architecture Diagram


![New Diagram](https://user-images.githubusercontent.com/89881906/144729744-41212a56-3820-4dca-8fb3-bc4a89f6d968.png)




## Key Feature Design:

* Muhammed Mahmood: The Key Feature I implemented was the random moveset of the pieces. Given the provided code, the instantiation of pieces on the board was placed inside the My_World class. Given the room for improvement, I decoupled the instantiation of pieces from the game world using a Factory pattern. This allowed the instantiation of random chess pieces and regular chess pieces to be easily swappable by creating a reference to a Factory type in my world and choosing either a RandomFactory or a RegularFactory. The RandomFactory utlized my teammate Chinmay's decoupling of the piece moveset into the Strategy pattern to easily swap the MoveStrategies of pieces.   

* Pratik Kasle: The Key Feature I implemented was the checkmate and check. I worked with parmeet on the checkmate. The checkmate feature uses observer design pattern.The checkmate was implemented with Observer and State design pattern. A checkmate oberver is attched in piece capture. The observer checks if the captured piece is a king than it changes the game state to BlackWon/WhiteWon State depending on who wins. The check feature used observer pattern. A observer is attached to every move. After every move board notifies check observer. All the legal allowed position of all the pieces of the opposite color are stored in an list.  Check observer verifies if king is on any of these positions in the list. If the king is on the position it is a check. The check feature also covers discovered checks. 
On check the king become transparent to notify the user that its a check.

* Parmeet Singh: I implemented the end game feature (checkmate) for the game. With the source code our group chose to expand on, the game continued despite capturing the king, until all pieces on the board were cleared. In order to solve that, I implemented a state-observer design patterns combination. In this approach, the board has 3 states (normal, blackCheckmate, whiteCheckmate), and the board is a subject along with an observer to observe the checkmate. Upon a checkmate, the observer changes the state of the board to the appropriate state (blackCheckmate/whiteCheckmate) depending on who wins the game.

* Chinmay Shukla: I implemented the Strategy patterns that segregated the moveset of the piece from the pieces. Initially, the source code had hardcoded the movement of the pieces. In order to make it easier to implement a key part of our project, it was important that my teammates had the ability to easily assign the moveset of certain piece to any random piece. To solve this predicament I used a strategy pattern in which I made a class IMoveStrategy which was implemented by an abstract class MoveStrategy. The methods of this abstract class were implemented by the respective piece movement strategy. For instance, the moveset of the queen was implemented by QueenStratedy, rook had RookStrategy, Knight had KnightStrategy, and so on. So we can easily select a MoveStrategy(with currStrategy object) with a variable object(of RookStrategy,QueenStratey,BishopStrategy,KnightStrategy,PawnStrategy and KingStrategy) so the piece will implement that particular moveset.












