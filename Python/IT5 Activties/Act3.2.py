def fibo(val):
   if val <= 1:
       return val
   else:
       return(fibo(val - 1) + fibo(val - 2))

def invalidInput(val):
    while int(val) < 1:
        val = int(input("Value must be greater than 0\t:"))
    return val

sum = 0
string = ''
n = int(input('Enter Value: '))
n = invalidInput(n)
for i in range(n):
    string += str(fibo(i))+'+'
    sum += fibo(i)
print(f'{string[:-1]}=\t{sum}')