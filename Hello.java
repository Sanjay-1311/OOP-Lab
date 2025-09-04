import java.util.*;
public class Hello{
	public static void main(String[] args){
 			Scanner sc=new Scanner(System.in);
 			int flag=0;
 			System.out.println("Enter the number of rows");
 			int a=sc.nextInt();
 			System.out.println("Enter the number of colums");
 			int b=sc.nextInt();
 			int[][] c=new int[a][b];
 			for(int i=0;i<a;i++){
 				for (int j=0;j<b;j++){
 					System.out.println("Enter the elements");
 					c[i][j]=sc.nextInt();
 				}
 					
 			}
 			System.out.println("Enter the number of rows for second matrix");
 			int a1=sc.nextInt();
 			System.out.println("Enter the number of colums for second matrix");
 			int b1=sc.nextInt();
 			int[][] d=new int[a][b];
 			for(int i=0;i<a1;i++){
 				for (int j=0;j<b1;j++){
 					System.out.println("Enter the elements");
 					d[i][j]=sc.nextInt();
 				}
 					
 			}
 			if (b!=b1){
 				System.out.println("The matrix multiplication is not possible");
 				flag=1;
 				
 			}
 			else{
 				int[][] resultant=new int[a][b1];
 				for (int i=0;i<a;i++){
 					for(int j=0;j<b1;j++){
 						for(int k=0;k<b;k++){
 							resultant[i][j]+=c[i][k]*d[k][j];
 						}
 					}
 				}
 				for (int i=0;i<a;i++){
 					for(int j=0;j<b1;j++){
 						System.out.println(resultant[i][j]);
 					}
 				}
 			}
 			
 				
 			
 			sc.close();
 			
	}
}
