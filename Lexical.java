import java.util.*;

public class Lexical {
    private static String buffer;
    private static int state;
    private static int row, col, len;
    private static int pointer;
    private static char ch;

    private static final List<String> KEYWORDS = Arrays.asList(
        "auto", "double", "int", "struct", "break", "else", "long", "switch",
        "case", "enum", "register", "typedef", "char", "extern", "return", "union",
        "const", "float", "short", "unsigned", "continue", "for", "signed", "void",
        "default", "goto", "sizeof", "volatile", "do", "if", "static", "while"
    );

    private static void getChar() {
        if (++pointer == buffer.length()) return;
        ch = buffer.charAt(pointer);
    }

    private static boolean isLetter() {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private static boolean isDigit() {
        return ch >= '0' && ch <= '9';
    }

    private static void goForward() {
        getChar();
        col++;
        len++;
    }

    private static void reset() {
        len = 0;
        state = 0;
    }

    private static Token createToken(String type) {
        return new Token(buffer.substring(pointer - len, pointer), type, row, col - len);
    }

    private static Token createToken(String type, int dif) {
        return new Token(buffer.substring(pointer - len, pointer - dif), type, row, col - len);
    }

    public static boolean isKeyword(String word) {
        return KEYWORDS.contains(word);
    }

    public static List<Token> run(String buffer) {
        Lexical.buffer = buffer;
        state = 0;
        pointer = -1;
        row = 0; col = 0;
        len = 0;
        List<Token> tokens = new ArrayList<>();
        Token token;

        getChar();

        while (pointer < buffer.length()) {

            switch (state) {
                case 0:
                    if (ch == ' ' ) {
                        col++;
                        getChar();
                    } else if (ch == '\t') {
                        col+=4;
                        getChar();
                    } else if (ch == '\n') {
                        row++;
                        col = 0;
                        getChar();
                    } else if (isDigit()) {
                        goForward();
                        state = 3;
                    } else if (isLetter() || ch == '_') {
                        goForward();
                        state = 1;
                    } else if (ch == '/') {
                        goForward();
                        state = 21;
                    } else if (ch == '[' || ch == ']' || ch == '(' || ch == ')'
                            || ch == '{' || ch == '}' || ch == ';' || ch == ','
                            || ch == ':') {
                        goForward();
                        state = 25;           
                    } else if (ch == '"' ) {
                        goForward();
                        state = 39;
                    } else if (ch == '\'') {
                        state = 35;
                    } else if (ch == '!' || ch == '^' || ch == '%' || ch == '=' || ch == '*') {
                        goForward();
                        state = 26;
                    } else if (ch == '+') {
                        goForward();
                        state = 27;
                    } else if (ch == '-') {
                        goForward();
                        state = 28;
                    } else if (ch == '&') {
                        goForward();
                        state = 31;
                    } else if (ch == '|') {
                        goForward();
                        state = 32;
                    } else if (ch == '<') {
                        goForward();
                        state = 29;
                    } else if (ch == '>') {
                        goForward();
                        state = 30;
                    } else if (ch == '?' || ch == '~') {
                        goForward();
                        state = 33;
                    } else {
                        System.out.println("Error.");
                    }
                    break;
            
                case 1:
                    if ( isLetter() || isDigit() || ch == '_') goForward();
                    else state = 2;
                    break;
                
                case 2:
                    if (isKeyword(buffer.substring(pointer - len, pointer))) {
                        token = createToken("Keyword");
                    } else token = createToken("Identifier");
                    tokens.add(token);
                    reset();
                    break;
            
                case 3:
                    if (isDigit()) {
                        goForward();
                    } else if (ch == '.') {
                        goForward();
                        state = 4;
                    } else if (ch == 'u' || ch == 'U') {
                        goForward();
                        state = 8;
                    } else if (ch == 'L') {
                        goForward();
                        state = 9;
                    }  else if (ch == 'l') {
                        goForward();
                        state = 10;
                    } else {
                        state = 7;
                    }
                    break;
                
                case 4:
                    if (isDigit()) {
                        goForward();
                        state = 5;
                    } else System.out.println("Error.");
                    
                    break;
            
                case 5:
                    if (isDigit()) {
                        goForward();
                    } else if (ch == 'f' || ch == 'F') {
                        goForward();
                        state = 18;
                    } else state = 6;
                    break;

                case 6:
                    token = createToken("Double Number");
                    tokens.add(token);
                    reset();
                    break;

                case 7:
                    token = createToken("Integer Number");
                    tokens.add(token);
                    reset();
                    break;

                case 8:
                    if (ch == 'L') {
                        goForward();
                        state = 11;
                    } else if (ch == 'l') {
                        goForward();
                        state = 12;
                    } else state = 15;
                    break;

                case 9:
                    if (ch == 'L') {
                        goForward();
                        state = 13;
                    } else state = 17;
                    break;

                case 10:
                    if (ch == 'l') {
                        goForward();
                        state = 13;
                    } else state = 17;
                    break;

                case 11:
                    if (ch == 'L') {
                        goForward();
                        state = 14;
                    } else state = 16;
                    break;

                case 12:
                    if (ch == 'l') {
                        goForward();
                        state = 14;
                    } else state = 16;
                    break;
                
                case 13:
                    token = createToken("Long Long Number", 2);
                    tokens.add(token);
                    reset();
                    break;

                case 14:
                    token = createToken("Unsigned Long Long Number", 3);
                    tokens.add(token);
                    reset();
                    break;

                case 15:
                    token = createToken("Unsigned Integer Number", 1);
                    tokens.add(token);
                    reset();
                    break;

                case 16:
                    token = createToken("Unsigned Long Number", 2);
                    tokens.add(token);
                    reset();
                    break;

                case 17:
                    token = createToken("Long Number", 1);
                    tokens.add(token);
                    reset();
                    break;
                
                case 18:
                    if (ch == 'l' || ch == 'L') {
                        goForward();
                        state = 20;
                    } else state = 19;
                    break;

                case 19:
                    token = createToken("Float Number", 1);
                    tokens.add(token);
                    reset();
                    break;

                case 20:
                    token = createToken("Double Number", 2);
                    tokens.add(token);
                    reset();
                    break;
                
                case 21:
                    if (ch == '/') {
                        goForward();
                        state = 22;
                    } else if (ch == '*') {
                        goForward();
                        state = 23;
                    } else state = 26;
                    break;

                case 22:
                    if (ch == '\n') state = 0;
                    goForward();
                    break;
                
                case 23:
                    if (ch == '*') state = 24;
                    goForward();
                    break;
                
                case 24:
                    if (ch == '/') state = 0;
                    else state = 23;
                    goForward();
                    break;

                case 25:
                    token = createToken("Delimeter");
                    tokens.add(token);
                    reset();
                    break;

                case 26:
                    if (ch == '=') goForward();
                    state = 33;
                    break;
                
                case 27:
                    if (ch == '+') {
                        goForward();
                        state = 33;
                    } else state = 26;
                    break;

                case 28:
                    if (ch == '-') {
                        goForward();
                        state = 33;
                    } else state = 26;
                    break;
    
                case 29:
                    if (ch == '<') goForward();
                    state = 26;
                    break;
                
                case 30:
                    if (ch == '>') goForward();
                    state = 26;
                    break;

                case 31:
                    if (ch == '|') goForward();
                    state = 26;
                    break;
                
                case 32:
                    if (ch == '&') goForward();
                    state = 26;
                    break;
                
                case 33:
                    token = createToken("Operator");
                    tokens.add(token);
                    reset();
                    break;

                case 34:
                    if (ch == '"') state = 39;
                    goForward();
                    break;

                case 35:
                    if (ch == '\\') state = 36;
                    else state = 37;
                    goForward();
                    break;

                case 36:
                    if (ch == '\\' || ch == 't' || ch == 'n' || ch == 'r') {
                        goForward();
                        state = 38;
                    } else {
                        System.out.println("Error.");
                    }
                    break;

                case 37:
                    if (ch == '\'') {
                        goForward();
                        state = 39;
                    } else {
                        System.out.println("Error.");
                    }
                    break;

                case 38:
                    token = createToken("Character");
                    tokens.add(token);
                    reset();
                    break;

                case 39:
                    token = createToken("String");
                    tokens.add(token);
                    reset();
                   break; 
                default:
                    System.out.println("Error");
                    break;
            }
        }

        return tokens;
    }

}
