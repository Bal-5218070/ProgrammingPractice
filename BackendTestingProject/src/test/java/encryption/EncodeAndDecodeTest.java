package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecodeTest {
@Test
public void sampleTest() {
	

//String encodedData  = new String (Base64.getEncoder().encode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
//System.out.println(encodedData);

String DecodedData  = new String (Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
System.out.println(DecodedData);

}
}