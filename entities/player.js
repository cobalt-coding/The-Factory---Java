//Insert player code
var Player = function() {
	this.x = 50;
	this.y = 50;
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
	
	if (keys["ArrowUp"] && !this.falling) {
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
	for (var i = 0 ; i < blocks[level].length ; i++) {
		if (rectCollide(this, blocks[level][i]) && (blocks[level][i].type === "n")) {
            if (velX > 0) {
                this.velX = 0;
                this.x = blocks[level][i].x-this.width;
            }
            if (velX < 0) {
                this.velX = 0;
                this.x = blocks[level][i].x+blocks[level][i].width;
            }
            if (velY > 0) {
                this.velY = 0;
                this.y = blocks[level][i].y-this.height;
				this.falling = false;
            }
            if (velY < 0) {
                this.velY = 0;
                this.y = blocks[level][i].y+blocks[level][i].height;
            	this.falling = true;
			}
			continue;
        }
	}
}
