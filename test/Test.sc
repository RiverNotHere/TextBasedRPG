# Demo Story

# Map designs
room start
    description "You find yourself at the entrance of a mysterious cave."
    options
        go_inside "Enter the cave."

room main_hall
    description "You enter a vast main hall with multiple paths leading in different directions."
    options
        go_left "Take the left path."
        go_right "Take the right path."
        go_forward "Continue forward."

room dark_corridor
    description "You find yourself in a dark corridor. Strange noises echo through the cave."
    options
        go_back "Go back to the main hall."
        go_forward "Continue through the dark corridor."

room treasure_room
    description "You discover a room filled with glittering treasures!"
    options
        take_treasure "Take the treasures and continue."
        leave_treasure "Leave the treasures and continue."

room enemy_encounter
    description "Suddenly, you encounter a fierce enemy blocking your path!"
    options
        fight_enemy "Engage in a battle."
        flee "Try to escape."

room exit
    description "You see a faint light at the end of the tunnel. The exit is within reach."
    options
        exit_cave "Exit the cave and complete your adventure."
