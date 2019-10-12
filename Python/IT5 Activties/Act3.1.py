def power(base, exponent):
    # Your code goes here
    return base**exponent

def decToBinary(value):
    # Your code goes here'
    if len(str(bin(value))[2:]) is 3:
        return '0'+str(bin(value))[2:]
    else:
        return str(bin(value))[2:]

def isPalindrome(valStr):
    # Your code goes here
    if valStr == valStr[::-1]:
        return True
    else:
        return False

def invalidInput(val):
    while int(val) < 1:
        val = int(input("Value must be greater than 0\t:"))
    return val


base = int(input("Base\t\t: "))
base = invalidInput(base)
exp = int(input("Exponent\t: "))
exp = invalidInput(exp)


p = power(base, exp)
b = decToBinary(p)
pal = isPalindrome(b)

print(base, " raised to the power of ", exp, " is ", p)
print(p, " is ", b, " in binary ")
print("Palindrome: ", pal)
