def encode(input_string):
    count = 1
    prev = ''
    lst = []
    for character in input_string:
        if character != prev:
            if prev:
                entry = (prev,count)
                lst.append(entry)
                #print lst
            count = 1
            prev = character
        else:
            count += 1
    else:
        entry = (character,count)
        lst.append(entry)
    return lst
 
 
def decode(lst):
    q = ""
    for character, count in lst:
        q += character * count
    return q
 
#Method call
txt = "aaaaahhhhhhmmmmmmmuiiiiiiiaaaaaa"
print 'Original text:\n' + txt
print str(len(txt)) + ' chars'
encoded = encode(txt)
print (encoded)
print str(len(encoded*2)) + ' chars'
print 'Tc: ' + str(float(len(txt))/float(len(encoded*2))) + ':1'
print 'Decoding: '
decoded = decode(encoded)
print (decoded)