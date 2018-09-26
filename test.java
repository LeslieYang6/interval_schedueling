import java.util.Comparator;
import java.util.Arrays;
class Task
{
	 int start;
	 int end;
	 int weight;
	 Task(int x,int y,int z)
	 {
		 start=x;
        end=y;
        weight=z;
	 }
}

class TaskComparator implements Comparator<Task>
{
  public int compare(Task a,Task b)
  {
	   return a.end>b.end?1:0;
  }
}

public class test
{

     public static int Closest(Task d[],int i)
     {
    	 for(int k=i-1;k>=0;k--)
    	 {
    		 if(d[k].end<=d[i].start)
    			 return k;
    	 }
    	 return -1;
     }
     ///
     
     public static int Schedualing(Task d[])
     {
    	 int []table=new int[d.length];
    	 Arrays.sort(d,new TaskComparator());
    	 table[0]=d[0].weight;
    	 for(int i=1;i<d.length;i++)
    	 {    
    		 int notinclude=table[i-1];
    		 int include=d[i].weight;
    		 int k=Closest(d,i);
    		 if(k!=-1)
    			 include+=table[k];
    		 table[i]=Math.max(include,notinclude); 
    	 }
    	 return table[d.length-1];
     }
     
     public static void main(String[] args)
     {
    	 Task jobs[]= {new Task(1,2,50),new Task(3, 5, 20), 
                 new Task(6, 19, 100), new Task(2, 100, 200),new Task(4,5,233)}; 
    	 System.out.println("Optimal profit is"+ Schedualing(jobs));
     }
     
}