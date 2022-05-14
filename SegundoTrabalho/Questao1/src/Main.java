import Controllers.FilterController;
import Controllers.ThreadsController;
import Datas.FindTxtFiles;
import java.util.List;
import java.util.Vector;

public class Main {

  public int max = 0;

  public static void main(String[] args) {
    /*
         • Método principal que faz a chamada dos outros OBS: os arquivos devem estar no Desktop,
           em uma pasta chamada programacaoParalela
         */

    String dir = new String("");

    // definição do path do sistema para definir local do arquivo:
    if (System.getProperty("os.name").contains("Windows")) dir = System.getProperty("user.home") + "\\Desktop\\programacaoParalela\\";
    else dir = System.getProperty("user.home") + "/Desktop/programacaoParalela/";

    // declaração de variáveis e definição da quantidade de cpus e path para os arquivos
    FindTxtFiles txt_files = new FindTxtFiles();
    txt_files.findData("C:\\Users\\Marcu\\Desktop\\programacaoParalela\\");
    List list = txt_files.dirPaths();
    int tam = list.size(), cpus = Runtime.getRuntime().availableProcessors(), ref = (int) (tam / cpus), max = 0;

    ThreadsController[] threads = new ThreadsController[cpus];
    // Distribuição da quantidade de arquivos a serem processados por núcleos da máquina hospedeira do programa, a fim de melhorar o processamento:
    List v1 = list.subList(0, ref), v2 = list.subList(ref, ref * 2), v3 = list.subList(ref * 2, ref * 3),
    v4 = list.subList(ref * 3, ref * 4),v5 = list.subList(ref * 4, ref * 5), v6 = list.subList(ref * 5, ref * 6);
    threads[0] = new ThreadsController(v1); threads[1] = new ThreadsController(v2); threads[2] = new ThreadsController(v3);
    threads[3] = new ThreadsController(v4); threads[4] = new ThreadsController(v5); threads[5] = new ThreadsController(v6);

    // inicia as threads declaradas acima
    for (int cpu = 0; cpu < threads.length; cpu++) threads[cpu].start();
    
    // sincroniza as threads
    for (int cpu = 0; cpu < threads.length; cpu++) {
      try {
        threads[cpu].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } // fim do tratamento de erro
    } // fim do for

    // exibição para o usuário
    System.out.println("[*]The largest prime number is: " + FindTxtFiles.max);
    System.out.println("[*]the path to the largest prime number is?: " + FindTxtFiles.path_);
  }
}
