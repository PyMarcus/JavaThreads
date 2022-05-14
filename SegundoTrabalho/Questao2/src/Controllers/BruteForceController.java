package Controllers;


import Datas.FindZipFile;

import java.util.*;

public class BruteForceController {
    /*
        Classe que faz combinações, com a ideia de permutação, para executar
        as tentativas forçadas de encontrar a senha.
     */
    
    // modificadores de acesso
    private String data;
    private final String user = System.getProperty("user.name");
    private final FindZipFile findThisZip = new FindZipFile("C:\\Users\\" + getUser() + "\\Desktop\\arquivo.zip");

    public String getUser() {return user;}

    public FindZipFile getFindThisZip() {return findThisZip;}

    // constructor
    public BruteForceController(String data){ this.data = data; }
    public BruteForceController(){};

    //getters and setters
    public String getData() { return data; }

    public void setData(String data) {this.data = data; }

    // métodos
    public void unLock(){
        /*
            Método que faz as combinações de caracteres, passa por  todas as combinações.Contudo, possui tamanho definido,
            uma vez que, a informação de comprimento da senha foi dada.
            A sequência de for, garantiu bastante velocidade no processo, ao contrário de uma primeira tentativa de recursividade
            :parameters: (void)
            :return: (void)
         */
        char[] password = new char[7];
        char[] char_vet = getData().toCharArray();
        String pw = new String("");

        int count = 0;
        for (int first = 0; first < char_vet.length; first++) {
            password[count] = char_vet[first];
            for (int second = 0; second < char_vet.length; second++) {
                password[count + 1] = char_vet[second];
                for (int third = 0; third < char_vet.length; third++) {
                    password[count + 2] = char_vet[third];
                    for (int fourth = 0; fourth < char_vet.length; fourth++) {
                        password[count + 3] = char_vet[fourth];
                        for (int fifth = 0; fifth < char_vet.length; fifth++) {
                            password[count + 4] = char_vet[fifth];
                            for (int sixth = 0; sixth < char_vet.length; sixth++) {
                                password[count + 5] = char_vet[sixth];
                                for (int seventh = 0; seventh < char_vet.length; seventh++) {
                                    password[count + 6] = char_vet[seventh];
                                    for(char charactere : password) pw += charactere;
                                    getFindThisZip().unzipFile(pw);  // a senha gerada é enviada ao método unzipfile para ser testada
                                    pw = "";
                                } // fim do sétimo for
                            } // fim do sexto for
                        } // fim do quinto for
                    } // fim do quarto for
                } // fim do terceiro for
            } // fim do segundo for
        } // fim do primeiro for
    }

    public <T> List<Collection<T>> product(Collection<T> interator, int length) {
        /*
        Método pronto que simula o método product da classe intertools do python.
        Esse método foi implementado para conferir maior flexibilidade ao programa(além da ideia de otimizar o tempo de desenvolvimento),contudo,
        o uso de threads no mesmo não foi viabilizado.
        # o recurso está disponível em: https://stackoverflow.com/questions/63433335/java-alternative-of-product-function-of-python-form-itertools
        Todo o crédito para o autor deste método.
        :parameters (Collections<T>) conjunto de caracteres separados por virgulas
        :parameters (int) tamanho da senha
        : return (List)
        */
        String pw = new String("");
        List<Collection<T>> result = Collections.nCopies(1, Collections.emptyList());
        for (Collection<T> pool : Collections.nCopies(length, new LinkedHashSet<>(interator))) {  // cria combinações em um dicionário
            List<Collection<T>> temp = new ArrayList<>();
            for (Collection<T> x : result) {  // para cada combinação, concatena no array list
                for (T y : pool) {
                    Collection<T> z = new ArrayList<>(x);
                    z.add(y);
                   pw += y;
                    temp.add(z);
                }
            }
            result = temp;
        }
        return result;
    }


}
