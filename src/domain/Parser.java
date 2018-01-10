package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
	public List<Token> tokens;
	public List<Token> tokensOrdered;
	
	public Parser(List<Token> tokens) {
		super();
		this.tokens = tokens;
		this.tokensOrdered = new ArrayList<>();
	}
	
	private int prio(Token token) {
		if(token.getType().equals(Token.TokenType.OperateurPLUS)) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public void parse(){
		Stack<Token> stack = new Stack<Token>();
		for (int i = 0; i < tokens.size(); i++) {
			//System.out.println("step" + i);
			for (int j = 0; j < tokensOrdered.size(); j++) {
				//System.out.println(tokensOrdered.get(j));
			}
			//Si c'est un op�rande, le placer sur le fichier de sortie
			if(tokens.get(i).getType().equals(Token.TokenType.NUMBER)) {
				tokensOrdered.add(tokens.get(i));
			}
			// Si c'est une parenth�se ouvrante, la mettre sur la pile
			else if(tokens.get(i).getType().equals(Token.TokenType.LEFTBRACKET)) {
				stack.push(tokens.get(i));
			}
			
			//Si c'est une parenth�se fermante, enlever les op�rateurs de la pile 
			//et les placer sur le fichier de sortie jusqu'� ce que l'on rencontre 
			//la parenth�se ouvrante, que l'on �limine.
			else if(tokens.get(i).getType().equals(Token.TokenType.RIGHTBRACKET)) {
				
				while(!stack.peek().getType().equals(Token.TokenType.LEFTBRACKET)) {
						tokensOrdered.add(stack.pop());
					}
				stack.pop();

			}
			
			//Si c'est un op�rateur, alors
			else if(tokens.get(i).getType().equals(Token.TokenType.OperateurMULTI) || 
					tokens.get(i).getType().equals(Token.TokenType.OperateurPLUS)) {
				
				//Si la pile est vide, pousser l'op�rateur sur la pile
				if(stack.empty()) {
					stack.push(tokens.get(i));
				}
				
				//Si le sommet de la pile est une parenth�se ouvrante, pousser l'op�rateur sur la pile
				else if(stack.peek().getType().equals(Token.TokenType.LEFTBRACKET)) {
					stack.push(tokens.get(i));
				}
				
				//Si l'op�rateur est prioritaire sur celui au sommet de la pile, pousser l'op�rateur sur la pile
				else if( prio(tokens.get(i)) >= prio(stack.peek())) {
					stack.push(tokens.get(i));
				}
				
				//Sinon, enlever l'op�rateur de la pile et le mettre sur le fichier de sortie. 
				else if( prio(tokens.get(i)) < prio(stack.peek())) {
					while(stack.peek().getType().equals(Token.TokenType.OperateurMULTI)) {
						tokensOrdered.add(stack.pop());
						if(stack.empty()) {
							break;
						}
					}
					
						//Replacer ensuite l'op�rateur courant sur la pile
						stack.push(tokens.get(i));
				}
			}
		}
		while(!stack.empty()) {
			tokensOrdered.add(stack.pop());
		}
	}
}
