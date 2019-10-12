flames = {
    0: 'Not Compatible',
    1: 'Friends',
    2: 'Lovers',
    3: 'Affection',
    4: 'Marriage',
    5: 'Enemies',
    6: 'Siblings',
}
name = input("Enter your name: ").replace(' ','').lower()
partner = input("Enter partner's name: ").replace(' ','').lower()
a,b = [],[]
namerem = parrem = ''

for x in name:
    a.append(x)
for x in partner:
    b.append(x)

for x in a:
    if x not in b:
        namerem += x
for x in b:
    if x not in a:
        parrem += x

sum = len(namerem)+len(parrem)

print(f'Your Name\t\t\t\t\t\t\t: {name}\n'
      f'Partner\'s\t\t\t\t\t\t\t: {partner}\n\n'
      f'Your remaining letters\t\t\t\t: {",".join(namerem)}\n'
      f'Partner\'s remaining letters\t\t\t: {",".join(parrem)}\n'
      f'Your remaining letters(count)\t\t: {len(namerem)}\n'
      f'Partner\'s remaining letters(count)\t: {len(parrem)}\n'
      f'Sum\t\t\t\t\t\t\t\t\t: {sum}\n'
      f'Relationship\t\t\t\t\t\t:{flames[6] if sum%6 == 0 else flames[sum%6] if sum > 6 else flames[sum]}')