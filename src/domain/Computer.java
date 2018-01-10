package domain;

import java.util.List;
import java.util.Stack;

public class Computer {
	public List<Token> tokensOrdered;
	public Stack<Token> result;
	public double resultat;

	public Computer(List<Token> tokensOrdered) {
		super();
		this.tokensOrdered = tokensOrdered;
		this.result = new Stack<Token>();
		this.resultat = 0;
	}
	
	public double compute() {

        for(int i = 0; i < tokensOrdered.size(); i++) {
        	System.out.println(this.result);
        	
            if(tokensOrdered.get(i).getType().equals(Token.TokenType.NUMBER)) {
            	this.result.push(tokensOrdered.get(i));
            }
            else {
                Token b = this.result.pop();
                Token a = this.result.pop();
                
                if(this.tokensOrdered.get(i).getValue().equals("+")) {
                	double sum = Double.parseDouble(a.getValue()) + Double.parseDouble(b.getValue());
                	String strSum = String.valueOf(sum);
                	this.result.push(new Token(Token.TokenType.NUMBER, strSum));
                }
                
                else if(this.tokensOrdered.get(i).getValue().equals("-")) {
                	double sum = Double.parseDouble(a.getValue()) - Double.parseDouble(b.getValue());
                	String strSum = String.valueOf(sum);
                	this.result.push(new Token(Token.TokenType.NUMBER, strSum));
                }
                
                else if(this.tokensOrdered.get(i).getValue().equals("*")) {
                	double sum = Double.parseDouble(a.getValue()) * Double.parseDouble(b.getValue());
                	String strSum = String.valueOf(sum);
                	this.result.push(new Token(Token.TokenType.NUMBER, strSum));
                }
                
                else if(this.tokensOrdered.get(i).getValue().equals("/")) {
                	double sum = Double.parseDouble(a.getValue()) / Double.parseDouble(b.getValue());
                	String strSum = String.valueOf(sum);
                	this.result.push(new Token(Token.TokenType.NUMBER, strSum));
                }
              
            }
        }
        this.resultat = Double.valueOf(this.result.peek().getValue());
        return this.resultat;
        
    }
}
	

