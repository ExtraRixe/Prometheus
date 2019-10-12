import array as a

def cleaner(string):
    return str(string)[12:-2]

def invalidInput(val):
    while int(val) < 1:
        val = int(input("Value must be greater than 0\t:"))
    return val

arr,odd,even,pos,neg = a.array("i"),a.array("i"),a.array("i"),a.array("i"),a.array("i")
arrsum=sume=sumo = 0

for i in range(invalidInput(int(input("Enter array size: ")))):
    arr.append(int(input(f"Enter value for index {i}: ")))

for i in range(len(arr)):
    if arr[i] < 0:
        neg.append(arr[i])
    else:
        pos.append(arr[i])
    if arr[i] is 0:
        pass
    elif arr[i] % 2 is 0:
        even.append(arr[i])
        sume += arr[i]
    else:
        odd.append(arr[i])
        sumo += arr[i]
    arrsum += arr[i]

print(f'\n\nArray: {cleaner(arr)} \nSum: {arrsum} \nHigh: {max(arr)} \nLow: {min(arr)}'
      f'\n\nPositive Integers: {cleaner(pos)}\nNegative Integers: {cleaner(neg)}'
      f'\n\nOdd: {cleaner(odd)} \nSum: {sumo} \nHigh: {max(odd)} \nLow: {min(odd)}'
      f'\n\nEven: {cleaner(even)} \nSum: {sume} \nHigh: {max(even)} \nLow: {min(even)}')