package Controllers;

public class SolveCpf {

  /*
      • Classe que verifica se o cpf é válido
      com base em cálculos tradicionais.Basta, portanto, passar-lhe um número com 11 algarismos.
    */

  private String cpf = new String();

  // getters e setters
  public String getCpf() { return this.cpf; }

  public void setCpf(String new_value) { this.cpf = new_value; }

  // constructor:
  public SolveCpf(String cpf) {
    assert cpf.length() == 11; // o tamanho deve ser igual a 11
    this.cpf = cpf;
  }

  // métodos:
  public boolean verifyCpf() {
    /*
        Método que recebe o cpf e chama outros dois para calcular os dígitos verificadores finais
        "O algoritmo de validação de CPF calcula o primeiro dígito verificador a partir dos 9 primeiros
         dígitos do CPF, e em seguida, calcula o segundo dígito verificador a partir dos 9 primeiros dígitos do CPF,
         mais o primeiro dígito, obtido na primeira parte."
        :parameters: void
        :return: boolean
     */

    int[] cpf_ = new int[11];
    int[] noRefMemo = new int[11];
    for (int i = 0; i < getCpf().length(); i++) { // loop que percorre números de cpf com a tentativa de se ter menos condicionais
      cpf_[i] = Integer.parseInt(String.valueOf(getCpf().charAt(i)));
      noRefMemo[i] = Integer.parseInt(String.valueOf(getCpf().charAt(i)));
    }
    int tenth = findTheFirst(cpf_);

    if ((int) cpf_[9] == tenth) {
      int eleventh = findTheSecond(noRefMemo);
      if (eleventh == (int) cpf_[10]) return true;
    }
    return false;
  }

  private int findTheFirst(int[] nineDigits) {
    /*
      Método que calcula o primeiro dígito.
      :parameters: int[] (os nove digitos do cpf)
      :return: int (retorna o décimo dígido)
    */
    int sum = 0;
    int count = 2;
    for (int i = nineDigits.length - 3; i >= 0; i--) {
      nineDigits[i] = nineDigits[i] * count;  
      count++;
    }
    for (int i = nineDigits.length - 3; i >= 0; i--) sum += nineDigits[i]; // soma os valores acumulados pelas multiplicações acima
    int rest = sum % 11;  // pega o resto da divisao por 11
    if (rest >= 2) return 11 - rest;
    return 0;
  }

  private int findTheSecond(int[] nineDigits) {
    /*
      Método que calcula o primeiro dígito.
      :parameters: int[] (os nove dígitos do cpf)
      :return: int (retorna o décimo primeiro dígito)
    */
    int sum = 0;
    int count = 2;
    for (int i = nineDigits.length - 2; i >= 0; i--) {
      nineDigits[i] = nineDigits[i] * count;
      count++;
    }
    for (int i = nineDigits.length - 2; i >= 0; i--) sum += nineDigits[i]; // soma os valores acumulados pelas multiplicações acima
    int rest = sum % 11; // pega o resto da divisao por 11
    if (rest >= 2) return 11 - rest;
    return 0;
  }
}
