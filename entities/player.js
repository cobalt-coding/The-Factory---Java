//Insert player code
var Player = function() {
	this.x = 20;
	this.y = 20;
	this.width = 20;
	this.height = 20;
	
	this.velX = 0;
	this.velY = 0;
	this.falling = true;
};

Player.prototype.draw = function() {
	c.fillStyle = "#000000"
	c.fillRect(this.x, this.y, this.width, this.height);
}

Player.prototype.update = function() {
	
	if (keys["ArrowLeft"]) {
		this.velX -= 0.5;
	}
	
	if (keys["ArrowRight"]) {
        this.velX+=0.5;
    }
	
	if (keys["ArrowUp"]) {
		this.velY-=8;
	}
	this.falling = true;
	
	this.velY+=0.3;
    
    this.x+=this.velX;
    this.collide(this.velX, 0);
    this.y+=this.velY;
    this.collide(0, this.velY);
	
	this.velX /= 1.1;
	
}

Player.prototype.collide = function(velX, velY) {
	//Insert code when block class is complete
}
