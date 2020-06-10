package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
	private E data;
	private BinarySearchTree<E> leftTree, rightTree;

	public BinarySearchTree(){
	}


	private  BinarySearchTree(E data){
		this.data = data;
	}

	public void printInOrder() {

		if (this.data!=null){
			if (leftTree!=null) leftTree.printInOrder();
			System.out.print(this.data + " ");
			if(rightTree!=null) rightTree.printInOrder();
		}
	}

	public boolean isEmpty(){
		return false;
	}

	public boolean loopup(E data){
		if ( data == null || this.data == null) return false;
		else {
			if (data.compareTo(this.data) == 0) return true;
			else if (data.compareTo(this.data) <  0){
				return (this.leftTree == null?false:leftTree.loopup(data));
			}
			else {
				return (this.rightTree == null? false: rightTree.loopup(data));
			}
		}
	}

	public boolean addNode(E data){
		if(data == null){
			return false;
		}else if(this.data ==null){
			this.data = data;
			return true;
		}else{
			if(this.data.compareTo(data) ==0){
				return false;
			}else if(data.compareTo(this.data) <0){
				if(leftTree == null){
					leftTree = new BinarySearchTree<E>(data);
				}else{
					leftTree.addNode(data);
				}
			}else{
				if(rightTree== null){
					rightTree = new BinarySearchTree<E>(data);
				}else{
					rightTree.addNode(data);
				}
			}
			return true;
		}
	}

	public int diepte(){
		int totaalLeft = 0;
		int totaalRight = 0;
		if(this.leftTree != null){
			totaalLeft += this.leftTree.diepte();
		}

		if(this.rightTree != null) {
			totaalRight += this.rightTree.diepte();
		}

		return Math.max(++totaalLeft, ++totaalRight);
	}

	public boolean isLeaf(){
		return (this.leftTree==null && this.rightTree==null);
	}

	public boolean removeNode(E data){
		if (data == null || this.data == null)
			return false;
		else if (data.compareTo(this.data) == 0){
			if (this.isLeaf()){
				this.data = null;
			}
			else if (this.leftTree != null){
				E grootsteLinks = leftTree.searchGreatest();
				this.data = grootsteLinks;
				this.leftTree.removeNode(grootsteLinks);
			}else{
				E kleinsteRechts  = rightTree.searchSmallest();
				this.data = kleinsteRechts = rightTree.searchSmallest();
				this.rightTree.removeNode(kleinsteRechts);
			}
			return true;
		} else if (data.compareTo(this.data) < 0){
			if(this.leftTree == null) return false;
			else return this.leftTree.removeNode(data);
		} else if (this.rightTree == null) return false;
		else return this.rightTree.removeNode(data);
	}

	public void ruimOp(){
		if (this.leftTree != null){
			if (this.leftTree.data == null){
				this.leftTree = null;
			}else {
				this.leftTree.ruimOp();
			}
		}
		if (this.rightTree != null){
			if (this.rightTree.data == null){
				this.rightTree = null;
			} else {
				this.rightTree.ruimOp();
			}
		}
	}
	public ArrayList<E> getPath(E waarde){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		ArrayList<E> pad = new ArrayList<>();
		pad.add(this.data);
		if (this.data.compareTo(waarde) == 0){
			return pad;
		} else {
			ArrayList<E> deelpad;
			if (this.data.compareTo(waarde) > 0){
				if (this.leftTree == null){
					return null;
				}
				deelpad = this.leftTree.getPath(waarde);
			}else{
				if (this.rightTree == null){
					return null;
				}
				deelpad = this.rightTree.getPath(waarde);
			}
			if (deelpad == null) return null;
			pad.addAll(deelpad);
			return pad;
		}
	}

	public E searchGreatest(){
		if (rightTree == null) return this.data;
		return rightTree.searchGreatest();
	}

	public E searchSmallest(){
		if (leftTree == null) return this.data;
		return leftTree.searchSmallest();
	}

	public int count(){
		/*
		if (leftTree != null) {
			return this.leftTree.count();
		}*/
		return 1;
	}
}