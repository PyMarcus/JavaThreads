package Controllers;

public class PerformerController extends Thread{
    /*
        Classe criada para aumentar o desempenho dos ataques ao arquivo e,
        além disso, criar multiplas threads
     */
    private String data;

    public PerformerController(String data){ this.data = data; }

    public String getData() {  return data;}

    public void setData(String data) { this.data = data;}

    @Override
    public void run() {
        /*
        Método sobreescrito da classe thread, utiliza threads para execução em paralelo.
         */
        super.run();
        BruteForceController brute_force_pw = new BruteForceController(getData());
        brute_force_pw.unLock();
    }
}
