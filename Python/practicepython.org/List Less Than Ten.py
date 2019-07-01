val = []
less = []

num = input("Enter numbers (Separate using whitespace): ").split()

for x in range(len(num)):
    val.append(num[x])

for z in val:
    if int(z) < 10:
        less.append(z)

# *NOTE: The for loop below has the same result the the z-loop above
# for z in range(len(list)):
#     listnum = int(list[x])
#     if listnum < 10:
#         less.append(str(listnum))

print("Your entered values are: " + ",".join(val))
print("The values less than 10 are: "+",".join(less))
