public class Lexical {
    private static String buffer ;
    private static int state;
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
    

    static void run(String buffer) {
        Lexical.buffer = buffer;
        state = 0;
        pointer = -1;
        int row = 0, col = 0;
        int len = 0;
        
        getChar();

        while (true) {

            switch (state) {
                case 0:
                    if (ch == ' ' ) {
                        col++;
                        getChar();
                        break;
                    } else if (ch == '\t') {
                        col+=4;
                        getChar();
                        break;
                    } else if (ch == '\n') {
                        row++;
                        col = 0;
                        getChar();
                        break;
                    } else if (isDigit()) {
                        getChar();
                        state = 3;
                    } else if (isLetter() || ch == '_') {
                        getChar();
                        state = 1;
                    } else if (ch == '/') {
                        getChar();
                        state = 21;
                    } else if (ch == '[' || ch == ']' || ch == '(' || ch == ')'
                            || ch == '{' || ch == '}' || ch == ';' || ch == ','
                            || ch == ':') {
                        getChar();
                        state = 25;           
                    } else if (ch == '"' ) {
                        // not finished
                    } else if (ch == '\'') {
                        // not finished
                    } else if (ch == '!' || ch == '^' || ch == '%' || ch == '=' || ch == '*') {
                        getChar();
                        state = 26;
                    } else if (ch == '+') {
                        getChar();
                        state = 27;
                    } else if (ch == '-') {
                        getChar();
                        state = 28;
                    } else if (ch == '&') {
                        getChar();
                        state = 31;
                    } else if (ch == '|') {
                        getChar();
                        state = 32;
                    } else if (ch == '<') {
                        getChar();
                        state = 29;
                    } else if (ch == '>') {
                        getChar();
                        state = 30;
                    } else if (ch == '?' || ch == '~') {
                        getChar();
                        state = 33;
                    } else {
                        System.out.println("Error.");
                    }

                    col++;
                    len++;
                    break;
            
                case 1:
                    if ( isLetter() || isDigit() || ch == '_') getChar();
                    else state = 2;
                    break;
                
                case 2:
                    // Token identifier or keyword
                    break;
            
                case 3:
                    if (isDigit()) {
                        getChar();
                    } else if (ch == '.') {
                        getChar();
                        state = 4;
                    } else if (ch == 'u' || ch == 'U') {
                        getChar();
                        state = 8;
                    } else if (ch == 'L') {
                        getChar();
                        state = 9;
                    }  else if (ch == 'l') {
                        getChar();
                        state = 10;
                    } else {
                        state = 7;
                    }
                    break;
                
                case 4:
                    if (isDigit()) {
                        getChar();
                        state = 5;
                    } else System.out.println("Error.");
                    
                    break;
            
                case 5:
                    if (isDigit()) {
                        getChar();
                    } else if (ch == 'f' || ch == 'F') {
                        getChar();
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
                        getChar();
                        state = 11;
                    } else if (ch == 'l') {
                        getChar();
                        state = 12;
                    } else state = 15;
                    break;

                case 9:
                    if (ch == 'L') {
                        getChar();
                        state = 13;
                    } else state = 17;
                    break;

                case 10: 
                    if (ch == 'l') {
                        getChar();
                        state = 13;
                    } else state = 17;
                    break;

                case 11:
                    if (ch == 'L') {
                        getChar();
                        state = 14;
                    } else state = 16;
                    break;

                case 12:
                    if (ch == 'l') {
                        getChar();
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
                        getChar();
                        state = 20;
                    } else state = 19;
                    break;

                case 19:
                    // Token float
                    break;

                case 20:
                    // Token double
                    break;
                
                    
                    
                    
                default:
                    break;
            }
        }

    }

}
