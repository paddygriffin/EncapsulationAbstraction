package ie.gmit.sw;

public class VernamCypher implements Cypherable, CypherKey {

	private CypherKey key;
	
	
	public VernamCypher(CypherKey key) {
		super();
		this.key = key;
	}
	public String encrypt(String plainText) throws CypherException{
		return new String (encrypt(plainText.getBytes()));

	}
	public byte[] encrypt(byte[] plainText) throws CypherException{
		
		for (int i = 0; i < plainText.length; i++) {
			plainText[i] = (byte) (plainText[i] ^ key.getKey().charAt(i));//i assigned the value a byte, only works if the key is the same length as cyphertext
		}
		
		return plainText;
		
	}
	
	public String decrypt(String cypherText) throws CypherException {
		return new String (decrypt(cypherText.getBytes()));
		
	}
	
	public byte[] decrypt(byte[] cypherText) throws CypherException{
		for (int i = 0; i < cypherText.length; i++) {
			cypherText[i] = (byte) (cypherText[i]  ^ key.getKey().charAt(i));//i assigned the value a byte, 
		}
		
		return cypherText;
		
	}
	
	public void setKey(String key) throws CypherException {
		this.key.setKey(key);
	}
	public String getKey() {
		return key.getKey();
	}
	

}
