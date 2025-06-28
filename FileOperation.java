import java.io.*;
import java.util.Scanner;
class FileOperation{
	public static void main(String ag[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("1:Write To File");
	System.out.println("2:Read To File");
	System.out.println("3:Modify File");
	int ch=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter File Name:");
	String f=sc.nextLine();
	switch(ch){
	case 1:
		System.out.print("Enter Text File to write:");
		String con=sc.nextLine();
		try{
			FileWriter w=new FileWriter(f);
			w.write(con);
			w.close();
			System.out.println("File Write Successfully..");
		}catch(IOException e)
		{
			System.out.println("Error Writing to File:"+e.getMessage());
		}
		break;
	case 2:
		try{
			FileReader r=new FileReader(f);
			System.out.println("File Content:");
			int chh;
			while((chh=r.read())!=-1)
			{
				System.out.println((char)chh);
			}
			r.close();
			}catch(IOException e)
			{
				System.out.println("Error Reading File:"+e.getMessage());
			}
			break;
	case 3:
		System.out.print("Enter text to Find:");
		String preText=sc.nextLine();
		System.out.print("Enter new Text:");
		String newText=sc.nextLine();
		try{
			String constr="";
			BufferedReader b=new BufferedReader(new FileReader(f));
			String line;
			while((  line=b.readLine())!=null){
				constr+=line+"\t";
			}
			b.close();
			constr=constr.replace(preText,newText);
			FileWriter w=new FileWriter(f);
		}catch(IOException e){
			System.out.println("Error Modify File:"+e.getMessage());
		}
		break;
	default:
		System.out.println("Invalid Choice..");
	}
	sc.close();
	}
}