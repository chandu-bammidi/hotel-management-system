import java.util.*;
import java.io.*;
import one_part;
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
		System.out.println("Your bill for A/C "+(bed)+"-bedded room:"+(1500*bed*days));
		System.out.println();
	}
	if(r_no>500 && r_no<550)
	{
		System.out.println("Your bill for Non-A/C "+(bed)+"-bedded room:"+(750*bed*days));
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
class main_class23
{
public static void main(String []args) throws Exception
{
Scanner ip6=new Scanner(System.in);
hotel23 h=new hotel23();
int sel;
do
{
System.out.println("1.room booking\n2.check out\n3.want to order food\n4.exit");
sel=ip6.nextInt();
if(sel==1)
{
try{
h.prior();
}catch(IOException e){}
}
if(sel==2)
{
	h.bill();
}
}while(sel!=4);
System.out.println("Thank you!!\n visit Again");
}
}