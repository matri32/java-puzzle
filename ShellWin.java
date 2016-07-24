package shell;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ShellWin extends JPanel implements ActionListener,MouseListener {
    JButton startGame=new JButton("开始");
    JButton stopGame=new JButton("停止");
    int[][] tus=new int[3][3];
    //存鼠标的行
    int hh=0;
    int ll=0;//存鼠标的列
    boolean sy=false;
    public ShellWin()
    {
    	this.addMouseListener(this);
        放数();
        打乱();
       this.add(startGame);this.add(stopGame);
       
    }
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawRect(100,100, 300, 300);
    	for (int i = 0; i<3; i++) {
			for (int j = 0; j < 3; j++) {
				if(tus[i][j]!=9)
				{
					显示图片(g,this,"img/tu"+tus[i][j]+".jpg",100+100*j,100+100*i);
				}			
			}
		}  
    	if(sy)
    	{
    		赢(g);	
    	}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startGame)
		{
		   this.repaint();
		   this.requestFocus();
		}
	}
	void 点击(int x,int y)
	{
		hh=y/100-1;
		ll=x/100-1;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(sy)
		{
		   return;  	
		}
		点击(e.getX(),e.getY());
		换();
		repaint();
		if(能赢吗())
		{
		    System.out.println("yes");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    public void 放数()
    {
    	int shu=1;
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				tus[i][j]=shu;
				shu++;
			}
		}
    }
    void 显示图片(Graphics g,ShellWin win,String img_source,int x,int y)
    {
    	try {
			Image image=ImageIO.read(new File(img_source));
			g.drawImage(image, x, y, win);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    void 换()
    {
    	if(hh!=0&&tus[hh-1][ll]==9)
    	{
    	   	tus[hh-1][ll]=tus[hh][ll];
    	   	tus[hh][ll]=9;
    	}
    	else if(hh!=2&&tus[hh+1][ll]==9)
    	{
    		tus[hh+1][ll]=tus[hh][ll];
    		tus[hh][ll]=9;
    	}
    	else if(ll!=0&&tus[hh][ll-1]==9)
    	{
    		tus[hh][ll-1]=tus[hh][ll];
    		tus[hh][ll]=9;
    	}
    	else if(ll!=2&&tus[hh][ll+1]==9)
    	{
    		tus[hh][ll+1]=tus[hh][ll];
    		tus[hh][ll]=9;
    	}
    }
    void 赢(Graphics g)
    {
    	sy=true;
    	g.drawString("恭喜", 200, 200);
    }
    boolean 能赢吗()
    {
    	int shu=1;
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			    if(shu!=tus[i][j])
			    {
			       return false;	
			    }
			    shu++;
			}
		}
    	sy=true;
    	return true;
    }
    void 打乱()
    {
    	for (int i = 0; i < 10; i++) {
		   int t1=随机数(0,2);
		   int t2=随机数(0,2);
		   int t3=随机数(0,2);
		   int t4=随机数(0,2);
		   int temp=tus[t1][t2];
		   tus[t1][t2]=tus[t3][t4];
		   tus[t3][t4]=temp;
		}
    }
    int 随机数(int cong,int dao)
    {
       	return cong+(int)((dao-cong+1)*Math.random());
    }
}
