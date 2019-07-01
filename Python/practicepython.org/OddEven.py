choice = {"yes", "no", "y", "n"}
no = {'no', 'n'}
bool=True

while bool:                                                 # Loops until user enters a string from list choice
    val = int(input("Enter number: "))
    if val % 2 is 0:                                        # If entered integer is divisible by 2 then val is even, else it is odd
        print("Number is even")
    else:
        print("Number is odd")

    cont = input("Another one? yes/no ").lower()
    while cont not in choice or cont.isalpha() is False:    # If input is not an alphabet or does not belong in list choice, ask again
        cont = input("Another one? yes/no > ").lower()
    if cont in no:                                          # If entered string belongs to list no, end program
        bool=False

