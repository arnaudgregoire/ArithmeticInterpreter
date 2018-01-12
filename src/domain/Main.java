package domain;

public class Main {

	public static void main(String[] args) {
		
		// on transforme la chaine de caractère en tokens
		Lexer lexer = new Lexer("3+4*2+(6*3+2)+8+(10)+5"); 
		System.out.println("lexing...");
		lexer.lex();
		for (int i = 0; i < lexer.tokens.size(); i++) {
			System.out.println(lexer.tokens.get(i));
		}
		
		// on parse les tokens pour les réordonner, supprimer les parenthèses
		// et mettre correctement les opérateurs
		
		Parser parser = new Parser(lexer.tokens);
		System.out.println("parsing...");
		parser.parse();
		for (int i = 0; i < parser.tokensOrdered.size(); i++) {
			System.out.println(parser.tokensOrdered.get(i));
		}
		
		// On parcout notre liste ordonnée de tokens
		Computer computer = new Computer(parser.tokensOrdered);
		System.out.println("computing...");
		computer.compute();
		
		
		System.out.println("resultat :" + computer.resultat);

	}

}
