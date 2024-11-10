public class Lexerisis {
    private final String input;
    private int position = 0;

    public Lexerisis(String input) {
        this.input = input;
    }

    public Token nextToken() {
        if(position >= input.length()) return null;

        char currentChar = input.charAt(position);
        // Ignorar espacios en blanco
        if(Character.isWhitespace(currentChar)) {
            position++;
            return new Token(TipoToken.WHITESPACE, " ");
        }
        // La clase Character tiene metodos para reconocer caracteres
        //Recnocer numeros enteros
        if (Character.isDigit(currentChar)){
            //StringBuilder es una clase que permite concatenar cadenas de caracteres
            StringBuilder buffer = new StringBuilder();
            while (position < input.length() && Character.isDigit(input.charAt(position))){
                buffer.append(input.charAt(position));
                position++;
            }
            return new Token(TipoToken.ENTERO, buffer.toString());
        }

        // Reconocer identificadores
        if (Character.isLetter(currentChar)){
            StringBuilder buffer = new StringBuilder();
            while (position < input.length() && Character.isLetter(input.charAt(position))){
                buffer.append(input.charAt(position));
                position++;
            }
            return new Token(TipoToken.IDENTIFICADOR, buffer.toString());
        }

        // Reconocer operadores
        if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'){
            position++;
            return new Token(TipoToken.OPERADOR, Character.toString(currentChar));
        }

        // Caracteres desconocidos
        position++;
        return new Token(TipoToken.UKNOWN, Character.toString(currentChar));
    }
}
