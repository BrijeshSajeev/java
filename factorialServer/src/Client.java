import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("localhost",5003);
            System.out.println("Conntected");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number");
            int x = Integer.parseInt(bf.readLine());
            PrintWriter pf = new PrintWriter(soc.getOutputStream(),true);
            pf.println(x);
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            int fact = Integer.parseInt(bf2.readLine());
            System.out.println("The factorial of "+x+" is > ");
            System.out.println(fact);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
