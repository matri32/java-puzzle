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
    JButton startGame=new JButton("��ʼ");
    JButton stopGame=new JButton("ֹͣ");
    int[][] tus=new int[3][3];
    //��������
    int hh=0;
    int ll=0;//��������
    boolean sy=false;
    public ShellWin()
    {
    	this.addMouseListener(this);
        ����();
        ����();
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
					��ʾͼƬ(g,this,"img/tu"+tus[i][j]+".jpg",100+100*j,100+100*i);
				}			
			}
		}  
    	if(sy)
    	{
    		Ӯ(g);	
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
	void ���(int x,int y)
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
		���(e.getX(),e.getY());
		��();
		repaint();
		if(��Ӯ��())
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
    public void ����()
    {
    	int shu=1;
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				tus[i][j]=shu;
				shu++;
			}
		}
    }
    void ��ʾͼƬ(Graphics g,ShellWin win,String img_source,int x,int y)
    {
    	try {
			Image image=ImageIO.read(new File(img_source));
			g.drawImage(image, x, y, win);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    void ��()
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
    void Ӯ(Graphics g)
    {
    	sy=true;
    	g.drawString("��ϲ", 200, 200);
    }
    boolean ��Ӯ��()
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
    void ����()
    {
    	for (int i = 0; i < 10; i++) {
		   int t1=�����(0,2);
		   int t2=�����(0,2);
		   int t3=�����(0,2);
		   int t4=�����(0,2);
		   int temp=tus[t1][t2];
		   tus[t1][t2]=tus[t3][t4];
		   tus[t3][t4]=temp;
		}
    }
    int �����(int cong,int dao)
    {
       	return cong+(int)((dao-cong+1)*Math.random());
    }
}
