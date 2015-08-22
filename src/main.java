import java.awt.Color;
import java.awt.Composite;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class main implements ActionListener {
	
	BinaryTree Tree;
	Draw draw;
	JFrame treeFrame, frame;
	
	main() {
		frame = new JFrame("Binary Trees");
		frame.setSize(350, 500 ) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		treeFrame = new JFrame("Binary Tree");
		treeFrame.setSize(800, 500);
		treeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		treeFrame.setVisible(false);
		
		JButton preOrder = new JButton("Preorder");
		JButton postOrder = new JButton("Postorder");
		JButton inOrder = new JButton("Inorder");
		JButton drawButton = new JButton("Draw");
		JButton countNodes = new JButton("Number of Nodes");
		JButton countLeaves = new JButton("Number of Leaves");
		JButton depth = new JButton("Depth");
		
		preOrder.addActionListener(this);
		postOrder.addActionListener(this);
		inOrder.addActionListener(this);
		drawButton.addActionListener(this);
		countNodes.addActionListener(this);
		countLeaves.addActionListener(this);
		depth.addActionListener(this);
		
		
		
		Tree = new BinaryTree(6,5);
		draw = new Draw(Tree);
		
		frame.add(preOrder);
		frame.add(inOrder);
		frame.add(postOrder);
		frame.add(drawButton);
		frame.add(countNodes);
		frame.add(countLeaves);
		frame.add(depth);
	
		treeFrame.add(draw);
				
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new main();
				
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case "Preorder":  
			Tree.preOrder();
			System.out.println();
		break;
		case "Inorder":  
			Tree.inOrder();
			System.out.println();
		break;
		case "Postorder":
			Tree.postOrder();
			System.out.println();
		break;
		case "Draw":
			Tree.draw(draw, treeFrame.getWidth()/2 , 10, treeFrame.getWidth()/2);
			treeFrame.setVisible(true);
		break;
		case "Number of Nodes":
			System.out.println(Tree.getNofNodes());
		break;
		case "Depth":
			System.out.println(Tree.getDepth());
		break;
		case "Number of Leaves":
			System.out.println(Tree.getLeafs());
		break;
		}
		
	}

}
