package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Performer extends Thread {

    /*
        Classe criada para escrever, em arquivo, os resultados obtidos e,
        além disso, criar multiplas threads.Além disso, exibe no terminal, os resultados.
     */
  private FileWriter write;
  private final Long init;
  private final Long end;
  private final String init_;

  // getters e setters
  public String getInit_() { return init_; }

  public Long getInit() { return init;}

  public Long getEnd() { return end; }

  // constructor
  public Performer(long init, long end, String init_) {
    this.init = init;
    this.end = end;
    this.init_ = init_;
  }

  // escreve no arquivo os cpfs gerados válidos, bem como também os exibe:
  @Override
  public void run() {
    super.run();
    String user = System.getProperty("user.name");
    File _file = new File(
      "C://Users//" + user + "//Desktop//validated_cpf.txt"
    );
    String cpf_ = getInit_();
    for (long i = getInit(); i < getEnd(); i++) {
      // resolve o problema da falta de zeros, o que, se não fosse corrigido, causaria a posibilidade de cpfs inválidos começados com 0
      SolveCpf solve = new SolveCpf(cpf_.substring(0, 11 - Long.toString(i).length()) + i);  
      boolean cpf = solve.verifyCpf();

      if (cpf) {
        System.out.println("CPF 🇧🇷 válido: " + cpf_.substring(0, 11 - Long.toString(i).length()) + i);
        try {
          write = new FileWriter(_file, true);
          write.write("" + i + "\n");
          write.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
