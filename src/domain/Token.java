package domain;

public class Token {
	
	public enum TokenType {
		  LEFTBRACKET,
		  RIGHTBRACKET,
		  NUMBER,
		  OperateurMULTI,
		  OperateurPLUS,
		}
	
	private TokenType type;
	private String value;
	
	public Token(TokenType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public TokenType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", value=" + value + "]";
	}
	
}
