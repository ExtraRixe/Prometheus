from tkinter import *


window = Tk()

window.title("Text Simulator")
window.geometry(f'600x800+1300+100')
window.configure(bg='#95ba6c')
window.resizable(False,True)

class SMS:
    inbox = []
    load = 5
    def __init__(self, capacity):
        self.capacity = capacity

    def setload(self):
        load = int(textBox.get('1.0','end-1c'))
        self.load += load
        lbl.configure(text=s.inPrint())
        textBox.delete('1.0', END)

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
            textBox.delete('1.0', END)
            textBox.insert('1.0', "Inbox Full!\n"
                  "Failed to send message!")
        elif self.load<1:
            print("Not enough load!\n"
                  "Failed to send message!")
        elif textBox.get('1.0', 'end-1c') == "":
            textBox.delete('1.0', END)
            textBox.insert('1.0',"Message is empty!\n"
                  "Failed to send message!")
        else:
            self.inbox.append(textBox.get('1.0', 'end-1c')+'\n\n')
            self.load -= 1
            textBox.delete('1.0',END)
            lbl.configure(text=s.inPrint())

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
        elif index < len(self.inbox) and index > 0:
            self.inbox.pop(index)
        else:
            print("Index out of Range!")

    def viewSMS(self):
        if len(self.inbox) > 0:
            textBox.delete('1.0',END)
            print('\n','\n\n'.join(self.inbox))
            textBox.insert(INSERT,self.inbox)

    def searchSMS(self, index):
        if SMS.isEmpty(self):
            textBox.delete('1.0',END)
            textBox.insert('1.0','Inbox is Empty!')
        elif index < len(self.inbox) and index > -1:
            print(self.inbox[index])
        else:
            print("Index out of Range!")

    def clear(self):
        textBox.delete('1.0', END)
        self.inbox = []

    def setCapacity(self):
        capacity = int(textBox.get('1.0','end-1c'))
        if self.capacity < capacity:
            self.capacity = capacity
            lbl.configure(text=s.inPrint())
        textBox.delete('1.0',END)


    def getLoadBalance(self):
        return self.load

    def totalSMS(self):
        return len(self.inbox)

    def getCapacity(self):
        return self.capacity

    def inPrint(self):
        return f'Inbox Capacity\t:{SMS.totalSMS(self)}/{SMS.getCapacity(self)}\t\tBalance\t:{SMS.getLoadBalance(self)}\n'

    def close(self):
        exit()


s = SMS(10)

lbl = Label(window, text = s.inPrint(),width = 70, height = 5, font = 'pixelmix',bg = '#95ba6c', fg = '#4d6632')

textBox = Text(window, font = 'pixelmix 12', height = 10)
sendText = Button(window, text="Send Text", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5,  font = 'pixelmix', command = s.setSMS)
inbox = Button(window, text="Inbox", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5, font = 'pixelmix', command = s.viewSMS)
clearInbox = Button(window, text="Clear Inbox", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5, font = 'pixelmix', command = s.clear)
addLoad = Button(window, text="Add Load", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5, font = 'pixelmix', command = s.setload)
upInbox = Button(window, text="Increase Inbox Capacity", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5, font = 'pixelmix', command = s.setCapacity)
close = Button(window, text="Close", bg='#95ba6c', fg = '#4d6632',width = 70, height = 5, font = 'pixelmix', command = s.close)



lbl1 = Label(window,width = 70, height = 1,bg = '#95ba6c', fg = '#4d6632')
lbl2 = Label(window,width = 70, height = 1,bg = '#95ba6c', fg = '#4d6632')
lbl3 = Label(window,width = 70, height = 1,bg = '#95ba6c', fg = '#4d6632')

lbl.pack(side = 'top', fill = 'x')
textBox.pack(side = 'top', fill = 'x')
sendText.pack(side = 'top', fill = 'x')
inbox.pack(side = 'top', fill = 'x')
lbl1.pack(side = 'top', fill = 'x')
clearInbox.pack(side = 'top', fill = 'x')
lbl2.pack(side = 'top', fill = 'x')
addLoad.pack(side = 'top', fill = 'x')
upInbox.pack(side = 'top', fill = 'x')
lbl3.pack(side = 'top', fill = 'x')
close.pack(side = 'top', fill = 'x')

window.mainloop()
