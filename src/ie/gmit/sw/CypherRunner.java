package ie.gmit.sw;

public class CypherRunner {

	public static void main(String[] args) throws Throwable {
		CypherKey ck = new CaesarCypher().new CypherKeyImpl(); //bad practice 
		Cypherable cc = new CaesarCypher(ck);
		cc.setKey("7");
		
		
		System.out.println("------CaesarCypher----------");
		String s = cc.encrypt("OBJECT ORIENTED PROGRAMMING");
		System.out.println("Enc:" + s);
		System.out.println("Dec:" + cc.decrypt(s));
		
		//polymorphism
		cc = new VernamCypher(new CypherKey() {
			private String key;
			
			
			
			@Override
			public void setKey(String key) throws CypherException {
				// TODO Auto-generated method stub
				this.key = key;
				
			}
			
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return this.key;
			}
		}
		);
		cc.setKey("THE QUICK BRON FOX JUMPED OVER THE LAZY DOGS");
		System.out.println("------vernom Cypher----------");
		s = cc.encrypt("SOFTWARE DEVELOPMENT");
		System.out.println("Enc:" + s);
		System.out.println("Dec:" + cc.decrypt(s));

	}

}
