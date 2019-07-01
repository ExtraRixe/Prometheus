num = input("Enter two numbers: ")
a,b = num.split(" ",2)

start = int(a)
end = int(b)

if start < 0 or end < start or end == start or end > 99:
    print("Fail to process")

else:
    for x in range(start,end+1):
        team = "team"+str(x)

        if len(team)==5:
            team = team[:4]+"0"+str(x)

        print(team)