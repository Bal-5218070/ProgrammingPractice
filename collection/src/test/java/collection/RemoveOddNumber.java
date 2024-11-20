package collection;
import java.util.*;
public class RemoveOddNumber {
public static void main(String[] args) {
	Collection c1= new ArrayList();
	c1.add(27);
	c1.add(37);
	c1.add(67);
	c1.add(97);
	c1.add(100);
	Iterator itr = c1.iterator();
	while(itr.hasNext()) {
		Object k = itr.next();
		 Integer intvalue =(Integer) k;
		 if(intvalue%2==1) {
			 itr.remove();
		 }
	}
	System.out.println(c1);
}
}
