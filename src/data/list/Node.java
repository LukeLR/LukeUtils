/**
 * This file is part of LukeUtils.
 *
 * LukeUtils is free software: you can redistribute it and/or modify
 * it under the terms of the cc-by-nc-sa (Creative Commons Attribution-
 * NonCommercial-ShareAlike) as released by the Creative Commons
 * organisation, version 3.0.
 *
 * LukeUtils is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

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