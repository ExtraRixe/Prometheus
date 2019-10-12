vowel = "aeiou"
text = input("Enter a word: ")

while text.islower() is False or text.isalpha() is False or text.isspace() is True or len(text) <=2 or len(text) >=11 or len(text.split()) >1:
    text = input("Input MUST be a single word."
                 "\nconsisting only of lowercase English letters."
                 "\nThe word will be at least 3 and at most 10 characters long."
                 "\n>>Enter a word: ")

first = text[0]
if first in vowel:
    print("\nOriginal Word: "+text+"\t Piglatin: "+text+"ay")

else:
    print("\nOriginal Word: "+text+"\t Piglatin: "+text[1:]+first+"ay")


