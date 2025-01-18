import java.util.ArrayList;
import java.util.Scanner;

public class UrnaEletronica {

  private int numeroConvertido = 0, totalVotos = 0,  empate = 0;;
  static int votosNulos = 0;
  double porcentagem;
  Candidatos vencedor;
  private ArrayList<Candidatos> listCandidatos = new ArrayList<>();

  public UrnaEletronica() {
    listCandidatos.add(new Candidatos("Ada Lovalece", "01"));
    listCandidatos.add(new Candidatos("Alan Turing", "02"));
    listCandidatos.add(new Candidatos("Marie Curie", "03"));
    listCandidatos.add(new Candidatos("Albert Einstein", "04"));
    listCandidatos.add(new Candidatos("Ludwig Van Beethoven", "05"));
  }

  public void receberVoto(String numero) {
    int numeroConvertido = Integer.parseInt(numero);
    if (numeroConvertido >= 1 && numeroConvertido <= 5) {
      for (Candidatos candidato : listCandidatos) {
        if (candidato.getNumero().equals(numero)) {
          candidato.incrementarVotos();
          totalVotos++;
          System.out.println("Voto computado com sucesso!");
          break;
        }
      }

    } else {
      votosNulos++;
      System.out.println("Voto computado com sucesso!");
    }

  }

  public void apurarResultado() {
    int maiorVoto = 0;
    
    for (Candidatos candidatos : listCandidatos){
      if(candidatos.getVotos() > maiorVoto){
         maiorVoto = candidatos.getVotos();
        vencedor = candidatos;
        empate = 0;
      }else if(candidatos.getVotos() == maiorVoto){
        empate++;
      }
    
    }  
    
}

  public void mostarResultado() {
    System.out.println("Apuração do votos\n");
    for (Candidatos candidatos : listCandidatos) {
      if(totalVotos > 0){
      porcentagem = ((double) candidatos.getVotos() /totalVotos)*100;
      }else{
        porcentagem = 0.0;
      }
      System.out.printf("%s - %s: %d votos (%.2f%%)%n", 
      candidatos.getNumero(),
      candidatos.getNome(),  
      candidatos.getVotos(), 
      porcentagem);
    }
    if(empate == 0){
    System.out.println("O vencedor da eleição: " + vencedor.getNome());
    }else{
    System.out.println("O resultado deu empate: ");
    }
  }

  public static void main(String[] args) {
    UrnaEletronica urna = new UrnaEletronica();
    Scanner sc = new Scanner(System.in);

    System.out.println("Bem vindo a urna eletrônica");
    System.out.println();
    System.out.println("Candidatos: ");
    for (Candidatos candidatos : urna.listCandidatos) {
      System.out.println(candidatos.getNumero() + " - " + candidatos.getNome());
    }

    String numero;
    for (int i = 0; i < 10; i++) {
      while (true) {
        System.out.print("Digite o número do candidato: ");
        numero = sc.nextLine();

        if (numero.length() == 2 && numero.charAt(0) == '0') {
          urna.receberVoto(numero);
          break;
        }
        if (numero.matches("\\d")) {
          System.out.println("Voto inválido");
        } else {
          System.out.println("Voto inválido");
        }

      }

    }
    urna.apurarResultado();
    urna.mostarResultado();
    System.out.println("Voto(s) nulos: " + votosNulos);
    sc.close();
  }

}
