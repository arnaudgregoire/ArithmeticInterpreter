package domain;

public class Main {

	public static void main(String[] args) {
		Lexer lexer = new Lexer("3+4*2+(6*3+2)+8"); 
		System.out.println("lexing...");
		lexer.lex();
		for (int i = 0; i < lexer.tokens.size(); i++) {
			System.out.println(lexer.tokens.get(i));
		}
		
		Parser parser = new Parser(lexer.tokens);
		System.out.println("parsing...");
		parser.parse();
		for (int i = 0; i < parser.tokensOrdered.size(); i++) {
			System.out.println(parser.tokensOrdered.get(i));
		}
		
		Computer computer = new Computer(parser.tokensOrdered);
		System.out.println("computing...");
		computer.compute();
		
		
		System.out.println("resultat :" + computer.resultat);

	}

}
