vowel = ["a","e","i","o","u"]
o, e, a, s, c, v, d= 0, 0, 0, 0, 0, 0, 0

string=input("Enter String: ")

for x in range(0, len(string)):
    if string[x].isalpha():
        a+=1    #Alphabet counter
    if string[x] in vowel:
        v += 1 #Vowel counter
    if string[x] not in vowel and string[x].isalpha():
        c += 1 #Consonant counter
    if string[x].isspace() is False and string[x].isalpha() is False and string[x].isdigit() is False:
        s += 1 #Special Character counter
    if string[x].isdigit():
        d+=1                    #Digit counter
        num = int(string[x])
        if num % 2 == 0: e += 1 #Even counter
        else: o += 1 #Odd counter


print("Special Characters: "+str(s))
print("Total Alphabet: " + str(a))
print("Consonants: "+str(c))
print("Vowels: "+str(v))
print("Digits: "+str(d))
print("Even: "+str(e))
print("Odd: "+str(o))
