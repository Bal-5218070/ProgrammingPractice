package collection;
import java.util.*;
public class Program2 {
public static void main(String[] args) {
	Collection c1 = new ArrayList<>();
	c1.add(40);
	c1.add(60);
	c1.add(100);
	int sum=0;
	for(Object o1:c1) {
		sum=sum+ (Integer)	o1;
	}
	System.out.println(sum); 
}
}
