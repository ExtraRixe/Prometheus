class RiceCooker:
    kg = capacity = consumed = left = 0
    #180g = 1cup
    def __init__(self):
        self.consumed = 10000.0 / 1000.0  #15kg
        self.capacity = 15.0
        print('hello')

    def g_kg(self,grams):
        grams / 1000
        return grams

    def g_cup(self,cup):    #1cup == 180grams
        cup = (cup * 180) / 1000.0
        return cup

    def addRice(self,add):
        if self.consumed == self.capacity:
            print("Error! Rice bin is at full capacity!")
        elif add > self.capacity:
            print('Error! Max capacity is 15kg')
        else:
            add / 1000
            self.consumed += add

    def cookRice(self, cup):
        if cup > self.left:
            print('Error! Input Exceeds allowable consumption')
        else:
            self.consumed -= RiceCooker.g_cup(self,cup)
            return f'Cooking {cup} cups of rice.'
    def emptyBin(self):
        self.consumed = 0

    def remainingCups(self,cups):
        return int(self.left // cups)

    def getter(self):
        self.left = self.consumed * 1000 / 180

        return f'Consumed\t\t\t:{self.consumed:.2f}/{self.capacity:.2f}kg\n' \
            f'Storage Left\t\t:{self.capacity - self.consumed:.2f}kg\n' \
            f'Cups Left\t\t\t:{self.left:.2f}'

rc = RiceCooker()

while True:
    print('\n')
    choice = input(f'{rc.getter()}\n'
        f'________________________________\n'
        f'[A]dd Rice\n'
        f'[C]ook Rice\n'
        f'[T]imer\n'
        f'[E]mpty Bin\n'
        f'...........\n'
        f'[X]Exit\n\n'
        f'>>').lower()
    if choice == 'a':
        add = float(input('Enter Rice to add in kg: '))
        rc.addRice(add)
    if choice == 'c':
        cook = float(input('How many cups to cook? '))
        rc.cookRice(cook)
    if choice == 't':
        time = input('Time[HH:MM]\t\t:').split(':')
        # time[1]//60
        while True:
            cups = int(input(f'How many cups to cook every {time[0]} hour/s {time[1]} minutes?\n'))
            if cups > rc.left:
                print('Error! Input Exceeds allowable consumption')
            else:
                print(f'AutoRice will automatically cook {cups} cup/s of rice every {time[0]} hour/s {time[1]} minute/s\n'
                      f'Remaining Serving\t: {rc.remainingCups(cups)}')
                break
    if choice == 'e':
        while True:
            yn = input('Are you sure you want to empty the bin? [Y/N]')
            if yn == 'y':
                rc.emptyBin()
                break
            if yn == 'n':
                break

    if choice == 'x':
        exit()