# Beat Maker Project

## Proposal

I plan to program a drum-beat maker which is simple and fun to use. 
The user can select a few *attributes* that they want the beat to have, such as:

- genre
- tempo
- stressed beats


And then the beat will be generated according to different models that are preset in the code.
To make the programming and generation easier, I have imported a MIDI library called Jfugue from http://www.jfugue.org/index.html. This library allows the programmer
to program beats using strings and concise settings. 

The targeted audience will be users looking to play around with beats of different genres without a great deal of background knowledge in music.

This project is interesting because I find that beats, due to their varying nature, can be generated relatively easily, without following a complex model.

Since I also play the drumset, I am also interested in learning more about beats and improve my knowledge in a different way.

## User Story

- As a user, I want to be able to view all the created beats in a list.
- As a user, I want to be able to play all the beats in the collection.
- As a user, I want to have an interface which allows me to create new beats.
- As a user, I want to modify the genre of a beat during its creation.
- As a user, I want to view and modify the stressed parts during creation of beat.
- As a user, I want to select the tempo during creation.
- As a user, I want to save my beats to a json file when I select quit.
- As a user, I want to load my beats from json file during startup.

## Instructions for Grader

- You can click on create beats or view beats in the homepage menu.
- For creating beats, you will need to give the beat a name, set a genre and a tempo.
- You will be taken to the "set stressed beats" section if you check the checkbox. There you can select which beat will be stressed in each bar.
- At the "view beats" page, you can play and delete beats. *There might be a 5-10 second delay for playing the beat, which I think is due to a problem between the java sound system and the library I used.*
- My audio component is playing the beat, and my visual components are the pictures I used in the menus.
- The program automatically loads from the state file at startup.
- The program saves the state if the "Quit" button at the homepage is pressed.


## Phase 4: Task 2

- Test & Design Robust Class

In the `Reader` class of the `persistance` package, I have implemented the constructor `Reader()` and
the method `ReadFile()` with checked expressions, catching the IOException and the JsonException that might be thrown from the input processing.

I have also tested the class making use of the appropriate rules about testing exceptions, inside the `ReaderTest` class inside the `persistance` package in the test folder.

- Type Hierarchy

I utilized an abstract class, `BeatModel`, to encapsulate some of the common behavior that is required in the individual style models, `JazzModel`, `RockModel`, `HipHopModel` and `ElectronicModel`.

They share common methods such as `getTopLayer`, which gets the first layer of beats inside the model, so that the `Beat` constructor can modify the first layer of beats and make a new beat. 


## Phase 4: Task 3

- Cohesion Problem 

Inside the original `GUI` class inside the `ui` package, I encapsulated a JFrame inside the GUI class, and directly performed actions on the JFrame.

This violates the overall cohesion because looking back, I have now used GUI as a "manager" for initializing, processing and retreiving information from my Pages(which extend JPanel). 
It would be bad design to include a JFrame class directly as a field inside`GUI` as well. 

In order to maintain cohesive code, I decided to refactor out the `JFrame myFrame` field into an encapsulating class `MyFrame`, and have GUI access it through public methods. 

Now the code is more readable and the design  is more complete.

- Coupling Problem 

Also for the `GUI` class inside the `ui` package, I noticed that there is coupling between the way I am handling the actions from the individual JPanels.

I am passing all the information collected from the JPanel back to the GUI class through methods invoked by the individual Page Classes. To make sure the GUI
knows what is being passed in, I used keywords such as "next", "quit", "back", .., and hardcoded them in my program.

I realized that this creates a coupling problem -- if I want to make a change to the commands that are sent or alter the behavior of the GUI class, I would have to make changes in both `GUI` and the `Page` classes.
This can easily cause problems and bugs.

Thus I decided to fix the issue by creating a public map called `command` inside  `GUI`, which maps the command we want to send to the actual string that is recognized by the methods.
This way both the `GUI` and the `Page` classes can reference the same map and thus they will use the same string every time. This reduces coupling and makes the code more readable and easier to modify.
