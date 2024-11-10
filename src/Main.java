//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lexerisis lexerisis = new Lexerisis("123 + variable1 - 456$");

        Token token;
        while ((token = lexerisis.nextToken()) != null) {
            if (token.getType() == TipoToken.UKNOWN) {
                System.out.println("Cadena no reconocida: " + token.getLexeme());
            } else
            if (token.getType() != TipoToken.WHITESPACE) {
                System.out.println("Token: " + token.getType() + ", Lexeme: " + token.getLexeme());
            }
        }
    }

}