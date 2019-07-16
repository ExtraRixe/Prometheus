sum,x,grade = 0,0,0

while grade != -1:
    grade = int(input("Enter grade: "))
    if grade in range(0,101):
        sum += grade
        x += 1

ave = sum/x
point = ((100-ave)+10)/10

print(f'{ave:.2f}')
print(f'5.0' if ave>49 else '9.0' if ave<75 else f'{point:.2f}')