package ie.gmit.sw;

public class CypherRunner {

	public static void main(String[] args) throws Throwable {
		CaesarCypher cc = new CaesarCypher();
		cc.key = 7;
		
		
		System.out.println("------CaesarCypher----------");
		String s = cc.encrypt("OBJECT ORIENTED PROGRAMMING");
		System.out.println("Enc:" + s);
		System.out.println("Dec:" + cc.decrypt(s));


	}

}
