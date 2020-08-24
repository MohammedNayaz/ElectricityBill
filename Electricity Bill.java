package electricitybill;
import java.util.*;
import java.time.LocalDate;

abstract class EleBoard
{
	abstract void AD_display();
	abstract void PD_display();
	abstract void CD_display();
	abstract void BD_display();
	abstract void CoD_display();
	abstract void fxdcharges_display();
	abstract void FAC_display();
	abstract void AC_display();
		
}
class AccountDetails
{
	long RRno, AccId, MRcode;
	Scanner s1 = new Scanner(System.in);
	{
	}
	void AD_input()
	{
		System.out.println("Account Details");
		System.out.println("RR no:");
		RRno=s1.nextLong();
		System.out.println("Account number:");
		AccId=s1.nextLong();
		System.out.println("MR Code:");
		MRcode=s1.nextLong();
	}
	void AD_display()
	{
		System.out.println("Account Details ");
		System.out.println("RR No: \t" +RRno );
		System.out.println("Acc Id:\t" +AccId );
		System.out.println("M.R Code:\t"+MRcode);
	}
}

class PersonalDetails extends AccountDetails
{
	String Name, Adr;
	Scanner s2 = new Scanner(System.in);
	{
	}
	void PD_input()
	{
		System.out.println("Name:");
		Name=s2.next();
		System.out.println("Address:");
		Adr=s2.next();
	}
	void PD_display()
	{
		System.out.println("PersonalDetails");
		System.out.println("Name and Address");
		System.out.print(Name);
		System.out.print("\t");
		System.out.println(Adr);
	}
	
}

class ConnectionDetails extends PersonalDetails
{
	String Tariff="1LT2A1-N";
	String SaneLoad;
	Scanner s3 = new Scanner(System.in);
	{
	}
	void CD_input()
	{
		System.out.println("Sane Load(Ex. 1kw/2kw/3kw):");
		SaneLoad=s3.next();
	}
	void CD_display()
	{
		System.out.println("ConnectionDetails");
		System.out.println("Tariff:\t" +Tariff);
		System.out.print("Sane Load\t" +SaneLoad);
		System.out.println("KW+0HP");
	}
}

class BillingDetails extends ConnectionDetails
{
	String date1, date2;
	Scanner s4 = new Scanner(System.in);
	{
	}
	void BD_input()
	{
		System.out.println("Enter Billing Period");
		System.out.println("From:");
		date1=s4.next();
		System.out.println("To");
		date2=s4.next();
	}
	void BD_display()
	{
		System.out.println("Billing Details");
		System.out.println("Bill Period\t");
		System.out.print(date1);
		System.out.print(" : ");
		System.out.println(date2);
		System.out.print("Billing Date:");
		LocalDate ld = LocalDate.now(); 
	    System.out.println(ld); 
	    System.out.print("Bill No:"); 
	    System.out.println(Math.random());
	}	
}

class ConsumptionDetails extends BillingDetails 
{
	long prev, pres, con=1;
	double units;
	
	Scanner s5 = new Scanner(System.in);
	{
	}
	void CoD_input()
	{
		System.out.println("\nPrevious Readng:\t");
		prev=s5.nextLong();
		System.out.println("\nPresent Readng:\t");
		pres=s5.nextLong();
		units=prev-pres;
	}
		void CoD_display()
		{
			System.out.println("Consumption Details");
			System.out.println("Prev. Rdng:\t"+prev);
			System.out.println("Pres. Rdng:\t"+pres);
			System.out.println("Constant:\t"+con);
			System.out.print("Consuption(units)");
			System.out.println(Math.round(+units));
			System.out.println("Average");
			System.out.println("Record MD:\t0KW");
			System.out.println("Power Factor:\t0.0");
			System.out.println("Connected Load 0.0KW");
		}
}

