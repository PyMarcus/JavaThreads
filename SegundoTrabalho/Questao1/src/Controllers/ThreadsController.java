package Controllers;

import Datas.FindTxtFiles;
import java.util.List;
import java.util.Vector;

public class ThreadsController extends Thread {
  /*
  Classe responsável pelo aumento da performance do programa.
  Isso pois, ela aproveita, ao máximo, os núcleos do computador
  */

  private int max_number;
  public List<String> vector;
  public int[] numbers = new int[1];

  public int getMax_number() { return max_number; }

  public void setMax_number(int max_number) { this.max_number = max_number; }

  public ThreadsController(List vector) { this.vector = vector; }

  @Override
  public void run() {
    /*
    Executa no núcleo do processador as instruções abaixo.
    :método sobreescrito da classe Thread
    :return (void)
    */
    boolean verify = false;

    for (String files : this.vector) {
      for (Object number : ParserController.treatLinesFromTxt(files)) {
        verify = isPrime((int) number);
        if (verify) {
          if ((int) number > getMax_number()) {
            //System.out.println(number);
            setMax_number((int) number);
            this.numbers[0] = (int) number;
            FindTxtFiles.capture((int) number, files);
          } // fim do if
        } // fim do if
      } // fim do for
    } // fim do for
  }

  private boolean isPrime(int number) {
    /*
    Verifica se o número apontado é primo ou não, se o for, retorna o booleano true
    :parameters: (int) número contido no arquivo
    :return (boolean)
    */
    for (int i = 2; i < number; i++) {
      if (number % i == 0) return false;
    }
    return true;
  }
}
