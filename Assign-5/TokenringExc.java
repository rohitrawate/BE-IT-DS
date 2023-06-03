// package Assign-5;

import java.io.DataInputStream;
import java.util.Scanner;

public class TokenringExc  {
    
    public static void main(String[] args) throws Throwable  {
        
        // Scanner  sc = new Scanner( System.in);
        DataInputStream dis = new DataInputStream(System.in);

        System.out.println("Enter Num of Nodes:");
        // int n = sc.nextInt();
        int n = Integer.parseInt(dis.readLine());

        // Num of Node zto form Ring
        int token = 0;
        int ch = 1;
        for (int i = 0; i < n; i++) 
        {
          System.out.print(" "+ i);   
        }
        System.out.println(" "+ 0);

        try{
            while( ch < 3){
                System.out.print(" Enter Sender :");
                // int s = sc.nextInt();
                int s = Integer.parseInt(dis.readLine());
                System.out.print(" Enter Receiver :");
                // int r = sc.nextInt();
                int r = Integer.parseInt(dis.readLine());
                System.out.print(" Enter Data :");
                // String d = sc.next();
                String d = (dis.readLine());

                System.out.print("Token passing:");
                //current token not equal to sender, increment i by 1 and j by j+1%n

                for(int i= token ; i != s ; i++ )
                {
                    System.out.print( " "+ i + "->");
                }
                System.out.println( "  "+ s);

                System.out.println("Sender " + s + " sending data: " + d);

               // start forwarding from node after sender until it becomes equal to receiver and increment  by i+1%n
                for (int i = (s+1)  ; i != r ;  i =(i+1)% n) {
                    System.out.println("Data " + d + " forwarded by " + i);
                 }
                 System.out.println("Receiver " + r + " received data: " + d);

                token = s;
                ch = ch++;
            }
        
        }   catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
    }
}

