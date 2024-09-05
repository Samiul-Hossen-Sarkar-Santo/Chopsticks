# Chopsticks - A Traditional Hand Game

## Overview

**Chopsticks** is a traditional hand game usually played between two players. The goal is to outmaneuver your opponent using strategic hand movements, ensuring you're not left with both hands "out" or "eliminated." This is a console-based version of the game, and I built it as a personal project to practice Object-Oriented Programming (OOP) in Java. Although the idea is traditional, I've looked and a digital version of this game is not commonly available online. And I do have plans to develop a mobile version of the game In Sha Allah.

## Gameplay

1. **Turn-based**: Players take turns to perform moves.
2. **First Turn**: The first player is chosen randomly.
3. **Actions**: On a player's turn, they can:
    - **Attack**: Use one of their chopsticks to tap (touch) an opponent's chopstick. If the total count of a chopstick reaches 5, it is considered "out" or eliminated and cannot be used further.
    - **Split**: Distribute their total count across the opponent’s chopsticks (e.g., if a player has 5 fingers, they can split them into 3 and 2 across onto the both hands).

## Rules

- **Chopsticks Count**: Each chopstick can hold a maximum of 4 counts. If the total reaches 5, it is eliminated and represented by "0."
- **Winning Conditions**:
    1. A player loses if both their hands are eliminated (both hands have a count of 5 or are represented by "0").
    2. A player loses if they can neither attack nor split on their turn.

## Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/chopsticks-game.git
   ```

2. **Navigate to the project directory**:
   ```sh
   cd chopsticks-game
   ```

3. **Compile the Java files**:
   ```sh
   mkdir -p bin
   javac -d bin src/*.java
   ```

4. **Run the game**:
   ```sh
   java -cp bin Main
   ```

## Usage

- Run the `ChopSticksRunner` class to start the game.
- Follow on-screen instructions to play the game.
- Players alternate between attacking or splitting until one player wins by eliminating both of the opponent’s hands.

## Future Plans

The next step for this project is to develop a mobile version of the game. Currently, no mobile or web-based version of **Chopsticks** exists, making this an exciting opportunity to bring this traditional game to modern platforms. And well, I'm already learning Flutter with that plan on my mind!

## Development

This project was a personal initiative to strengthen my knowledge of Object-Oriented Programming (OOP) and Java. And I plan to expand this project into mobile app development.

Feel free to reach out for any questions or feedback about **Chopsticks**!
