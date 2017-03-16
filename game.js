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

//Useful functions
{
	//Define a random function
	function random(min, max) {
		var w = max-min;
		return Math.random()*w+min;	
	}

	//Function for checking if object a is colliding with object b if and when objects a and b are anchored to the top right corner.
	function rectCollide(a, b) {
		return a.x+a.width > b.x && a.y+a.height > b.y && a.x < b.x+b.width && a.y < b.y+b.height;    
	}

	//Function for checking if object a is colliding with object b if and when object a is anchored to the top right corner, and object b is anchored to the center of itself.
	function cornerCenter(a, b) {
		return a.x+a.width > b.x-b.width/2 && a.y+a.height > b.y-b.height/2 && a.x < b.x+b.width/2 && a.y < b.y+b.height/2;
	}

	//Function for drawing triangles.
	function triangle(x1, y1, x2, y2, x3, y3) {
		c.beginPath();
		c.moveTo(x1, y1);
		c.lineTo(x2, y2);
		c.lineTo(x3, y3);
		c.fill();
	}

	function dist(x1, y1, x2, y2) {
		return Math.sqrt( Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2) );
	}
}

var level = 0;
var levels = [
	[
		"............................",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		".                          .",
		"............................"
	]
];
var blocks = [];

for (var i = 0 ; i < levels.length ; i++) {
	//Adds empty arrays to arrays filled with entities to seperate entities by level.
	blocks.push([]);
	//Loop through the rows of the strings.
	for (var t = 0 ; t < levels[i].length ; t++) {
		//Loop through the individual characters in the strings.
		for (var j = 0 ; j < levels[i][t].length ; j++) {
			//A switch statement based off the character of the current string.
			switch(levels[i][t][j]) {
				case ".":
					blocks[i].push(new Block(j*30, t*30, 31, 31, "n"));
					break;
			}
		}   
	}
}

var bob = new Player();

//To prevent cluttering of the draw function, game handling will go here.
var Game = function() {
	//Variables for the game
	
	
};

Game.prototype.interact = function() {
	//Handling the game
	
	c.fillStyle = "#ffffff";
	c.fillRect(0, 0, 700, 500);
	
	for (var i = 0 ; i < blocks[level].length ; i++) {
		blocks[level][i].draw();
	}
	
	bob.draw();
	bob.update();
	
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
