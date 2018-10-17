package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

public class Controller  {

    @FXML
    public TitledPane tpStartMenu;
    @FXML
    public TitledPane tpChoosingTopic;
    @FXML
    public TitledPane tpGameAction;
    @FXML
    public TitledPane tpResult;
    @FXML
    public Accordion a1;
    @FXML
    public TextField tfNickname;
    @FXML
    public TextField tfServerIP;
    @FXML
    public Label lbMyIP;
    @FXML
    public Label lbgY;
    @FXML
    public Label lbQuestion;
    @FXML
    public Button btnAnswer1;
    @FXML
    public Button btnAnswer2;
    @FXML
    public Button btnAnswer3;
    @FXML
    public Button btnAnswer4;
    @FXML
    public Label lbYourNicknameResult;
    @FXML
    public Label lbOpponentNicknameResult;
    @FXML
    public ProgressIndicator piYourMainResult;
    @FXML
    public ProgressIndicator piOpponentMainResult;
    @FXML
    public ProgressIndicator piYourAdditionalResult1;
    @FXML
    public ProgressIndicator piYourAdditionalResult2;
    @FXML
    public ProgressIndicator piOpponentAdditionalResult1;
    @FXML
    public ProgressIndicator piOpponentAdditionalResult2;
    @FXML
    public Label lbWinnerNickname;
    @FXML
    public  Label lbNicknameOpponent;
    @FXML
    public javafx.scene.image.ImageView iViewQuestions;
    @FXML
    public Label lbChoice;
    @FXML
    public Label lbWinnerNick;
    @FXML
    public Label lbYourAdditionalResult1;
    @FXML
    public Label lbYourAdditionalResult2;
    @FXML
    public Label lbOpponentAdditionalResult1;
    @FXML
    public Label lbOpponentAdditionalResult2;


    private DataOutputStream dout; // поток для соединения с противником
    private boolean topicChoosed = false;

    private ArrayList<Question> myQuestionsList = new ArrayList<>();
    private ArrayList<Question> opponentQuestionsList = new ArrayList<>();
    private ArrayList<Question> mainQuestionsList = new ArrayList<>();
    private ArrayList<Integer> rightAnswersList = new ArrayList<>();

    private int currentQuestion =0;
    private ArrayList<Integer> myAnswersList = new ArrayList<>();
    private ArrayList<Integer> opponentAnswersList = new ArrayList<>();

    private String firstTopic = "";
    private String secondTopic = "";


    /**
     * Define and output local ip address of current computer.
     * Add event filter to the text filed.
     * */
    public void initialize(){
        a1.setExpandedPane(tpStartMenu);
        Main.mainstage.setResizable(false);

        InetAddress addr;
        String myLanIP = "";
        try {
            addr = InetAddress.getLocalHost(); //Получение IP компьютера
            myLanIP = addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
       // lbMyIP.setText("My IP: " + myLanIP);
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements()){
                NetworkInterface n = (NetworkInterface)e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()){
                    InetAddress i = (InetAddress)ee.nextElement();

                    if(i.getHostAddress().startsWith("192.168.0.")) {
                        myLanIP = i.getHostAddress();
                    }

                }
            }
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        lbMyIP.setText("My IP: " + myLanIP);



