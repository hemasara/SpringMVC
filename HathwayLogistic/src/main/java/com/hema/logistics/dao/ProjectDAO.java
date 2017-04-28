package com.hema.logistics.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hema.logistics.entities.ProjectEntity;

@Repository
public class ProjectDAO {
	
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public boolean saveProject(ProjectEntity project){
		Session s = sf.getCurrentSession();
		s.save(project);
		return true;
	}
	
	public boolean deleteProject (int projectId){
		Session s = sf.getCurrentSession();
		s.delete(projectId);
		return true;
	}
	
	public ProjectEntity getProject(){
		return null;
	}
	
	public List<ProjectEntity> getAllProjects(){
		return null;
	}

}
