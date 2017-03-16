var Block = function (x, y, width, height, type) {
    this.x = x;
    this.y = y;
	this.width = width;
	this.height = height;
    this.type = type;
};

Block.prototype.draw = function (){
	switch(this.type) {
		case "n":
			c.fillStyle = "rgb(10, 10, 10)";
			c.fillRect(this.x, this.y, this.width, this.height);
			break;
	}
};