class FixedCharge extends ConsumptionDetails
{
	double amt, temp, temp1, temp2 ;
	void fxdcharges_display()
	{
		System.out.println("Fixed Charges (Unit, Rate, Amount)");
		System.out.println("1KW\t60\t60.00");
		System.out.println("1KW\t70\t70.00");
		System.out.println("--------------------------------------------------");
		System.out.println("Energy Charges (Unit, Rate, Amount)");
		
		if(units<=30)
		{
			amt = units*3.75;
			System.out.print(units);
			System.out.print("\t3.75\t");
			System.out.println(+(30*3.75));
			
			
		}
		else if(units>30 && units<=100)
		{
			amt = (units-30)*5.2 + (30*3.75);
			temp=(units-30)*5.2;
			
			System.out.print("30");
			System.out.print("\t3.75\t");
			System.out.println(+(30*3.75));
			
			System.out.print(+(units-30));
			System.out.print("\t5.2\t");
			System.out.println(Math.round(+temp));
			
		}
		else if(units>100 && units<=200)
		{
			amt = (units-100)*6.65 + (70*5.2) + (30*3.75);
			temp=(70)*5.2;
			temp1=(units-100)*6.65;
			
			System.out.print("30");
			System.out.print("\t3.75\t");
			System.out.println(+(30*3.75));
			
			System.out.print("70");
			System.out.print("\t5.2\t");
			System.out.println(Math.round(+temp));
			
			System.out.print(+(units-100));
			System.out.print("\t6.65\t");
			System.out.println(Math.round(+temp1));
		}
		else
		{
			amt = (units-200)*8.1 + (200*6.65) + (70*5.2) + (30*3.75);
			temp=(70)*5.2;
			temp1=(units-100)*6.65;
			temp2=(units-200)*8.1;
			
			System.out.print("30");
			System.out.print("\t3.75\t");
			System.out.println(+(30*3.75));
			
			System.out.print("70");
			System.out.print("\t5.2\t");
			System.out.println(Math.round(+temp));
			
			System.out.print(+(units-100));
			System.out.print("\t6.65\t");
			System.out.println(Math.round(+temp1));
			
			System.out.print(+(units-200));
			System.out.print("\t6.65\t");
			System.out.println(Math.round(+temp2));
		}		
	}
	void FAC_display()
	{
		double fac;
		System.out.println("FAC Charges(Unit, Rate, Amount)");
		System.out.print(+units);
		System.out.print("\t 0.12 \t");
		fac=(units*0.12);
		System.out.println(+fac);
		
	}
	
}


class Addition extends FixedCharge
{
	float rebate, penalty, intrest, others,  Arrears, cred, subsidy;
	double lp, BillAmt, tax;
	
		Scanner s6 = new Scanner(System.in);
		{
		}
			void bill_input()
			{
				System.out.println("Rebate:");
				rebate=s6.nextFloat();
				System.out.println("PF Penalty:");
				penalty=s6.nextFloat();
				System.out.println("Interest:");
				intrest=s6.nextFloat();
				System.out.println("others:");
				others=s6.nextFloat();
				System.out.println("Arrears:");
				Arrears=s6.nextFloat();
				System.out.println("cresits & Adjustment");
				cred=s6.nextFloat();
				System.out.println("GOK Subsidy:");
				subsidy=s6.nextFloat();	
			}
		
	
	
	
	void AC_display()
	{
		System.out.println("Additional Charges");
		System.out.println("Rebate:             \t"+rebate);
		System.out.println("PF Penalty:         \t"+penalty);
		
		if(penalty!=0)
		{
  		    lp=penalty*0.12;
		    System.out.println("Load/MD penalty:\t"+lp);
		}
		else
		{
		    System.out.println("Load/MD penalty:\t0.00");
		}
		
		System.out.println("Interest:           \t"+intrest);
		System.out.println("others:             \t"+others);
		
		if(units<100)
		{
			tax=31.65; 
			System.out.println("Tax:            \t"+tax);
		}
		else if(units>100)
		{
			tax=35.02;
			System.out.println("Tax:            \t"+tax);
		}
		
		BillAmt =  60 + 70 + amt + (units*0.12) + tax;
		System.out.println("Bill Amt:           \t"+BillAmt);
		System.out.println("Arrears             \t"+Arrears);
		System.out.println("credits & Adjustment\t"+cred);
		System.out.println("GOK Subsidy:        \t"+subsidy);
		System.out.println("--------------------------------------------------");	
		
		net=60 + 70 + amt + (units*0.12) + tax + rebate + penalty + intrest + others +  Arrears +  cred + subsidy ;
		System.out.print("Net Amt Due           \tRs.");
		System.out.println(Math.round(+net));
		
	}
}


