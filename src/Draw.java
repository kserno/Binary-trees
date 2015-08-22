import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Draw extends JPanel{
	
	private static int r = 5;
	private BinaryTree tree;
	
	public Draw(BinaryTree tree) {
		this.tree = tree;
	}
	
	public void drawAgain() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0,140 ,255));
		if (tree!= null) {
			drawTree(tree,g,tree.getX(),tree.getY(), tree.getSir());			
		}
		
	}

	private void drawTree(BinaryTree tree,Graphics g,int x, int y , int sir) {
		// TODO Auto-generated method stub
		g.drawOval(x - r, y - r, r*2, r*2);
		if (tree.getL()!=null) g.drawLine(x , y, x - sir/2, y+30);
		if (tree.getR()!=null) g.drawLine(x , y, x + sir/2, y+30);
		if (tree.getL()!=null) drawTree(tree.getL(),g,x - sir /2, y+30, sir/2);	
		if (tree.getR()!=null) drawTree(tree.getR(),g,x + sir /2, y+30, sir/2);
		
	}


}
