name = input("Enter your name: ").replace(' ','').lower()                      #.replace(' ','') << Replace whitespace with nothing, thus removing whitespaces
partner = input("Enter partner's name: ").replace(' ','').lower()
a,b = [],[]                                                                    #Declaring a List, This is where the letters from the input will be stored
namerem = parrem = ''                                                          #Declaring a String(Can also be a List) this is where the non-recurring letters will be stored

for x in name:                                                                 #Loop through the letters in string name
    a.append(x)                                                                #Appends every letter of string name to List 'a'
for x in partner:                                                              #Loop through the letters in string partner
    b.append(x)                                                                #Appends every letter of string partner to List 'b'

for x in a:                                                                    #Loop through all elements in List 'a'
    if x not in b:                                                             #If 'x' (Current letter) does not exist in List'b'(Partner's Name)
        namerem += x                                                           #Adds the non-recurring letters to a String (or you can append it to a new list)
for x in b:
    if x not in a:
        parrem += x

sum = len(namerem)+len(parrem)                                                 #Gets the sum of the length of both the remaining letters of your name, as well as your partner's
mod = sum                                                                      #The value of mod is the value of sum

if sum > 6:                                                                    #If sum is greater than 6 << 6 is the length of the word 'FLAMES'
    mod = sum%6                                                                #Gets the remainder of sum/6
                                                                               #F = 1, L = 2, A = 3, M = 4, E = 5, S = 6
if mod == 0:
    rel = 'Not Compatible'
elif mod == 1:
    rel = 'Friends'
elif mod == 2:
    rel = 'Lovers'
elif mod == 3:
    rel = 'Affection'
elif mod== 4:
    rel = 'Marriage'
elif mod == 5:
    rel = 'Enemy'
elif mod == 6:
    rel = 'Sibling'


print(f'Your Name\t\t\t\t\t\t\t: {name}\n'
      f'Partner\'s\t\t\t\t\t\t\t: {partner}\n\n'
      f'Your remaining letters\t\t\t\t: {",".join(namerem)}\n'
      f'Partner\'s remaining letters\t\t\t: {",".join(parrem)}\n'
      f'Your remaining letters(count)\t\t: {len(namerem)}\n'
      f'Partner\'s remaining letters(count)\t: {len(parrem)}\n'
      f'Sum\t\t\t\t\t\t\t\t\t: {sum}\n'
      f'Relationship\t\t\t\t\t\t:{rel}')