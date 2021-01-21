import java.util.*;
import java.time.*;
import java.io.*;
class hotel23
{
int a[]=new int[10];
hotel23() throws Exception
{
File f3=new File("rooms.txt");
Scanner sc3= new Scanner(f3);
int i=0;
for(i=0;i<10;i++)
{
a[i]=sc3.nextInt();
}
sc3.close();
}
void available(int seat,char ch) throws Exception
{
if(ch=='a' && seat==1)
{
System.out.println("Availability\n"+"A/C Single bedded rooms:"+a[0]);
--a[0];
this.book("ac");
}
if(ch=='a' && seat==2)
{
System.out.println("Availability\n"+"A/C double bedded rooms:"+a[1]);
--a[1];
this.book("ac");
}
if(ch=='a' && seat==3)
{
System.out.println("Availability\n"+"A/C triple bedded rooms:"+a[2]);
--a[2];
this.book("ac");
}
if(ch=='a' && seat==4)
{
System.out.println("Availability\n"+"A/C four bedded rooms:"+a[3]);
--a[3];
this.book("ac");
}
if(ch=='n' && seat==1)
{
System.out.println("Availability\n"+"Non-A/C Single bedded rooms:"+a[4]);
--a[4];
this.book("na");
}
if(ch=='n' && seat==2)
{
System.out.println("Availability\n"+"Non-A/C double bedded rooms:"+a[5]);
--a[5];
this.book("na");
}
if(ch=='n' && seat==3)
{
System.out.println("Availability\n"+"Non-A/C triple bedded rooms:"+a[6]);
--a[6];
this.book("na");
}
if(ch=='n' && seat==4)
{
System.out.println("Availability\n"+"Non-A/C four bedded rooms:"+a[7]);
--a[7];
this.book("na");
}
}
void prior() throws Exception
{
	Scanner ip=new Scanner(System.in);
	System.out.println("Welcome to paradise");
	System.out.println("Food or Stay ???...");
	System.out.println("A/C or Non-A/C...???"+"For A/C PRESS a      For Non-A/c press n");
	char ch=ip.next().charAt(0);
	System.out.println("single..?? preferable single bedded room\ncouple..?? preferable double bedded room\nFamily..?? triple bedded or four bedded room");
	System.out.println("if single press 1 else if double press 2 else if triple else if four press 4");
	int seat=ip.nextInt();
	try
	{
	this.available(seat,ch);
	}catch(IOException e){}
}
void book(String ch2) throws Exception
{
	Scanner ip1=new Scanner(System.in);
	System.out.println("Want to change decision press y other wise  press n");
	char ch1=ip1.next().charAt(0);
	if(ch1=='y')
	{
	try
	{
	this.prior();
	}catch(IOException e){}
	}
	if(ch1=='n' && ch2=="ac")
	{
	System.out.println("Booking confirmed.....\n Your Room no.:"+(++a[8]));
	System.out.println();
	this.update();
	}
	if(ch1=='n' && ch2=="na")
	{
	System.out.println("Booking confirmed.....\n Your Room no.:"+(++a[9]));
	System.out.println();
	this.update();
	}
}
void bill() throws Exception
{
	Scanner ip5=new Scanner(System.in);
	int days,r_no,bed;
	System.out.println("Enter no. of days you stay here:");
	days=ip5.nextInt();
	System.out.println("which type of room single,double,triple,four..?? enter no.");
	bed=ip5.nextInt();
	System.out.println("Enter room no.:");
	r_no=ip5.nextInt();
	if(r_no>400 && r_no<450)
	{
		System.out.println("                $$$$$$$$$$$$$$$$$$ BILL  $$$$$$$$$$$$$$$$$$\n");
		System.out.println("		    Your bill for A/C "+(bed)+"-bedded room:"+(1500*bed*days));
		System.out.println();
	}
	if(r_no>500 && r_no<550)
	{
		System.out.println("                $$$$$$$$$$$$$$$$$$ BILL  $$$$$$$$$$$$$$$$$$\n");
		System.out.println("		 Your bill for Non-A/C "+(bed)+"-bedded room:"+(750*bed*days));
		System.out.println();
	}
}
void update() throws Exception
{
File f5=new File("rooms.txt");
PrintWriter pw1 =new PrintWriter(f5);
for(int i=0;i<a.length;i++)
{
	pw1.println(a[i]);
}
pw1.close();
}
}
class one_part
{
char menu() throws IOException
{
LocalTime present=LocalTime.now();
String bf1="11:30:00";
String bf2="15:00:00";
LocalTime bf3 = LocalTime.parse(bf1);
LocalTime bf4 = LocalTime.parse(bf2);
String lunch1="07:00:00";
String lunch2="10:30:00";
LocalTime lunch3=LocalTime.parse(lunch1);
LocalTime lunch4=LocalTime.parse(lunch2);
String dinner1="19:30:00";
String dinner2="23:30:00";
LocalTime dinner3=LocalTime.parse(dinner1);
LocalTime dinner4=LocalTime.parse(dinner2);
File f=new File("breakfast.txt");
Scanner sc= new Scanner(f);
File f1=new File("lunch.txt");
Scanner sc1=new Scanner(f1);
File f2=new File("dinner.txt");
Scanner sc2=new Scanner(f2);
char ch;
if(present.isAfter(bf3) && present.isBefore(bf4))
{
ch='b';
while(sc.hasNext())
{
String line =sc.nextLine();
System.out.println(line);
}
return ch;
}
else if(present.isAfter(lunch3) && present.isBefore(lunch4))
{
ch='l';
while(sc1.hasNext())
{
String line1 =sc1.nextLine();
System.out.println(line1);
}
return ch;
}
else if(present.isAfter(dinner3) && present.isBefore(dinner4))
{
ch='d';
while(sc2.hasNext())
{
String line2 =sc2.nextLine();
System.out.println(line2);
}
return ch;
}
else
{
System.out.println("Restaurent closed");
System.exit(0);
}
sc.close();
sc1.close();
sc2.close();
return 0;
}
}
class bill1
{
	String bf[]={"puri    ","idly    ","vada    ","parantha"};
	int bff[]={40,40,40,20};
	String lnch[]={"Thali     ","puloa     ","Biryani   ","Fried rice"};
	int lnch1[]={60,70,90,80};
	String dnr[]={"Thali   ","puloa   ","parantha","Roti    "};
	int dnr1[]={60,70,20,10};
	static int in;
	static int index[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	static int item[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	void bill(char ch)
	{
		int sum=0;
		if(ch=='b')
		{
		System.out.println("                $$$$$$$$$$$$$$$$$$ BILL  $$$$$$$$$$$$$$$$$$\n");
		System.out.println("		Item 		Quantity 		Cost");
		for(int i=0;i<index.length;i++)
		{
			if(index[i]!=-1){
			System.out.println("		"+bf[index[i]]+" 	   "+item[i]+" 			"+bff[index[i]]*item[i]);
			sum=sum+(bff[index[i]]*item[i]);
			}
		}
		System.out.println("          ----------------------------------           ------");
		System.out.println("                                  Grand Total"+"           "+sum);
		System.out.println();
		System.out.println("                                       *************THANKS FOR COMING*************"+"\n"+"                                          *************VISIT AGAIN*************");
		}
		if(ch=='l')
		{
		System.out.println("                $$$$$$$$$$$$$$$$$$ BILL  $$$$$$$$$$$$$$$$$$\n");
		System.out.println("		Item 		Quantity 		Cost");
		for(int i=0;i<index.length;i++)
		{
			if(index[i]!=-1){
			System.out.println("		"+lnch[index[i]]+" 	   "+item[i]+" 			"+lnch1[index[i]]*item[i]);
			sum=sum+(lnch1[index[i]]*item[i]);
			}
		}
		System.out.println("          ----------------------------------           ------");
		System.out.println("                                  Grand Total"+"           "+sum);
		System.out.println();
		System.out.println("                                       *************THANKS FOR COMING*************"+"\n"+"                                          *************VISIT AGAIN*************");

		}
		if(ch=='d')
		{
		System.out.println("                $$$$$$$$$$$$$$$$$$ BILL  $$$$$$$$$$$$$$$$$$\n");
		System.out.println("		Item 		Quantity 		Cost");
		for(int i=0;i<index.length;i++)
		{
			if(index[i]!=-1){
			System.out.println("		"+dnr[index[i]]+" 	   "+item[i]+" 			"+dnr1[index[i]]*item[i]);
			sum=sum+(dnr1[index[i]]*item[i]);
			}
		}
		System.out.println("          ----------------------------------           ------");
		System.out.println("                                  Grand Total"+"           "+sum);
		System.out.println();
		System.out.println("                                       *************THANKS FOR COMING*************"+"\n"+"                                          *************VISIT AGAIN*************");
		}
	}
}
class order1 extends bill1
{
	Scanner iput= new Scanner(System.in);
	static int ind=0;
	int dup;
	int itm;
	void order(char ch)
	{
	if(ch=='b')
	{
		System.out.println("Enter the s.no for selecting the Item");
		dup=iput.nextInt();
		if(dup==1)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+bf[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('b');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==2)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+bf[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('b');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==3)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+bf[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('b');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==4)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+bf[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('b');
			}
			item[ind]=itm;
			ind++;
		}
		else{
			System.out.println("Enter valid choice...\n Try again");
		order('b');
		}
	}
	else if(ch=='l')
	{
		//System.out.println("Place your order for Lunch");
		System.out.println("Enter the s.no for selecting the Item");
		dup=iput.nextInt();
		if(dup==1)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+lnch[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('l');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==2)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+lnch[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('l');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==3)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+lnch[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('l');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==4)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+lnch[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('l');
			}
			item[ind]=itm;
			ind++;
		}
		else{
			System.out.println("Enter valid choice...\n Try again");
		order('l');
		}
	}
	else if(ch=='d')
	{
		System.out.println("Enter the s.no for selecting the Item");
		dup=iput.nextInt();
		if(dup==1)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+dnr[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('d');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==2)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+dnr[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('d');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==3)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+dnr[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('d');
			}
			item[ind]=itm;
			ind++;
		}
		if(dup==4)
		{
			index[ind]=dup-1;
			System.out.println("Enter quantity for:"+dnr[dup-1]);
			itm=iput.nextInt();
			if(itm<1)
			{
				System.out.println("Enter valid choice...\n Try again");
				order('d');
			}
			item[ind]=itm;
			ind++;
		}
		else{
			System.out.println("Enter valid choice...\n Try again");
		order('d');
		}
	}
	}
}
class main_class
{
public static void main(String []args) throws Exception
{
char ch;
order1 order2=new order1();
char ch1=' ';
Scanner ip=new Scanner(System.in);
one_part o=new one_part();
hotel23 h=new hotel23();
int sel;
do
{
System.out.println("1.room booking\n2.check out\n3.want to order food\n4.exit");
sel=ip.nextInt();
if(sel==1)
{
try{
h.prior();
}catch(IOException e){}
}
else if(sel==2)
{
	h.bill();
}
else if(sel==3)
{
try
{
ch1=o.menu();
}catch(IOException e){}
do
{
order2.order(ch1);
System.out.println("Press y for order again...press any key for bill");
ch=ip.next().charAt(0);
}while(ch=='y' || ch=='Y');
bill1 b=new bill1();
b.bill(ch1);
}
else if(sel>4 || sel<1){
	System.out.println("Enter valid choice\n Try again....");
}
}while(sel!=4);
System.out.println("                                    Thank you!!\n                                    visit Again");
}
}