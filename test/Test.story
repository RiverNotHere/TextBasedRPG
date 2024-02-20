# Demo Story

# Map designs
room start
    description "You find yourself at the entrance of a mysterious cave."
    options
        enter "Enter the cave."

room main_hall
    description "You enter a vast main hall with multiple paths leading in different directions."
    options
        north "Take the north path."
        south "Take the south path."
        east "Take the east path."
        west "Take the west path."

room dark_corridor
    description "You find yourself in a dark corridor. Strange noises echo through the cave."
    options
        north "Continue north through the dark corridor."
        south "Go back to the main hall."

room treasure_room
    description "You discover a room filled with glittering treasures!"
    options
        take_treasure "Take the treasures and continue."
        leave_treasure "Leave the treasures and continue."

room enemy_encounter
    description "Suddenly, you encounter a fierce enemy blocking your path!"
    options
        engage_enemy "Engage in a battle."
        flee "Try to escape."

room exit
    description "You see a faint light at the end of the tunnel. The exit is within reach."
    options
        exit "Exit the cave and complete your adventure."

# Map Connections
map "test.map"

start
    enter -> main_hall
main_hall
    north -> dark_corridor
    south -> treasure_room
    east -> enemy_encounter
    west -> exit
dark_corridor
    north -> treasure_room
    south -> main_hall
treasure_room
    back -> main_hall
enemy_encounter
    back -> main_hall
    east -> exit
exit
    back -> main_hall
