package Practice;

import org.testng.annotations.Test;

import com.backend.testing.A;

import static com.backend.testing.A.*;
//this functionality is available above jdk 1.5 version
//static import

public class Runner {
@Test
public void sampleTest() {
	//given();
//	when();

	//	then();
	A a1= new A();
	a1.a().b().c().d();;
	
	
}
}
