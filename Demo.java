import java.util.*;


class Student
{
	public int Rno;
	public String Name;
	public int Age;
	public int Marks;

	public static int Generator;

	static
	{
		Generator =0;
	}

	public Student(String str, int X, int Y)
	{
		this.Rno = ++Generator;
		this.Name = str;
		this.Age= X;
		this.Marks =Y;
	}

	public void Display()
	{
		System.out.println(this.Rno+ " "+ this.Name+ " "+ this.Age + " "+ this.Marks);
	}
}

class DBMS
{
	public LinkedList <Student> lobj;
	
	public DBMS()
	{
		lobj = new LinkedList <Student> ();
	}

	public void StartDBMS()
	{
		System.out.println("Marvellous DBMS started Succesfully...");
		System.out.println("Table Schema created succesfully...");

		String Query;
		String Tokens[];
		
		Scanner sobj = new Scanner(System.in);
		int TokensCount =0;

		while(true)
		{
			System.out.print("Costumized DBMS : ");
			Query = sobj.nextLine();

			Tokens= Query.split(" ");

			TokensCount = Tokens.length;

			if(TokensCount ==1)
			{
				if("exit".equals(Tokens[0]))
				{
					System.out.println("Thank You For Using Customized DBMS");
					break;
				}
			}
			else if(TokensCount ==2)
			{}
			else if(TokensCount ==3)
			{}
			else if(TokensCount ==4)
			{
				if(("select".equals(Tokens[0]))&&("*".equals(Tokens[1])))
				{
					SelectFrom();
				}
			}
			else if(TokensCount ==5)
			{
				if("select".equals(Tokens[0]))
				{
					if("MAX".equals(Tokens[1]))
					{
						System.out.println("Maximum Marks are : "+Aggregate_Max());
					}
					else if("MIN".equals(Tokens[1]))
					{
						System.out.println("Maniimum Marks are : "+Aggregate_Min());
					}
					else if("AVG".equals(Tokens[1]))
					{
						System.out.println("Average Marks are : "+Aggregate_AVG());
					}
					else if("SUM".equals(Tokens[1]))
					{
						System.out.println("Sum of Marks are : "+Aggregate_Sum());
					}
				}
			}
			else if(TokensCount ==6)
			{}
			else if(TokensCount ==7)
			{
				if("insert".equals(Tokens[0]))
				{
					InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
				}
				else if("delete".equals(Tokens[0]))
				{
					DeleteFrom(Integer.parseInt(Tokens[6]));
				}
			}
		}
	}

	// Insert into Table student value(______,________,______);
	public void InsertIntoTable(String name, int age, int marks)
	{	
		Student sobj = new Student(name,age,marks);
		lobj.add(sobj);
	}

	// Select * from student
	public void SelectFrom()
	{
		System.out.println("Records from the student table are : ");

		for(Student sref : lobj)
		{
			sref.Display();
		}
	}

	// Select * from student where  Rno = 11
	public void SelectFrom(int no)
	{
		System.out.println("Records from the student table are : ");

		for(Student sref : lobj)
		{
			if(sref.Rno== no)
			{
				sref.Display();
				break;
			}
		}
	}

	// Select * from student where  Name = 'Sayali'
	public void SelectFrom(String str)
	{
		for(Student sref : lobj)
		{
			if(str.equals(sref.Name))
			{
				sref.Display();
				break;
			}
		}
	}

	// delete from student where Rno=2 
	public void DeleteFrom(int no)
	{
		int i=0;
		for(Student sref : lobj)
		{
			if(sref.Rno == no)
			{
				lobj.remove(i);
				break;
			}
			i++;
		}
	}
	
	// Select MAX(marks) from student
	public int Aggregate_Max()
	{
		Student temp = lobj.get(0);
		int iMax = temp.Marks;
		for(Student sref : lobj)
		{
			if(sref.Marks > iMax)
			{
				iMax = sref.Marks;
			}
		}

		return iMax;
	}

	// Select MIN(marks) from student
	public int Aggregate_Min()
	{
		Student temp = lobj.get(0);
		int iMin = temp.Marks;

		for(Student sref : lobj)
		{
			if(sref.Marks < iMin)
			{
				iMin = sref.Marks;
			}
		}
		return iMin;
	}

	// Select SUM(marks) from student
	public int Aggregate_Sum()
	{
		int iSum =0;
		for(Student sref : lobj)
		{
			iSum = iSum + sref.Marks;
		}
		return iSum;
	}

	// Select AVG(marks) from student
	public double Aggregate_AVG()
	{
		int iSum =0;
		for(Student sref : lobj)
		{
			iSum = iSum + sref.Marks;
		}

		return (iSum/(lobj.size()));
	}

	
}

class Demo
{
	public static void main(String arg[])
	{
		DBMS obj = new DBMS();
		obj.StartDBMS();
	}
}