import java.util.*;

public class SLR {
    
    public static boolean parse(List<Token> tokens) {
        Stack<Integer> stateStack = new Stack<>();
        stateStack.push(0);
        tokens.add(new Token("$", "$", -1, -1 )); 

        int index = 0;

        while (true) {
            int currentState = stateStack.peek();
            String currentToken = tokens.get(index).type;

            Map<String, String> actions = SLRTable.actionTable[currentState];
            String action = actions != null ? actions.get(currentToken) : null;

            if (action == null) {
                System.out.println("Syntax Error at token: " + currentToken);
                return false;
            }

            if (action.startsWith("s")) { // Shift
                int nextState = Integer.parseInt(action.substring(1));
                stateStack.push(nextState);
                System.out.println("Shift: " + currentToken);
                index++;

            } else if (action.startsWith("r")) { // Reduce
                int grammarIndex = Integer.parseInt(action.substring(1));
                GrammarRule rule = SLRTable.grammar.get(grammarIndex);

                System.out.println("Reduce: " + rule);

                for (int i = 0; i < rule.right.size(); i++) {
                    stateStack.pop();
                }

                currentState = stateStack.peek();
                Map<String, Integer> gotos = SLRTable.gotoTable[currentState];
                Integer gotoState = gotos != null ? gotos.get(rule.left) : null;

                if (gotoState == null) {
                    System.out.println("Syntax Error in GOTO for: " + rule.left);
                    return false;
                }

                stateStack.push(gotoState);

            } else if (action.equals("acc")) { // Accept
                System.out.println("Accepted");
                return true;
            }
        }
    } 

}
