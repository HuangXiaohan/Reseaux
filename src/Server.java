/**
 * Created by huang on 03/05/16.
 */
import java.io.*;

import java.net.*;


public class Server {
    public static int port = 4700;
    private ServerSocket server;
    private Socket socket;
    private ObjectOutputStream outputObject;
    private ObjectInputStream inputObject;


    public Server() throws IOException, ClassNotFoundException {
        try{
            this.server = new ServerSocket(port);
            System.out.println("The server is listening of port: " + server.getLocalPort() + ". Waiting connect...");
            this.socket = server.accept();
        }catch (Exception e){
            e.printStackTrace();
        }

        invoke();

    }

    private void invoke() throws IOException, ClassNotFoundException {
        inputObject = new ObjectInputStream(socket.getInputStream());
        outputObject = new ObjectOutputStream(socket.getOutputStream());
        ClientObject clientObject = (ClientObject) inputObject.readObject();

        if(clientObject.getArg().equals("-new"))
            invokeNew(clientObject.getObject());
        else if(clientObject.getArg().equals("-listAll"))
            invokeListAll(clientObject.getObject());
        else if(clientObject.getArg().equals("-get"))
            invokeGet(clientObject.getObject());
        else if(clientObject.getArg().equals("-set"))
            invokeSet(clientObject.getObject());
        else if(clientObject.getArg().equals("getContributor"))
            invokeGetContributor(clientObject.getObject());

    }


    private void invokeNew(Object object) throws IOException{

    }

    private void invokeListAll(Object object) throws IOException{

    }

    private void invokeGet(Object object) throws IOException{

    }

    private void invokeSet(Object object) throws IOException{

    }

    private void invokeGetContributor(Object object) throws IOException{

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
    }


    /*public static void main(String args[]) {

        try{

            ServerSocket server=null;

            try{

                server=new ServerSocket(4700);

                }catch(Exception e) {

                System.out.println("can not listen to:"+e);

                }

            Socket socket=null;

            try{

                socket=server.accept();

                }catch(Exception e) {

                System.out.println("Error."+e);

                }

            String line;

            BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter os = new PrintWriter(socket.getOutputStream());

            BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Client:"+is.readLine());

            line=sin.readLine();

            while(!line.equals("bye")){

                os.println(line);

                os.flush();

                System.out.println("Server:"+line);

                System.out.println("Client:"+is.readLine());

                line=sin.readLine();

                }

            os.close();

            is.close();

            socket.close();

            server.close();

            }catch(Exception e){

            System.out.println("Error:"+e);

            }

        }
        */
}
