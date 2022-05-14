package Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserController {

  /* Faz o parse das linhas do arquivo retornando um vetor com os números, apenas números*/

  public static Vector treatLinesFromTxt(String path_and_file) {
    /*
      Analisa as linhas do arquivo em busca de números e retorna o vetor para
      ser verificado novamente após isso.
      :parameters: String (caminho do arquivo)
      :return: Vector (vetor com números adquiridos ao ler o arquivo)
      */
    String text = new String();
    String[] items;
    Path path_type = Paths.get(path_and_file);
    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher;
    double num;
    Vector numbers = new Vector();
    boolean is_number = false;
    List<String> lines;
    try {
      text = new String(Files.readAllBytes(path_type));
      lines = new ArrayList<>();
      lines.add(text);
      for (String line : lines) {
        items = line.replaceAll("\\s+", ",").split(","); // alguns arquivos continham espaços em branco e vírgulas, logo, é necessário considerá-los também.
        for (String item : items) {
          matcher = pattern.matcher(item);
          is_number = matcher.matches();
          if (is_number) {
            num = Double.parseDouble(item.trim());
            if ((int) num > 5000000) { // Em uma rápida leitura no arquivo, percebe-se que há números primos maiores, isso reduz uso de memória e processamento
              numbers.add((int) num);
            } // fim do if
          } // fim do if
        } // fim do for
        lines.clear(); // não ocupar demasiada memória, pós alocação
      } // fim do for
    } catch (IOException e) {  e.printStackTrace(); }
    finally { return numbers; } // após o tratamento dos erros, retorna os números.
  }
}
