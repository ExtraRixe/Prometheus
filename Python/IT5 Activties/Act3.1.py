def power(base, exponent):
    # Your code goes here
    return base**exponent
    """
        The function works as power of a number such that 2**3 is equal to 8
    """


def decToBinary(value):
    # Your code goes here'
    if len(str(bin(value))[2:]) is 3:
        return '0'+str(bin(value))[2:]
    else:
        return str(bin(value))[2:]

    """
        The function converts an integer value to binary digits such that 9 is 1001
    """


def isPalindrome(valStr):
    # Your code goes here
    if valStr == valStr[::-1]:
        return True
    else:
        return False
    """
       Determines whether a value is palindrome or Not such that
       1001 - Palindrome: True
       1002 - Palindrome: False
       0110 - Palindrome: True
    """

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
