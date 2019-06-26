import random

name = input("Enter your name: ").capitalize()
bet = input("Hi! "+name+", please place your bet: ")
bold='\033[1m'
regular='\033[0m'
print("You have 3 turn. Now, give me the max number to generate.\n"
      "Well, "+name+", you have to guess from "+bold+"1 to 10 to win 100.",end=regular)

ai = random.randrange(1,10)
rpt = 1

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
        print("Good job, " + name + "! You guessed the number in " + str(rpt) + " guesses! You won 100.")
    else:
        print("Good job, " + name + "! You guessed the number in " + str(rpt) + " guess! You won 100.")