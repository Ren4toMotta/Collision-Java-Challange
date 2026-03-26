# Cap 07 — Collision Detection

Java Swing project featuring two selectable players that move through a 2D scenario with collision detection against walls and screen boundaries.

## Features

- Two players with different shapes (circle and rectangle)
- Click to select a player and change its color
- WASD movement for the selected player
- Collision detection against static obstacles
- Collision detection against screen boundaries
- ESC key to exit the application

## Controls

| Key | Action |
|-----|--------|
| W | Move up |
| A | Move left |
| S | Move down |
| D | Move right |
| Mouse click (player) | Select player |
| ESC | Exit |

## Project Structure
```
src/AULA/DESAFIO_01/
├── Principal.java   # Application entry point
├── moldura.java     # Main window (JFrame)
├── painel.java      # Game panel with mouse and keyboard events
├── player.java      # Player entity with movement and collision
└── obstaculos.java  # Static obstacles in the scenario
```

## How it Works

- Players spawn at random positions on the panel
- Clicking on a player selects it and highlights it in yellow
- The selected player moves with WASD at 5px per step
- `verifColisoesMuro()` moves the player, checks for intersection with each obstacle and reverts the position if a collision is detected
- `verifColisaoCenario()` prevents the player from leaving the screen boundaries

## How to Run

1. Clone the repository
2. Open the project in Eclipse or any Java IDE
3. Run the `Principal.java` class inside the `AULA.DESAFIO_01` package

## Authors

Renato da Motta, Kendy Wakiyama, Gustavo Gabriel — 25/03/2026
