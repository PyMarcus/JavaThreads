package Datas;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;


public class FindZipFile {
    /*
        Classe responsável por conter funcionalidades que abrem e testam as
        senhas geradas no arquivo zip especificado
     */
    private String local;
    protected static final String RED = "\u001B[31m";  // cores (vermelha: password não encontrado)
    protected static final String SUCCESS = "\u001B[32m"; // cor (verde: password encontrado)

    //getter e setter
    public String getLocal() { return local; }

    public void setLocal(String local) { this.local = local; }

    public FindZipFile(String path){ this.local = path; }

    public void unzipFile(String pw){
        /*
            Método que acessa e ataca ,o arquivo com senha, a fim de descompactá-lo.
            :parameters: String (a senha gerada)
            :return: void
         */

        String[] name = getLocal().replace("\\", ",").split(","); // pega nome do arquivo zip
        String[] local_ = getLocal().replace("\\", ",").split(",");
        ZipFile zip_file = new ZipFile(getLocal(), pw.toCharArray());  // comprime o arquivo especificado
        try
        {
            zip_file.extractFile("resultado.txt", getLocal().replace(local_[local_.length - 1], ""));  // Se concluído, descompacta para a pasta resultado
            System.out.println(SUCCESS + "[*] GOOD JOB!");
            System.out.println(SUCCESS + "[*] PASSWORD WAS FOUND: " + pw);
            System.exit(0); // encerra programa, ao concluir!
        }
        catch (ZipException e) {  System.out.println(RED + "[*] Possible password found: " + pw); }
    }
}
