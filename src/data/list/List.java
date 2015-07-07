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

public class List<E> {
	public Node<E> head, tail, current;
	
	public List(){
		head = tail = current = null;
	}
	
	public List(E element){
		construct (element);
	}
	
	public void construct(E element){
		head = tail = current = new Node<E>(element);
	}
	
	public void append(E element){
		if (!isEmpty()){
			tail.setNext(new Node<E>(element));
			tail = tail.getNext();
		} else {
			construct (element);
		}
	}
	
	public void prepend(E element){
		if (!isEmpty()){
			head.setPrevious(new Node<E>(element));
			head = head.getPrevious();
		} else {
			construct (element);
		}
	}
	
	public void toFirst(){
		current = head;
	}
	
	public void toLast(){
		current = tail;
	}
	
	public boolean isFirst(){
		return current == head;
	}
	
	public boolean isLast(){
		return current == tail;
	}
	
	public void next(){
		if (current.getNext() != null){
			current = current.getNext();
		}
	}
	
	public void previous(){
		if (current.getPrevious() != null){
			current = current.getPrevious();
		}
	}
	
	public boolean isEmpty(){
		return head == null | tail == null | current == null;
	}
	
	public E current(){
		if (!isEmpty()){
			return current.getContent();
		} else {
			return null;
		}
	}
	
	public E first(){
		if (!isEmpty()){
			return head.getContent();
		} else {
			return null;
		}
	}
	
	public E last(){
		if (!isEmpty()){
			return tail.getContent();
		} else {
			return null;
		}
	}
	
	public E get(int index){
		if(!isEmpty()){
			E object;
			Node oldCurrent = current;
			jump(index);
			object = current();
			current = oldCurrent;
			return object;
		} else {
			return null;
		}
	}
	
	public int size(){
		if (!isEmpty()){
			int size = 0;
			Node<E> oldCurrent = current;
			for (toFirst();!isLast();next()){
				size++;
			}
			current = oldCurrent;
			return size;
		} else {
			return 0;
		}
	}
	
	public void jump(int index){
		if (!isEmpty()){
			toFirst();
			for (int i = 0; i <= index && !isLast(); i++){
				next();
			}
		}
	}
	
	public void jumpBy(int offset){
		if (!isEmpty()){
			for (int i = 0; i <= offset && !isLast(); i++){
				next();
			}
		}
	}
	
	public int getIndex(E element){
		if (!isEmpty()){
			int index = 0;
			Node<E> oldCurrent = current;
			if (element == null){
				for (toFirst();!isLast();next()){
					if (current() == null){
						current = oldCurrent;
						return index;
					}
					index++;
				}
			} else {
				for (toFirst();!isLast();next()){
					if (current().equals(element)){
						current = oldCurrent;
						return index;
					}
					index++;
				}
			}
			return -1;
		} else {
			return -1;
		}
	}
	
	public boolean contains(E element){
		return getIndex(element) != -1;
	}
}