public class Bill extends Addition
{
	public static void main(String args[]) 
	{
		Bill B = new Bill();
		System.out.println("-----Electricity board-----");
		System.out.println("-----O/o AEE(Ele.) City-----");
		System.out.println("\nEnter the Details----");
		
		B.AD_input();
		B.PD_input();
		B.CD_input();
		B.BD_input();
		B.CoD_input();
		B.bill_input();
		
		System.out.println("--------------------------------------------------\n\n\n");
		System.out.println("-----Electricity board-----");
		System.out.println("-----O/o AEE(Ele.) City-----");
		B.AD_display();
		System.out.println("--------------------------------------------------");
		B.PD_display();
		System.out.println("--------------------------------------------------");
		B.CD_display();
		System.out.println("--------------------------------------------------");
		B.BD_display();
		System.out.println("--------------------------------------------------");
		B.CoD_display();
		System.out.println("--------------------------------------------------");
		B.fxdcharges_display();
		System.out.println("--------------------------------------------------");
		B.FAC_display();
		System.out.println("--------------------------------------------------");
		B.AC_display();
		
		LocalDate Da = LocalDate.now(); 
	    System.out.println("\t"+Da);
	}

}

/*
Expected Output:

-----Electricity board-----
-----O/o AEE(Ele.) City-----

Enter the Details----
Account Details
RR no:
1212121
Account number:
2323232
MR Code:
4578
Name:
Mdn
Address:
Chitradurga
Sane Load(Ex. 1kw/2kw/3kw):
2
Enter Billing Period
From:
22/07/2020
To
22/08/2020

Present  Readng:	
6673

Previous Readng:	
6597
Rebate:
0
PF Penalty:
0
Interest:
0
others:
0
Arrears:
0
cresits & Adjustment
0
GOK Subsidy:
0
--------------------------------------------------



-----Electricity board-----
-----O/o AEE(Ele.) City-----
Account Details 
RR No: 	1212121
Acc Id:	2323232
M.R Code:	4578
--------------------------------------------------
PersonalDetails
Name and Address
Mdn	Chitradurga
--------------------------------------------------
ConnectionDetails
Tariff:	1LT2A1-N
Sane Load	2KW+0HP
--------------------------------------------------
Billing Details
Bill Period   	22/07/2020 : 22/08/2020
Billing Date: 	2020-08-23
Bill No:0.8444379962901818
--------------------------------------------------
Consumption Details
Prev. Rdng:	6673
Pres. Rdng:	6597
Constant:	1
Consuption(units)76
Average
Record MD:	0KW
Power Factor:	0.0
Connected Load: 0.0KW
--------------------------------------------------
Fixed Charges (Unit, Rate, Amount)
1KW	60	60.00
1KW	60	70.00
--------------------------------------------------
Energy Charges (Unit, Rate, Amount)
30	3.75	112.5
46.0	5.2	239
--------------------------------------------------
FAC Charges(Unit, Rate, Amount)
76.0	 0.12 	9.12
--------------------------------------------------
Additional Charges
Rebate:             	0.0
PF Penalty:         	0.0
Load/MD penalty:	0.00
Interest:           	0.0
others:             	0.0
Tax:            	31.65
Bill Amt:           	522.47
Arrears             	0.0
credits & Adjustment	0.0
GOK Subsidy:        	0.0
--------------------------------------------------
Net Amt Due           	Rs.522
Due Date       	2020-08-23


*/
