import Controllers.BruteForceController;
import Controllers.PerformerController;
import java.util.List;
import java.util.Scanner;



public class Main {
    /*
       Classe principal que invoca os métodos de bruteforce e multiprocessamento.
       Além disso, é necessário ter a dependência contida no arquivo requirements.txt para executar o programa.
    */
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice;
        BruteForceController bfc = new BruteForceController();

        System.out.println(ANSI_GREEN + "       %                           %.    \n" +
                "   @@   @                       @   @@  \n" +
                ",@    @@       @@@@%,.*@@@@@     @@    @\n" +
                " @@@@@@  @@@@                @@@ ,@@@@@@\n" +
                "        @@@                     @       \n" +
                "        ,@                       @      \n" +
                "        @@    .@@@@     @@@@     @      \n" +
                "         @/   @@@@@#   @@@@@@   @/      \n" +
                "          .@             @@   @@        \n" +
                "         @@  @@@    @@@    @@ @@        \n" +
                "       @@ @@   @           @ @@ @@      \n" +
                " @   @ ,@      @@@@@@@@@@@@@   *@  @   @\n" +
                " @@@@  *@                       @   @@@@\n" +
                "    @@&@&                       @@&@@  ");
        System.out.println(ANSI_GREEN + "\n    WELCOME TO CRACK THE PASSWORD!!!");
        System.out.println("[*]CHOOSE 1 TO RUN THE MAIN PROGRAM (SEEK 7-CHARACTER PASSWORD)"); // escolha 1 possui threads
        System.out.println("[*]CHOOSE 2 TO SET A PASSWORD SIZE (THIS MAY TAKE TIME)"); //escolha 2 não possui threads, mas, suporta qualquer tamanho
        System.out.println("[*]ANY OTHER KEY TO EXIT");
        System.out.print("[***]YOUR CHOICE >>>  ");
        try{
            choice = input.nextInt();
            if(choice == 1){
                // combinação de caracteres a serem testados pelas threads a fim de garantir ataques diversos, porém,não randômicos
                String string  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                String string1  = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String string2  = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String string3  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                String string4  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                String string5  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
                PerformerController thread1 = new PerformerController(string), thread2 = new PerformerController(string1),
                        thread3 = new PerformerController(string2), thread4 = new PerformerController(string3),
                        thread5 = new PerformerController(string4), thread6 = new PerformerController(string5);
                // inicio das threads
                thread1.start();thread2.start();thread3.start();
                thread4.start();thread5.start();thread6.start();
                // sincronização das threads
                try {
                    thread1.join();thread2.join(); thread3.join();
                    thread4.join();thread5.join();thread6.join();
                } catch (InterruptedException e) { e.printStackTrace(); } // fim do tratamento de erro
            }else if(choice == 2){
                // escolhe tamanho arbitrário de senhas
                System.out.print("\n[*]LENGTH >>> ");
                try{
                    String pw = "";
                    choice = input.nextInt();
                    bfc.product(List.of(
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
                            'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0','1', '2', '3',
                            '4', '5', '6', '7', '8', '9'), choice).forEach(
                                    (item) -> bfc.getFindThisZip().unzipFile(
                                            item.toString().replace("[", "")
                                                    .replace("]", "").replace(",", "")
                                                    .replace(" ", "")));
                }catch (Exception e){  } // fim do tratamento de erro

            }else{
                System.out.println("[*]BYE");
                System.exit(0);
            } // fim do else
        }catch (Exception e){
            System.out.println("[*]BYE");
            System.exit(0);
        } // fim do tratamento de erros

    }
}
