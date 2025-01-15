public class Token {
    int row, col;
    String group, type;

    String value;

    Token(String value, String group, int row, int col) {
        this.row = row;
        this.col = col;
        this.group = group;
        this.value = value;

        setType();
    }

    private void setType() {
        if (group.equals("Keyword")) {
            switch (value) {
                case "int":
                case "double":
                case "char":
                case "float":
                case "short":
                case "long":
                case "void":
                    type = "type";
                    break;
                case "for":
                case "while":
                case "switch":
                case "if":
                case "else":
                case "return":
                case "break":
                case "default":
                case "case":
                    type = value;
                    break;
                case "sizeof":
                    type = "op1";
                    break;
                default:
                    break;
            }
        } else if (group.equals("Operator")) {
            switch (value) {
                case "!":
                case "~":
                    type = "op1";
                    break;
            
                default:
                    type = "op2";
                    break;
            }
        } else if (group.equals("Delimeter")) {
            type = value;
        } else if (group.equals("Identifier")) {
            type = "id";
        } else if (group.equals("Double Number") || group.equals("Integer Number") || group.equals("Long Long Number") || group.equals("Unsigned Long Long Number") || group.equals("Unsigned Integer Number") || group.equals("Long Number") || group.equals("Float Number") ) {
            type = "number";
        } else {
            type = value;
            // could be developed
            System.out.println("could not find the type.");
        }
    }

    @Override
    public String toString() {
        return "Token{" +
                "row=" + row +
                ", col=" + col +
                ", group='" + group + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
    
}
