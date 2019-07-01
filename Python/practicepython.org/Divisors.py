num = int(input("Enter Number: "))     # Asks the user for an integer input
divisor = []                           # Declaring a variable "divisor" as a list

for x in range (1,num+1):
    if num % x == 0:                   # if num/x does not have a remainder
        divisor.append(x)              # if the if-statement is true then the value of x will be added to divisor

print(f"The Divisors of {num} is/are: "+"".join(str(divisor)[1:-1]))