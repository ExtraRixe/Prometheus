val1 = int(input("Enter Start Value: "))
while val1 <=0:
    print("Invalid input, try again")
    val1 = int(input(">> Enter Start Value: "))

val2 = int(input("Enter End Value: "))
while val2 <=0:
    print("Invalid input, try again")
    val2 = int(input(">> Enter End Value: "))
while val2 <= val1:
    print("End value is lesser than Start Value, try again")
    val2 = int(input(">> Enter End Value: "))

val2+=1
sum=0

for i in range(val1,val2):
    if i == val2-1:
        print(str(i) + "^3")
        sum+=i**3

    else:
        print(str(i)+"^3",end="+")
        sum+=i**3


print("="+str(sum))
input("Press any key to exit...")
exit()