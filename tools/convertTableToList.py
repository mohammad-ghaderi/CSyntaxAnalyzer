
list = []

name = [  "type", "id", "=", "(", ")", "[", "]", ",", ";", "{", "}", "return", "break", "number", "op1", "op2", "if", "else", "while", "for", "switch", "case", ":", "default", "$", "S'", "S", "DECL", "VAR_REST", "PARAMS", "PAR_REST", "CMP_STMT", "STMT_LIST", "STMT", "EXP", "IDEXP", "NUMEXP", "ARGS", "ARG_REST", "IF_STMT", "ELSE_STMT", "WHILE_STMT", "FOR_STMT", "SWITCH_STMT", "CASE_LIST", "DEFA",
]

inputFile = open("y.html")
s = -1
f = False
c = -1

row = {}

print("converting...")

for line in inputFile:
    line = line[:-1]
    if (f) :
        f = False
        continue
    if (line == "<tr>"):
        f = True
        s += 1
        c = -1
        continue
    if (line == "</tr>"): 
        list.append(row)
        row = {}
        continue
    c += 1
    
    line = line[6:]
    line = line[:-5]
    if (line != ""):
        row[name[c]] = line
    
    
# print(list)
inputFile.close()


output = open("table.py", 'w') 
flag = True
i = 0
for row in list:
    table_name = "actionTable"
    flag = True
    output.write(f"{table_name}[{i}] = new HashMap<>();\n")
    for item in row:
        if (name.index(item) >= 25 and flag):
            flag = False
            table_name = "gotoTable"
            output.write(f"{table_name}[{i}] = new HashMap<>();\n")

        value = row[item]
        if (table_name == "actionTable"): value = '"' + value + '"'
        output.write(f'{table_name}[{i}].put("{item}", {value});\n')

    output.write("\n")
    i += 1

output.close()

print("done.")
