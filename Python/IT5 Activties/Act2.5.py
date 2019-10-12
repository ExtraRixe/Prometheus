import random

name = input("Enter your name: ").capitalize()
while name.isalnum() is False:
    name = input("Please don't leave this blank\n>>Enter your name: ").capitalize()

bet = int(input("Hi! "+name+", please place your bet: "))
while bet % 10 != 0 or bet < 10:
    bet = int(input("Bet amount must be of 10's\n>>Hi! " + name + ", please place your bet: "))

bold='\033[1m'
regular='\033[0m'

max = int(input("You have 3 turns. Now, give me the max number to generate: "))
while max < 5:
    max = int(input("Max number MUST be >= 4\nYou have 3 turns. Now, give me the max number to generate.\n"))

ai = random.randrange(1,max)
rpt = 1
price = max*10

print("Well, "+name+", you have to guess from "+bold+"1 to "+str(max)+" to win "+str(price)+"."+regular)

if name == "Svcheats1":
    print("number to guess is: "+str(ai))

guess = int(input("\nTake a guess: "))

while guess!= ai:
    if rpt>2:
        print("Sorry, "+name+"! You are out of turns. You lost!")
        break
    if guess > ai:
        guess = int(input("Your guess is too high.\n"
                          "Take a guess: "))
    else:
        guess = int(input("Your guess is too low.\n"
                          "Take a guess: "))
    rpt+=1

if guess == ai:
    if rpt>1:
        print("Good job, " + name + "! You guessed the number in " + str(rpt) + " guesses! You won "+str(price)+".")
    else:
        print("Good job, " + name + "! You guessed the number in " + str(rpt) + " guess! You won "+str(price)+".")