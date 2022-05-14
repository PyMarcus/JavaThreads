package Controllers;

import java.io.File;

public class FilterController {
  /*
    Classe que cria métodos, estáticos, de filtros pela extensão de arquivos (estilo estruturada, devido conter apenas um método)
   */

  public static String filterThis(String file_path_name) {
    /*
      Filtra o arquivo conforme a sua extensão, já pré-definida como .txt.
      :parameters: file_path_name (String) caminho para o arquivo
      :return: String se for txt, retorna o nome do caminho para o arquivo, do contrário, empty string
     */
    File file = new File(file_path_name);
    boolean ext_from_file = file.getName().endsWith(".txt");
    if (ext_from_file) return file_path_name;
    return "";
  }
}
