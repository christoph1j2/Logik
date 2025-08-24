# Logik - Mastermind Game

A simple Mastermind puzzle game built with Java and JavaFX.

## What is it?

This is a digital version of the classic Mastermind board game. You try to guess a secret sequence of 5 colors within 10 attempts. After each guess, you get feedback to help you narrow down the solution.

## Features

- Click circles to cycle through 8 different colors
- Get feedback after each guess (black = right color & position, white = right color wrong position)  
- 10 attempts to crack the code
- Reset button to start over
- Show/hide solution button

## Tech Stack

- Java 9+
- JavaFX 17.0.6  
- Maven for build management

## How to Run

1. Make sure you have Java 9+ installed
2. Clone this repo
3. Run: `mvn clean javafx:run`

Or use the Maven wrapper:
```bash
# Windows
.\mvnw.cmd clean javafx:run

# Mac/Linux  
./mvnw clean javafx:run
```

## How to Play

1. The computer picks a secret sequence of 5 colors
2. Click the circles at the bottom to choose your colors  
3. Click "Guess" to submit your attempt
4. Look at the feedback:
   - Black circles = right color in right position
   - White circles = right color but wrong position
5. Use the clues to make better guesses
6. Win by getting all 5 colors in the right spots!

Available colors: Red, Green, Blue, Yellow, Purple, Cyan, Orange, Pink

## Project Structure

Simple MVC setup:
- `Main.java` - starts the app
- `LogikController.java` - handles UI events  
- `LogikModel.java` - game logic
- `Colors.java` - color options
- `GameView.fxml` - UI layout

That's it! Just a fun little puzzle game to practice Java/JavaFX.
