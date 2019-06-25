
charge = int(input("Enter Battery Charge: "))
while charge<0 or charge>100:
    charge = int(input("Invalid input!\nPlease enter value between 1-100 \n\nEnter Battery Charge: "))

distance =float(input("Enter Distance: "))
while distance<0.1:
    distance = float(input("Invalid input!\n*The minimum distance is 0.1(km) \n\nEnter Distance: "))

mass = float(input("Enter load: "))
while mass<0 or mass>10000:
    mass = int(input("Invalid input!\nPlease enter value between 0-10,000 \n\nEnter load: "))

capacity = float(input("Enter Capacity: "))
while capacity<3000 or capacity>10000:
    capacity = int(input("Invalid input!\nPlease enter value between 3,000-10,000 \n\nEnter Capacity: "))

gvwr = capacity/2.205 #lbs-kg

if mass == 0:
    total_consumption = distance * 3 / 100
    charge_distance = distance * 3 / distance / 100
    max_distance = charge/charge_distance
else:
    load = mass / 2
    total_consumption = distance*load*3/100
    charge_distance = load * distance * 3 / distance / 100
    max_distance = charge/charge_distance

print("\n\nBattery Level: "+str(charge)+"%")
print("GVRW: "+str(gvwr)+"kg")
print("Distance: "+str(distance)+"km")
print("Load Weight: "+str(mass))
print("Battery Level(Consumed): "+str(total_consumption)+"%")
print("Charge per km: "+str(charge_distance)+"%")
print("Maximum distance: "+str(max_distance)+"km")



