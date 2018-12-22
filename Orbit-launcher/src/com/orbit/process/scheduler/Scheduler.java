package com.orbit.process.scheduler;

import java.util.Timer;

import com.orbit.process.pool.ProcessStoreImpl;

public class Scheduler {
	
	
	int FLUSH_DELAY_TIME = 1100; //1.1 seconds
	
	
	
	static boolean  semaphoreToken = true;
	ProcessStoreImpl psi = new ProcessStoreImpl();
	private volatile int processId = -1;;
	
	public Scheduler() {
		for(int i=0;i<psi.getpool().size();i++) {
	if(semaphoreToken) {
		semaphoreToken = false;	

		processId = psi.getTopInstruction();
		try {
		// To Do add code to write to port
		
		psi.removeTop();
		}catch(Exception e) {
			continue;
		}
		semaphoreToken = true;
		
	}	
}
	}

}
