package practiceSerailization;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

   
class Project1 {

  
   String projectname;

   
   String projectStatus;

   
   int teamSize;

   
   List<String> teamMember;

  
   ProjectManager projectManager;


    public Project1(String projectname, String projectStatus, int teamSize, List<String> teamMember,
		ProjectManager projectManager) {
	super();
	this.projectname = projectname;
	this.projectStatus = projectStatus;
	this.teamSize = teamSize;
	this.teamMember = teamMember;
	this.projectManager = projectManager;
}
	public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
    public String getProjectname() {
        return projectname;
    }
    
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
    public String getProjectStatus() {
        return projectStatus;
    }
    
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    public int getTeamSize() {
        return teamSize;
    }
    
    public void setTeamMember(List<String> teamMember) {
        this.teamMember = teamMember;
    }
    public List<String> getTeamMember() {
        return teamMember;
    }
    
    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
    public ProjectManager getProjectManager() {
        return projectManager;
    }
    
}


 class ProjectManager {

  
   String name;

   
   String empID;


   
	public ProjectManager(String name, String empID) {
	super();
	this.name = name;
	this.empID = empID;
}
	public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    public String getEmpID() {
        return empID;
    }
    
}



public class Run3_POJO {
public static void main(String[] args) throws Throwable, DatabindException, IOException {
	List<String> lit=new ArrayList<String>();
	lit.add("Jhon");
	lit.add("devid");
	lit.add("Stev");
	ProjectManager pm =new ProjectManager("sagar", "tp01");
	Project1 projectobj =new Project1("Deepak", "created", 10,lit , pm);
	//now i want to access the data available there
	//System.out.println(projectobj.projectname);
	
	ObjectMapper objm =new ObjectMapper();
	objm.writeValue(new File("./project1.json"), projectobj);
	
	//serailaization
	
}
}
