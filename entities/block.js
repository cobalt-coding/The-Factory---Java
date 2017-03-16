var Block = function (x, y, type){/*When creating a new instance of the block class, you need to pass in the position you want it to have*/
    this.x = x;
    this.y = y;
    this.type = type;//Available types include: Normal(N), Temp(T), and Spike(S).  For type, just enter the initial of the type of block you want.
    switch(type){
        case "N":
          var image = "https://cdn.discordapp.com/attachments/219666140098461696/291741990830473216/Metal_BlockNormal.png";
          break;
        case "T":
          var image =""; 
    }
};

Block.prototype.draw = function (){
  c.drawImage(image, 0, 0, 32, 32, x, x, 32, 32);
};
