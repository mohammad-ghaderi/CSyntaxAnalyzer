public class Token {
    int row, col;
    String type;

    String value;



    Token(String value, String type, int row, int col) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.value = value;
    }
    
}
