package Project2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleWebServer {

    public static void main(String[] args) {
        int port = 80;
        try {
            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket pipe = server.accept();
                PrintWriter out = new PrintWriter(pipe.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(pipe.getInputStream()));

                while (in.ready()) {
                    String line = in.readLine();
                    System.out.println(line);
                }

                out.println("HTTP/1.1 200 OK\n");
//                out.println("<html><body><h1>Hello!</h1></body></html>");

                out.println("<html>");
                out.println("<head>");
                out.println("<title>First JSP</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Hi Pankaj</h3><br>");
                out.println("<strong>Current Time is</strong>: " + new Date() );


                out.println("</body>");
                out.println("</html>");
                out.close();
                in.close();

                //break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}