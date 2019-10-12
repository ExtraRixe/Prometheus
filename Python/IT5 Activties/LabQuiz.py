num = input("Enter two numbers: ")
a,b = num.split(" ",2)

start = int(a)
end = int(b)+1

if start < 0 or end < start or end == start or end > 99:
    print("Fail to process")

else:
    for x in range(start,end):
        team = "team"+str(x)

        if x<=9:
            team = team[:4]+"0"+str(x)

        print(team)