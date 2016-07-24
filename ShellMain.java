package shell;

import javax.swing.JFrame;

public class ShellMain extends JFrame {
    public ShellWin win;
    public ShellMain()
    {
    	this.win=new ShellWin();
    	this.setTitle("∆¥Õº”Œœ∑");
    	this.setSize(500,500);
    	this.setVisible(true);
    	this.add(win);
    	this.setLocation(200, 100);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		new ShellMain();
	}

}
