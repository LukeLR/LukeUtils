package data.list;

public class Node<E> {
	public Node<E> next, previous;
	public E element;
	
	public Node(E element){
		next = null;
		previous = null;
		this.element = element;
	}
	
	public Node(E element, Node<E> next, Node<E> previous){
		this.next = next;
		this.previous = previous;
		this.element = element;
	}
	
	public Node(E element, Node<E> next){
		this.next = next;
		previous = null;
		this.element = element;
	}
	
	public void setNext(Node<E> next){
		this.next = next;
	}
	
	public void setPrevious(Node<E> previous){
		this.previous = previous;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public Node<E> getPrevious(){
		return previous;
	}
	
	public E getContent(){
		return element;
	}
}