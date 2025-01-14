public class Token {
    int row, col;
    int type;

    String value;

    Token(String value, int type, int row, int col) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.value = value;
    }
    
}
