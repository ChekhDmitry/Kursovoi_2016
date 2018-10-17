package sample;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClient implements Runnable {

    private final Controller fxmlCntrl;
    private Socket newSocket;
    private DataInputStream din;
    private DataOutputStream dout;
    private String serverIP;
    private String yourNickname;


    public MyClient(Controller fxmlCntrl, String serverIP, String yourNickname){
        this.fxmlCntrl = fxmlCntrl;
        this.serverIP = serverIP;
        this.yourNickname = yourNickname;
    }

    @Override
    public void run() {

        while(true){
            try {
                newSocket = new Socket(serverIP, 5678);
                din = new DataInputStream(newSocket.getInputStream());
                dout = new DataOutputStream(newSocket.getOutputStream());

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fxmlCntrl.returnDout(dout);
                    }
                });

                // отправка никнейма
                dout.writeUTF(yourNickname);
                String nickname = din.readUTF();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fxmlCntrl.writeNickname(nickname);
                    }
                });

                while(true) {
                    // прием сообщение с темой и номерами вопросов
                    String temp_msg = din.readUTF();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            fxmlCntrl.opponentListGenerator(temp_msg);
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




            } catch (IOException e) {
                //e.printStackTrace();
            }finally {
                try {
                    newSocket.close();
                 //   System.out.println("Закрыл сокеты в finally");
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
