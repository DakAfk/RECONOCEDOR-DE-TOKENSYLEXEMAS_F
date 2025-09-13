package Modelo;

public class Token {
    // Constantes de tipo de token
    public static final int PACKAGE      = 1;
    public static final int IMPORT       = 2;
    public static final int FUNC         = 3;
    public static final int ASSIGN       = 4;
    public static final int PLUS         = 5;
    public static final int MINUS        = 6;
    public static final int MULT         = 7;
    public static final int DIV          = 8;
    public static final int IDENTIFIER   = 9;
    public static final int INT_LITERAL  = 10;
    public static final int LPAREN       = 11;
    public static final int RPAREN       = 12;
    public static final int LBRACE       = 13;
    public static final int RBRACE       = 14;
    public static final int SEMICOLON    = 15;
    public static final int QUOTE        = 16;

    private int type;
    private String lexeme;

    public Token(int type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public int getType() { return type; }
    public String getLexeme() { return lexeme; }

    @Override
    public String toString() {
        return "Token{type=" + type + ", lexeme='" + lexeme + "'}";
    }
}
