package jacksonSerailization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run3_jackson_deserialization {
public static void main(String[] args) throws Throwable, DatabindException, IOException {
	ObjectMapper objm =new ObjectMapper();
	Project pobj = objm.readValue(new File("./project.json"), Project.class);//name of the pojo class
	System.out.println(pobj.getProjectName());
	System.out.println(pobj.getCreatedBy());
	System.out.println(pobj.getTeamSize());
	System.out.println(pobj.getStatus());
	
	}
}
