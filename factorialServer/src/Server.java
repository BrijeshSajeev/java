import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            System.out.println("Waiting for client..");
            ServerSocket ss = new ServerSocket(5003);
            Socket soc = ss.accept();
            System.out.println("Connection established");
            BufferedReader bf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            int number = Integer.parseInt(bf.readLine());
            int fact = factorial(number);
            PrintWriter ps = new PrintWriter(soc.getOutputStream(),true);
            ps.println(fact);

        }catch (IIOException e){
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

   public static int factorial(int num){
        if(num ==1)
            return 1;
        return num * factorial(num-1);
   }

}
