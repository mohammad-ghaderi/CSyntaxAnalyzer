print("reading file...")
inpFile = open("z.html", 'r')
print("file has been read.")

buffer = ""
print("starting...")
for line in inpFile:
    buffer += line[:-1]

    buffer = buffer.replace(' style="color: green;"', '')
    print("green done.")
    buffer = buffer.replace('&nbsp;', '')
    print("&nbsp done.")
    buffer = buffer.replace('<sub>', '')
    buffer = buffer.replace('</sub>', '')
    print("sub done.")
    buffer = buffer.replace(' style="color: blue;"', '')
    print("blue done.")
    
    buffer = buffer.replace('<span>', '')
    buffer = buffer.replace('</span>', '')
    print("span done.")


out = open('out.html', 'w')
out.write(buffer)
out.close()