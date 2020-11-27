import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE; //necessario para encerrar o programa propriamente

public class Main {

	public static void main(String[] args) 
	{
		MainFrame frame = new MainFrame(); 
		//game.init();
		
		frame.setSize(1280,720);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int) (screenSize.getHeight()/2 - frame.getSize().getHeight()/2)); 
		frame.setResizable(false);
		frame.setTitle("Dungeon Crawler");
		frame.setVisible(true); 
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //encerra a execucao do programa ao fechar a janela
	}

}
