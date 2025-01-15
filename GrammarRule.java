import java.util.List;

public class GrammarRule {
    public final String left; 
    public final List<String> right;

    public GrammarRule(String left, List<String> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + " -> " + String.join(" ", right);
    }
}
