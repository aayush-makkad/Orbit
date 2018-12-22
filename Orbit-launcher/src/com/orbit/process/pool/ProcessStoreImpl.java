package com.orbit.process.pool;

import java.util.ArrayList;

public class ProcessStoreImpl implements ProcessStore{

	@Override
	public void addProcess(int _processnumber) {
		poolList.add(_processnumber);
	}

	@Override
	public ArrayList<Integer> getpool() {
		
		return poolList;
	}

	@Override
	public boolean removeTop() {
		
		try {
		poolList.remove(0);
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}

	@Override
	public int getTopInstruction() {
		
		return poolList.get(0);
	}
	
	

	
	
	
}
