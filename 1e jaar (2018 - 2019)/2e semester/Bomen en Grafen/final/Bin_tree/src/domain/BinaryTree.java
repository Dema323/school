package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){//eerst current data, daarna die in de linker boom en daarna rechter boom
        System.out.print(this.data + " ");
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();
	}


	public void printInorder(){//eerst linker boom, daarna current data en daarna rechter boom
	    if (this.leftTree != null) this.leftTree.printInorder();
        System.out.print(this.data + " ");
	    if (this.rightTree != null) this.rightTree.printPreorder();
    }

    public void printPostorder(){//eerst linker boom, daarna rechter boom en daarna current data
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();
        System.out.print(this.data + " ");
    }

    public int aantalknopen(){
	    int totaal = 0;
        if (this.leftTree != null){//check linker kant van de boom
            totaal += this.leftTree.aantalknopen();
        }
        if (this.rightTree != null){//check rechter kant van de boom
            totaal += this.rightTree.aantalknopen();
        }
        return ++totaal;//check root van de boom
    }

    public int diepte(){
	    int maxdieptelinks = 0;
	    if (this.leftTree != null){//check diepte van de linker boom
	        maxdieptelinks += this.leftTree.diepte();
        }
        int maxdiepterechts = 0;
	    if (this.rightTree != null){//check diepte van de rechter boom
	        maxdiepterechts += this.rightTree.diepte();
        }
        return Math.max(++maxdieptelinks, ++maxdiepterechts);//bepaal maximale diepte van links of rechts + de root van de boom
    }

    public boolean isleaf(){return (this.leftTree == null && this.rightTree == null);}//checkt of het een leaf is (geen kinderen)

    public int kindersom(){
	    int total;
	    if (this.data % 5 == 0){

        }
	    return total;
    }

}