class SMS:
    inbox = []
    load = 5
    def __init__(self, capacity):
        self.capacity = capacity
        self.load = 0

    def setload(self,load):
        self.load += load

    def isFull(self):
        if len(self.inbox) is self.capacity:
            return True
        else:
            return False

    def isEmpty(self):
        if len(self.inbox) is 0:
            return True
        else:
            return False

    def setSMS(self):
        if SMS.isFull(self):
            print("Inbox Full!\n"
                  "Failed to send message!")
        elif self.load<1:
            print("Not enough load!\n"
                  "Failed to send message!")
        else:
            sms = input('Enter Text\t:')
            self.inbox.append(sms)
            self.load -= 1

    def deleteSMS_Value(self,value):
        if SMS.isEmpty(self):
            print('Inbox is Empty!')
        elif value not in self.inbox:
            print("Message not found!")
        else:
            self.inbox.remove(value)

    def deleteSMS_Index(self, index):
        if SMS.isEmpty(self):
            print('Inbox is Empty!')
        elif index < len(self.inbox) and index > -1:
            self.inbox.pop(index)
        else:
            print("Index out of Range!")

    def viewSMS(self):
        if len(self.inbox) > 0:
            print('\n','\n\n'.join(self.inbox),'\n')

    def searchSMS(self, index):
        if SMS.isEmpty(self):
            print('Inbox is Empty!')
        elif index < len(self.inbox) and index > -1:
            print(self.inbox[index])
        else:
            print("Index out of Range!")

    def clear(self):
        self.inbox = []

    def setCapacity(self,capacity):
        self.capacity = capacity

    def getLoadBalance(self):
        return self.load

    def totalSMS(self):
        return len(self.inbox)

    def getCapacity(self):
        return self.capacity

    def inPrint(self):
        print(f'Inbox Capacity\t:{SMS.totalSMS(self)}/{SMS.getCapacity(self)}\t\tBalance\t:{SMS.getLoadBalance(self)}\n')


s = SMS(10)

while True:
    s.inPrint()
    choice = input('\n'
                   '[S]end Text\n'
                   '[V]iew Inbox\n' #delete and search
                   '[C]lear Inbox\n'
                   '---------------\n'
                   '[A]dd Load\n'
                   '[I]ncrease Inbox Capacity\n'
                   '---------------\n'
                   '[E]xit\n\n'
                   '>>').lower()

    if choice == 's':
        s.setSMS()
    elif choice == 'v':
        s.viewSMS()
        view_choice = input('\n'
                       '[S]earch\n'
                       '[D]elete\n'
                       '[B]ack\n').lower()
        if view_choice == 's':
            index = int(input('Enter Index: '))
            s.searchSMS(index)
        elif view_choice == 'd':
            delete_choice = input('\n'
                                  'Delete by:\n'
                                  '[I]ndex\n'
                                  '[V]alue')
            if delete_choice == 'i':
                s.deleteSMS_Index(int(input('Enter Index: ')))
            elif delete_choice == 'v':
                s.deleteSMS_Value(input('Enter value'))

    elif choice == 'c':
        s.clear()
    elif choice == 'a':
        s.setload(int(input('Enter Load: ')))
    elif choice == 'i':
        s.setCapacity(int(input('Enter new inbox capacity: ')))
    elif choice == 'e':
        exit()