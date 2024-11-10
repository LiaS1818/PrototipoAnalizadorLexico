public class Token {
    private final TipoToken type;
    private final String lexeme;

    public Token(TipoToken type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public TipoToken getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexeme='" + lexeme + '\'' +
                '}';
    }
}