        // Проверка tfServerIP на ввод некорректных символов
        tfServerIP.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!(event.getCode().isDigitKey())
                        && (event.getCode() != KeyCode.PERIOD)
                        && !(event.getCode().isFunctionKey())
                        && !(event.getCode().isArrowKey())
                        && !(event.getCode().isModifierKey())
                        && !(event.getCode().isNavigationKey())
                        && !(event.getCode().isMediaKey())
                        && !(event.getCode().isKeypadKey())
                        && (event.getCode() != KeyCode.BACK_SPACE) ){

                    tfServerIP.deletePreviousChar();
                }
            }
        });


    }

    // Запуск сервера
    /**
     * Start new thread with MyServer class as server part of application.
     * */
    @FXML
    public void startServer(){
        Thread serverT = new Thread(new MyServer(this, tfNickname.getText()));
        serverT.setDaemon(true);
        serverT.start();
    }

    // Вывод имени противника
    /**
     * Set text for user's and opponent's nickname labels.
     *
     * @param str Opponent's nickname
     *
     * */
    void writeNickname(String str){
        lbgY.setText("Your opponent:");
        lbNicknameOpponent.setText(str);
        lbOpponentNicknameResult.setText(str);
        lbYourNicknameResult.setText(tfNickname.getText().trim());
        a1.setExpandedPane(tpChoosingTopic);
    }

    // Запуск клиента
    /**
     * Start new thread with MyClient class as client part of application.
     * */
    @FXML
    public void startClient(){
       Thread clientT = new Thread(new MyClient(this, tfServerIP.getText(), tfNickname.getText()));
        clientT.setDaemon(true);
        clientT.start();
    }


    // Обработчики кнопок для выбора темы
    /**
     * Click event handler. Corresponds "Java" topic.
     * */
    @FXML
    public void btnJavaClick(){
        if(!topicChoosed) {
            myListGenerator("java");
            topicChoosed = true;
            lbChoice.setText("Java");
        }
    }

    /**
     * Click event handler. Corresponds "Swift" topic.
     * */
    @FXML
    public void btnSwiftClick(){
        if(!topicChoosed) {
            myListGenerator("swift");
            topicChoosed = true;
            lbChoice.setText("Swift");
        }
    }

    /**
     * Click event handler. Corresponds "C#" topic.
     * */
    @FXML
    public void btnCsharpClick(){
        if(!topicChoosed) {
            myListGenerator("csharp");
            topicChoosed = true;
            lbChoice.setText("C#");
        }
    }

    /**
     * Click event handler. Corresponds "JavaScript" topic.
     * */
    @FXML
    public void btnJsClick(){
        if(!topicChoosed) {
            myListGenerator("js");
            topicChoosed = true;
            lbChoice.setText("Js");
        }
    }

    /**
     * Click event handler. Corresponds "Html" topic.
     * */
    @FXML
    public void btnHtmlClick(){
        if(!topicChoosed) {
            myListGenerator("html");
            topicChoosed = true;
            lbChoice.setText("Html");
        }
    }

    /**
     * Click event handler. Corresponds "Css" topic.
     * */
    @FXML
    public void btnCssClick(){
        if(!topicChoosed) {
            myListGenerator("css");
            topicChoosed = true;
            lbChoice.setText("CSS");
        }
    }

    /**
     * Click event handler. Corresponds "Php" topic.
     * */
    @FXML
    public void btnPhpClick(){
        if(!topicChoosed) {
            myListGenerator("php");
            topicChoosed = true;
            lbChoice.setText("PHP");
        }
    }

    /**
     * Click event handler. Corresponds "C++" topic.
     * */
    @FXML
    public void btnCplusClick(){
        if(!topicChoosed) {
            myListGenerator("cplus");
            topicChoosed = true;
            lbChoice.setText("C++");
        }
    }

    /**
     * Click event handler. Corresponds "Python" topic.
     * */
    @FXML
    public void btnPythonClick(){
        if(!topicChoosed) {
            myListGenerator("python");
            topicChoosed = true;
            lbChoice.setText("Python");
        }
    }

    /**
     * Click event handler. Corresponds "Ruby" topic.
     * */
    @FXML
    public void btnRubyClick(){
        if(!topicChoosed) {
            myListGenerator("ruby");
            topicChoosed = true;
            lbChoice.setText("Ruby");
        }
    }


    // возвращает из потока(сервер/клиент) поток для связи с противником
    /**
     * Return DataOutputStream variable from the client or server thread
     * and set it into Controller class private field "dout".
     *
     * @param dout OutputStream
     * */
    void returnDout(DataOutputStream dout){
        this.dout = dout;
    }

    // десериализует и генерирует вопросы по выбранной теме
    /**
     * Define absolute path of current topic serialized file,
     * deserialize question list and generate main list for test.
     * Send message with data about user's question list.
     *
     * @param topicName Current topic
     * */
    private void myListGenerator(String topicName){

        if(firstTopic.equals("")){
            firstTopic = topicName;
        }else{
            secondTopic = topicName;
        }

        String fileName ="";

        URL location = Controller.class.getProtectionDomain().getCodeSource().getLocation();
        fileName = location.getPath();

        switch (topicName){
            case "css":{
                //fileName = "D:\\quest\\cssquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\cssquestions.ser";
                break;
            }
            case "html":{
                //fileName = "D:\\quest\\htmlquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\htmlquestions.ser";
                break;
            }
            case "cplus":{
                //fileName = "D:\\quest\\cplusplusquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\cplusplusquestions.ser";
                break;
            }
            case "java":{
                //fileName = "D:\\quest\\javaquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\javaquestions.ser";
                break;
            }
            case "php":{
                //fileName = "D:\\quest\\phpquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\phpquestions.ser";
                break;
            }
            case "csharp":{
                //fileName = "D:\\quest\\csharpquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\csharpquestions.ser";
                break;
            }
            case "js":{
                //fileName = "D:\\quest\\jsquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\jsquestions.ser";
                break;
            }
            case "python":{
               // fileName = "D:\\quest\\pythonquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\pythonquestions.ser";
                break;
            }
            case "ruby":{
                //fileName = "D:\\quest\\rubyquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\rubyquestions.ser";
                break;
            }
            default:{
                //fileName = "D:\\quest\\tempquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\tempquestions.ser";
            }
        }


        Object tempObj = null;
        try {
            FileInputStream filein = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(filein);
            tempObj = in.readObject();
            filein.close();
            in.close();
            myQuestionsList = (ArrayList<Question>)tempObj;

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        Random rnd = new Random();
        ArrayList<Integer>rNumber = new ArrayList<>();
        int number = 0;

        for(int i = 0; i < 5; i++){
            number = rnd.nextInt(myQuestionsList.size());
            if(!rNumber.contains(number)){
                rNumber.add(number);
            }else{
                i--;
            }
        }


        String msgForOpponent="";
        for(int t : rNumber){
            mainQuestionsList.add(myQuestionsList.get(t));
            rightAnswersList.add(myQuestionsList.get(t).getRightAnswer());
            msgForOpponent = msgForOpponent+" "+Integer.toString(t);
        }

        try {
            dout.writeUTF(topicName+msgForOpponent); // отправка сопернику темы и номеров вопросов
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("mylist "+ mainQuestionsList.size());
        if(mainQuestionsList.size() == 10){
            startGameAction();
        }

    }

    // десериализует и получает вопросы противника
    /**
     * Define absolute path of current topic serialized file,
     * deserialize question list and generate main list for test.
     *
     * @param topicName Current topic
     * */
     void opponentListGenerator(String topicName){
        String topic="";
        ArrayList<Integer>rNumber = new ArrayList<>();
        boolean topicFlag = false;

        for(String str : topicName.split(" ")){
            if(!topicFlag){
                topic = str;
                topicFlag = true;
            }else{
                rNumber.add(Integer.parseInt(str));

            }
        }

        if(firstTopic.equals("")){
            firstTopic = topic;
        }else{
            secondTopic = topic;
        }

        //lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" ("+ topic +")");

        String fileName = "";
        URL location = Controller.class.getProtectionDomain().getCodeSource().getLocation();
        fileName = location.getPath();

        switch (topic){
            case "css":{
                //fileName = "D:\\quest\\cssquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\cssquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (CSS)");
                break;
            }
            case "html":{
                //fileName = "D:\\quest\\htmlquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\htmlquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (Html)");
                break;
            }
            case "cplus":{
                //fileName = "D:\\quest\\cplusplusquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\cplusplusquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (C++)");
                break;
            }
            case "java":{
                //fileName = "D:\\quest\\javaquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\javaquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (Java)");
                break;
            }
            case "php":{
                //fileName = "D:\\quest\\phpquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\phpquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (PHP)");
                break;
            }
            case "csharp":{
                //fileName = "D:\\quest\\csharpquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\csharpquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (C#)");
                break;
            }
            case "js":{
                //fileName = "D:\\quest\\jsquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\jsquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (JS)");
                break;
            }
            case "python":{
                //fileName = "D:\\quest\\pythonquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\pythonquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (Python)");
                break;
            }
            case "ruby":{
                //fileName = "D:\\quest\\rubyquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\rubyquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" (Ruby)");
                break;
            }
            default:{
                //fileName = "D:\\quest\\tempquestions.ser";
                fileName =fileName.substring(0,fileName.length()-22) +"\\tempquestions.ser";

                lbNicknameOpponent.setText(lbNicknameOpponent.getText()+" ("+ topic +")");
            }
        }


        Object tempObj = null;
        try {
            FileInputStream filein = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(filein);
            tempObj = in.readObject();
            filein.close();
            in.close();
            opponentQuestionsList = (ArrayList<Question>)tempObj;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        for(int t : rNumber){
            mainQuestionsList.add(opponentQuestionsList.get(t));
            rightAnswersList.add(opponentQuestionsList.get(t).getRightAnswer());
        }

       // System.out.println("oppon "+ mainQuestionsList.size());
        if(mainQuestionsList.size() == 10){
            startGameAction();
        }


    }

    // переход к игровому процессу
    /**
     * Output first question text to label and
     * corresponding answers text to buttons.
     * */
    private void startGameAction(){
        lbQuestion.setText(mainQuestionsList.get(0).getQuestion());
        btnAnswer1.setText(mainQuestionsList.get(0).getAnswer1());
        btnAnswer2.setText(mainQuestionsList.get(0).getAnswer2());
        btnAnswer3.setText(mainQuestionsList.get(0).getAnswer3());
        btnAnswer4.setText(mainQuestionsList.get(0).getAnswer4());
        a1.setExpandedPane(tpGameAction);
        currentQuestion = 0;

       setImageOnGameAction(firstTopic);

    }


    // обработчики кнопок ответов на вопросы
    /**
     * Click event handler. Corresponds first answer button.
     * Add new user's answer to list.
     * */
    @FXML
    public void btnAnswer1Click(){
        myAnswersList.add(1);
        if(currentQuestion != 9) {
            currentQuestion++;
            lbQuestion.setText(mainQuestionsList.get(currentQuestion).getQuestion());
            btnAnswer1.setText(mainQuestionsList.get(currentQuestion).getAnswer1());
            btnAnswer2.setText(mainQuestionsList.get(currentQuestion).getAnswer2());
            btnAnswer3.setText(mainQuestionsList.get(currentQuestion).getAnswer3());
            btnAnswer4.setText(mainQuestionsList.get(currentQuestion).getAnswer4());

            if(currentQuestion==5){
                setImageOnGameAction(secondTopic);
            }

        }else{
            a1.setExpandedPane(tpResult);
            sendMyAnswersList();
        }

    }

    /**
     * Click event handler. Corresponds second answer button.
     * Add new user's answer to list.
     * */
    @FXML
    public void btnAnswer2Click(){
        myAnswersList.add(2);
        if(currentQuestion != 9) {
            currentQuestion++;
            lbQuestion.setText(mainQuestionsList.get(currentQuestion).getQuestion());
            btnAnswer1.setText(mainQuestionsList.get(currentQuestion).getAnswer1());
            btnAnswer2.setText(mainQuestionsList.get(currentQuestion).getAnswer2());
            btnAnswer3.setText(mainQuestionsList.get(currentQuestion).getAnswer3());
            btnAnswer4.setText(mainQuestionsList.get(currentQuestion).getAnswer4());

            if(currentQuestion==5){
                setImageOnGameAction(secondTopic);
            }


        }else{
            a1.setExpandedPane(tpResult);
            sendMyAnswersList();
        }

    }

    /**
     * Click event handler. Corresponds third answer button.
     * Add new user's answer to list.
     * */
    @FXML
    public void btnAnswer3Click(){
        myAnswersList.add(3);
        if(currentQuestion != 9) {
            currentQuestion++;
            lbQuestion.setText(mainQuestionsList.get(currentQuestion).getQuestion());
            btnAnswer1.setText(mainQuestionsList.get(currentQuestion).getAnswer1());
            btnAnswer2.setText(mainQuestionsList.get(currentQuestion).getAnswer2());
            btnAnswer3.setText(mainQuestionsList.get(currentQuestion).getAnswer3());
            btnAnswer4.setText(mainQuestionsList.get(currentQuestion).getAnswer4());

            if(currentQuestion==5){
                setImageOnGameAction(secondTopic);
            }

        }else{
            a1.setExpandedPane(tpResult);
            sendMyAnswersList();
        }

    }

    /**
     * Click event handler. Corresponds fourth answer button.
     * Add new user's answer to list.
     * */
    @FXML
    public void btnAnswer4Click(){
        myAnswersList.add(4);
        if(currentQuestion != 9) {
            currentQuestion++;
            lbQuestion.setText(mainQuestionsList.get(currentQuestion).getQuestion());
            btnAnswer1.setText(mainQuestionsList.get(currentQuestion).getAnswer1());
            btnAnswer2.setText(mainQuestionsList.get(currentQuestion).getAnswer2());
            btnAnswer3.setText(mainQuestionsList.get(currentQuestion).getAnswer3());
            btnAnswer4.setText(mainQuestionsList.get(currentQuestion).getAnswer4());

            if(currentQuestion==5){
               setImageOnGameAction(secondTopic);
            }

        }else{
            a1.setExpandedPane(tpResult);
            sendMyAnswersList();
        }

    }

    // отображает картинку по темам раундов
    /**
     * Set image corresponding to the current topic.
     *
     * @param topic Current topic
     * */
    private void setImageOnGameAction(String topic){
        Image img = null;
        switch (topic){
            case "java":{ img = new Image("java_color.png"); break;}
            case "php":{ img = new Image("php_color.png"); break;}
            case "js":{ img = new Image("js_color.png"); break;}
            case "html":{ img = new Image("html_color.png"); break;}
            case "css":{ img = new Image("css_color.png"); break;}
            case "swift":{ img = new Image("swift_color.png"); break;}
            case "python":{ img = new Image("python_color.png"); break;}
            case "cplus":{ img = new Image("c++_color.png"); break;}
            case "csharp":{ img = new Image("si_sharp.png"); break;}
            case "ruby":{ img = new Image("ruby_color.png"); break;}
        }
        iViewQuestions.setImage(img);
    }

    // получаем список ответов противника
    /**
     * Generate opponent's answer list.
     *
     * @param msg Message with opponent answers
     * */
     void getOpponentAnswersList(String msg){
        for(String str : msg.split(" ")){
            opponentAnswersList.add(Integer.parseInt(str));
        }

        clearProgressIndicators();

        if((opponentAnswersList.size() == 10) && (myAnswersList.size() == 10)){
            startResultCheck();
        }

    }

    // отправка сопернику моего списка ответов
    /**
     * Send user's answers list to the opponent.
     * */
    private void sendMyAnswersList(){
        String msgToOpponent = "";

        for(int t : myAnswersList){
            msgToOpponent = msgToOpponent + Integer.toString(t)+" ";
        }

        try {
            dout.writeUTF(msgToOpponent.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

        clearProgressIndicators();

        if((opponentAnswersList.size() == 10) && (myAnswersList.size() == 10)){
            startResultCheck();
        }
    }

    // подсчет результатов
    /**
     * Compare player's answers list and generate game result.
     * */
    private void startResultCheck(){

        int myPoints = 0;
        int opponentsPoints = 0;

        int myFirstRaundPoints = 0;
        int mySecondRaundPoints = 0;
        int opponentFirstRaundPoints = 0;
        int opponentSecondRaundPoints = 0;

        for(int i = 0; i < 10; i++){
            if(myAnswersList.get(i)==rightAnswersList.get(i)){
                myPoints++;
                if(i<5){
                    myFirstRaundPoints++;
                }else{
                    mySecondRaundPoints++;
                }
            }
            if(opponentAnswersList.get(i)==rightAnswersList.get(i)){
                opponentsPoints++;
                if(i<5){
                    opponentFirstRaundPoints++;
                }else{
                    opponentSecondRaundPoints++;
                }
            }
        }


        if(myPoints > opponentsPoints){
            lbWinnerNickname.setText("won this game!");
            lbWinnerNick.setText(tfNickname.getText().trim());
        }else if(myPoints < opponentsPoints){
            lbWinnerNickname.setText("won this game!");
            lbWinnerNick.setText(lbOpponentNicknameResult.getText().trim());
        }else if(myPoints == opponentsPoints){
            lbWinnerNickname.setText("It is a draw!");
            lbWinnerNick.setText(tfNickname.getText().trim() +" | "+lbOpponentNicknameResult.getText().trim());
        }

        setProgressIndicatorsTitles();

        piYourMainResult.setProgress(myPoints/10.0);
        piOpponentMainResult.setProgress(opponentsPoints/10.0);

        piYourAdditionalResult1.setProgress(myFirstRaundPoints/5.0);
        piYourAdditionalResult2.setProgress(mySecondRaundPoints/5.0);

        piOpponentAdditionalResult1.setProgress(opponentFirstRaundPoints/5.0);
        piOpponentAdditionalResult2.setProgress(opponentSecondRaundPoints/5.0);

        clearResources();

    }

    // очистка ресурсов(данных) для повторного запуска
    /**
     * Clear and prepare variables and components to game repeating.
     * */
    private void clearResources(){
        topicChoosed = false;
        firstTopic = "";
        secondTopic = "";

         myQuestionsList.clear();
         opponentQuestionsList.clear();
         mainQuestionsList.clear();
         rightAnswersList .clear();

         currentQuestion =0;
         myAnswersList.clear();
         opponentAnswersList.clear();

        lbChoice.setText("");

        for(String str: lbNicknameOpponent.getText().split(" ")){
            lbNicknameOpponent.setText(str);
            break;
        }


    }

    // очистка индикаторов прогресса
    /**
     * Clear progress indicators.
     * */
    private void clearProgressIndicators(){
        piYourMainResult.setProgress(0.0);
        piOpponentMainResult.setProgress(0.0);
        piYourAdditionalResult1.setProgress(0.0);
        piYourAdditionalResult2.setProgress(0.0);
        piOpponentAdditionalResult1.setProgress(0.0);
        piOpponentAdditionalResult2.setProgress(0.0);
        lbWinnerNickname.setText("Wait for your opponent...");
        lbWinnerNick.setText("");
        lbYourAdditionalResult1.setText("");
        lbOpponentAdditionalResult1.setText("");
        lbYourAdditionalResult2.setText("");
        lbOpponentAdditionalResult2.setText("");
    }

    // обработчик кнопки повтора игры
    /**
     * Click event handler. Corresponds repeating the game situation.
     * */
    @FXML
    public void btnRepeatGameClick(){
        a1.setExpandedPane(tpChoosingTopic);
    }

    // определение заголовка для индикатора в соответствии с темой вопросов
    /**
     * Define choosed topics and output it to the labels.
     * */
    private void setProgressIndicatorsTitles(){
        switch (firstTopic) {
            case "html": {
                lbYourAdditionalResult1.setText("Html");
                lbOpponentAdditionalResult1.setText("Html");
                break;
            }
            case "css": {
                lbYourAdditionalResult1.setText("Css");
                lbOpponentAdditionalResult1.setText("Css");
                break;
            }
            case "php": {
                lbYourAdditionalResult1.setText("PHP");
                lbOpponentAdditionalResult1.setText("PHP");
                break;
            }
            case "js": {
                lbYourAdditionalResult1.setText("Js");
                lbOpponentAdditionalResult1.setText("Js");
                break;
            }
            case "swift": {
                lbYourAdditionalResult1.setText("Swift");
                lbOpponentAdditionalResult1.setText("Swift");
                break;
            }
            case "ruby": {
                lbYourAdditionalResult1.setText("Ruby");
                lbOpponentAdditionalResult1.setText("Ruby");
                break;
            }
            case "csharp": {
                lbYourAdditionalResult1.setText("C#");
                lbOpponentAdditionalResult1.setText("C#");
                break;
            }
            case "cplus": {
                lbYourAdditionalResult1.setText("C++");
                lbOpponentAdditionalResult1.setText("C++");
                break;
            }
            case "java": {
                lbYourAdditionalResult1.setText("Java");
                lbOpponentAdditionalResult1.setText("Java");
                break;
            }
            case "python": {
                lbYourAdditionalResult1.setText("Python");
                lbOpponentAdditionalResult1.setText("Python");
                break;
            }
        }

            switch (secondTopic){
                case "html":{
                    lbYourAdditionalResult2.setText("Html");
                    lbOpponentAdditionalResult2.setText("Html");
                    break;
                }
                case "css":{
                    lbYourAdditionalResult2.setText("Css");
                    lbOpponentAdditionalResult2.setText("Css");
                    break;
                }
                case "php":{
                    lbYourAdditionalResult2.setText("PHP");
                    lbOpponentAdditionalResult2.setText("PHP");
                    break;
                }
                case "js":{
                    lbYourAdditionalResult2.setText("Js");
                    lbOpponentAdditionalResult2.setText("Js");
                    break;
                }
                case "swift":{
                    lbYourAdditionalResult2.setText("Swift");
                    lbOpponentAdditionalResult2.setText("Swift");
                    break;
                }
                case "ruby":{
                    lbYourAdditionalResult2.setText("Ruby");
                    lbOpponentAdditionalResult2.setText("Ruby");
                    break;
                }
                case "csharp":{
                    lbYourAdditionalResult2.setText("C#");
                    lbOpponentAdditionalResult2.setText("C#");
                    break;
                }
                case "cplus":{
                    lbYourAdditionalResult2.setText("C++");
                    lbOpponentAdditionalResult2.setText("C++");
                    break;
                }
                case "java":{
                    lbYourAdditionalResult2.setText("Java");
                    lbOpponentAdditionalResult2.setText("Java");
                    break;
                }
                case "python":{
                    lbYourAdditionalResult2.setText("Python");
                    lbOpponentAdditionalResult2.setText("Python");
                    break;
                }



        }
    }
}
