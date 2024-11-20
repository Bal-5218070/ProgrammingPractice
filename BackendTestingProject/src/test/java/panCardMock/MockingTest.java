package panCardMock;

import org.mockito.Mockito;

// inside this class i am plannig to develope mock
class PANCard{
	public  String isValid(String panCard) {
		//pancardSchemas
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")==true) {
			return "is valid pancard";
		}
		else {
			return "is not valid pancard";
		}
	}
	public static PANCard getMockObject() {
		PANCard mocObject = Mockito.mock(PANCard.class);// i am going to specify which class  you are planning to do a mocking 
		//solution and it is going to return the same class object
		//this method is going to return same class object
		// if youu plan to develope dummy pancard number there is class called mockito
		Mockito.when(mocObject.isValid("ABCDE9855J")).thenReturn("valid panCard");
		Mockito.when(mocObject.isValid("ABCDZ9155J")).thenReturn("valid panCard");
		Mockito.when(mocObject.isValid("ABCDE985J")).thenReturn("invalid panCard");
		return mocObject;
	}
}



public class MockingTest {
public static void main(String[] args) {
	//System.out.println(PANCard.isValid("ABCDE1234A"));
	PANCard Obj=PANCard.getMockObject();
	// let me put validation here
	System.out.println(Obj.isValid("ABCDE9855J"));
}
}
