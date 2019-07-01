smart = ['13','14','20','21','28','29','30']
tnt = ['08','09','10','11','12','18','19']
sun = ['22','23','32','33']
globe = ['15','16','17','25','26','27']
tm = ['03','04','05','06','07']
red = ['01','02','24']



num=input("Enter the number: ")

while num[:2] != "09" or len(num) > 11 or len(num) < 11 or num.isdigit() is False or num.isspace() is True:
    num = input("Mobile number must start with '09'\nMobile number must ONLY contain 11-digits\n>>Enter the number: ")

if num[2:4] in smart:
    print(str(num)+"\tSMART")
if num[2:4] in tnt:
    print(str(num)+"\tTNT")
if num[2:4] in sun:
    print(str(num)+"\tSUN")
if num[2:4] in globe:
    print(str(num)+"\tGLOBE")
if num[2:4] in tm:
    print(str(num)+"\tTM")
if num[2:4] in red:
    print(str(num)+"\tRED")
