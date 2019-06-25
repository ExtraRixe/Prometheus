digit = ["1","2","3","4","5","6","7","8","9","0"]
vowel = ["a","e","i","o","u"]
o,e,l,s,c,v,d=0,0,0,0,0,0,0

string=input("Enter String: ")

for a in range(0,len(string)):
    if string[a].isalpha(): l+=1
    if string[a] in vowel: v += 1 #Vowel counter
    if string[a] not in vowel:
        if string[a].isalpha(): c += 1 #Consonant counter
    if string[a].isalpha() is False:
        if string[a].isdigit() is False: s += 1 #Special Character counter
    if string[a].isdigit():
        d+=1                    #Digit counter
        num = int(string[a])
        if num % 2 == 0: e += 1 #Even counter
        else: o += 1 #Odd counter


print("Special Characters: "+str(s))
print("Total Alphabet: "+str(l))
print("Consonants: "+str(c))
print("Vowels: "+str(v))
print("Digits: "+str(d))
print("Even: "+str(e))
print("Odd: "+str(o))
