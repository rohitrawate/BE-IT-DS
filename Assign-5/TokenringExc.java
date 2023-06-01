// package Assign-5;

import java.util.Scanner;

public class TokenringExc {
    public static void main(String[] args) {
        
        Scanner  sc = new Scanner( System.in);
        System.out.println("Enter Num of Nodes:");
        int n = sc.nextInt();

        int token = 0;
        
        for (int i = 0; i < n; i++) 
        {
          System.out.println(" "+ i);   
        }
        System.out.println(" "+ 0);

        try{
            while(true){
                System.out.print(" Enter Sender :");
                int s = sc.nextInt();
                System.out.print(" Enter Receiver :");
                int r = sc.nextInt();
                System.out.print(" Enter Data :");
                String d = sc.next();

                System.out.print("Token passing:");
                //current token not equal to sender, increment i by 1 and j by j+1%n


            }
        }
    }
}
