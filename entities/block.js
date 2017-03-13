var Block = function (x, y, width, height)/*When creating a new instance of the block class, you need to pass in the position you want it to have*/{
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
};

Block.prototype.draw = function () {
  c.fillstyle = "#000080" //navy blue
  c.fillRect(this.x,this.y,this.width,this.height)
};
