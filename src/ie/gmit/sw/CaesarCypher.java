package ie.gmit.sw;

public class CaesarCypher {
	
	public int key;

	public String encrypt(String plainText) throws CypherException{
		return new String (encrypt(plainText.getBytes()));

	}
	public byte[] encrypt(byte[] plainText) throws CypherException{
		
		for (int i = 0; i < plainText.length; i++) {
			plainText[i] = (byte) (plainText[i] + key);//i assigned the value a byte, 
		}
		
		return plainText;
		
	}
	
	public String decrypt(String cypherText) throws CypherException {
		return new String (decrypt(cypherText.getBytes()));
		
	}
	
	public byte[] decrypt(byte[] cypherText) throws CypherException{
		for (int i = 0; i < cypherText.length; i++) {
			cypherText[i] = (byte) (cypherText[i] - key);//i assigned the value a byte, 
		}
		
		return cypherText;
		
	}
	@Override
	protected void finalize() throws Throwable {
		//out of scope before garbage collected
		System.out.println("caesarCypher ("+ this +") is about to be GC'D"); // Garbage Collected
	}

}
