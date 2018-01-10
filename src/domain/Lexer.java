package domain;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
	
	private String expression;
	private String currentWord;
	private String currentChar;
	private int current;
	public List<Token> tokens;
	
	public Lexer(String expression) {
		super();
		this.expression = expression;
		this.currentChar = this.expression.substring(0, 1);
		this.currentWord="";
		this.current = 0;
		this.tokens = new ArrayList<Token>();
		
	}
	
	public void lex() {
		while(this.current<this.expression.length()) {
			if(isLeftBracket()) {
				consume();
				this.tokens.add(new Token(Token.TokenType.LEFTBRACKET,this.currentWord));
				this.currentWord = "";
			}
			if(isRightBracket()) {
				consume();
				this.tokens.add(new Token(Token.TokenType.RIGHTBRACKET,this.currentWord));
				this.currentWord = "";
			}
			else if (isNumber()) {
				consume();
				while(isNumber() && this.current < this.expression.length()-1) {
					consume();
				}
				this.tokens.add(new Token(Token.TokenType.NUMBER,this.currentWord));
				this.currentWord = "";
			}
			else if (isOperateurMulti()) {
				consume();
				this.tokens.add(new Token(Token.TokenType.OperateurMULTI,this.currentWord));
				this.currentWord = "";
			}
			else if (isOperateurPlus()) {
				consume();
				this.tokens.add(new Token(Token.TokenType.OperateurPLUS,this.currentWord));
				this.currentWord = "";
			}
		}
	}
	
	private boolean isLeftBracket() {
		return "(".contains(this.currentChar);
	}
	
	private boolean isRightBracket() {
		return ")".contains(this.currentChar);
	}
	
	private boolean isNumber() {
		return "0123456789.".contains(this.currentChar);
	}
	
	private boolean isOperateurMulti() {
		return "*/".contains(this.currentChar);
	}
	
	private boolean isOperateurPlus() {
		return "+-".contains(this.currentChar);
	}
	
	private void consume() {
		  try {
				this.currentWord += this.currentChar;
				this.current +=1;
				this.currentChar = this.expression.substring(this.current, this.current + 1);
			  }
		  catch (Exception e) {
			    System.out.println(e.getMessage());
			  }
	}
}
