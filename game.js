
			//Electron stuff
			{
				const electron = require("electron");
				const {app, BrowserWindow} = electron;
				app.on('ready', () => {
					let win = new BrowserWindow({width:716, height: 520, resizable: false, title: "The Factory"});
					win.setMenuBarVisibility(false);
					win.loadURL(`file://${__dirname}/index.html`);
				})
			}