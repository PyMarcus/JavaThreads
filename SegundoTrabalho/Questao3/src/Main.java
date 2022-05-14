import Controllers.*;

public class Main {
  /*
     • Método principal que faz a chamada dos outros da implementação
   */
  public static void main(String[] args) throws InterruptedException {
    long limit = 99999999999L;
    int cpu = Runtime.getRuntime().availableProcessors();
    long div = limit / cpu;
    // divide a distribuição do cpf para as threads, conforme a quantidade de cpus.As strings são pontos iniciais que servirão de base para o start
    Performer thread1 = new Performer(00000000000L,div, "00000000000"), thread2 = new Performer(div, div * 2, "16666666666"),
     thread3 = new Performer(div * 2, div * 3,"33333333333"), thread4 = new Performer(div * 3, div * 4, "49999999998"),
      thread5 = new Performer( div * 4,div * 5,"66666666664"), thread6 = new Performer(div * 5, div * 6, "83333333330");
    // inicializa as threads
    thread1.start();thread2.start();thread3.start();
    thread4.start();thread5.start();thread6.start();
    // sincroniza as threads
    try {
      thread1.join();thread2.join();thread3.join();
      thread4.join();thread5.join();thread6.join();
    } catch (Exception e) {}
  }
}
