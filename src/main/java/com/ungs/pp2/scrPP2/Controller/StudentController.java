package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.View.StudentView;

public class StudentController {
	   private StudentDto model;
	   private StudentView view;

	   public StudentController(StudentDto model, StudentView view){
	      this.model = model;
	      this.view = view;
	   }

	   public void setStudentName(String name){
	      model.setName(name);		
	   }

	   public String getStudentName(){
	      return model.getName();		
	   }

	   public void setStudentRollNo(String rollNo){
	      model.setRollNo(rollNo);		
	   }

	   public String getStudentRollNo(){
	      return model.getRollNo();		
	   }

	   public void updateView(){				
	      view.printStudentDetails(model.getName(), model.getRollNo());
	   }	
	}
