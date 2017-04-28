package com.hema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.logistics.dao.ProjectDAO;
import com.hema.logistics.entities.ProjectEntity;
import com.hema.logistics.model.Logistics;
import com.hema.logistics.model.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectDAO pdao;
	
	public boolean saveProject(Project project){
		ProjectEntity pe = new ProjectEntity();
			pe.setProjectId(project.getProjectId());
			pe.setProjectName(project.getProjectName());
			pe.setProjectOwner(project.getProjectOwner());
			pe.setProjectDuration(project.getProjectDuration());
			pe.setProjectCost(project.getProjectCost());
			
		pdao.saveProject(pe);
		
		return true;
	}
	
	public boolean deleteProject (int projectId){
		return true;
	}
	
	public Project getProject(){
		return null;
	}
	
	public List<Project> getAllProjects(){
		return null;
	}

	
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
