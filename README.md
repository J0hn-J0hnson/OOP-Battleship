# OOP-Battleship

Battleship is a strategy type guessing game for two players. It is played on ruled grids  on which each player's fleet of warships are marked. The locations of the fleets are concealed from the other player. Players alternate turns calling "shots" at the other player's ships, and the objective of the game is to destroy the opposing player's fleet.

The game is played on four grids, two for each player. Individual squares in the grid are identified by letter and number. On one grid the player arranges ships and records the shots by the opponent. On the other grid, the player records their own shots <- only own shots are shown during the game, shots by the opponenent are handled in the background. 

Before play begins, each player secretly arranges their ships on their primary grid. Each ship occupies a number of consecutive squares on the grid, arranged either horizontally or vertically. The number of squares for each ship is determined by the type of ship. The ships cannot overlap (i.e., only one ship can occupy any given square in the grid). The types and numbers of ships allowed are the same for each player.

![image](https://user-images.githubusercontent.com/91310490/224898536-a04be499-32c7-4bda-bc95-02d13cb2e1f7.png)

After the ships have been positioned, the game proceeds in a series of rounds. In each round, each player takes a turn to announce a target square in the opponent's grid which is to be shot at. The opponent announces whether or not the square is occupied by a ship. If it is a "hit", the player who is hit marks this on their own or "ocean" grid (handled in the background). The attacking player marks the hit or miss on their own "tracking" or "target" grid, in order to build up a picture of the opponent's fleet.

When all of the squares of a ship have been hit, the ship's owner announces the sinking of the Carrier, Submarine, Cruiser/Destroyer/Patrol Boat, or the titular Battleship. If all of a player's ships have been sunk, the game is over and their opponent wins. If all ships of both players are sunk by the end of the round, the game is a draw.

Preview:
Shown below, the initial interface. Player 1 first inserts the locations of his ships into the program by writing their locations in the following format [A-J][0-9] -> [A-j][0-9] exmaple: A0 A4, the inclusive distance between the two coordinates must be the same as the size of the ship ex: Carrier size = 5 | distance from A0 A4 = 5.


![image](https://user-images.githubusercontent.com/91310490/224932133-692f0a31-94ad-430f-8e0b-843ddf5b15ee.png)

player 2's turn


![image](https://user-images.githubusercontent.com/91310490/225036923-09b51e3e-cdf5-4230-9d07-ea1fbc7deef7.png)


victory screen in a game with only 1 ship.




![image](https://user-images.githubusercontent.com/91310490/224933306-f475b7ab-34df-4d99-8e29-ab38c7b78234.png)




Next players take turns inputting a coordinate [A-J][0-9] that they wish to attack, if it misses / hits / sinks a ship the system will send an announcement

![image](https://user-images.githubusercontent.com/91310490/224934674-4c3fb697-06b5-4d3c-a969-0bbc1b1bce97.png)

![image](https://user-images.githubusercontent.com/91310490/224934943-65402a63-347c-4674-9bf6-4f26c2b97c9b.png)

