//Setting up canvas for editing
var canvas = document.getElementById("ctx");
var c = canvas.getContext("2d");
//Current frame
var cFrame = 0;
//Array to handle keyboard events
var keys = [];
//Current scene of the game as opposed to menu, help screen, etc
var scene = "game";

//Array to handle multiple sounds at once
var sounds = [];

//To prevent cluttering of the draw function, game handling will go here.
var Game = function() {
	//Variables for the game
	
};

Game.prototype.interact = function() {
	//Handling the game
	
}

//Initializing a new instance of the game object
var game = new Game();

//Initialize the draw function
function init() {
	window.requestAnimationFrame(draw);
}

//Running the init code
init();

//Draw function
function draw() {
	switch(scene) {
		case "game":
			game.interact();
	}
	//Up the frame, every frame
	cFrame++;
	window.requestAnimationFrame(draw);
}

//Handle key events.
window.addEventListener("keydown", function(e) {
    keys[e.key] = true;
	e.preventDefault();
});

window.addEventListener("keyup", function(e) {
    keys[e.key] = false;
	e.preventDefault();
});
