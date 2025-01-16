import java.util.*;

public class SLRTable {
    
    public static final List<GrammarRule> grammar = Arrays.asList(
        new GrammarRule("S'", Arrays.asList("S")),
        new GrammarRule("S", Arrays.asList("typ", "i", "DEC", "S")),
        new GrammarRule("S", Arrays.asList()),
        new GrammarRule("DECL", Arrays.asList("", "EX", "VAR_REST")),
        new GrammarRule("DECL", Arrays.asList("", "PARAM", "", "CMP_STMT")),
        new GrammarRule("DECL", Arrays.asList("", "EX", "", "VAR_REST")),
        new GrammarRule("DECL", Arrays.asList("", "i", "VAR_RES", "")),
        new GrammarRule("VAR_REST", Arrays.asList("", "i", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList("", "EX", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList("", "EX", "", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList(";")),
        new GrammarRule("PARAMS", Arrays.asList("typ", "i", "PAR_REST")),
        new GrammarRule("PARAMS", Arrays.asList()),
        new GrammarRule("PAR_REST", Arrays.asList("", "typ", "i", "PAR_REST")),
        new GrammarRule("PAR_REST", Arrays.asList("", "EX", "", "PAR_REST")),
        new GrammarRule("PAR_REST", Arrays.asList()),
        new GrammarRule("CMP_STMT", Arrays.asList("", "STMT_LIS", "}")),
        new GrammarRule("STMT_LIST", Arrays.asList("STM", "STMT_LIST")),
        new GrammarRule("STMT_LIST", Arrays.asList()),
        new GrammarRule("STMT", Arrays.asList("typ", "i", "DECL")),
        new GrammarRule("STMT", Arrays.asList("EX", ";")),
        new GrammarRule("STMT", Arrays.asList("IF_STMT")),
        new GrammarRule("STMT", Arrays.asList("WHILE_STMT")),
        new GrammarRule("STMT", Arrays.asList("FOR_STMT")),
        new GrammarRule("STMT", Arrays.asList("SWITCH_STMT")),
        new GrammarRule("STMT", Arrays.asList("CMP_STMT")),
        new GrammarRule("STMT", Arrays.asList("retur", "EX", ";")),
        new GrammarRule("STMT", Arrays.asList("brea", ";")),
        new GrammarRule("EXP", Arrays.asList("i", "IDEXP")),
        new GrammarRule("EXP", Arrays.asList("numbe", "NUMEXP")),
        new GrammarRule("EXP", Arrays.asList("op", "EXP")),
        new GrammarRule("IDEXP", Arrays.asList("op", "EXP")),
        new GrammarRule("IDEXP", Arrays.asList("", "ARG", ")")),
        new GrammarRule("IDEXP", Arrays.asList("VAR_REST")),
        new GrammarRule("NUMEXP", Arrays.asList("op", "EXP")),
        new GrammarRule("NUMEXP", Arrays.asList()),
        new GrammarRule("ARGS", Arrays.asList("EX", "ARG_REST")),
        new GrammarRule("ARGS", Arrays.asList()),
        new GrammarRule("ARG_REST", Arrays.asList("", "EX", "ARG_REST")),
        new GrammarRule("ARG_REST", Arrays.asList()),
        new GrammarRule("IF_STMT", Arrays.asList("i", "", "EX", "", "STM", "ELSE_STMT")),
        new GrammarRule("ELSE_STMT", Arrays.asList("els", "STMT")),
        new GrammarRule("ELSE_STMT", Arrays.asList()),
        new GrammarRule("WHILE_STMT", Arrays.asList("whil", "", "EX", "", "STMT")),
        new GrammarRule("FOR_STMT", Arrays.asList("fo", "", "EX", "", "EX", "", "EX", "", "STMT")),
        new GrammarRule("SWITCH_STMT", Arrays.asList("switc", "", "EX", "", "", "CASE_LIS", "DEF", "}")),
        new GrammarRule("CASE_LIST", Arrays.asList("cas", "EX", "", "STM", "CASE_LIST")),
        new GrammarRule("CASE_LIST", Arrays.asList()),
        new GrammarRule("DEFA", Arrays.asList("defaul", "", "STMT")),
        new GrammarRule("DEFA", Arrays.asList("'"))                
    );

    // Action table as an array of maps (index is the state number)
    public static final Map<String, String>[] actionTable = new Map[119]; // Example for 6 states

    // Goto table as an array of maps (index is the state number)
    public static final Map<String, Integer>[] gotoTable = new Map[119]; // Example for 6 states


    static {

        actionTable[0] = new HashMap<>();
        actionTable[0].put("type", "s2");
        actionTable[0].put("$", "r2");
        gotoTable[0] = new HashMap<>();
        gotoTable[0].put("S", 1);
        
        actionTable[1] = new HashMap<>();
        actionTable[1].put("$", "acc");
        
        actionTable[2] = new HashMap<>();
        actionTable[2].put("id", "s3");
        
        actionTable[3] = new HashMap<>();
        actionTable[3].put("=", "s5");
        actionTable[3].put("(", "s6");
        actionTable[3].put("[", "s7");
        actionTable[3].put(",", "s8");
        gotoTable[3] = new HashMap<>();
        gotoTable[3].put("DECL", 4);
        
        actionTable[4] = new HashMap<>();
        actionTable[4].put("type", "s2");
        actionTable[4].put("$", "r2");
        gotoTable[4] = new HashMap<>();
        gotoTable[4].put("S", 9);
        
        actionTable[5] = new HashMap<>();
        actionTable[5].put("id", "s11");
        actionTable[5].put("number", "s12");
        actionTable[5].put("op1", "s13");
        gotoTable[5] = new HashMap<>();
        gotoTable[5].put("EXP", 10);
        
        actionTable[6] = new HashMap<>();
        actionTable[6].put("type", "s15");
        actionTable[6].put(")", "r12");
        gotoTable[6] = new HashMap<>();
        gotoTable[6].put("PARAMS", 14);
        
        actionTable[7] = new HashMap<>();
        actionTable[7].put("id", "s11");
        actionTable[7].put("number", "s12");
        actionTable[7].put("op1", "s13");
        gotoTable[7] = new HashMap<>();
        gotoTable[7].put("EXP", 16);
        
        actionTable[8] = new HashMap<>();
        actionTable[8].put("id", "s17");
        
        actionTable[9] = new HashMap<>();
        actionTable[9].put("$", "r1");
        
        actionTable[10] = new HashMap<>();
        actionTable[10].put("=", "s20");
        actionTable[10].put("[", "s21");
        actionTable[10].put(",", "s19");
        actionTable[10].put(";", "s22");
        gotoTable[10] = new HashMap<>();
        gotoTable[10].put("VAR_REST", 18);
        
        actionTable[11] = new HashMap<>();
        actionTable[11].put("=", "s20");
        actionTable[11].put("(", "s25");
        actionTable[11].put("[", "s21");
        actionTable[11].put(",", "s19");
        actionTable[11].put(";", "s22");
        actionTable[11].put("op2", "s24");
        gotoTable[11] = new HashMap<>();
        gotoTable[11].put("VAR_REST", 26);
        gotoTable[11].put("IDEXP", 23);
        
        actionTable[12] = new HashMap<>();
        actionTable[12].put("=", "r35");
        actionTable[12].put(")", "r35");
        actionTable[12].put("[", "r35");
        actionTable[12].put("]", "r35");
        actionTable[12].put(",", "r35");
        actionTable[12].put(";", "r35");
        actionTable[12].put("op2", "s28");
        actionTable[12].put(":", "r35");
        gotoTable[12] = new HashMap<>();
        gotoTable[12].put("NUMEXP", 27);
        
        actionTable[13] = new HashMap<>();
        actionTable[13].put("id", "s11");
        actionTable[13].put("number", "s12");
        actionTable[13].put("op1", "s13");
        gotoTable[13] = new HashMap<>();
        gotoTable[13].put("EXP", 29);
        
        actionTable[14] = new HashMap<>();
        actionTable[14].put(")", "s30");
        
        actionTable[15] = new HashMap<>();
        actionTable[15].put("id", "s31");
        
        actionTable[16] = new HashMap<>();
        actionTable[16].put("]", "s32");
        
        actionTable[17] = new HashMap<>();
        actionTable[17].put("=", "s20");
        actionTable[17].put("[", "s21");
        actionTable[17].put(",", "s19");
        actionTable[17].put(";", "s22");
        gotoTable[17] = new HashMap<>();
        gotoTable[17].put("VAR_REST", 33);
        
        actionTable[18] = new HashMap<>();
        actionTable[18].put("type", "r3");
        actionTable[18].put("id", "r3");
        actionTable[18].put("{", "r3");
        actionTable[18].put("}", "r3");
        actionTable[18].put("return", "r3");
        actionTable[18].put("break", "r3");
        actionTable[18].put("number", "r3");
        actionTable[18].put("op1", "r3");
        actionTable[18].put("if", "r3");
        actionTable[18].put("else", "r3");
        actionTable[18].put("while", "r3");
        actionTable[18].put("for", "r3");
        actionTable[18].put("switch", "r3");
        actionTable[18].put("case", "r3");
        actionTable[18].put("default", "r3");
        actionTable[18].put("$", "r3");
        
        actionTable[19] = new HashMap<>();
        actionTable[19].put("id", "s34");
        
        actionTable[20] = new HashMap<>();
        actionTable[20].put("id", "s11");
        actionTable[20].put("number", "s12");
        actionTable[20].put("op1", "s13");
        gotoTable[20] = new HashMap<>();
        gotoTable[20].put("EXP", 35);
        
        actionTable[21] = new HashMap<>();
        actionTable[21].put("id", "s11");
        actionTable[21].put("number", "s12");
        actionTable[21].put("op1", "s13");
        gotoTable[21] = new HashMap<>();
        gotoTable[21].put("EXP", 36);
        
        actionTable[22] = new HashMap<>();
        actionTable[22].put("type", "r10");
        actionTable[22].put("id", "r10");
        actionTable[22].put("=", "r10");
        actionTable[22].put(")", "r10");
        actionTable[22].put("[", "r10");
        actionTable[22].put("]", "r10");
        actionTable[22].put(",", "r10");
        actionTable[22].put(";", "r10");
        actionTable[22].put("{", "r10");
        actionTable[22].put("}", "r10");
        actionTable[22].put("return", "r10");
        actionTable[22].put("break", "r10");
        actionTable[22].put("number", "r10");
        actionTable[22].put("op1", "r10");
        actionTable[22].put("if", "r10");
        actionTable[22].put("else", "r10");
        actionTable[22].put("while", "r10");
        actionTable[22].put("for", "r10");
        actionTable[22].put("switch", "r10");
        actionTable[22].put("case", "r10");
        actionTable[22].put(":", "r10");
        actionTable[22].put("default", "r10");
        actionTable[22].put("$", "r10");
        
        actionTable[23] = new HashMap<>();
        actionTable[23].put("=", "r28");
        actionTable[23].put(")", "r28");
        actionTable[23].put("[", "r28");
        actionTable[23].put("]", "r28");
        actionTable[23].put(",", "r28");
        actionTable[23].put(";", "r28");
        actionTable[23].put(":", "r28");
        
        actionTable[24] = new HashMap<>();
        actionTable[24].put("id", "s11");
        actionTable[24].put("number", "s12");
        actionTable[24].put("op1", "s13");
        gotoTable[24] = new HashMap<>();
        gotoTable[24].put("EXP", 37);
        
        actionTable[25] = new HashMap<>();
        actionTable[25].put("id", "s11");
        actionTable[25].put(")", "r37");
        actionTable[25].put("number", "s12");
        actionTable[25].put("op1", "s13");
        gotoTable[25] = new HashMap<>();
        gotoTable[25].put("EXP", 39);
        gotoTable[25].put("ARGS", 38);
        
        actionTable[26] = new HashMap<>();
        actionTable[26].put("=", "r33");
        actionTable[26].put(")", "r33");
        actionTable[26].put("[", "r33");
        actionTable[26].put("]", "r33");
        actionTable[26].put(",", "r33");
        actionTable[26].put(";", "r33");
        actionTable[26].put(":", "r33");
        
        actionTable[27] = new HashMap<>();
        actionTable[27].put("=", "r29");
        actionTable[27].put(")", "r29");
        actionTable[27].put("[", "r29");
        actionTable[27].put("]", "r29");
        actionTable[27].put(",", "r29");
        actionTable[27].put(";", "r29");
        actionTable[27].put(":", "r29");
        
        actionTable[28] = new HashMap<>();
        actionTable[28].put("id", "s11");
        actionTable[28].put("number", "s12");
        actionTable[28].put("op1", "s13");
        gotoTable[28] = new HashMap<>();
        gotoTable[28].put("EXP", 40);
        
        actionTable[29] = new HashMap<>();
        actionTable[29].put("=", "r30");
        actionTable[29].put(")", "r30");
        actionTable[29].put("[", "r30");
        actionTable[29].put("]", "r30");
        actionTable[29].put(",", "r30");
        actionTable[29].put(";", "r30");
        actionTable[29].put(":", "r30");
        
        actionTable[30] = new HashMap<>();
        actionTable[30].put("{", "s42");
        gotoTable[30] = new HashMap<>();
        gotoTable[30].put("CMP_STMT", 41);
        
        actionTable[31] = new HashMap<>();
        actionTable[31].put(")", "r15");
        actionTable[31].put("[", "s45");
        actionTable[31].put(",", "s44");
        gotoTable[31] = new HashMap<>();
        gotoTable[31].put("PAR_REST", 43);
        
        actionTable[32] = new HashMap<>();
        actionTable[32].put("=", "s20");
        actionTable[32].put("[", "s21");
        actionTable[32].put(",", "s19");
        actionTable[32].put(";", "s22");
        gotoTable[32] = new HashMap<>();
        gotoTable[32].put("VAR_REST", 46);
        
        actionTable[33] = new HashMap<>();
        actionTable[33].put("type", "r6");
        actionTable[33].put("id", "r6");
        actionTable[33].put("{", "r6");
        actionTable[33].put("}", "r6");
        actionTable[33].put("return", "r6");
        actionTable[33].put("break", "r6");
        actionTable[33].put("number", "r6");
        actionTable[33].put("op1", "r6");
        actionTable[33].put("if", "r6");
        actionTable[33].put("else", "r6");
        actionTable[33].put("while", "r6");
        actionTable[33].put("for", "r6");
        actionTable[33].put("switch", "r6");
        actionTable[33].put("case", "r6");
        actionTable[33].put("default", "r6");
        actionTable[33].put("$", "r6");
        
        actionTable[34] = new HashMap<>();
        actionTable[34].put("=", "s20");
        actionTable[34].put("[", "s21");
        actionTable[34].put(",", "s19");
        actionTable[34].put(";", "s22");
        gotoTable[34] = new HashMap<>();
        gotoTable[34].put("VAR_REST", 47);
        
        actionTable[35] = new HashMap<>();
        actionTable[35].put("=", "s20");
        actionTable[35].put("[", "s21");
        actionTable[35].put(",", "s19");
        actionTable[35].put(";", "s22");
        gotoTable[35] = new HashMap<>();
        gotoTable[35].put("VAR_REST", 48);
        
        actionTable[36] = new HashMap<>();
        actionTable[36].put("]", "s49");
        
        actionTable[37] = new HashMap<>();
        actionTable[37].put("=", "r31");
        actionTable[37].put(")", "r31");
        actionTable[37].put("[", "r31");
        actionTable[37].put("]", "r31");
        actionTable[37].put(",", "r31");
        actionTable[37].put(";", "r31");
        actionTable[37].put(":", "r31");
        
        actionTable[38] = new HashMap<>();
        actionTable[38].put(")", "s50");
        
        actionTable[39] = new HashMap<>();
        actionTable[39].put(")", "r39");
        actionTable[39].put(",", "s52");
        gotoTable[39] = new HashMap<>();
        gotoTable[39].put("ARG_REST", 51);
        
        actionTable[40] = new HashMap<>();
        actionTable[40].put("=", "r34");
        actionTable[40].put(")", "r34");
        actionTable[40].put("[", "r34");
        actionTable[40].put("]", "r34");
        actionTable[40].put(",", "r34");
        actionTable[40].put(";", "r34");
        actionTable[40].put(":", "r34");
        
        actionTable[41] = new HashMap<>();
        actionTable[41].put("type", "r4");
        actionTable[41].put("id", "r4");
        actionTable[41].put("{", "r4");
        actionTable[41].put("}", "r4");
        actionTable[41].put("return", "r4");
        actionTable[41].put("break", "r4");
        actionTable[41].put("number", "r4");
        actionTable[41].put("op1", "r4");
        actionTable[41].put("if", "r4");
        actionTable[41].put("else", "r4");
        actionTable[41].put("while", "r4");
        actionTable[41].put("for", "r4");
        actionTable[41].put("switch", "r4");
        actionTable[41].put("case", "r4");
        actionTable[41].put("default", "r4");
        actionTable[41].put("$", "r4");
        
        actionTable[42] = new HashMap<>();
        actionTable[42].put("type", "s55");
        actionTable[42].put("id", "s11");
        actionTable[42].put("{", "s42");
        actionTable[42].put("}", "r18");
        actionTable[42].put("return", "s62");
        actionTable[42].put("break", "s63");
        actionTable[42].put("number", "s12");
        actionTable[42].put("op1", "s13");
        actionTable[42].put("if", "s64");
        actionTable[42].put("while", "s65");
        actionTable[42].put("for", "s66");
        actionTable[42].put("switch", "s67");
        gotoTable[42] = new HashMap<>();
        gotoTable[42].put("CMP_STMT", 61);
        gotoTable[42].put("STMT_LIST", 53);
        gotoTable[42].put("STMT", 54);
        gotoTable[42].put("EXP", 56);
        gotoTable[42].put("IF_STMT", 57);
        gotoTable[42].put("WHILE_STMT", 58);
        gotoTable[42].put("FOR_STMT", 59);
        gotoTable[42].put("SWITCH_STMT", 60);
        
        actionTable[43] = new HashMap<>();
        actionTable[43].put(")", "r11");
        
        actionTable[44] = new HashMap<>();
        actionTable[44].put("type", "s68");
        
        actionTable[45] = new HashMap<>();
        actionTable[45].put("id", "s11");
        actionTable[45].put("number", "s12");
        actionTable[45].put("op1", "s13");
        gotoTable[45] = new HashMap<>();
        gotoTable[45].put("EXP", 69);
        
        actionTable[46] = new HashMap<>();
        actionTable[46].put("type", "r5");
        actionTable[46].put("id", "r5");
        actionTable[46].put("{", "r5");
        actionTable[46].put("}", "r5");
        actionTable[46].put("return", "r5");
        actionTable[46].put("break", "r5");
        actionTable[46].put("number", "r5");
        actionTable[46].put("op1", "r5");
        actionTable[46].put("if", "r5");
        actionTable[46].put("else", "r5");
        actionTable[46].put("while", "r5");
        actionTable[46].put("for", "r5");
        actionTable[46].put("switch", "r5");
        actionTable[46].put("case", "r5");
        actionTable[46].put("default", "r5");
        actionTable[46].put("$", "r5");
        
        actionTable[47] = new HashMap<>();
        actionTable[47].put("type", "r7");
        actionTable[47].put("id", "r7");
        actionTable[47].put("=", "r7");
        actionTable[47].put(")", "r7");
        actionTable[47].put("[", "r7");
        actionTable[47].put("]", "r7");
        actionTable[47].put(",", "r7");
        actionTable[47].put(";", "r7");
        actionTable[47].put("{", "r7");
        actionTable[47].put("}", "r7");
        actionTable[47].put("return", "r7");
        actionTable[47].put("break", "r7");
        actionTable[47].put("number", "r7");
        actionTable[47].put("op1", "r7");
        actionTable[47].put("if", "r7");
        actionTable[47].put("else", "r7");
        actionTable[47].put("while", "r7");
        actionTable[47].put("for", "r7");
        actionTable[47].put("switch", "r7");
        actionTable[47].put("case", "r7");
        actionTable[47].put(":", "r7");
        actionTable[47].put("default", "r7");
        actionTable[47].put("$", "r7");
        
        actionTable[48] = new HashMap<>();
        actionTable[48].put("type", "r8");
        actionTable[48].put("id", "r8");
        actionTable[48].put("=", "r8");
        actionTable[48].put(")", "r8");
        actionTable[48].put("[", "r8");
        actionTable[48].put("]", "r8");
        actionTable[48].put(",", "r8");
        actionTable[48].put(";", "r8");
        actionTable[48].put("{", "r8");
        actionTable[48].put("}", "r8");
        actionTable[48].put("return", "r8");
        actionTable[48].put("break", "r8");
        actionTable[48].put("number", "r8");
        actionTable[48].put("op1", "r8");
        actionTable[48].put("if", "r8");
        actionTable[48].put("else", "r8");
        actionTable[48].put("while", "r8");
        actionTable[48].put("for", "r8");
        actionTable[48].put("switch", "r8");
        actionTable[48].put("case", "r8");
        actionTable[48].put(":", "r8");
        actionTable[48].put("default", "r8");
        actionTable[48].put("$", "r8");
        
        actionTable[49] = new HashMap<>();
        actionTable[49].put("=", "s20");
        actionTable[49].put("[", "s21");
        actionTable[49].put(",", "s19");
        actionTable[49].put(";", "s22");
        gotoTable[49] = new HashMap<>();
        gotoTable[49].put("VAR_REST", 70);
        
        actionTable[50] = new HashMap<>();
        actionTable[50].put("=", "r32");
        actionTable[50].put(")", "r32");
        actionTable[50].put("[", "r32");
        actionTable[50].put("]", "r32");
        actionTable[50].put(",", "r32");
        actionTable[50].put(";", "r32");
        actionTable[50].put(":", "r32");
        
        actionTable[51] = new HashMap<>();
        actionTable[51].put(")", "r36");
        
        actionTable[52] = new HashMap<>();
        actionTable[52].put("id", "s11");
        actionTable[52].put("number", "s12");
        actionTable[52].put("op1", "s13");
        gotoTable[52] = new HashMap<>();
        gotoTable[52].put("EXP", 71);
        
        actionTable[53] = new HashMap<>();
        actionTable[53].put("}", "s72");
        
        actionTable[54] = new HashMap<>();
        actionTable[54].put("type", "s55");
        actionTable[54].put("id", "s11");
        actionTable[54].put("{", "s42");
        actionTable[54].put("}", "r18");
        actionTable[54].put("return", "s62");
        actionTable[54].put("break", "s63");
        actionTable[54].put("number", "s12");
        actionTable[54].put("op1", "s13");
        actionTable[54].put("if", "s64");
        actionTable[54].put("while", "s65");
        actionTable[54].put("for", "s66");
        actionTable[54].put("switch", "s67");
        gotoTable[54] = new HashMap<>();
        gotoTable[54].put("CMP_STMT", 61);
        gotoTable[54].put("STMT_LIST", 73);
        gotoTable[54].put("STMT", 54);
        gotoTable[54].put("EXP", 56);
        gotoTable[54].put("IF_STMT", 57);
        gotoTable[54].put("WHILE_STMT", 58);
        gotoTable[54].put("FOR_STMT", 59);
        gotoTable[54].put("SWITCH_STMT", 60);
        
        actionTable[55] = new HashMap<>();
        actionTable[55].put("id", "s74");
        
        actionTable[56] = new HashMap<>();
        actionTable[56].put(";", "s75");
        
        actionTable[57] = new HashMap<>();
        actionTable[57].put("type", "r21");
        actionTable[57].put("id", "r21");
        actionTable[57].put("{", "r21");
        actionTable[57].put("}", "r21");
        actionTable[57].put("return", "r21");
        actionTable[57].put("break", "r21");
        actionTable[57].put("number", "r21");
        actionTable[57].put("op1", "r21");
        actionTable[57].put("if", "r21");
        actionTable[57].put("else", "r21");
        actionTable[57].put("while", "r21");
        actionTable[57].put("for", "r21");
        actionTable[57].put("switch", "r21");
        actionTable[57].put("case", "r21");
        actionTable[57].put("default", "r21");
        
        actionTable[58] = new HashMap<>();
        actionTable[58].put("type", "r22");
        actionTable[58].put("id", "r22");
        actionTable[58].put("{", "r22");
        actionTable[58].put("}", "r22");
        actionTable[58].put("return", "r22");
        actionTable[58].put("break", "r22");
        actionTable[58].put("number", "r22");
        actionTable[58].put("op1", "r22");
        actionTable[58].put("if", "r22");
        actionTable[58].put("else", "r22");
        actionTable[58].put("while", "r22");
        actionTable[58].put("for", "r22");
        actionTable[58].put("switch", "r22");
        actionTable[58].put("case", "r22");
        actionTable[58].put("default", "r22");
        
        actionTable[59] = new HashMap<>();
        actionTable[59].put("type", "r23");
        actionTable[59].put("id", "r23");
        actionTable[59].put("{", "r23");
        actionTable[59].put("}", "r23");
        actionTable[59].put("return", "r23");
        actionTable[59].put("break", "r23");
        actionTable[59].put("number", "r23");
        actionTable[59].put("op1", "r23");
        actionTable[59].put("if", "r23");
        actionTable[59].put("else", "r23");
        actionTable[59].put("while", "r23");
        actionTable[59].put("for", "r23");
        actionTable[59].put("switch", "r23");
        actionTable[59].put("case", "r23");
        actionTable[59].put("default", "r23");
        
        actionTable[60] = new HashMap<>();
        actionTable[60].put("type", "r24");
        actionTable[60].put("id", "r24");
        actionTable[60].put("{", "r24");
        actionTable[60].put("}", "r24");
        actionTable[60].put("return", "r24");
        actionTable[60].put("break", "r24");
        actionTable[60].put("number", "r24");
        actionTable[60].put("op1", "r24");
        actionTable[60].put("if", "r24");
        actionTable[60].put("else", "r24");
        actionTable[60].put("while", "r24");
        actionTable[60].put("for", "r24");
        actionTable[60].put("switch", "r24");
        actionTable[60].put("case", "r24");
        actionTable[60].put("default", "r24");
        
        actionTable[61] = new HashMap<>();
        actionTable[61].put("type", "r25");
        actionTable[61].put("id", "r25");
        actionTable[61].put("{", "r25");
        actionTable[61].put("}", "r25");
        actionTable[61].put("return", "r25");
        actionTable[61].put("break", "r25");
        actionTable[61].put("number", "r25");
        actionTable[61].put("op1", "r25");
        actionTable[61].put("if", "r25");
        actionTable[61].put("else", "r25");
        actionTable[61].put("while", "r25");
        actionTable[61].put("for", "r25");
        actionTable[61].put("switch", "r25");
        actionTable[61].put("case", "r25");
        actionTable[61].put("default", "r25");
        
        actionTable[62] = new HashMap<>();
        actionTable[62].put("id", "s11");
        actionTable[62].put("number", "s12");
        actionTable[62].put("op1", "s13");
        gotoTable[62] = new HashMap<>();
        gotoTable[62].put("EXP", 76);
        
        actionTable[63] = new HashMap<>();
        actionTable[63].put(";", "s77");
        
        actionTable[64] = new HashMap<>();
        actionTable[64].put("(", "s78");
        
        actionTable[65] = new HashMap<>();
        actionTable[65].put("(", "s79");
        
        actionTable[66] = new HashMap<>();
        actionTable[66].put("(", "s80");
        
        actionTable[67] = new HashMap<>();
        actionTable[67].put("(", "s81");
        
        actionTable[68] = new HashMap<>();
        actionTable[68].put("id", "s82");
        
        actionTable[69] = new HashMap<>();
        actionTable[69].put("]", "s83");
        
        actionTable[70] = new HashMap<>();
        actionTable[70].put("type", "r9");
        actionTable[70].put("id", "r9");
        actionTable[70].put("=", "r9");
        actionTable[70].put(")", "r9");
        actionTable[70].put("[", "r9");
        actionTable[70].put("]", "r9");
        actionTable[70].put(",", "r9");
        actionTable[70].put(";", "r9");
        actionTable[70].put("{", "r9");
        actionTable[70].put("}", "r9");
        actionTable[70].put("return", "r9");
        actionTable[70].put("break", "r9");
        actionTable[70].put("number", "r9");
        actionTable[70].put("op1", "r9");
        actionTable[70].put("if", "r9");
        actionTable[70].put("else", "r9");
        actionTable[70].put("while", "r9");
        actionTable[70].put("for", "r9");
        actionTable[70].put("switch", "r9");
        actionTable[70].put("case", "r9");
        actionTable[70].put(":", "r9");
        actionTable[70].put("default", "r9");
        actionTable[70].put("$", "r9");
        
        actionTable[71] = new HashMap<>();
        actionTable[71].put(")", "r39");
        actionTable[71].put(",", "s52");
        gotoTable[71] = new HashMap<>();
        gotoTable[71].put("ARG_REST", 84);
        
        actionTable[72] = new HashMap<>();
        actionTable[72].put("type", "r16");
        actionTable[72].put("id", "r16");
        actionTable[72].put("{", "r16");
        actionTable[72].put("}", "r16");
        actionTable[72].put("return", "r16");
        actionTable[72].put("break", "r16");
        actionTable[72].put("number", "r16");
        actionTable[72].put("op1", "r16");
        actionTable[72].put("if", "r16");
        actionTable[72].put("else", "r16");
        actionTable[72].put("while", "r16");
        actionTable[72].put("for", "r16");
        actionTable[72].put("switch", "r16");
        actionTable[72].put("case", "r16");
        actionTable[72].put("default", "r16");
        actionTable[72].put("$", "r16");
        
        actionTable[73] = new HashMap<>();
        actionTable[73].put("}", "r17");
        
        actionTable[74] = new HashMap<>();
        actionTable[74].put("=", "s5");
        actionTable[74].put("(", "s6");
        actionTable[74].put("[", "s7");
        actionTable[74].put(",", "s8");
        gotoTable[74] = new HashMap<>();
        gotoTable[74].put("DECL", 85);
        
        actionTable[75] = new HashMap<>();
        actionTable[75].put("type", "r20");
        actionTable[75].put("id", "r20");
        actionTable[75].put("{", "r20");
        actionTable[75].put("}", "r20");
        actionTable[75].put("return", "r20");
        actionTable[75].put("break", "r20");
        actionTable[75].put("number", "r20");
        actionTable[75].put("op1", "r20");
        actionTable[75].put("if", "r20");
        actionTable[75].put("else", "r20");
        actionTable[75].put("while", "r20");
        actionTable[75].put("for", "r20");
        actionTable[75].put("switch", "r20");
        actionTable[75].put("case", "r20");
        actionTable[75].put("default", "r20");
        
        actionTable[76] = new HashMap<>();
        actionTable[76].put(";", "s86");
        
        actionTable[77] = new HashMap<>();
        actionTable[77].put("type", "r27");
        actionTable[77].put("id", "r27");
        actionTable[77].put("{", "r27");
        actionTable[77].put("}", "r27");
        actionTable[77].put("return", "r27");
        actionTable[77].put("break", "r27");
        actionTable[77].put("number", "r27");
        actionTable[77].put("op1", "r27");
        actionTable[77].put("if", "r27");
        actionTable[77].put("else", "r27");
        actionTable[77].put("while", "r27");
        actionTable[77].put("for", "r27");
        actionTable[77].put("switch", "r27");
        actionTable[77].put("case", "r27");
        actionTable[77].put("default", "r27");
        
        actionTable[78] = new HashMap<>();
        actionTable[78].put("id", "s11");
        actionTable[78].put("number", "s12");
        actionTable[78].put("op1", "s13");
        gotoTable[78] = new HashMap<>();
        gotoTable[78].put("EXP", 87);
        
        actionTable[79] = new HashMap<>();
        actionTable[79].put("id", "s11");
        actionTable[79].put("number", "s12");
        actionTable[79].put("op1", "s13");
        gotoTable[79] = new HashMap<>();
        gotoTable[79].put("EXP", 88);
        
        actionTable[80] = new HashMap<>();
        actionTable[80].put("id", "s11");
        actionTable[80].put("number", "s12");
        actionTable[80].put("op1", "s13");
        gotoTable[80] = new HashMap<>();
        gotoTable[80].put("EXP", 89);
        
        actionTable[81] = new HashMap<>();
        actionTable[81].put("id", "s11");
        actionTable[81].put("number", "s12");
        actionTable[81].put("op1", "s13");
        gotoTable[81] = new HashMap<>();
        gotoTable[81].put("EXP", 90);
        
        actionTable[82] = new HashMap<>();
        actionTable[82].put(")", "r15");
        actionTable[82].put("[", "s45");
        actionTable[82].put(",", "s44");
        gotoTable[82] = new HashMap<>();
        gotoTable[82].put("PAR_REST", 91);
        
        actionTable[83] = new HashMap<>();
        actionTable[83].put(")", "r15");
        actionTable[83].put("[", "s45");
        actionTable[83].put(",", "s44");
        gotoTable[83] = new HashMap<>();
        gotoTable[83].put("PAR_REST", 92);
        
        actionTable[84] = new HashMap<>();
        actionTable[84].put(")", "r38");
        
        actionTable[85] = new HashMap<>();
        actionTable[85].put("type", "r19");
        actionTable[85].put("id", "r19");
        actionTable[85].put("{", "r19");
        actionTable[85].put("}", "r19");
        actionTable[85].put("return", "r19");
        actionTable[85].put("break", "r19");
        actionTable[85].put("number", "r19");
        actionTable[85].put("op1", "r19");
        actionTable[85].put("if", "r19");
        actionTable[85].put("else", "r19");
        actionTable[85].put("while", "r19");
        actionTable[85].put("for", "r19");
        actionTable[85].put("switch", "r19");
        actionTable[85].put("case", "r19");
        actionTable[85].put("default", "r19");
        
        actionTable[86] = new HashMap<>();
        actionTable[86].put("type", "r26");
        actionTable[86].put("id", "r26");
        actionTable[86].put("{", "r26");
        actionTable[86].put("}", "r26");
        actionTable[86].put("return", "r26");
        actionTable[86].put("break", "r26");
        actionTable[86].put("number", "r26");
        actionTable[86].put("op1", "r26");
        actionTable[86].put("if", "r26");
        actionTable[86].put("else", "r26");
        actionTable[86].put("while", "r26");
        actionTable[86].put("for", "r26");
        actionTable[86].put("switch", "r26");
        actionTable[86].put("case", "r26");
        actionTable[86].put("default", "r26");
        
        actionTable[87] = new HashMap<>();
        actionTable[87].put(")", "s93");
        
        actionTable[88] = new HashMap<>();
        actionTable[88].put(")", "s94");
        
        actionTable[89] = new HashMap<>();
        actionTable[89].put(";", "s95");
        
        actionTable[90] = new HashMap<>();
        actionTable[90].put(")", "s96");
        
        actionTable[91] = new HashMap<>();
        actionTable[91].put(")", "r13");
        
        actionTable[92] = new HashMap<>();
        actionTable[92].put(")", "r14");
        
        actionTable[93] = new HashMap<>();
        actionTable[93].put("type", "s55");
        actionTable[93].put("id", "s11");
        actionTable[93].put("{", "s42");
        actionTable[93].put("return", "s62");
        actionTable[93].put("break", "s63");
        actionTable[93].put("number", "s12");
        actionTable[93].put("op1", "s13");
        actionTable[93].put("if", "s64");
        actionTable[93].put("while", "s65");
        actionTable[93].put("for", "s66");
        actionTable[93].put("switch", "s67");
        gotoTable[93] = new HashMap<>();
        gotoTable[93].put("CMP_STMT", 61);
        gotoTable[93].put("STMT", 97);
        gotoTable[93].put("EXP", 56);
        gotoTable[93].put("IF_STMT", 57);
        gotoTable[93].put("WHILE_STMT", 58);
        gotoTable[93].put("FOR_STMT", 59);
        gotoTable[93].put("SWITCH_STMT", 60);
        
        actionTable[94] = new HashMap<>();
        actionTable[94].put("type", "s55");
        actionTable[94].put("id", "s11");
        actionTable[94].put("{", "s42");
        actionTable[94].put("return", "s62");
        actionTable[94].put("break", "s63");
        actionTable[94].put("number", "s12");
        actionTable[94].put("op1", "s13");
        actionTable[94].put("if", "s64");
        actionTable[94].put("while", "s65");
        actionTable[94].put("for", "s66");
        actionTable[94].put("switch", "s67");
        gotoTable[94] = new HashMap<>();
        gotoTable[94].put("CMP_STMT", 61);
        gotoTable[94].put("STMT", 98);
        gotoTable[94].put("EXP", 56);
        gotoTable[94].put("IF_STMT", 57);
        gotoTable[94].put("WHILE_STMT", 58);
        gotoTable[94].put("FOR_STMT", 59);
        gotoTable[94].put("SWITCH_STMT", 60);
        
        actionTable[95] = new HashMap<>();
        actionTable[95].put("id", "s11");
        actionTable[95].put("number", "s12");
        actionTable[95].put("op1", "s13");
        gotoTable[95] = new HashMap<>();
        gotoTable[95].put("EXP", 99);
        
        actionTable[96] = new HashMap<>();
        actionTable[96].put("{", "s100");
        
        actionTable[97] = new HashMap<>();
        actionTable[97].put("type", "r42");
        actionTable[97].put("id", "r42");
        actionTable[97].put("{", "r42");
        actionTable[97].put("}", "r42");
        actionTable[97].put("return", "r42");
        actionTable[97].put("break", "r42");
        actionTable[97].put("number", "r42");
        actionTable[97].put("op1", "r42");
        actionTable[97].put("if", "r42");
        actionTable[97].put("else", "s102");
        actionTable[97].put("while", "r42");
        actionTable[97].put("for", "r42");
        actionTable[97].put("switch", "r42");
        actionTable[97].put("case", "r42");
        actionTable[97].put("default", "r42");
        gotoTable[97] = new HashMap<>();
        gotoTable[97].put("ELSE_STMT", 101);
        
        actionTable[98] = new HashMap<>();
        actionTable[98].put("type", "r43");
        actionTable[98].put("id", "r43");
        actionTable[98].put("{", "r43");
        actionTable[98].put("}", "r43");
        actionTable[98].put("return", "r43");
        actionTable[98].put("break", "r43");
        actionTable[98].put("number", "r43");
        actionTable[98].put("op1", "r43");
        actionTable[98].put("if", "r43");
        actionTable[98].put("else", "r43");
        actionTable[98].put("while", "r43");
        actionTable[98].put("for", "r43");
        actionTable[98].put("switch", "r43");
        actionTable[98].put("case", "r43");
        actionTable[98].put("default", "r43");
        
        actionTable[99] = new HashMap<>();
        actionTable[99].put(";", "s103");
        
        actionTable[100] = new HashMap<>();
        actionTable[100].put("type", "r47");
        actionTable[100].put("id", "r47");
        actionTable[100].put("{", "r47");
        actionTable[100].put("}", "r47");
        actionTable[100].put("return", "r47");
        actionTable[100].put("break", "r47");
        actionTable[100].put("number", "r47");
        actionTable[100].put("op1", "r47");
        actionTable[100].put("if", "r47");
        actionTable[100].put("else", "r47");
        actionTable[100].put("while", "r47");
        actionTable[100].put("for", "r47");
        actionTable[100].put("switch", "r47");
        actionTable[100].put("case", "s105");
        actionTable[100].put("default", "r47");
        gotoTable[100] = new HashMap<>();
        gotoTable[100].put("CASE_LIST", 104);
        
        actionTable[101] = new HashMap<>();
        actionTable[101].put("type", "r40");
        actionTable[101].put("id", "r40");
        actionTable[101].put("{", "r40");
        actionTable[101].put("}", "r40");
        actionTable[101].put("return", "r40");
        actionTable[101].put("break", "r40");
        actionTable[101].put("number", "r40");
        actionTable[101].put("op1", "r40");
        actionTable[101].put("if", "r40");
        actionTable[101].put("else", "r40");
        actionTable[101].put("while", "r40");
        actionTable[101].put("for", "r40");
        actionTable[101].put("switch", "r40");
        actionTable[101].put("case", "r40");
        actionTable[101].put("default", "r40");
        
        actionTable[102] = new HashMap<>();
        actionTable[102].put("type", "s55");
        actionTable[102].put("id", "s11");
        actionTable[102].put("{", "s42");
        actionTable[102].put("return", "s62");
        actionTable[102].put("break", "s63");
        actionTable[102].put("number", "s12");
        actionTable[102].put("op1", "s13");
        actionTable[102].put("if", "s64");
        actionTable[102].put("while", "s65");
        actionTable[102].put("for", "s66");
        actionTable[102].put("switch", "s67");
        gotoTable[102] = new HashMap<>();
        gotoTable[102].put("CMP_STMT", 61);
        gotoTable[102].put("STMT", 106);
        gotoTable[102].put("EXP", 56);
        gotoTable[102].put("IF_STMT", 57);
        gotoTable[102].put("WHILE_STMT", 58);
        gotoTable[102].put("FOR_STMT", 59);
        gotoTable[102].put("SWITCH_STMT", 60);
        
        actionTable[103] = new HashMap<>();
        actionTable[103].put("id", "s11");
        actionTable[103].put("number", "s12");
        actionTable[103].put("op1", "s13");
        gotoTable[103] = new HashMap<>();
        gotoTable[103].put("EXP", 107);
        
        actionTable[104] = new HashMap<>();
        actionTable[104].put("}", "r49");
        actionTable[104].put("default", "s109");
        gotoTable[104] = new HashMap<>();
        gotoTable[104].put("DEFA", 108);
        
        actionTable[105] = new HashMap<>();
        actionTable[105].put("id", "s11");
        actionTable[105].put("number", "s12");
        actionTable[105].put("op1", "s13");
        gotoTable[105] = new HashMap<>();
        gotoTable[105].put("EXP", 110);
        
        actionTable[106] = new HashMap<>();
        actionTable[106].put("type", "r41");
        actionTable[106].put("id", "r41");
        actionTable[106].put("{", "r41");
        actionTable[106].put("}", "r41");
        actionTable[106].put("return", "r41");
        actionTable[106].put("break", "r41");
        actionTable[106].put("number", "r41");
        actionTable[106].put("op1", "r41");
        actionTable[106].put("if", "r41");
        actionTable[106].put("else", "r41");
        actionTable[106].put("while", "r41");
        actionTable[106].put("for", "r41");
        actionTable[106].put("switch", "r41");
        actionTable[106].put("case", "r41");
        actionTable[106].put("default", "r41");
        
        actionTable[107] = new HashMap<>();
        actionTable[107].put(")", "s111");
        
        actionTable[108] = new HashMap<>();
        actionTable[108].put("}", "s112");
        
        actionTable[109] = new HashMap<>();
        actionTable[109].put(":", "s113");
        
        actionTable[110] = new HashMap<>();
        actionTable[110].put(":", "s114");
        
        actionTable[111] = new HashMap<>();
        actionTable[111].put("type", "s55");
        actionTable[111].put("id", "s11");
        actionTable[111].put("{", "s42");
        actionTable[111].put("return", "s62");
        actionTable[111].put("break", "s63");
        actionTable[111].put("number", "s12");
        actionTable[111].put("op1", "s13");
        actionTable[111].put("if", "s64");
        actionTable[111].put("while", "s65");
        actionTable[111].put("for", "s66");
        actionTable[111].put("switch", "s67");
        gotoTable[111] = new HashMap<>();
        gotoTable[111].put("CMP_STMT", 61);
        gotoTable[111].put("STMT", 115);
        gotoTable[111].put("EXP", 56);
        gotoTable[111].put("IF_STMT", 57);
        gotoTable[111].put("WHILE_STMT", 58);
        gotoTable[111].put("FOR_STMT", 59);
        gotoTable[111].put("SWITCH_STMT", 60);
        
        actionTable[112] = new HashMap<>();
        actionTable[112].put("type", "r45");
        actionTable[112].put("id", "r45");
        actionTable[112].put("{", "r45");
        actionTable[112].put("}", "r45");
        actionTable[112].put("return", "r45");
        actionTable[112].put("break", "r45");
        actionTable[112].put("number", "r45");
        actionTable[112].put("op1", "r45");
        actionTable[112].put("if", "r45");
        actionTable[112].put("else", "r45");
        actionTable[112].put("while", "r45");
        actionTable[112].put("for", "r45");
        actionTable[112].put("switch", "r45");
        actionTable[112].put("case", "r45");
        actionTable[112].put("default", "r45");
        
        actionTable[113] = new HashMap<>();
        actionTable[113].put("type", "s55");
        actionTable[113].put("id", "s11");
        actionTable[113].put("{", "s42");
        actionTable[113].put("return", "s62");
        actionTable[113].put("break", "s63");
        actionTable[113].put("number", "s12");
        actionTable[113].put("op1", "s13");
        actionTable[113].put("if", "s64");
        actionTable[113].put("while", "s65");
        actionTable[113].put("for", "s66");
        actionTable[113].put("switch", "s67");
        gotoTable[113] = new HashMap<>();
        gotoTable[113].put("CMP_STMT", 61);
        gotoTable[113].put("STMT", 116);
        gotoTable[113].put("EXP", 56);
        gotoTable[113].put("IF_STMT", 57);
        gotoTable[113].put("WHILE_STMT", 58);
        gotoTable[113].put("FOR_STMT", 59);
        gotoTable[113].put("SWITCH_STMT", 60);
        
        actionTable[114] = new HashMap<>();
        actionTable[114].put("type", "s55");
        actionTable[114].put("id", "s11");
        actionTable[114].put("{", "s42");
        actionTable[114].put("return", "s62");
        actionTable[114].put("break", "s63");
        actionTable[114].put("number", "s12");
        actionTable[114].put("op1", "s13");
        actionTable[114].put("if", "s64");
        actionTable[114].put("while", "s65");
        actionTable[114].put("for", "s66");
        actionTable[114].put("switch", "s67");
        gotoTable[114] = new HashMap<>();
        gotoTable[114].put("CMP_STMT", 61);
        gotoTable[114].put("STMT", 117);
        gotoTable[114].put("EXP", 56);
        gotoTable[114].put("IF_STMT", 57);
        gotoTable[114].put("WHILE_STMT", 58);
        gotoTable[114].put("FOR_STMT", 59);
        gotoTable[114].put("SWITCH_STMT", 60);
        
        actionTable[115] = new HashMap<>();
        actionTable[115].put("type", "r44");
        actionTable[115].put("id", "r44");
        actionTable[115].put("{", "r44");
        actionTable[115].put("}", "r44");
        actionTable[115].put("return", "r44");
        actionTable[115].put("break", "r44");
        actionTable[115].put("number", "r44");
        actionTable[115].put("op1", "r44");
        actionTable[115].put("if", "r44");
        actionTable[115].put("else", "r44");
        actionTable[115].put("while", "r44");
        actionTable[115].put("for", "r44");
        actionTable[115].put("switch", "r44");
        actionTable[115].put("case", "r44");
        actionTable[115].put("default", "r44");
        
        actionTable[116] = new HashMap<>();
        actionTable[116].put("}", "r48");
        
        actionTable[117] = new HashMap<>();
        actionTable[117].put("type", "r47");
        actionTable[117].put("id", "r47");
        actionTable[117].put("{", "r47");
        actionTable[117].put("}", "r47");
        actionTable[117].put("return", "r47");
        actionTable[117].put("break", "r47");
        actionTable[117].put("number", "r47");
        actionTable[117].put("op1", "r47");
        actionTable[117].put("if", "r47");
        actionTable[117].put("else", "r47");
        actionTable[117].put("while", "r47");
        actionTable[117].put("for", "r47");
        actionTable[117].put("switch", "r47");
        actionTable[117].put("case", "s105");
        actionTable[117].put("default", "r47");
        gotoTable[117] = new HashMap<>();
        gotoTable[117].put("CASE_LIST", 118);
        
        actionTable[118] = new HashMap<>();
        actionTable[118].put("type", "r46");
        actionTable[118].put("id", "r46");
        actionTable[118].put("{", "r46");
        actionTable[118].put("}", "r46");
        actionTable[118].put("return", "r46");
        actionTable[118].put("break", "r46");
        actionTable[118].put("number", "r46");
        actionTable[118].put("op1", "r46");
        actionTable[118].put("if", "r46");
        actionTable[118].put("else", "r46");
        actionTable[118].put("while", "r46");
        actionTable[118].put("for", "r46");
        actionTable[118].put("switch", "r46");
        actionTable[118].put("case", "r46");
        actionTable[118].put("default", "r46");
        
        
        

    }
}
