package com.mycompany.a3;

import java.util.Vector;

public class GameObjectCollection implements ICollection{  // Iterator design pattern
	private Vector<GameObject> gameObjects;
	
	public GameObjectCollection() {
		gameObjects = new Vector<GameObject>();
	}
	
	public void set(int index, GameObject gameObject) {
		gameObjects.set(index, gameObject);
	}
	
	public GameObject get(int index) {
		return gameObjects.get(index);
	}
	
	public void add(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public int size() {
		return gameObjects.size();
	}
	
	public void remove(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public IIterator getIterator() {
		return new GameObjectIterator();
	}
	
	private class GameObjectIterator implements IIterator {  // iterator for going through the objects in the collection
		private int index;
		
		public GameObjectIterator() {
			index = -1;
		}
		
		public boolean hasNext() {
			if(gameObjects.size() <= 0) {
				return false;
			}
			if(index == gameObjects.size() - 1) {
				index = -1;
				return false;
			}
			return true;
		}
		
		public GameObject getNext() {
			index++;
			return gameObjects.get(index);
		}
	}
}
