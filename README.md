# Poop Code Why

## Summary 

Our team's project is to take the implementation of a simple chess board, and modify it so the game instead follows two new rules.

1. Once selecting a piece, you must move it.

1. The moveset of each piece may not match its rank. (E.g. A pawn may look like a pawn but moves like a bishop.)

Additionally, based off of the starting code, we must implement the following logic, 

1. Identifying Checkmate and ending the game.

1. Starting the game as white.

1. Fixing the moveset of pawn, (allows perpendicular capture) 

Link to 1 min ad video: https://www.youtube.com/watch?v=5Mprv3HX-Mw

Link to Agile Video: https://www.youtube.com/watch?v=h4EcFGi0l5Q

## Team Member Journals:

* Chinmay Shukla: https://docs.google.com/document/d/1hJMsJwp5Xlyywy-onqwICOrtpbDtYrHZYfIUAjbDRoQ/edit?usp=sharing

* Muhammmed Mahmood: https://docs.google.com/document/d/1OIwvsKmLpW2Pc0GV55G3Gw_0hWcfRI1yykBY_kX0wZQ/edit?usp=sharing

* Parmeet Singh: https://docs.google.com/document/d/1mTYzsSg6dEoM-nRt_nIEjZhkx56JWAxNDi5SLKIIucs/edit#heading=h.5o2fqzsgwrzz

* Pratik Kasle:https://docs.google.com/document/d/1GwsSLKxkEtjYEYjZaAHFsPTI5SQPiBy5Arp-FFRsN5k/edit

## Architecture Diagrams:

### Starting Architecture Diagram

This is the design of the source code we started this project with.

![Old Diagram](/diagrams/old-design.png)

### New Architecture Diagram


![New Diagram](/diagrams/new-design.png)



## Key Feature Design:

* Muhammed Mahmood: The Key Feature I implemented was the random moveset of the pieces. Given the provided code, the instantiation of pieces on the board was placed inside the My_World class. Given the room for improvement, I decoupled the instantiation of pieces from the game world using a Factory pattern. This allowed the instantiation of random chess pieces and regular chess pieces to be easily swappable by creating a reference to a Factory type in my world and choosing either a RandomFactory or a RegularFactory. The RandomFactory utlized my teammate Chinmay's decoupling of the piece moveset into the Strategy pattern to easily swap the MoveStrategies of pieces.   

* Pratik Kasle: The Key Feature I implemented was the checkmate and check. I worked with parmeet on the checkmate. The checkmate feature uses observer design pattern. A checkmate oberver is  attached to every piece capture. The observer checks if the captured piece is a king than it ends and than endgame. The check feature used observer pattern. A observer is attached to every move. After every move it checks if king is on any possible legal position of all the pieces of opposite color.










