import random

atk_list = ['','Rock', 'Paper', 'Scissors']
choice = {"yes", "no", "y", "n"}
no = {'no', 'n'}

bool=True

while bool:
    user = int(input("Please choose your weapon \n [1]Rock \n [2]Paper \n [3]Scissors \n"))
    while user not in range(1,4):
        user = int(input("Invalid input!\n>>Please choose your weapon \n [1]Rock \n [2]Paper \n [3]Scissors \n"))

    ai_choice = atk_list[random.randrange(1, 4)]
    user = atk_list[user]
    print("Player: " + user)
    print("Computer: " + ai_choice)

    if user is ai_choice:
        print("Its a tie!")

    elif user is "Rock":
        print("You lose!") if ai_choice is "Paper" else print("You Win!")

    elif user is "Paper":
        print("You lose!") if ai_choice is "Scissors" else print("You Win!")

    elif user is "Scissors":
        print("You lose!") if ai_choice is "Rock" else print("You Win!")

    cont = str(input("\nDo you want to play again? [Y/N] \n")).lower()

    while cont not in choice:
        cont = input("\nInvalid Input!\nDo you want to play again? [Y/N] \n").lower()
    if cont in no:
        bool=False
        print("Goodbye!")


