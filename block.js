var Block = function (x, y)/*When creating a new instance of the block class, you need to pass in the position you want it to have*/{
    this.x = x;
    this.y = y;
    var height, width = 30;
};

Block.prototype.draw = function (){
  c.fillstyle = "#000080" 
  c.fillRect(this.x,this.y,width,height)
};

