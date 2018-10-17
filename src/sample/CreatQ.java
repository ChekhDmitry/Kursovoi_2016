package sample;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatQ {

    public static ArrayList<Question>questList = new ArrayList<Question>();
    public static void main(String args[]){
        System.out.println("Hello");

       Question newQ = new Question();
        newQ.setQuestion("Which variable is containing the array of paths from which the libraries are loaded?");
        newQ.setAnswer1("$?");
        newQ.setAnswer2("$$");
        newQ.setAnswer3("$:");
        newQ.setAnswer4("$#");
        newQ.setRightAnswer(3);
        questList.add(newQ);

        Question newQ1 = new Question();
        newQ1.setQuestion("Which of the lists of primitive Ruby types is the most complete?");
        newQ1.setAnswer1("int, char, date, long");
        newQ1.setAnswer2("Array, Numeric, String, Hash, Range");
        newQ1.setAnswer3("Array, Numeric, String");
        newQ1.setAnswer4("There are not primitive types in Ruby");
        newQ1.setRightAnswer(4);
        questList.add(newQ1);

        Question newQ2 = new Question();
        newQ2.setQuestion("Which classes of objects can be used by associative arrays (class Hash) as a key?");
        newQ2.setAnswer1("Only numeric");
        newQ2.setAnswer2("Only strings");
        newQ2.setAnswer3("Any type");
        newQ2.setAnswer4("Only numeric and strings");
        newQ2.setRightAnswer(3);
        questList.add(newQ2);

        Question newQ4 = new Question();
        newQ4.setQuestion("Which of the classes in the standard Ruby library is used to send e-mail messages?");
        newQ4.setAnswer1("Net::SMTP");
        newQ4.setAnswer2("Internet::PMTP");
        newQ4.setAnswer3("Net::POPMail");
        newQ4.setAnswer4("Internet::SMTP");
        newQ4.setRightAnswer(1);
        questList.add(newQ4);

        Question newQ3 = new Question();
        newQ3.setQuestion("Which of the options will be displayed on the screen as a result of the following code:\n \"hello\" .send: puts, \"world\"");
        newQ3.setAnswer1("hello world");
        newQ3.setAnswer2("hello");
        newQ3.setAnswer3("world");
        newQ3.setAnswer4("world hello");
        newQ3.setRightAnswer(2);
        questList.add(newQ3);

        Question newQ5 = new Question();
        newQ5.setQuestion("What keywords do not apply to working with exceptions (exception)?");
        newQ5.setAnswer1("raise");
        newQ5.setAnswer2("throw");
        newQ5.setAnswer3("rescue");
        newQ5.setAnswer4("try");
        newQ5.setRightAnswer(4);
        questList.add(newQ5);

        Question newQ6 = new Question();
        newQ6.setQuestion("Specify all the operations that are missing in Ruby.");
        newQ6.setAnswer1("++, +=");
        newQ6.setAnswer2("==, **");
        newQ6.setAnswer3("**, <<");
        newQ6.setAnswer4("++, :=");
        newQ6.setRightAnswer(4);
        questList.add(newQ6);

        /*Question newQ7 = new Question();
        newQ7.setQuestion("Which line of code produces an error?");
        newQ7.setAnswer1("3 + 4");
        newQ7.setAnswer2("'5' + 6");
        newQ7.setAnswer3("\"one\" + \"2\"");
        newQ7.setAnswer4("\"7\" + 'eight'");
        newQ7.setRightAnswer(2);
        questList.add(newQ7);

        Question newQ8 = new Question();
        newQ8.setQuestion("What is the output of this code?\n>>> print( 3 * '7' )");
        newQ8.setAnswer1("21");
        newQ8.setAnswer2("An error message");
        newQ8.setAnswer3("3 * '7'");
        newQ8.setAnswer4("777");
        newQ8.setRightAnswer(4);
        questList.add(newQ8);

        Question newQ9 = new Question();
        newQ9.setQuestion("What is the output of this code?\n>>> int(\"3\" + \"4\")");
        newQ9.setAnswer1("34");
        newQ9.setAnswer2("\"7\"");
        newQ9.setAnswer3("\"34\"");
        newQ9.setAnswer4("7");
        newQ9.setRightAnswer(1);
        questList.add(newQ9);

        Question newQ10 = new Question();
        newQ10.setQuestion("What is the output of this code?\n>>> float(\"210\" * int(input(\"Enter a number:\")))\nEnter a number: 2");
        newQ10.setAnswer1("\"210210\"");
        newQ10.setAnswer2("\"420.0\"");
        newQ10.setAnswer3("210210.0");
        newQ10.setAnswer4("420");
        newQ10.setRightAnswer(3);
        questList.add(newQ10);

        Question newQ11 = new Question();
        newQ11.setQuestion("What is the output of this code?\n>>> spam = \"eggs\"\n>>> print(spam * 3)");
        newQ11.setAnswer1("spamspamspam");
        newQ11.setAnswer2("eggseggseggs");
        newQ11.setAnswer3("\"spamspamspam\"");
        newQ11.setAnswer4("eggs333");
        newQ11.setRightAnswer(2);
        questList.add(newQ11);

        Question newQ12 = new Question();
        newQ12.setQuestion("What is the result of this code?\n>>> x = \"a\"\n>>> x *= 3\n>>> print(x)");
        newQ12.setAnswer1("\"3a\"");
        newQ12.setAnswer2("\"a333\"");
        newQ12.setAnswer3("An error message");
        newQ12.setAnswer4("aaa");
        newQ12.setRightAnswer(4);
        questList.add(newQ12);

        Question newQ13 = new Question();
        newQ13.setQuestion("Which lines are executed when a Python file is run?");
        newQ13.setAnswer1("Every line");
        newQ13.setAnswer2("The first line only");
        newQ13.setAnswer3("The first 100 lines");
        newQ13.setAnswer4("Only even lines");
        newQ13.setRightAnswer(1);
        questList.add(newQ13);

        Question newQ14 = new Question();
        newQ14.setQuestion("What is the correct python file's extension?");
        newQ14.setAnswer1(".python");
        newQ14.setAnswer2(".srcpython");
        newQ14.setAnswer3(".pythonscript");
        newQ14.setAnswer4(".py");
        newQ14.setRightAnswer(4);
        questList.add(newQ14);

        Question newQ15 = new Question();
        newQ15.setQuestion("What are the two Boolean values in Python?");
        newQ15.setAnswer1("Truth and Falsity");
        newQ15.setAnswer2("true and false");
        newQ15.setAnswer3("yes and no");
        newQ15.setAnswer4("True and False");
        newQ15.setRightAnswer(4);
        questList.add(newQ15);

        Question newQ16 = new Question();
        newQ16.setQuestion("What part of an \" if \" statement should be indented?");
        newQ16.setAnswer1("The first line");
        newQ16.setAnswer2("All of it");
        newQ16.setAnswer3("The statement within it");
        newQ16.setAnswer4("The last line");
        newQ16.setRightAnswer(3);
        questList.add(newQ16);

        Question newQ17 = new Question();
        newQ17.setQuestion("A shorter option for an \" else if \" statement is:");
        newQ17.setAnswer1("elif");
        newQ17.setAnswer2("elsef");
        newQ17.setAnswer3("elf");
        newQ17.setAnswer4("~if");
        newQ17.setRightAnswer(1);
        questList.add(newQ17);

        Question newQ18 = new Question();
        newQ18.setQuestion("How many items are in the list? [2,]");
        newQ18.setAnswer1("2");
        newQ18.setAnswer2("1");
        newQ18.setAnswer3("3");
        newQ18.setAnswer4("0");
        newQ18.setRightAnswer(2);
        questList.add(newQ18);

        Question newQ19 = new Question();
        newQ19.setQuestion("Which line of code will cause an error?\nnum = [5, 4, 3, [2], 1]\nprint(num[0])\nprint(num[3][0])\nprint(num[5])");
        newQ19.setAnswer1("line 2");
        newQ19.setAnswer2("line 3");
        newQ19.setAnswer3("line 4");
        newQ19.setAnswer4("line 1");
        newQ19.setRightAnswer(3);
        questList.add(newQ19);

        Question newQ20 = new Question();
        newQ20.setQuestion("What is the result of this code?\nnums = list(range(5))\nprints(nums[4])");
        newQ20.setAnswer1("5");
        newQ20.setAnswer2("4");
        newQ20.setAnswer3("3");
        newQ20.setAnswer4("syntax error");
        newQ20.setRightAnswer(2);
        questList.add(newQ20);

        Question newQ21 = new Question();
        newQ21.setQuestion("What is the result of this code?\nnums = list(range(5, 8))\nprint(len(nums))");
        newQ21.setAnswer1("8");
        newQ21.setAnswer2("5");
        newQ21.setAnswer3("40");
        newQ21.setAnswer4("3");
        newQ21.setRightAnswer(4);
        questList.add(newQ21);

        Question newQ22 = new Question();
        newQ22.setQuestion("What is the result of this code?\nnums = list(range(3, 15, 3))\nprint(nums[2]) ");
        newQ22.setAnswer1("9");
        newQ22.setAnswer2("12");
        newQ22.setAnswer3("3");
        newQ22.setAnswer4("5");
        newQ22.setRightAnswer(1);
        questList.add(newQ22);

        Question newQ23 = new Question();
        newQ23.setQuestion("What is the output of this code?\nlist = [1, 1, 2, 3, 5, 8, 13]\nprint(list[list[4]])");
        newQ23.setAnswer1("4");
        newQ23.setAnswer2("3");
        newQ23.setAnswer3("8");
        newQ23.setAnswer4("5");
        newQ23.setRightAnswer(3);
        questList.add(newQ23);

        Question newQ24 = new Question();
        newQ24.setQuestion("What does this code output?\nletters = ['x', 'y', 'z']\nletters.insert(1, 'w')\nprint(letters[2])");
        newQ24.setAnswer1("z");
        newQ24.setAnswer2("w");
        newQ24.setAnswer3("y");
        newQ24.setAnswer4("x");
        newQ24.setRightAnswer(3);
        questList.add(newQ24);

        Question newQ25 = new Question();
        newQ25.setQuestion("What symbol is used to make a single line comment?");
        newQ25.setAnswer1("//");
        newQ25.setAnswer2("\\\\");
        newQ25.setAnswer3("<");
        newQ25.setAnswer4("#");
        newQ25.setRightAnswer(4);
        questList.add(newQ25);

        Question newQ26 = new Question();
        newQ26.setQuestion("What error is caused by importing an unknown module?");
        newQ26.setAnswer1("ImportError");
        newQ26.setAnswer2("UnknownModuleError");
        newQ26.setAnswer3("ModuleError");
        newQ26.setAnswer4("SyntaxError");
        newQ26.setRightAnswer(1);
        questList.add(newQ26);

        Question newQ27 = new Question();
        newQ27.setQuestion("Choose the correct syntax to import the \"math\" module.");
        newQ27.setAnswer1("include math");
        newQ27.setAnswer2("import math");
        newQ27.setAnswer3("import(\"math\")");
        newQ27.setAnswer4("connect \"math\"");
        newQ27.setRightAnswer(2);
        questList.add(newQ27);

        Question newQ28 = new Question();
        newQ28.setQuestion("What name is given to Python's pre installed modules?");
        newQ28.setAnswer1("Unix");
        newQ28.setAnswer2("Import Library");
        newQ28.setAnswer3("The Standart Library");
        newQ28.setAnswer4("Usual Sample Library");
        newQ28.setRightAnswer(3);
        questList.add(newQ28);

        Question newQ29 = new Question();
        newQ29.setQuestion("What does PyPI stand for?");
        newQ29.setAnswer1("Python Package Installer");
        newQ29.setAnswer2("Python Project Index");
        newQ29.setAnswer3("Python Pattern Information");
        newQ29.setAnswer4("Python Package Index");
        newQ29.setRightAnswer(4);
        questList.add(newQ29);

        Question newQ30 = new Question();
        newQ30.setQuestion("What keyword is used to create your own function?");
        newQ30.setAnswer1("function");
        newQ30.setAnswer2("def");
        newQ30.setAnswer3("func");
        newQ30.setAnswer4("proc");
        newQ30.setRightAnswer(2);
        questList.add(newQ30);

        Question newQ31 = new Question();
        newQ31.setQuestion("Which exception is raised by this code?\nprint(\"7\" + 4)");
        newQ31.setAnswer1("TypeError");
        newQ31.setAnswer2("ValueError");
        newQ31.setAnswer3("ZeroDivisionError");
        newQ31.setAnswer4("FunctionError");
        newQ31.setRightAnswer(1);
        questList.add(newQ31);

        Question newQ32 = new Question();
        newQ32.setQuestion("What statement is used to handle exceptions?");
        newQ32.setAnswer1("try/catch");
        newQ32.setAnswer2("try/finish");
        newQ32.setAnswer3("try/except");
        newQ32.setAnswer4("try/test");
        newQ32.setRightAnswer(3);
        questList.add(newQ32);

        Question newQ33 = new Question();
        newQ33.setQuestion("What keyword is used to raise exceptions?");
        newQ33.setAnswer1("throw");
        newQ33.setAnswer2("call");
        newQ33.setAnswer3("drop");
        newQ33.setAnswer4("raise");
        newQ33.setRightAnswer(4);
        questList.add(newQ33);

        Question newQ34 = new Question();
        newQ34.setQuestion("Which function is used to access files?");
        newQ34.setAnswer1("open()");
        newQ34.setAnswer2("fopen()");
        newQ34.setAnswer3("fileopen()");
        newQ34.setAnswer4("faccess()");
        newQ34.setRightAnswer(1);
        questList.add(newQ34);

        Question newQ35 = new Question();
        newQ35.setQuestion("How would you close a file stored in a variable \"text_file\"?");
        newQ35.setAnswer1("close(text_file)");
        newQ35.setAnswer2("text_file.close()");
        newQ35.setAnswer3("close(\"text_file\")");
        newQ35.setAnswer4("fclose(text_file)");
        newQ35.setRightAnswer(2);
        questList.add(newQ35);

        Question newQ36 = new Question();
        newQ36.setQuestion("Which line of code writes \"Hello world!\" to a file?");
        newQ36.setAnswer1("write(\"Hello world!\", file)");
        newQ36.setAnswer2("write(file, \"Hello world!\")");
        newQ36.setAnswer3("file.write(\"Hello world!\")");
        newQ36.setAnswer4("input.file(\"Hello world!\")");
        newQ36.setRightAnswer(3);
        questList.add(newQ36);

        Question newQ37 = new Question();
        newQ37.setQuestion("If a file write operation is successful, which one of these statements will be true?");
        newQ37.setAnswer1("file.write(msg) == true");
        newQ37.setAnswer2("file.write(msg) == msg");
        newQ37.setAnswer3("file.write(msg) == 1");
        newQ37.setAnswer4("file.write(msg) == len(msg)");
        newQ37.setRightAnswer(4);
        questList.add(newQ37);

        Question newQ38 = new Question();
        newQ38.setQuestion("How to open the file in binary read mode?");
        newQ38.setAnswer1("open(\"test.txt\", \"b\")");
        newQ38.setAnswer2("open(\"test.txt\", \"r\", \"bin\")");
        newQ38.setAnswer3("open(\"test.txt\", \"rb\")");
        newQ38.setAnswer4("open(\"test.txt\", \"bin\")");
        newQ38.setRightAnswer(3);
        questList.add(newQ38);

        Question newQ39 = new Question();
        newQ39.setQuestion("What is \"None\" often used to represent?");
        newQ39.setAnswer1("Absence of a value");
        newQ39.setAnswer2("A false value");
        newQ39.setAnswer3("An invalid value");
        newQ39.setAnswer4("An error value");
        newQ39.setRightAnswer(1);
        questList.add(newQ39);

        Question newQ40 = new Question();
        newQ40.setQuestion("What is the result of this code?\ntest = {}\nprint(test[0])");
        newQ40.setAnswer1("None");
        newQ40.setAnswer2("KeyError");
        newQ40.setAnswer3("0");
        newQ40.setAnswer4("false");
        newQ40.setRightAnswer(2);
        questList.add(newQ40);

        Question newQ41 = new Question();
        newQ41.setQuestion("What is the result of this code?\nprimes = {1: 2, 2: 3, 4: 7, 7: 17}\nprint(primes[primes[4]])");
        newQ41.setAnswer1("1");
        newQ41.setAnswer2("7");
        newQ41.setAnswer3("2");
        newQ41.setAnswer4("17");
        newQ41.setRightAnswer(4);
        questList.add(newQ41);

        Question newQ42 = new Question();
        newQ42.setQuestion("What is the result of this code?\nfib ={1: 1, 2: 1, 3: 2, 4: 3}\nprint(fib.get(4, 0) + fib.get(7, 5))");
        newQ42.setAnswer1("5");
        newQ42.setAnswer2("13");
        newQ42.setAnswer3("17");
        newQ42.setAnswer4("8");
        newQ42.setRightAnswer(4);
        questList.add(newQ42);

        Question newQ43 = new Question();
        newQ43.setQuestion("What is the result of this code?\nsqs = [0, 1, 4, 9, 16, 25, 36, 49, 64]\nprint(sqs[4:7])");
        newQ43.setAnswer1("[16, 25, 36, 49]");
        newQ43.setAnswer2("[25, 36, 49]");
        newQ43.setAnswer3("[16, 25, 36]");
        newQ43.setAnswer4("[25, 36");
        newQ43.setRightAnswer(3);
        questList.add(newQ43);

        Question newQ44 = new Question();
        newQ44.setQuestion("What is the output of this code?\nsqs = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]\nprint(sqs[1::4])");
        newQ44.setAnswer1("[1, 25, 81]");
        newQ44.setAnswer2("An error occurs");
        newQ44.setAnswer3("[1, 25]");
        newQ44.setAnswer4("[0, 1, 4]");
        newQ44.setRightAnswer(1);
        questList.add(newQ44);

        Question newQ45 = new Question();
        newQ45.setQuestion("What is the output of this code?\nsqs = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]\nprint(sqs[7:5:-1])");
        newQ45.setAnswer1("[]");
        newQ45.setAnswer2("[49, 36]");
        newQ45.setAnswer3("[49]");
        newQ45.setAnswer4("[25, 36, 49]");
        newQ45.setRightAnswer(2);
        questList.add(newQ45);

        Question newQ46 = new Question();
        newQ46.setQuestion("Which list slicing reverses the list 'numbers'?");
        newQ46.setAnswer1("numbers[::]");
        newQ46.setAnswer2("numbers[0:-1]");
        newQ46.setAnswer3("numbers[::-1]");
        newQ46.setAnswer4("numbers[-1::]");
        newQ46.setRightAnswer(3);
        questList.add(newQ46);

        Question newQ47 = new Question();
        newQ47.setQuestion("What could be described an immutable list?");
        newQ47.setAnswer1("A dictionary");
        newQ47.setAnswer2("A number");
        newQ47.setAnswer3("A function");
        newQ47.setAnswer4("A tuple");
        newQ47.setRightAnswer(4);
        questList.add(newQ47);

        Question newQ48 = new Question();
        newQ48.setQuestion("What is returned by functions that don't have a return statement?");
        newQ48.setAnswer1("None");
        newQ48.setAnswer2("False");
        newQ48.setAnswer3("0");
        newQ48.setAnswer4("-1");
        newQ48.setRightAnswer(1);
        questList.add(newQ48);

        Question newQ49 = new Question();
        newQ49.setQuestion("What are anonymous functions called?");
        newQ49.setAnswer1("lombdas");
        newQ49.setAnswer2("lambdas");
        newQ49.setAnswer3("lamdas");
        newQ49.setAnswer4("lambd");
        newQ49.setRightAnswer(2);
        questList.add(newQ49);

        Question newQ50 = new Question();
        newQ50.setQuestion("What statement is used in functions to turn them into generators?");
        newQ50.setAnswer1("generate");
        newQ50.setAnswer2("return");
        newQ50.setAnswer3("yield");
        newQ50.setAnswer4("lambdas");
        newQ50.setRightAnswer(3);
        questList.add(newQ50);

        Question newQ51 = new Question();
        newQ51.setQuestion("Which statement can be used to achieve the same behavior as\nmy_func = my_dec(my_func)?");
        newQ51.setAnswer1("@my_dec");
        newQ51.setAnswer2("my_func = @my_dec");
        newQ51.setAnswer3("my_dec(my_func)");
        newQ51.setAnswer4("my_dec + @my_func");
        newQ51.setRightAnswer(1);
        questList.add(newQ51);

        Question newQ52 = new Question();
        newQ52.setQuestion("Which of the following data types does not allow duplicate values?");
        newQ52.setAnswer1("Dictionaries");
        newQ52.setAnswer2("Tuple");
        newQ52.setAnswer3("Lists");
        newQ52.setAnswer4("Sets");
        newQ52.setRightAnswer(4);
        questList.add(newQ52);

        Question newQ53 = new Question();
        newQ53.setQuestion("What error is caused by trying to access unknown attributes?");
        newQ53.setAnswer1("NameError");
        newQ53.setAnswer2("TypeError");
        newQ53.setAnswer3("AttributeError");
        newQ53.setAnswer4("ValueError");
        newQ53.setRightAnswer(3);
        questList.add(newQ53);

        Question newQ54 = new Question();
        newQ54.setQuestion("Which piece of code shows a new class Spam inheriting from Egg?");
        newQ54.setAnswer1("class Egg : Spam:");
        newQ54.setAnswer2("class Spam(Egg):");
        newQ54.setAnswer3("class (Spam)Egg:");
        newQ54.setAnswer4("class Spam -> Egg:");
        newQ54.setRightAnswer(2);
        questList.add(newQ54);

        /*Question newQ55 = new Question();
        newQ55.setQuestion("Which function is used to stop a \"setInterval\" timer?");
        newQ55.setAnswer1("stopTimer");
        newQ55.setAnswer2("clearInterval");
        newQ55.setAnswer3("stopInterval");
        newQ55.setAnswer4("clearTimer");
        newQ55.setRightAnswer(2);
        questList.add(newQ55);

        Question newQ56 = new Question();
        newQ56.setQuestion("The type of function that executes when an event occurs is called:");
        newQ56.setAnswer1("event handler");
        newQ56.setAnswer2("event home");
        newQ56.setAnswer3("event function");
        newQ56.setAnswer4("event description");
        newQ56.setRightAnswer(1);
        questList.add(newQ56);

        Question newQ57 = new Question();
        newQ57.setQuestion("Can multiple event handlers be added to a single element?");
        newQ57.setAnswer1("No");
        newQ57.setAnswer2("Yes");
        newQ57.setAnswer3("Only for \"head\" element");
        newQ57.setAnswer4("Only for \"body\" element");
        newQ57.setRightAnswer(2);
        questList.add(newQ57);

        Question newQ58 = new Question();
        newQ58.setQuestion("A paragraph is inside a div element. You want the paragraph's click event to be handled first. You should use:");
        newQ58.setAnswer1("Handling");
        newQ58.setAnswer2("Capturing");
        newQ58.setAnswer3("Bubbling");
        newQ58.setAnswer4("Scrabling");
        newQ58.setRightAnswer(3);
        questList.add(newQ58);

        /*Question newQ59 = new Question();
        newQ59.setQuestion("For a member named \"mem\", select the two correct ways to print out a class memeber.");
        newQ59.setAnswer1("cout **mem;");
        newQ59.setAnswer2("cout  >> mem;");
        newQ59.setAnswer3("cout << *this >> mem");
        newQ59.setAnswer4("cout << this -> mem;");
        newQ59.setRightAnswer(4);
        questList.add(newQ59);

        Question newQ60 = new Question();
        newQ60.setQuestion("Which choice is the keyword for overloading an operator in C++?");
        newQ60.setAnswer1("this");
        newQ60.setAnswer2("operator");
        newQ60.setAnswer3("friend");
        newQ60.setAnswer4("overload");
        newQ60.setRightAnswer(2);
        questList.add(newQ60);

        Question newQ61 = new Question();
        newQ61.setQuestion("A class' public members are available to...");
        newQ61.setAnswer1("...derived class's member functions only");
        newQ61.setAnswer2("...everyone");
        newQ61.setAnswer3("...class member function only");
        newQ61.setAnswer4("...derived class's friend functions only");
        newQ61.setRightAnswer(2);
        questList.add(newQ61);

        Question newQ62 = new Question();
        newQ62.setQuestion("What does protected mean?");
        newQ62.setAnswer1("members are private");
        newQ62.setAnswer2("members are available to everyone");
        newQ62.setAnswer3("members are available to derived class members");
        newQ62.setAnswer4("members are not available for everyone");
        newQ62.setRightAnswer(3);
        questList.add(newQ62);

        Question newQ63 = new Question();
        newQ63.setQuestion("Briefly, polymorphism is...");
        newQ63.setAnswer1("...each implementation in a different functions");
        newQ63.setAnswer2("...one implementation, with different functions");
        newQ63.setAnswer3("...one implementation ,with one function");
        newQ63.setAnswer4("...one function, with different implementations");
        newQ63.setRightAnswer(4);
        questList.add(newQ63);

        Question newQ64 = new Question();
        newQ64.setQuestion(" A class is called polymorphic if ...");
        newQ64.setAnswer1("...it was declared using the keyword \"polymorphic\"");
        newQ64.setAnswer2("...it has a friend function");
        newQ64.setAnswer3("...it has constructor and destructor");
        newQ64.setAnswer4("...it has a virtual function");
        newQ64.setRightAnswer(4);
        questList.add(newQ64);

        Question newQ65 = new Question();
        newQ65.setQuestion("How to declare a pure function \"foo()\"?");
        newQ65.setAnswer1("virtual void foo( ) = 0;");
        newQ65.setAnswer2("virtual pure foo( );");
        newQ65.setAnswer3("pure void foo( ) { };");
        newQ65.setAnswer4("pure void $foo( );");
        newQ65.setRightAnswer(1);
        questList.add(newQ65);

        Question newQ66 = new Question();
        newQ66.setQuestion("A pure virtual function...");
        newQ66.setAnswer1("...must have an implementation");
        newQ66.setAnswer2("...has no body and must be implemented in derived classes");
        newQ66.setAnswer3("...must always return void");
        newQ66.setAnswer4("...must have a constructor and destructor");
        newQ66.setRightAnswer(2);
        questList.add(newQ66);

        Question newQ67 = new Question();
        newQ67.setQuestion("An abstract class is a class that...");
        newQ67.setAnswer1("...has a pure virtual function");
        newQ67.setAnswer2("...was declared using the \"abstract\" keyword");
        newQ67.setAnswer3("...has at least two methods declared");
        newQ67.setAnswer4("...has destructor");
        newQ67.setRightAnswer(1);
        questList.add(newQ67);

        Question newQ68 = new Question();
        newQ68.setQuestion("What keyword is used to throw an exception in C++?");
        newQ68.setAnswer1("pull");
        newQ68.setAnswer2("exc");
        newQ68.setAnswer3("throw");
        newQ68.setAnswer4("except");
        newQ68.setRightAnswer(3);
        questList.add(newQ68);

        Question newQ69 = new Question();
        newQ69.setQuestion("Which header file should be included to work with files?");
        newQ69.setAnswer1("<filestream>");
        newQ69.setAnswer2("<fiostream>");
        newQ69.setAnswer3("<fstream>");
        newQ69.setAnswer4("<foustream>");
        newQ69.setRightAnswer(3);
        questList.add(newQ69);

        Question newQ70 = new Question();
        newQ70.setQuestion("Which of the following declarations is illegal?");
        newQ70.setAnswer1("double a = 1;");
        newQ70.setAnswer2("char str = \"hello\";");
        newQ70.setAnswer3("const int* p1;");
        newQ70.setAnswer4("char *str = \"hello\";");
        newQ70.setRightAnswer(2);
        questList.add(newQ70);*/



       try {
            FileOutputStream outfile = new FileOutputStream("rubyquestions.ser");

            ObjectOutputStream out  = new ObjectOutputStream(outfile);
            out.writeObject(questList);

            outfile.close();
            out.close();
            System.out.println("good");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*Object tempObj = null;
        try {
            FileInputStream filein = new FileInputStream("htmlquestions.ser");
            ObjectInputStream in = new ObjectInputStream(filein);
            tempObj = in.readObject();
            filein.close();
            in.close();

            questList = (ArrayList<Question>)tempObj;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }






        for(Question t : questList){
            System.out.println(t.getQuestion());
            System.out.println(t.getAnswer1());
            System.out.println(t.getAnswer2());
            System.out.println(t.getAnswer3());
            System.out.println(t.getAnswer4());
            System.out.println(t.getRightAnswer());
        }*/

    }
}
