package practiceSerailization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

class Run2_Deserializationtest {
public static void main(String[] args) throws Throwable {
	FileInputStream input =new FileInputStream("./f.txt");
	ObjectInputStream object =new ObjectInputStream(input);
	NFSGame userobj = (NFSGame)object.readObject();
	
	System.out.println(userobj.name);
	System.out.println(userobj.level);
	System.out.println(userobj.score);
	System.out.println(userobj.life);
}
}

 
