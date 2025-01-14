public class Lexical {
    private static String buffer;
    private static int state;
    private static int row, col, len;
    private static int pointer;
    private static char ch;

    private static void getChar() {
        Lexical.ch = buffer.charAt(++pointer);
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

    static void run(String buffer) {
        Lexical.buffer = buffer;
        state = 0;
        pointer = -1;
        row = 0; col = 0;
        int len = 0;
        
        getChar();

        while (true) {

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
                    // Token identifier or keyword
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
                    // Token double number
                    break;

                case 7:
                    // Token integer number
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
                    // Token long long number
                    break;

                case 14:
                    // Token unsigned long long
                    break;

                case 15:
                    // Token unsigned int
                    break;

                case 16:
                    // Token unsigned long
                    break;

                case 17:
                    // Token long
                    break;
                
                case 18:
                    if (ch == 'l' || ch == 'L') {
                        goForward();
                        state = 20;
                    } else state = 19;
                    break;

                case 19:
                    // Token float
                    break;

                case 20:
                    // Token double
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
                    // Token delimiter
                    state = 0;
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
                    // Token operator
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
                    // Token character
                    
                    break;

                case 39:
                    // Token String
                   break; 
                default:
                    break;
            }
        }

    }

}
