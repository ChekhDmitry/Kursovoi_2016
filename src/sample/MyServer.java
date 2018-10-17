package sample;


import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import static java.lang.Thread.sleep;

public class MyServer implements Runnable {

    private final Controller fxmlCntrl;
    private ServerSocket mainServerSocket;
    private Socket newSocket;
    private DataInputStream din;
    private DataOutputStream dout;
    private String yourNickname;


    public MyServer(Controller fxmlCntrl, String yourNickname){

        this.fxmlCntrl=fxmlCntrl;
        this.yourNickname=yourNickname;

    }

    @Override
    public void run() {
        try {
        while (true) {
            //System.out.println("1serv");

            mainServerSocket = new ServerSocket(5678);
            newSocket = mainServerSocket.accept();
            //System.out.println("2serv");
            din = new DataInputStream(newSocket.getInputStream());
            dout = new DataOutputStream(newSocket.getOutputStream());

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fxmlCntrl.returnDout(dout);
                }
            });

            // отправка никнейма
            String nickname = din.readUTF();
            dout.writeUTF(yourNickname);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fxmlCntrl.writeNickname(nickname);
                }
            });


            while (true) {
                // прием сообщение с темой и номерами вопросов
                String temp_msg1 = din.readUTF();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fxmlCntrl.opponentListGenerator(temp_msg1);
                    }
                });

                // прием сщщбщения со списком ответов противника
                String temp_msg2 = din.readUTF();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fxmlCntrl.getOpponentAnswersList(temp_msg2);
                    }
                });
            }

                /*String temp_msg3 = din.readUTF();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fxmlCntrl.writeNickname(temp_msg3);
                    }
                });

                break;*/

             }
            } catch (IOException e) {
                //e.printStackTrace();
                try {
                    newSocket.close();
                    mainServerSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
              //  System.out.println("1");
                //return;
            }/*finally {
                try {
                    newSocket.close();
                    mainServerSocket.close();
                    System.out.println("Закрыл сокеты в finally");
                    return;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/



    }
}
