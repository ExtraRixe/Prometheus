class MathOperation:
    result = 0

    def __init__(self):
        print('An object is created')

    def add(self,num1,num2):
        result = (num1+num2)
        return result

    def subtract(self,num1,num2):
        result = (num1 - num2)
        return result

    def multiply(operator,num1,num2):
        operator.prod = (num1 * num2)

    def printProduct(ope):
        print(f'The product is\t\t\t\t: {ope.prod}')

    def divide(operation,num1,num2):
        result = (num1 / num2)
        return result

    def remainder(self,num1,num2):
        result = (num1 % num2)
        return result

    def power(self,base,exponent):
        a = base

        for x in range(exponent-1):
            base *= a
        return base

    def decimalToBinary(self,value):

        return str(bin(value))[2:]

calc = MathOperation()

print(f'The sum is\t\t\t\t\t:{calc.add(8,4)}\n'
      f'The difference is \t\t\t:{calc.subtract(8,4)}\n'
      f'The quotient is\t\t\t\t:{calc.divide(8,4)}\n'
      f'The remainder is\t\t\t:{calc.remainder(8,4)}\n'
      f'The power is\t\t\t\t:{calc.power(8,4)}\n'
      f'The binary is\t\t\t\t:{calc.decimalToBinary(84)}')
calc.multiply(8,4)
calc.printProduct()