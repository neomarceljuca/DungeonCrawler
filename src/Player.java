import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player 
{
	int x;
	int y;
	int width;
	int height;
	GamePanel panel; //a referencia do GamePanel eh util para o acesso do Panel pelo objeto player
	
	double xspeed;
	double yspeed;
	
	Rectangle hitBox;
	
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	
	public Player(int x, int y, GamePanel panel) 
	{
		this.panel = panel;
		this.x = x;
		this.y = y;
	
		width = 10;
		height = 10;
		hitBox = new Rectangle(x,y,width,height);
	}
	
	public void set() //chamado pelo gameloop timer em GamePanel
	{
		if(keyLeft) 
		{
			xspeed = -3;
		}
		else if(keyRight) 
		{
			xspeed = 3;
		}
		else 
		{
			if(Math.abs(xspeed) >= 0.5) 
			{
				xspeed *= 0.85;
			} else 
			{
				xspeed = 0;
			}
			
		}
		
		if(keyDown) 
		{
			yspeed = 3;
		}
		else if(keyUp) 
		{
			yspeed = -3;
		}
		else 
		{
			if(Math.abs(yspeed) >= 0.5) 
			{
				yspeed *= 0.85;
			} else 
			{
				yspeed = 0;
			}
		}
		
		
		
		x += xspeed;
		y += yspeed;
		
		hitBox.x = x;
		hitBox.y = y;
	}
	
	public void draw(Graphics2D gtd) 
	{
		gtd.setColor(Color.BLACK);
		gtd.fillRect(x,y,width,height);
	}
	
	
	
}
