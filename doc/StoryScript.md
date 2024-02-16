# Customize Story using StoryScript

## Introduction
Story Script File Extension: `.sc`

This file serves as the narrative backbone for the game. It defines various rooms, their descriptions, and possible player choices within those rooms. The script sets the stage for the game's plot and guides the player through different scenarios. Each room is associated with a unique identifier and contains a description and a set of options for the player to choose from.

## Usage
Room Definition:
```
room [roomName]
    description "[Room Description]"
    options
        [option1] "[Option 1 Description]"
        [option2] "[Option 2 Description]"
```
        

Example:
```
room start
    description "You find yourself at the entrance of a mysterious cave."
    options
        go_inside "Enter the cave."
```
