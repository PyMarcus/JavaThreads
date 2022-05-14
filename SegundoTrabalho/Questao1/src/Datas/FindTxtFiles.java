package Datas;

import Controllers.FilterController;
import Controllers.ParserController;
import java.io.File;
import java.util.Vector;

public class FindTxtFiles {

    /*
     • Classe definida para percorrer os diretórios, recursivamente, com a finalidade de encontrar os arquivos com extensão .txt
     */

  private Vector<String> txt_files = new Vector<>();
  private String where_are = new String();
  public static Vector<String> vetor = new Vector<>();
  public static int max = 0;
  public static String path_ = new String();

  public FindTxtFiles(String where_are) {
    /*
            • Constrói o objeto
            :parameters: where_are (path) String
            :return: void
         */
    this.where_are = where_are;
  }

  public FindTxtFiles() { this.where_are = null;}

  // getters e setters
  public Vector<String> getTxtFiles() { return txt_files; }

  public void setTxtFiles(Vector<String> txt_files) { this.txt_files = txt_files; }

  public String getWhereAre() {return where_are;}

  public void setWhereAre(String where_are) { this.where_are = where_are; }

  // métodos:
  public void findData(String dir_name) {
         /* Percorre os diretórios, de forma recursiva, e filtra arquivos .txt
           :parameters: String (nome do diretório dos arquivos)
           :return: void
         */
    File dir;
    String convert_to_string = "";

    if (getWhereAre() == null) dir = new File(dir_name); else dir = new File(getWhereAre());
    File[] diretories = dir.listFiles();

    if (diretories != null){
      for (int i = 0; i < diretories.length; i++){
        convert_to_string = diretories[i].toString();
        String parser = FilterController.filterThis(convert_to_string);
        if (!parser.equals("")) this.vetor.add(convert_to_string);
        findData(convert_to_string); // recursão
      } // fim do for
    } // fim do if
  }

  public Vector dirPaths() {
    /*
      Retorna vetor com o caminho dos diretórios
      :parameters: void
      :return: Vector
    */
    return vetor;
  }

  public static void capture(int num, String path) {
    /*
      Verifica, de modo comparativo os números, buscando sempre o maior
      :parameters: num (int), path (String)
      return: void
    */
    if (max < num) {
      max = num;
      path_ = path;
      System.out.println("[*]Possible largest prime number found in: " + path);
    } // fim do if
  }
}
