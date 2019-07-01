string = input("Please enter a word: ")
reverse = string[::-1]
print("This word is a palindrome") if string == reverse else print("This word is not a palindrome")

#                   NOTES for line 2
# [start:end:step]
# having a condition where string[2:5] gets all characters from indices(sg. index) 3 to 5; ie. 'Hello' becomes 'llo'
# The third parameter(step) indicates the increment/decrement between each index before slicing;

#     EXAMPLE: 'hello'[::2]
# H[0] E[1] L[2] L[3] O[4]
# start  1    2    1    2
# Therefore, 'hello' becomes 'hlo'

#       FURTHERMORE:
# setting the step parameter into a negative integer results in counting the string index in reverse
# which explains why [::-1] returns the string in its reverse order



#                           !MORE!
# The condition below has the same result with the condition in line 2

# reverse = ""
# for i in range(len(string)-1,-1,-1):
# 		reverse += string[i]
#print(reverse)