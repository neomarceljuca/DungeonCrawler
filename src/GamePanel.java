import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
//import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener
{
	Player player;
	
	Timer gameTimer;
	
	int mapX = 10; int mapY = 10; int mapTileSize = 64;
	int map[] = 
		{
				1,1,1,1,1,1,1,1,1,1,
				1,0,0,0,1,0,0,0,0,1,
				1,0,0,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,0,0,1,
				1,0,0,0,1,0,0,0,0,1,
				1,0,0,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,0,1,
				1,0,0,0,0,0,0,1,0,1,
				1,1,1,1,1,1,1,1,1,1
		};
	
	ArrayList<Wall> walls = new ArrayList<>();
	
	
	public GamePanel() 
	{
		player = new Player(400,300, this);
		
		makeWalls();
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() //base do gameloop
		{

			@Override
			public void run() {
	
				player.set();
				repaint();
			}
						
		}, 0, 17); //17milisegundos no timer para aproximadamente 60fps
		
	}
	
	public void makeWalls() 
	{
		for(int i =0 ; i < mapX ; i ++) 	
		{
			for(int j =0; j < mapY ; j ++) 
			{
				if(map[j*10 + i] == 1 ) walls.add(new Wall(i * mapTileSize, j * mapTileSize , mapTileSize, mapTileSize));			
			}
		}
	}
	
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		Graphics2D gtd = (Graphics2D) g;
		
		player.draw(gtd);
		
		for(Wall wall: walls) wall.draw(gtd);
	}
	


	void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = true;
		if(e.getKeyChar() == 'w') player.keyUp = true;
		if(e.getKeyChar() == 'd') player.keyRight = true;
		if(e.getKeyChar() == 's') player.keyDown = true;
	}


	void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = false;
		if(e.getKeyChar() == 'w') player.keyUp = false;
		if(e.getKeyChar() == 'd') player.keyRight = false;
		if(e.getKeyChar() == 's') player.keyDown = false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	}
	
}
