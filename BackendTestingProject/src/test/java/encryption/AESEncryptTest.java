package encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;

public class AESEncryptTest {
@Test
public void sampleTest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	String privateKey ="Ac03tEam@j!tu_#1";
	String data ="deepak";
	EnryptAnddecryptUtility ed = new  EnryptAnddecryptUtility();
	
			System.out.println(ed.encrypt(data, privateKey));
			
			
			
		System.out.println(	ed.decrypt("75mZ2BXSq4ztBd+mA0xuyg==", privateKey));
}
}
