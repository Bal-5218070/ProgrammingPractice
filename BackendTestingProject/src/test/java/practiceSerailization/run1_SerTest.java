        package practiceSerailization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 class NFSGame implements Serializable {
	String name;
	int level;
	long score;
	int life;

	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}

}
 public class run1_SerTest{
	public static void main(String[] args) throws Throwable {
		NFSGame user1Obj =new NFSGame("deepak", 120, 50000, 1);
		FileOutputStream fileout =new FileOutputStream("./f.txt");
		ObjectOutputStream object = new ObjectOutputStream(fileout);
		object.writeObject(user1Obj);
		System.out.println("====End=====");
	}

	
}
 //serialization