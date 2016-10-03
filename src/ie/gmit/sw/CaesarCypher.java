package ie.gmit.sw;

public class CaesarCypher implements CypherKey, Cypherable {
	//was refactored as the key was not protected, refactoring changes structure not behaviour
	private CypherKey key;
	
	

	public CaesarCypher(CypherKey key) {
		super();
		this.key = key;
	}
	public CaesarCypher() {
		super();
		
	}
	public String encrypt(String plainText) throws CypherException{
		return new String (encrypt(plainText.getBytes()));

	}
	public byte[] encrypt(byte[] plainText) throws CypherException{
		
		for (int i = 0; i < plainText.length; i++) {
			plainText[i] = (byte) (plainText[i] + Integer.parseInt(key.getKey()));//i assigned the value a byte, 
		}
		
		return plainText;
		
	}
	
	public String decrypt(String cypherText) throws CypherException {
		return new String (decrypt(cypherText.getBytes()));
		
	}
	
	public byte[] decrypt(byte[] cypherText) throws CypherException{
		for (int i = 0; i < cypherText.length; i++) {
			cypherText[i] = (byte) (cypherText[i] -  Integer.parseInt(key.getKey()));//i assigned the value a byte, 
		}
		
		return cypherText;
		
	}
	@Override
	protected void finalize() throws Throwable {
		//out of scope before garbage collected
		System.out.println("caesarCypher ("+ this +") is about to be GC'D"); // Garbage Collected
	}
	
	
	public class CypherKeyImpl implements CypherKey{
		private int keyText;
		
		public void setKey(String key) throws CypherException {
			this.keyText = Integer.parseInt(key);
			
		}

		
		public String getKey() {
			return new String("" + keyText);
		}
		
	}


	public void setKey(String key) throws CypherException {
		this.key.setKey(key);
	}
	public String getKey() {
		return key.getKey();
	}
	
	
	

}
