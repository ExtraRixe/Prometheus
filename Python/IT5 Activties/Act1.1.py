glass = int(input("Input Glasses: "))

liter=glass//10
gallon=liter//5
tank=gallon//50

xgallon=gallon-tank*50
xliter=liter-gallon*5
xglass=glass-liter*10

if glass<1:
    print("Invalid Input, Input should not be less than 1!")

else:
    print("Tank = "+str(tank) +"\n"+ "Gallon = "+str(xgallon) +"\n"+ "Liter = "+str(xliter) +"\n"+"Glass = "+str(xglass))

input("Press enter to exit...")
