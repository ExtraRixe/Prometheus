val = int(input("Enter Value: "))

sum=0
a=2

if val <=0:
    print("Invalid input")
    input("Press any key to exit...")
    exit()
else:
    for i in range(0,val):
        if i == val-1:
            sum += a
            print(str(a))
            a += 2
        else:
            sum+=a
            print(str(a),end="+")
            a += 2

print("="+str(sum))
input("Press any key to exit...")
exit()