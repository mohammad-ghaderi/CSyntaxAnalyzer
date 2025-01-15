import java.util.*;

public class SLRTable {
    
    public static final List<GrammarRule> grammar = Arrays.asList(
        new GrammarRule("S'", Arrays.asList("S")),
        new GrammarRule("S", Arrays.asList("typ", "i", "DEC", "S")),
        new GrammarRule("S", Arrays.asList(null)),
        new GrammarRule("DECL", Arrays.asList("EX", "VAR_REST")),
        new GrammarRule("DECL", Arrays.asList("", "PARAM", "", "CMP_STMT")),
        new GrammarRule("DECL", Arrays.asList("", "EX", "", "VAR_REST")),
        new GrammarRule("DECL", Arrays.asList("", "i", "VAR_RES", "")),
        new GrammarRule("VAR_REST", Arrays.asList("", "i", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList("", "EX", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList("", "EX", "", "VAR_REST")),
        new GrammarRule("VAR_REST", Arrays.asList(";")),
        new GrammarRule("PARAMS", Arrays.asList("typ", "i", "PAR_REST")),
        new GrammarRule("PARAMS", Arrays.asList(null)),
        new GrammarRule("PAR_REST", Arrays.asList("", "typ", "i", "PAR_REST")),
        new GrammarRule("PAR_REST", Arrays.asList("", "EX", "", "PAR_REST")),
        new GrammarRule("PAR_REST", Arrays.asList(null)),
        new GrammarRule("CMP_STMT", Arrays.asList("", "STMT_LIS", "}")),
        new GrammarRule("STMT_LIST", Arrays.asList("STM", "STMT_LIST")),
        new GrammarRule("STMT_LIST", Arrays.asList(null)),
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
        new GrammarRule("EXP", Arrays.asList("numbe", "op", "EXP")),
        new GrammarRule("EXP", Arrays.asList("op", "EXP")),
        new GrammarRule("IDEXP", Arrays.asList("op", "EXP")),
        new GrammarRule("IDEXP", Arrays.asList("", "ARG", ")")),
        new GrammarRule("IDEXP", Arrays.asList("VAR_REST")),
        new GrammarRule("ARGS", Arrays.asList("EX", "ARG_REST")),
        new GrammarRule("ARGS", Arrays.asList(null)),
        new GrammarRule("ARG_REST", Arrays.asList("", "EX", "ARG_REST")),
        new GrammarRule("ARG_REST", Arrays.asList(null)),
        new GrammarRule("IF_STMT", Arrays.asList("i", "", "EX", "", "STM", "ELSE_STMT")),
        new GrammarRule("ELSE_STMT", Arrays.asList("els", "STMT")),
        new GrammarRule("ELSE_STMT", Arrays.asList(null)),
        new GrammarRule("WHILE_STMT", Arrays.asList("whil", "", "EX", "", "STMT")),
        new GrammarRule("FOR_STMT", Arrays.asList("fo", "", "EX", "", "EX", "", "EX", "", "STMT")),
        new GrammarRule("SWITCH_STMT", Arrays.asList("switc", "", "EX", "", "", "CASE_LIS", "DEF", "}")),
        new GrammarRule("CASE_LIST", Arrays.asList("cas", "EX", "", "STM", "CASE_LIST")),
        new GrammarRule("CASE_LIST", Arrays.asList(null)),
        new GrammarRule("DEFA", Arrays.asList("defaul", "", "STMT")),
        new GrammarRule("DEFA", Arrays.asList("'"))
        
    );

    // Action table as an array of maps (index is the state number)
    public static final Map<String, String>[] actionTable = new Map[6]; // Example for 6 states

    // Goto table as an array of maps (index is the state number)
    public static final Map<String, Integer>[] gotoTable = new Map[6]; // Example for 6 states


    static {
        
        actionTable[0] = new HashMap<>();
        actionTable[0].put("type", "s2");
        actionTable[0].put("$", "r2");
        actionTable[0].put("S", "1");

        actionTable[1] = new HashMap<>();
        actionTable[1].put("$", "acc");

        actionTable[2] = new HashMap<>();
        actionTable[2].put("id", "s3");

        actionTable[3] = new HashMap<>();
        actionTable[3].put("id", "s9");
        actionTable[3].put("(", "s6");
        actionTable[3].put("[", "s7");
        actionTable[3].put(",", "s8");
        actionTable[3].put("number", "s10");
        actionTable[3].put("op1", "s11");
        actionTable[3].put("DECL", "4");
        actionTable[3].put("EXP", "5");

        actionTable[4] = new HashMap<>();
        actionTable[4].put("type", "s2");
        actionTable[4].put("$", "r2");
        actionTable[4].put("S", "12");

        actionTable[5] = new HashMap<>();
        actionTable[5].put("[", "s16");
        actionTable[5].put(",", "s14");
        actionTable[5].put("=", "s15");
        actionTable[5].put(";", "s17");
        actionTable[5].put("VAR_REST", "13");

        actionTable[6] = new HashMap<>();
        actionTable[6].put("type", "s19");
        actionTable[6].put(")", "r12");
        actionTable[6].put("PARAMS", "18");

        actionTable[7] = new HashMap<>();
        actionTable[7].put("id", "s9");
        actionTable[7].put("number", "s10");
        actionTable[7].put("op1", "s11");
        actionTable[7].put("EXP", "20");

        actionTable[8] = new HashMap<>();
        actionTable[8].put("id", "s21");

        actionTable[9] = new HashMap<>();
        actionTable[9].put("(", "s24");
        actionTable[9].put("[", "s16");
        actionTable[9].put(",", "s14");
        actionTable[9].put("=", "s15");
        actionTable[9].put(";", "s17");
        actionTable[9].put("op2", "s23");
        actionTable[9].put("VAR_REST", "25");
        actionTable[9].put("IDEXP", "22");

        actionTable[10] = new HashMap<>();
        actionTable[10].put("op2", "s26");

        actionTable[11] = new HashMap<>();
        actionTable[11].put("id", "s9");
        actionTable[11].put("number", "s10");
        actionTable[11].put("op1", "s11");
        actionTable[11].put("EXP", "27");

        actionTable[12] = new HashMap<>();
        actionTable[12].put("$", "r1");

        actionTable[13] = new HashMap<>();
        actionTable[13].put("type", "r3");
        actionTable[13].put("id", "r3");
        actionTable[13].put("{", "r3");
        actionTable[13].put("}", "r3");
        actionTable[13].put("return", "r3");
        actionTable[13].put("break", "r3");
        actionTable[13].put("number", "r3");
        actionTable[13].put("op1", "r3");
        actionTable[13].put("if", "r3");
        actionTable[13].put("else", "r3");
        actionTable[13].put("while", "r3");
        actionTable[13].put("for", "r3");
        actionTable[13].put("switch", "r3");
        actionTable[13].put("case", "r3");
        actionTable[13].put("default", "r3");
        actionTable[13].put("$", "r3");

        actionTable[14] = new HashMap<>();
        actionTable[14].put("id", "s28");

        actionTable[15] = new HashMap<>();
        actionTable[15].put("id", "s9");
        actionTable[15].put("number", "s10");
        actionTable[15].put("op1", "s11");
        actionTable[15].put("EXP", "29");

        actionTable[16] = new HashMap<>();
        actionTable[16].put("id", "s9");
        actionTable[16].put("number", "s10");
        actionTable[16].put("op1", "s11");
        actionTable[16].put("EXP", "30");

        actionTable[17] = new HashMap<>();
        actionTable[17].put("type", "r10");
        actionTable[17].put("id", "r10");
        actionTable[17].put(")", "r10");
        actionTable[17].put("[", "r10");
        actionTable[17].put("]", "r10");
        actionTable[17].put(",", "r10");
        actionTable[17].put("=", "r10");
        actionTable[17].put(";", "r10");
        actionTable[17].put("{", "r10");
        actionTable[17].put("}", "r10");
        actionTable[17].put("return", "r10");
        actionTable[17].put("break", "r10");
        actionTable[17].put("number", "r10");
        actionTable[17].put("op1", "r10");
        actionTable[17].put("if", "r10");
        actionTable[17].put("else", "r10");
        actionTable[17].put("while", "r10");
        actionTable[17].put("for", "r10");
        actionTable[17].put("switch", "r10");
        actionTable[17].put("case", "r10");
        actionTable[17].put(":", "r10");
        actionTable[17].put("default", "r10");
        actionTable[17].put("$", "r10");

        actionTable[18] = new HashMap<>();
        actionTable[18].put(")", "s31");

        actionTable[19] = new HashMap<>();
        actionTable[19].put("id", "s32");

        actionTable[20] = new HashMap<>();
        actionTable[20].put("]", "s33");

        actionTable[21] = new HashMap<>();
        actionTable[21].put("[", "s16");
        actionTable[21].put(",", "s14");
        actionTable[21].put("=", "s15");
        actionTable[21].put(";", "s17");
        actionTable[21].put("VAR_REST", "34");

        actionTable[22] = new HashMap<>();
        actionTable[22].put(")", "r28");
        actionTable[22].put("[", "r28");
        actionTable[22].put("]", "r28");
        actionTable[22].put(",", "r28");
        actionTable[22].put("=", "r28");
        actionTable[22].put(";", "r28");
        actionTable[22].put(":", "r28");

        actionTable[23] = new HashMap<>();
        actionTable[23].put("id", "s9");
        actionTable[23].put("number", "s10");
        actionTable[23].put("op1", "s11");
        actionTable[23].put("EXP", "35");

        actionTable[24] = new HashMap<>();
        actionTable[24].put("id", "s9");
        actionTable[24].put(")", "r35");
        actionTable[24].put("number", "s10");
        actionTable[24].put("op1", "s11");
        actionTable[24].put("EXP", "37");
        actionTable[24].put("ARGS", "36");

        actionTable[25] = new HashMap<>();
        actionTable[25].put(")", "r33");
        actionTable[25].put("[", "r33");
        actionTable[25].put("]", "r33");
        actionTable[25].put(",", "r33");
        actionTable[25].put("=", "r33");
        actionTable[25].put(";", "r33");
        actionTable[25].put(":", "r33");

        actionTable[26] = new HashMap<>();
        actionTable[26].put("id", "s9");
        actionTable[26].put("number", "s10");
        actionTable[26].put("op1", "s11");
        actionTable[26].put("EXP", "38");

        actionTable[27] = new HashMap<>();
        actionTable[27].put(")", "r30");
        actionTable[27].put("[", "r30");
        actionTable[27].put("]", "r30");
        actionTable[27].put(",", "r30");
        actionTable[27].put("=", "r30");
        actionTable[27].put(";", "r30");
        actionTable[27].put(":", "r30");

        actionTable[28] = new HashMap<>();
        actionTable[28].put("[", "s16");
        actionTable[28].put(",", "s14");
        actionTable[28].put("=", "s15");
        actionTable[28].put(";", "s17");
        actionTable[28].put("VAR_REST", "39");

        actionTable[29] = new HashMap<>();
        actionTable[29].put("[", "s16");
        actionTable[29].put(",", "s14");
        actionTable[29].put("=", "s15");
        actionTable[29].put(";", "s17");
        actionTable[29].put("VAR_REST", "40");

        actionTable[30] = new HashMap<>();
        actionTable[30].put("]", "s41");

        actionTable[31] = new HashMap<>();
        actionTable[31].put("{", "s43");
        actionTable[31].put("CMP_STMT", "42");

        actionTable[32] = new HashMap<>();
        actionTable[32].put(")", "r15");
        actionTable[32].put("[", "s46");
        actionTable[32].put(",", "s45");
        actionTable[32].put("PAR_REST", "44");

        actionTable[33] = new HashMap<>();
        actionTable[33].put("[", "s16");
        actionTable[33].put(",", "s14");
        actionTable[33].put("=", "s15");
        actionTable[33].put(";", "s17");
        actionTable[33].put("VAR_REST", "47");

        actionTable[34] = new HashMap<>();
        actionTable[34].put("type", "r6");
        actionTable[34].put("id", "r6");
        actionTable[34].put("{", "r6");
        actionTable[34].put("}", "r6");
        actionTable[34].put("return", "r6");
        actionTable[34].put("break", "r6");
        actionTable[34].put("number", "r6");
        actionTable[34].put("op1", "r6");
        actionTable[34].put("if", "r6");
        actionTable[34].put("else", "r6");
        actionTable[34].put("while", "r6");
        actionTable[34].put("for", "r6");
        actionTable[34].put("switch", "r6");
        actionTable[34].put("case", "r6");
        actionTable[34].put("default", "r6");
        actionTable[34].put("$", "r6");

        actionTable[35] = new HashMap<>();
        actionTable[35].put(")", "r31");
        actionTable[35].put("[", "r31");
        actionTable[35].put("]", "r31");
        actionTable[35].put(",", "r31");
        actionTable[35].put("=", "r31");
        actionTable[35].put(";", "r31");
        actionTable[35].put(":", "r31");

        actionTable[36] = new HashMap<>();
        actionTable[36].put(")", "s48");

        actionTable[37] = new HashMap<>();
        actionTable[37].put(")", "r37");
        actionTable[37].put(",", "s50");
        actionTable[37].put("ARG_REST", "49");

        actionTable[38] = new HashMap<>();
        actionTable[38].put(")", "r29");
        actionTable[38].put("[", "r29");
        actionTable[38].put("]", "r29");
        actionTable[38].put(",", "r29");
        actionTable[38].put("=", "r29");
        actionTable[38].put(";", "r29");
        actionTable[38].put(":", "r29");

        actionTable[39] = new HashMap<>();
        actionTable[39].put("type", "r7");
        actionTable[39].put("id", "r7");
        actionTable[39].put(")", "r7");
        actionTable[39].put("[", "r7");
        actionTable[39].put("]", "r7");
        actionTable[39].put(",", "r7");
        actionTable[39].put("=", "r7");
        actionTable[39].put(";", "r7");
        actionTable[39].put("{", "r7");
        actionTable[39].put("}", "r7");
        actionTable[39].put("return", "r7");
        actionTable[39].put("break", "r7");
        actionTable[39].put("number", "r7");
        actionTable[39].put("op1", "r7");
        actionTable[39].put("if", "r7");
        actionTable[39].put("else", "r7");
        actionTable[39].put("while", "r7");
        actionTable[39].put("for", "r7");
        actionTable[39].put("switch", "r7");
        actionTable[39].put("case", "r7");
        actionTable[39].put(":", "r7");
        actionTable[39].put("default", "r7");
        actionTable[39].put("$", "r7");

        actionTable[40] = new HashMap<>();
        actionTable[40].put("type", "r8");
        actionTable[40].put("id", "r8");
        actionTable[40].put(")", "r8");
        actionTable[40].put("[", "r8");
        actionTable[40].put("]", "r8");
        actionTable[40].put(",", "r8");
        actionTable[40].put("=", "r8");
        actionTable[40].put(";", "r8");
        actionTable[40].put("{", "r8");
        actionTable[40].put("}", "r8");
        actionTable[40].put("return", "r8");
        actionTable[40].put("break", "r8");
        actionTable[40].put("number", "r8");
        actionTable[40].put("op1", "r8");
        actionTable[40].put("if", "r8");
        actionTable[40].put("else", "r8");
        actionTable[40].put("while", "r8");
        actionTable[40].put("for", "r8");
        actionTable[40].put("switch", "r8");
        actionTable[40].put("case", "r8");
        actionTable[40].put(":", "r8");
        actionTable[40].put("default", "r8");
        actionTable[40].put("$", "r8");

        actionTable[41] = new HashMap<>();
        actionTable[41].put("[", "s16");
        actionTable[41].put(",", "s14");
        actionTable[41].put("=", "s15");
        actionTable[41].put(";", "s17");
        actionTable[41].put("VAR_REST", "51");

        actionTable[42] = new HashMap<>();
        actionTable[42].put("type", "r4");
        actionTable[42].put("id", "r4");
        actionTable[42].put("{", "r4");
        actionTable[42].put("}", "r4");
        actionTable[42].put("return", "r4");
        actionTable[42].put("break", "r4");
        actionTable[42].put("number", "r4");
        actionTable[42].put("op1", "r4");
        actionTable[42].put("if", "r4");
        actionTable[42].put("else", "r4");
        actionTable[42].put("while", "r4");
        actionTable[42].put("for", "r4");
        actionTable[42].put("switch", "r4");
        actionTable[42].put("case", "r4");
        actionTable[42].put("default", "r4");
        actionTable[42].put("$", "r4");

        actionTable[43] = new HashMap<>();
        actionTable[43].put("type", "s54");
        actionTable[43].put("id", "s9");
        actionTable[43].put("{", "s43");
        actionTable[43].put("}", "r18");
        actionTable[43].put("return", "s61");
        actionTable[43].put("break", "s62");
        actionTable[43].put("number", "s10");
        actionTable[43].put("op1", "s11");
        actionTable[43].put("if", "s63");
        actionTable[43].put("while", "s64");
        actionTable[43].put("for", "s65");
        actionTable[43].put("switch", "s66");
        actionTable[43].put("CMP_STMT", "60");
        actionTable[43].put("STMT_LIST", "52");
        actionTable[43].put("STMT", "53");
        actionTable[43].put("EXP", "55");
        actionTable[43].put("IF_STMT", "56");
        actionTable[43].put("WHILE_STMT", "57");
        actionTable[43].put("FOR_STMT", "58");
        actionTable[43].put("SWITCH_STMT", "59");

        actionTable[44] = new HashMap<>();
        actionTable[44].put(")", "r11");

        actionTable[45] = new HashMap<>();
        actionTable[45].put("type", "s67");

        actionTable[46] = new HashMap<>();
        actionTable[46].put("id", "s9");
        actionTable[46].put("number", "s10");
        actionTable[46].put("op1", "s11");
        actionTable[46].put("EXP", "68");

        actionTable[47] = new HashMap<>();
        actionTable[47].put("type", "r5");
        actionTable[47].put("id", "r5");
        actionTable[47].put("{", "r5");
        actionTable[47].put("}", "r5");
        actionTable[47].put("return", "r5");
        actionTable[47].put("break", "r5");
        actionTable[47].put("number", "r5");
        actionTable[47].put("op1", "r5");
        actionTable[47].put("if", "r5");
        actionTable[47].put("else", "r5");
        actionTable[47].put("while", "r5");
        actionTable[47].put("for", "r5");
        actionTable[47].put("switch", "r5");
        actionTable[47].put("case", "r5");
        actionTable[47].put("default", "r5");
        actionTable[47].put("$", "r5");

        actionTable[48] = new HashMap<>();
        actionTable[48].put(")", "r32");
        actionTable[48].put("[", "r32");
        actionTable[48].put("]", "r32");
        actionTable[48].put(",", "r32");
        actionTable[48].put("=", "r32");
        actionTable[48].put(";", "r32");
        actionTable[48].put(":", "r32");

        actionTable[49] = new HashMap<>();
        actionTable[49].put(")", "r34");

        actionTable[50] = new HashMap<>();
        actionTable[50].put("id", "s9");
        actionTable[50].put("number", "s10");
        actionTable[50].put("op1", "s11");
        actionTable[50].put("EXP", "69");

        actionTable[51] = new HashMap<>();
        actionTable[51].put("type", "r9");
        actionTable[51].put("id", "r9");
        actionTable[51].put(")", "r9");
        actionTable[51].put("[", "r9");
        actionTable[51].put("]", "r9");
        actionTable[51].put(",", "r9");
        actionTable[51].put("=", "r9");
        actionTable[51].put(";", "r9");
        actionTable[51].put("{", "r9");
        actionTable[51].put("}", "r9");
        actionTable[51].put("return", "r9");
        actionTable[51].put("break", "r9");
        actionTable[51].put("number", "r9");
        actionTable[51].put("op1", "r9");
        actionTable[51].put("if", "r9");
        actionTable[51].put("else", "r9");
        actionTable[51].put("while", "r9");
        actionTable[51].put("for", "r9");
        actionTable[51].put("switch", "r9");
        actionTable[51].put("case", "r9");
        actionTable[51].put(":", "r9");
        actionTable[51].put("default", "r9");
        actionTable[51].put("$", "r9");

        actionTable[52] = new HashMap<>();
        actionTable[52].put("}", "s70");

        actionTable[53] = new HashMap<>();
        actionTable[53].put("type", "s54");
        actionTable[53].put("id", "s9");
        actionTable[53].put("{", "s43");
        actionTable[53].put("}", "r18");
        actionTable[53].put("return", "s61");
        actionTable[53].put("break", "s62");
        actionTable[53].put("number", "s10");
        actionTable[53].put("op1", "s11");
        actionTable[53].put("if", "s63");
        actionTable[53].put("while", "s64");
        actionTable[53].put("for", "s65");
        actionTable[53].put("switch", "s66");
        actionTable[53].put("CMP_STMT", "60");
        actionTable[53].put("STMT_LIST", "71");
        actionTable[53].put("STMT", "53");
        actionTable[53].put("EXP", "55");
        actionTable[53].put("IF_STMT", "56");
        actionTable[53].put("WHILE_STMT", "57");
        actionTable[53].put("FOR_STMT", "58");
        actionTable[53].put("SWITCH_STMT", "59");

        actionTable[54] = new HashMap<>();
        actionTable[54].put("id", "s72");

        actionTable[55] = new HashMap<>();
        actionTable[55].put(";", "s73");

        actionTable[56] = new HashMap<>();
        actionTable[56].put("type", "r21");
        actionTable[56].put("id", "r21");
        actionTable[56].put("{", "r21");
        actionTable[56].put("}", "r21");
        actionTable[56].put("return", "r21");
        actionTable[56].put("break", "r21");
        actionTable[56].put("number", "r21");
        actionTable[56].put("op1", "r21");
        actionTable[56].put("if", "r21");
        actionTable[56].put("else", "r21");
        actionTable[56].put("while", "r21");
        actionTable[56].put("for", "r21");
        actionTable[56].put("switch", "r21");
        actionTable[56].put("case", "r21");
        actionTable[56].put("default", "r21");

        actionTable[57] = new HashMap<>();
        actionTable[57].put("type", "r22");
        actionTable[57].put("id", "r22");
        actionTable[57].put("{", "r22");
        actionTable[57].put("}", "r22");
        actionTable[57].put("return", "r22");
        actionTable[57].put("break", "r22");
        actionTable[57].put("number", "r22");
        actionTable[57].put("op1", "r22");
        actionTable[57].put("if", "r22");
        actionTable[57].put("else", "r22");
        actionTable[57].put("while", "r22");
        actionTable[57].put("for", "r22");
        actionTable[57].put("switch", "r22");
        actionTable[57].put("case", "r22");
        actionTable[57].put("default", "r22");

        actionTable[58] = new HashMap<>();
        actionTable[58].put("type", "r23");
        actionTable[58].put("id", "r23");
        actionTable[58].put("{", "r23");
        actionTable[58].put("}", "r23");
        actionTable[58].put("return", "r23");
        actionTable[58].put("break", "r23");
        actionTable[58].put("number", "r23");
        actionTable[58].put("op1", "r23");
        actionTable[58].put("if", "r23");
        actionTable[58].put("else", "r23");
        actionTable[58].put("while", "r23");
        actionTable[58].put("for", "r23");
        actionTable[58].put("switch", "r23");
        actionTable[58].put("case", "r23");
        actionTable[58].put("default", "r23");

        actionTable[59] = new HashMap<>();
        actionTable[59].put("type", "r24");
        actionTable[59].put("id", "r24");
        actionTable[59].put("{", "r24");
        actionTable[59].put("}", "r24");
        actionTable[59].put("return", "r24");
        actionTable[59].put("break", "r24");
        actionTable[59].put("number", "r24");
        actionTable[59].put("op1", "r24");
        actionTable[59].put("if", "r24");
        actionTable[59].put("else", "r24");
        actionTable[59].put("while", "r24");
        actionTable[59].put("for", "r24");
        actionTable[59].put("switch", "r24");
        actionTable[59].put("case", "r24");
        actionTable[59].put("default", "r24");

        actionTable[60] = new HashMap<>();
        actionTable[60].put("type", "r25");
        actionTable[60].put("id", "r25");
        actionTable[60].put("{", "r25");
        actionTable[60].put("}", "r25");
        actionTable[60].put("return", "r25");
        actionTable[60].put("break", "r25");
        actionTable[60].put("number", "r25");
        actionTable[60].put("op1", "r25");
        actionTable[60].put("if", "r25");
        actionTable[60].put("else", "r25");
        actionTable[60].put("while", "r25");
        actionTable[60].put("for", "r25");
        actionTable[60].put("switch", "r25");
        actionTable[60].put("case", "r25");
        actionTable[60].put("default", "r25");

        actionTable[61] = new HashMap<>();
        actionTable[61].put("id", "s9");
        actionTable[61].put("number", "s10");
        actionTable[61].put("op1", "s11");
        actionTable[61].put("EXP", "74");

        actionTable[62] = new HashMap<>();
        actionTable[62].put(";", "s75");

        actionTable[63] = new HashMap<>();
        actionTable[63].put("(", "s76");

        actionTable[64] = new HashMap<>();
        actionTable[64].put("(", "s77");

        actionTable[65] = new HashMap<>();
        actionTable[65].put("(", "s78");

        actionTable[66] = new HashMap<>();
        actionTable[66].put("(", "s79");

        actionTable[67] = new HashMap<>();
        actionTable[67].put("id", "s80");

        actionTable[68] = new HashMap<>();
        actionTable[68].put("]", "s81");

        actionTable[69] = new HashMap<>();
        actionTable[69].put(")", "r37");
        actionTable[69].put(",", "s50");
        actionTable[69].put("ARG_REST", "82");

        actionTable[70] = new HashMap<>();
        actionTable[70].put("type", "r16");
        actionTable[70].put("id", "r16");
        actionTable[70].put("{", "r16");
        actionTable[70].put("}", "r16");
        actionTable[70].put("return", "r16");
        actionTable[70].put("break", "r16");
        actionTable[70].put("number", "r16");
        actionTable[70].put("op1", "r16");
        actionTable[70].put("if", "r16");
        actionTable[70].put("else", "r16");
        actionTable[70].put("while", "r16");
        actionTable[70].put("for", "r16");
        actionTable[70].put("switch", "r16");
        actionTable[70].put("case", "r16");
        actionTable[70].put("default", "r16");
        actionTable[70].put("$", "r16");

        actionTable[71] = new HashMap<>();
        actionTable[71].put("}", "r17");

        actionTable[72] = new HashMap<>();
        actionTable[72].put("id", "s9");
        actionTable[72].put("(", "s6");
        actionTable[72].put("[", "s7");
        actionTable[72].put(",", "s8");
        actionTable[72].put("number", "s10");
        actionTable[72].put("op1", "s11");
        actionTable[72].put("DECL", "83");
        actionTable[72].put("EXP", "5");

        actionTable[73] = new HashMap<>();
        actionTable[73].put("type", "r20");
        actionTable[73].put("id", "r20");
        actionTable[73].put("{", "r20");
        actionTable[73].put("}", "r20");
        actionTable[73].put("return", "r20");
        actionTable[73].put("break", "r20");
        actionTable[73].put("number", "r20");
        actionTable[73].put("op1", "r20");
        actionTable[73].put("if", "r20");
        actionTable[73].put("else", "r20");
        actionTable[73].put("while", "r20");
        actionTable[73].put("for", "r20");
        actionTable[73].put("switch", "r20");
        actionTable[73].put("case", "r20");
        actionTable[73].put("default", "r20");

        actionTable[74] = new HashMap<>();
        actionTable[74].put(";", "s84");

        actionTable[75] = new HashMap<>();
        actionTable[75].put("type", "r27");
        actionTable[75].put("id", "r27");
        actionTable[75].put("{", "r27");
        actionTable[75].put("}", "r27");
        actionTable[75].put("return", "r27");
        actionTable[75].put("break", "r27");
        actionTable[75].put("number", "r27");
        actionTable[75].put("op1", "r27");
        actionTable[75].put("if", "r27");
        actionTable[75].put("else", "r27");
        actionTable[75].put("while", "r27");
        actionTable[75].put("for", "r27");
        actionTable[75].put("switch", "r27");
        actionTable[75].put("case", "r27");
        actionTable[75].put("default", "r27");

        actionTable[76] = new HashMap<>();
        actionTable[76].put("id", "s9");
        actionTable[76].put("number", "s10");
        actionTable[76].put("op1", "s11");
        actionTable[76].put("EXP", "85");

        actionTable[77] = new HashMap<>();
        actionTable[77].put("id", "s9");
        actionTable[77].put("number", "s10");
        actionTable[77].put("op1", "s11");
        actionTable[77].put("EXP", "86");

        actionTable[78] = new HashMap<>();
        actionTable[78].put("id", "s9");
        actionTable[78].put("number", "s10");
        actionTable[78].put("op1", "s11");
        actionTable[78].put("EXP", "87");

        actionTable[79] = new HashMap<>();
        actionTable[79].put("id", "s9");
        actionTable[79].put("number", "s10");
        actionTable[79].put("op1", "s11");
        actionTable[79].put("EXP", "88");

        actionTable[80] = new HashMap<>();
        actionTable[80].put(")", "r15");
        actionTable[80].put("[", "s46");
        actionTable[80].put(",", "s45");
        actionTable[80].put("PAR_REST", "89");

        actionTable[81] = new HashMap<>();
        actionTable[81].put(")", "r15");
        actionTable[81].put("[", "s46");
        actionTable[81].put(",", "s45");
        actionTable[81].put("PAR_REST", "90");

        actionTable[82] = new HashMap<>();
        actionTable[82].put(")", "r36");

        actionTable[83] = new HashMap<>();
        actionTable[83].put("type", "r19");
        actionTable[83].put("id", "r19");
        actionTable[83].put("{", "r19");
        actionTable[83].put("}", "r19");
        actionTable[83].put("return", "r19");
        actionTable[83].put("break", "r19");
        actionTable[83].put("number", "r19");
        actionTable[83].put("op1", "r19");
        actionTable[83].put("if", "r19");
        actionTable[83].put("else", "r19");
        actionTable[83].put("while", "r19");
        actionTable[83].put("for", "r19");
        actionTable[83].put("switch", "r19");
        actionTable[83].put("case", "r19");
        actionTable[83].put("default", "r19");

        actionTable[84] = new HashMap<>();
        actionTable[84].put("type", "r26");
        actionTable[84].put("id", "r26");
        actionTable[84].put("{", "r26");
        actionTable[84].put("}", "r26");
        actionTable[84].put("return", "r26");
        actionTable[84].put("break", "r26");
        actionTable[84].put("number", "r26");
        actionTable[84].put("op1", "r26");
        actionTable[84].put("if", "r26");
        actionTable[84].put("else", "r26");
        actionTable[84].put("while", "r26");
        actionTable[84].put("for", "r26");
        actionTable[84].put("switch", "r26");
        actionTable[84].put("case", "r26");
        actionTable[84].put("default", "r26");

        actionTable[85] = new HashMap<>();
        actionTable[85].put(")", "s91");

        actionTable[86] = new HashMap<>();
        actionTable[86].put(")", "s92");

        actionTable[87] = new HashMap<>();
        actionTable[87].put(";", "s93");

        actionTable[88] = new HashMap<>();
        actionTable[88].put(")", "s94");

        actionTable[89] = new HashMap<>();
        actionTable[89].put(")", "r13");

        actionTable[90] = new HashMap<>();
        actionTable[90].put(")", "r14");

        actionTable[91] = new HashMap<>();
        actionTable[91].put("type", "s54");
        actionTable[91].put("id", "s9");
        actionTable[91].put("{", "s43");
        actionTable[91].put("return", "s61");
        actionTable[91].put("break", "s62");
        actionTable[91].put("number", "s10");
        actionTable[91].put("op1", "s11");
        actionTable[91].put("if", "s63");
        actionTable[91].put("while", "s64");
        actionTable[91].put("for", "s65");
        actionTable[91].put("switch", "s66");
        actionTable[91].put("CMP_STMT", "60");
        actionTable[91].put("STMT", "95");
        actionTable[91].put("EXP", "55");
        actionTable[91].put("IF_STMT", "56");
        actionTable[91].put("WHILE_STMT", "57");
        actionTable[91].put("FOR_STMT", "58");
        actionTable[91].put("SWITCH_STMT", "59");

        actionTable[92] = new HashMap<>();
        actionTable[92].put("type", "s54");
        actionTable[92].put("id", "s9");
        actionTable[92].put("{", "s43");
        actionTable[92].put("return", "s61");
        actionTable[92].put("break", "s62");
        actionTable[92].put("number", "s10");
        actionTable[92].put("op1", "s11");
        actionTable[92].put("if", "s63");
        actionTable[92].put("while", "s64");
        actionTable[92].put("for", "s65");
        actionTable[92].put("switch", "s66");
        actionTable[92].put("CMP_STMT", "60");
        actionTable[92].put("STMT", "96");
        actionTable[92].put("EXP", "55");
        actionTable[92].put("IF_STMT", "56");
        actionTable[92].put("WHILE_STMT", "57");
        actionTable[92].put("FOR_STMT", "58");
        actionTable[92].put("SWITCH_STMT", "59");

        actionTable[93] = new HashMap<>();
        actionTable[93].put("id", "s9");
        actionTable[93].put("number", "s10");
        actionTable[93].put("op1", "s11");
        actionTable[93].put("EXP", "97");

        actionTable[94] = new HashMap<>();
        actionTable[94].put("{", "s98");

        actionTable[95] = new HashMap<>();
        actionTable[95].put("type", "r40");
        actionTable[95].put("id", "r40");
        actionTable[95].put("{", "r40");
        actionTable[95].put("}", "r40");
        actionTable[95].put("return", "r40");
        actionTable[95].put("break", "r40");
        actionTable[95].put("number", "r40");
        actionTable[95].put("op1", "r40");
        actionTable[95].put("if", "r40");
        actionTable[95].put("else", "s100");
        actionTable[95].put("while", "r40");
        actionTable[95].put("for", "r40");
        actionTable[95].put("switch", "r40");
        actionTable[95].put("case", "r40");
        actionTable[95].put("default", "r40");
        actionTable[95].put("ELSE_STMT", "99");

        actionTable[96] = new HashMap<>();
        actionTable[96].put("type", "r41");
        actionTable[96].put("id", "r41");
        actionTable[96].put("{", "r41");
        actionTable[96].put("}", "r41");
        actionTable[96].put("return", "r41");
        actionTable[96].put("break", "r41");
        actionTable[96].put("number", "r41");
        actionTable[96].put("op1", "r41");
        actionTable[96].put("if", "r41");
        actionTable[96].put("else", "r41");
        actionTable[96].put("while", "r41");
        actionTable[96].put("for", "r41");
        actionTable[96].put("switch", "r41");
        actionTable[96].put("case", "r41");
        actionTable[96].put("default", "r41");

        actionTable[97] = new HashMap<>();
        actionTable[97].put(";", "s101");

        actionTable[98] = new HashMap<>();
        actionTable[98].put("type", "r45");
        actionTable[98].put("id", "r45");
        actionTable[98].put("{", "r45");
        actionTable[98].put("}", "r45");
        actionTable[98].put("return", "r45");
        actionTable[98].put("break", "r45");
        actionTable[98].put("number", "r45");
        actionTable[98].put("op1", "r45");
        actionTable[98].put("if", "r45");
        actionTable[98].put("else", "r45");
        actionTable[98].put("while", "r45");
        actionTable[98].put("for", "r45");
        actionTable[98].put("switch", "r45");
        actionTable[98].put("case", "s103");
        actionTable[98].put("default", "r45");
        actionTable[98].put("CASE_LIST", "102");

        actionTable[99] = new HashMap<>();
        actionTable[99].put("type", "r38");
        actionTable[99].put("id", "r38");
        actionTable[99].put("{", "r38");
        actionTable[99].put("}", "r38");
        actionTable[99].put("return", "r38");
        actionTable[99].put("break", "r38");
        actionTable[99].put("number", "r38");
        actionTable[99].put("op1", "r38");
        actionTable[99].put("if", "r38");
        actionTable[99].put("else", "r38");
        actionTable[99].put("while", "r38");
        actionTable[99].put("for", "r38");
        actionTable[99].put("switch", "r38");
        actionTable[99].put("case", "r38");
        actionTable[99].put("default", "r38");

        actionTable[100] = new HashMap<>();
        actionTable[100].put("type", "s54");
        actionTable[100].put("id", "s9");
        actionTable[100].put("{", "s43");
        actionTable[100].put("return", "s61");
        actionTable[100].put("break", "s62");
        actionTable[100].put("number", "s10");
        actionTable[100].put("op1", "s11");
        actionTable[100].put("if", "s63");
        actionTable[100].put("while", "s64");
        actionTable[100].put("for", "s65");
        actionTable[100].put("switch", "s66");
        actionTable[100].put("CMP_STMT", "60");
        actionTable[100].put("STMT", "104");
        actionTable[100].put("EXP", "55");
        actionTable[100].put("IF_STMT", "56");
        actionTable[100].put("WHILE_STMT", "57");
        actionTable[100].put("FOR_STMT", "58");
        actionTable[100].put("SWITCH_STMT", "59");

        actionTable[101] = new HashMap<>();
        actionTable[101].put("id", "s9");
        actionTable[101].put("number", "s10");
        actionTable[101].put("op1", "s11");
        actionTable[101].put("EXP", "105");

        actionTable[102] = new HashMap<>();
        actionTable[102].put("}", "r47");
        actionTable[102].put("default", "s107");
        actionTable[102].put("DEFA", "106");

        actionTable[103] = new HashMap<>();
        actionTable[103].put("id", "s9");
        actionTable[103].put("number", "s10");
        actionTable[103].put("op1", "s11");
        actionTable[103].put("EXP", "108");

        actionTable[104] = new HashMap<>();
        actionTable[104].put("type", "r39");
        actionTable[104].put("id", "r39");
        actionTable[104].put("{", "r39");
        actionTable[104].put("}", "r39");
        actionTable[104].put("return", "r39");
        actionTable[104].put("break", "r39");
        actionTable[104].put("number", "r39");
        actionTable[104].put("op1", "r39");
        actionTable[104].put("if", "r39");
        actionTable[104].put("else", "r39");
        actionTable[104].put("while", "r39");
        actionTable[104].put("for", "r39");
        actionTable[104].put("switch", "r39");
        actionTable[104].put("case", "r39");
        actionTable[104].put("default", "r39");

        actionTable[105] = new HashMap<>();
        actionTable[105].put(")", "s109");

        actionTable[106] = new HashMap<>();
        actionTable[106].put("}", "s110");

        actionTable[107] = new HashMap<>();
        actionTable[107].put(":", "s111");

        actionTable[108] = new HashMap<>();
        actionTable[108].put(":", "s112");

        actionTable[109] = new HashMap<>();
        actionTable[109].put("type", "s54");
        actionTable[109].put("id", "s9");
        actionTable[109].put("{", "s43");
        actionTable[109].put("return", "s61");
        actionTable[109].put("break", "s62");
        actionTable[109].put("number", "s10");
        actionTable[109].put("op1", "s11");
        actionTable[109].put("if", "s63");
        actionTable[109].put("while", "s64");
        actionTable[109].put("for", "s65");
        actionTable[109].put("switch", "s66");
        actionTable[109].put("CMP_STMT", "60");
        actionTable[109].put("STMT", "113");
        actionTable[109].put("EXP", "55");
        actionTable[109].put("IF_STMT", "56");
        actionTable[109].put("WHILE_STMT", "57");
        actionTable[109].put("FOR_STMT", "58");
        actionTable[109].put("SWITCH_STMT", "59");

        actionTable[110] = new HashMap<>();
        actionTable[110].put("type", "r43");
        actionTable[110].put("id", "r43");
        actionTable[110].put("{", "r43");
        actionTable[110].put("}", "r43");
        actionTable[110].put("return", "r43");
        actionTable[110].put("break", "r43");
        actionTable[110].put("number", "r43");
        actionTable[110].put("op1", "r43");
        actionTable[110].put("if", "r43");
        actionTable[110].put("else", "r43");
        actionTable[110].put("while", "r43");
        actionTable[110].put("for", "r43");
        actionTable[110].put("switch", "r43");
        actionTable[110].put("case", "r43");
        actionTable[110].put("default", "r43");

        actionTable[111] = new HashMap<>();
        actionTable[111].put("type", "s54");
        actionTable[111].put("id", "s9");
        actionTable[111].put("{", "s43");
        actionTable[111].put("return", "s61");
        actionTable[111].put("break", "s62");
        actionTable[111].put("number", "s10");
        actionTable[111].put("op1", "s11");
        actionTable[111].put("if", "s63");
        actionTable[111].put("while", "s64");
        actionTable[111].put("for", "s65");
        actionTable[111].put("switch", "s66");
        actionTable[111].put("CMP_STMT", "60");
        actionTable[111].put("STMT", "114");
        actionTable[111].put("EXP", "55");
        actionTable[111].put("IF_STMT", "56");
        actionTable[111].put("WHILE_STMT", "57");
        actionTable[111].put("FOR_STMT", "58");
        actionTable[111].put("SWITCH_STMT", "59");

        actionTable[112] = new HashMap<>();
        actionTable[112].put("type", "s54");
        actionTable[112].put("id", "s9");
        actionTable[112].put("{", "s43");
        actionTable[112].put("return", "s61");
        actionTable[112].put("break", "s62");
        actionTable[112].put("number", "s10");
        actionTable[112].put("op1", "s11");
        actionTable[112].put("if", "s63");
        actionTable[112].put("while", "s64");
        actionTable[112].put("for", "s65");
        actionTable[112].put("switch", "s66");
        actionTable[112].put("CMP_STMT", "60");
        actionTable[112].put("STMT", "115");
        actionTable[112].put("EXP", "55");
        actionTable[112].put("IF_STMT", "56");
        actionTable[112].put("WHILE_STMT", "57");
        actionTable[112].put("FOR_STMT", "58");
        actionTable[112].put("SWITCH_STMT", "59");

        actionTable[113] = new HashMap<>();
        actionTable[113].put("type", "r42");
        actionTable[113].put("id", "r42");
        actionTable[113].put("{", "r42");
        actionTable[113].put("}", "r42");
        actionTable[113].put("return", "r42");
        actionTable[113].put("break", "r42");
        actionTable[113].put("number", "r42");
        actionTable[113].put("op1", "r42");
        actionTable[113].put("if", "r42");
        actionTable[113].put("else", "r42");
        actionTable[113].put("while", "r42");
        actionTable[113].put("for", "r42");
        actionTable[113].put("switch", "r42");
        actionTable[113].put("case", "r42");
        actionTable[113].put("default", "r42");

        actionTable[114] = new HashMap<>();
        actionTable[114].put("}", "r46");

        actionTable[115] = new HashMap<>();
        actionTable[115].put("type", "r45");
        actionTable[115].put("id", "r45");
        actionTable[115].put("{", "r45");
        actionTable[115].put("}", "r45");
        actionTable[115].put("return", "r45");
        actionTable[115].put("break", "r45");
        actionTable[115].put("number", "r45");
        actionTable[115].put("op1", "r45");
        actionTable[115].put("if", "r45");
        actionTable[115].put("else", "r45");
        actionTable[115].put("while", "r45");
        actionTable[115].put("for", "r45");
        actionTable[115].put("switch", "r45");
        actionTable[115].put("case", "s103");
        actionTable[115].put("default", "r45");
        actionTable[115].put("CASE_LIST", "116");

        actionTable[116] = new HashMap<>();
        actionTable[116].put("type", "r44");
        actionTable[116].put("id", "r44");
        actionTable[116].put("{", "r44");
        actionTable[116].put("}", "r44");
        actionTable[116].put("return", "r44");
        actionTable[116].put("break", "r44");
        actionTable[116].put("number", "r44");
        actionTable[116].put("op1", "r44");
        actionTable[116].put("if", "r44");
        actionTable[116].put("else", "r44");
        actionTable[116].put("while", "r44");
        actionTable[116].put("for", "r44");
        actionTable[116].put("switch", "r44");
        actionTable[116].put("case", "r44");
        actionTable[116].put("default", "r44");



        }

}
