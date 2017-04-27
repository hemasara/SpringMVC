package com.hema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hema.logistics.model.Logistics;

@Service
public class ProjectService {

	
	List<Logistics> logisticCollection = new ArrayList<Logistics>();
	
	public List<Logistics> getLogisticCollection() {
		return logisticCollection;
	}

	public ProjectService() {		
		Logistics l1 = new Logistics(101, "Hathway", 101.1f);
		Logistics l2 = new Logistics(102, "Amazon", 102.1f);
		Logistics l3 = new Logistics(103, "Fireway", 103.1f);
		
		logisticCollection.add(l1);
		logisticCollection.add(l2);
		logisticCollection.add(l3);
	}	
	
}
