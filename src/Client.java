/**
 * Created by huang on 03/05/16.
 */

import java.io.*;

import java.net.*;
import java.util.Scanner;

public class Client {
    private final String IP = "127.0.0.1";
    Socket socket;
    private ObjectOutputStream outputObject;
    private ObjectInputStream inputObject;

    public Client(){
        try{
            socket = new Socket(IP,4700);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * add a new idea
     * @param args
     * @throws IOException
     */
    private void newIdea(String[] args) throws IOException{
        this.outputObject = new ObjectOutputStream(socket.getOutputStream());
        if(args.length != 4)
            System.out.println("invalide commmande");
        User user = new User(args[2],args[3]);
        File file = new File("../File/"+args[1]);
        Idea idea = new Idea(file,user);
        ClientObject clientObject = new ClientObject("-new",idea);
        outputObject.writeObject(clientObject);
        outputObject.flush();
    }


    /**
     * list all of the idea with id
     * @param args
     * @throws IOException
     */
    private void listAllIdea(String[] args) throws IOException{
        this.outputObject = new ObjectOutputStream(socket.getOutputStream());
        if(args.length != 2)
            System.out.println("invalide commande");
        ClientObject clientObject = new ClientObject("-listAll",null);
        outputObject.writeObject(clientObject);
        outputObject.flush();

    }

    /**
     * get idea with an idea
     * @param args
     * @throws IOException
     */
    private void get(String[] args) throws IOException{

    }

    /**
     * change idea with an idea
     * @param args
     * @throws IOException
     */
    private void set(String[] args) throws IOException{

    }


    /**
     * get contributor of an idea with id
     * @param args
     * @throws IOException
     */
    private void getContributor(String[] args) throws IOException{

    }


    private void runCommande(Client client, String[] test) throws IOException{
        if(test[0].equals("-new"))
            client.newIdea(test);
        else if(test[0].equals("-listAll"))
            client.listAllIdea(test);
        else if(test[0].equals("get"))
            client.get(test);
        else if(test[0].equals("set"))
            client.set(test);
        else if(test[0].equals("getContributor"))
            client.getContributor(test);
        else
            System.out.println("invalide commande");
    }




    public static void main(String[] args) throws ClassNotFoundException{
        Scanner clavier;
        String fin = "exit";
        String input = " ";
        Client client = new Client();


        try {
            while (!input.equals(fin)) {
                System.out.println("write a commande :");
                clavier = new Scanner(System.in);
                input = clavier.nextLine();

                String[] test = input.split("\\s+");
                System.out.println("result of your commande :");
                client.runCommande(client, test);

                //client.readServer();

                client.socket.close();
            }


            client.socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*public static void main(String args[]) {

        try{

            Socket socket=new Socket("127.0.0.1",4700);

            BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

            PrintWriter os=new PrintWriter(socket.getOutputStream());

            BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readline;

            readline=sin.readLine();

            while(!readline.equals("bye")){

                os.println(readline);

                os.flush();

                System.out.println("Client:"+readline);

                System.out.println("Server:"+is.readLine());

                readline=sin.readLine();
                }
            os.close();

            is.close();

            socket.close();

            }catch(Exception e) {

            System.out.println("Error"+e);

            }

        }*/
}
