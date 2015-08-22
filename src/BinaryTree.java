import java.util.Random;

public class BinaryTree {
	
	private int info;
	private BinaryTree L,R;
	private static int treeLength;
	private Random r;
	private int index =1;
	private int x,y,sir;
	private Draw draw;
	private static int nnodes;
	private static int leaves;
	
	public BinaryTree(int info, BinaryTree L, BinaryTree R) {
		// TODO Auto-generated constructor stub
		this.info = info;
		this.L = L;
		this.R = R;
				
	}
	
	public BinaryTree(int destinedLength, int maxLength) {
		r = new Random();
		treeLength = destinedLength;
		info = r.nextInt(maxLength)+1;
		if (treeLength > index) {
			L = new BinaryTree(this, maxLength);
			R = new BinaryTree(this, maxLength);
		}
		
	}
	
	private BinaryTree(BinaryTree tree, int maxLength) {
		r = new Random();		// v kazdom constructori treba konstruktnut novy random inak to hadze nullPointerException lebo on sa vytvori vlastne pre kazdy objekt, ale pamat to nezatazuje pretoze ked sa prestane pouzivat ho automaticky znici garbage collector  
		info = r.nextInt(maxLength)+1;
		if (tree.index + 1 < treeLength) {
			this.index = tree.index + 1;
			L = new BinaryTree(this, maxLength);
			R = new BinaryTree(this, maxLength);
		}
		
	}
	
	public void preOrder() {
		System.out.print(String.valueOf(info));
		if (L != null) L.preOrder();
		if (R != null) R.preOrder();
		
	}
	
	public void inOrder() {
		if (L != null) L.inOrder();
		System.out.print(String.valueOf(info));
		if (R != null) R.inOrder();
		
	}
	
	public void postOrder() {
		if (L != null) L.postOrder();
		if (R != null) R.postOrder();
		System.out.print(String.valueOf(info));
	}
	
	public int getIndex() {
		return index;
	}
	

	public void draw(Draw draw, int x, int y, int sir) {
		this.x = x;
		this.y = y;
		this.sir = sir;
		this.draw = draw;
		draw.drawAgain();
		
				
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSir() {
		return sir;
	}
	
	public BinaryTree getL() {
		return L;		
	}
	
	public BinaryTree getR() {
		return R;
	}
	
	public Draw getDraw() {
		return draw;
	}
	
	private void countNodes() {
		nnodes++;
		if (L==null || R==null) leaves++;
		if (L!=null){
			L.countNodes();
		}
		if (R!=null) {
			R.countNodes();		
		}
	}
	
	public int getNofNodes() {
		if (nnodes==0) countNodes();
		return nnodes;
		
	}
	
	public int getLeafs() {
		if (leaves==0) countNodes();
		return leaves;
		
	}
	
	public int getDepth() {
		return treeLength;
	}
	
	
}
