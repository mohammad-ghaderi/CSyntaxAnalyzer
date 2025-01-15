

grammars = []

inputFile = open("../grammar.txt", 'r')
for inp in inputFile:
    line = list(inp.split(' '))
    left = line[0]
    right = line[2:]

    grammar = 'new GrammarRule("' + left + '"' + ', Arrays.asList('

    for rul in right:
        rul = rul[:-1]
        if rul == "''":
            grammar = grammar + "null, "
        else :
            grammar = grammar + '"' + rul + '", '
    
    print(grammar)
    grammar = grammar[:-2] + ')),'
    print(grammar)

    grammars.append(grammar)

file = open("convertedGrammar.txt", 'w')
for i in grammars:
    file.write(i + '\n')
