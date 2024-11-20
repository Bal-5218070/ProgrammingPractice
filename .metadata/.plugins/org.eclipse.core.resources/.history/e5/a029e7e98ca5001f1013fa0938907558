package jacksonSerailization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
	value = {"createdBy",//class project{
		              	//      String ProjectName;
                          	//String CreatedBy;
                       	//String Status;
	                //int teamSize;
			"projectName",//
			"teamsize",
			"status"
	
})
@JsonIgnoreProperties(
		value = {
				"teamSize"// i dont want to expose team size
		},allowSetters = true//this is mandatory
		)
//let me create one java class ist
class Project{//POJO class [Plain old java Object]//the businessclass whatever you create during 
	//serialization is called pojo class in java
	private String projectName;
	@JsonProperty(value ="created By")
	private String createdBy;//if we want create space in json file  then we will pass data in 
	//@json property annotation in value
	private int teamSize;
	private String status;
	//make sure create one empty constructor that is required for deserailaization
	private Project() {}
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;//i should be able to see this complete information in
		//the form of json file before running this program ,i should provide getters and setters method because
		//by taking help of setter method,it will write the data back to json file
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
		
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the teamSize
	 */
	public int getTeamSize() {
		return teamSize;
	}
	/**
	 * @param teamSize the teamSize to set
	 */
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

public class Run1_JacksonSerTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project pobj = new Project("Orange", "Deepak", 0, "Created");// java object
		// i am planning to convert this java object into json file
		ObjectMapper objm = new ObjectMapper();
		objm.writeValue(new File("./project.json"), pobj);// 1st argument is location of file where you want to create
															// json file
		// java.io.file (file related all mehtod come from io package)
		System.out.println("==========End============");
	}
}
