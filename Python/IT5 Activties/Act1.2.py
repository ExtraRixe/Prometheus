
try:
    name=input("Enter your name: ")
    capital=float(input("Enter Capital: "))

    if capital<=5000:
        print("Sorry you does not reach the minimum amount")
    elif capital>=500000:
        print("Sorry you reached the maximum amount")
    else:
        currency=input("Enter Currency(PHP/USD): ")
        monthly_interest=capital*7
        processing_fee=monthly_interest*0.015
        monthly_gross=monthly_interest
        monthly_net=monthly_gross-processing_fee
        annual_interest=monthly_interest*12
        annual_net=monthly_net*12

        print("Investor: "+name)
        print("Capital: "+str(capital))
        print("Monthly Interest: "+str(currency)+str(monthly_interest))
        print("Processing Fee: "+str(currency)+str(processing_fee))
        print("Monthly Payout (Gross): "+str(currency)+str(monthly_gross))
        print("Monthly Net income: "+str(currency)+str(monthly_net))
        print("Annual Interest: "+str(currency)+str(annual_interest))
        print("Annual Net: "+str(currency)+str(annual_net))
except:
    print("Invalid input!")
