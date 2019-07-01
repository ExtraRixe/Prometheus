from random import randint

a,b,c = [],[],[]

size = input("Enter two sizes(Separate using whitespace): ")
val1,val2 = size.split(" ",2)         # split() method splits a string into a list
                                        # The first parameter defines the separator,
                                        # The second parameter defines how many splits to do
                                      # This means that the first split is assigned to variable val1 and the second to val2

val1,val2 = int(val1),int(val2)       # Since the input is a String we need to convert val1 and val2 into integers
                                      # so that we can use their values as numerical conditions

for x in range(val1):
    a.append(randint(0,val1))         # appends(adds) a random integer to its list
for x in range(val2):
    b.append(randint(0,val2))         # appends(adds) a random integer to its list

for i in a:
    if i in b:                        # Checks if value from a exists in b
        c.append(i)

c=str(set(c))[1:-1]                   # Converts list c to a set.
                                      # A set does not allow duplicate values, thus removing any existing duplicate value
                                      # [1:-1] is used to remove the first and last characters; removing the brackets/braces
print('\n'+''.join(str(a))[1:-1]+'\n'+''.join(str(b))[1:-1]+f'\n\nCommon numbers: {c}')
