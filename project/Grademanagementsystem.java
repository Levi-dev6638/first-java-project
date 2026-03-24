package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grademanagementsystem {


    static String[] materias = {
        "matematica","portugues","ciencias","historia","geografia"
    };
    static Scanner sc = new Scanner(System.in);
    static String[] nomes = new String[5];
    static double[][][] notas = new double[5][5][3];
    static ArrayList<String> aprovados = new ArrayList<>();
    static ArrayList<String> reprovados = new ArrayList<>();


      
      static public void disciplinaMaiorMedia(){
        String disciplinaMaiorMedia = "";
         double maior = 0;

        for(int j=0;j<5;j++){
             double soma = 0;
             for(int i=0;i<5;i++){
                    for(int k=0;k<3;k++){
                        soma += notas[i][j][k];
                    }  
                }
                double media = soma / 15;
                if(media > maior){
                    maior = media;
                    disciplinaMaiorMedia= materias[j];

            }
        }
        System.out.println("disciplina com a maior média e " + disciplinaMaiorMedia +"");
        System.out.println("precione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

      static public void mediaTurma(){
         double total = 0;
         double soma = 0;
        for(int i=0;i<5;i++){
             for(int j=0;j<5;j++){
                for(int k=0;k<3;k++){
                  soma += notas[i][j][k];
                  total++;
             }       
            }
            double media = soma / total;
            System.out.println("media da turma e "+ media);
            System.out.println("precione Enter para continuar...");
            sc.nextLine();
            sc.nextLine();
    }
      }
        public static void reproAfbCrescente(){
        System.out.println("reprovados em ordem crescente");
        Collections.sort(reprovados);
        for(String d: reprovados){
            System.out.println(d);
        }
        System.out.println("precione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }    

       public static void alunoAprovados(){
        aprovados.clear();
        reprovados.clear();

      for(int i=0;i<nomes.length;i++){
            double soma = 0;
                for(int j=0;j<materias.length;j++){
                     double somaM =0;
                    for(int k=0;k<3;k++){
                        somaM += notas[i][j][k];
                    }
                    double mediaM = somaM /3;
                    soma += mediaM;
                    }
                    double mediaF = soma / materias.length;

                     if(mediaF >= 7){
                        aprovados.add(nomes[i]);   
                        }else{reprovados.add(nomes[i]);
                    }
                }
                System.out.println("Alunos aprovados");
                for(String n : aprovados){
                    System.out.println(n);
                }
                System.out.println("precione Enter para continuar...");
                sc.nextLine();
                sc.nextLine();
                }
            

    
      public static void ordemAfbCrescente(){
      
        System.out.println("Aprovados em ordem crescente");
        Collections.sort(aprovados);
        for(String d: aprovados){
            System.out.println(d);
        }
    }
     public static void maiorMedia(){
        String alunoMaiormedia = "";
         double maior = 0;

        for(int i=0;i<5;i++){
             double soma = 0;
             for(int j=0;j<5;j++){
                    for(int k=0;k<3;k++){
                        soma += notas[i][j][k];
                    }  
                }
                double media = soma / 3;
                if(media > maior){
                    maior = media;
                    alunoMaiormedia= nomes[i];

            }
        }
        System.out.println("aluno com a maior média e " + alunoMaiormedia +"");
        System.out.println("precione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }
    public static void cadastrarNome(){
      sc.nextLine();
      for(int i=0;i<5;i++){
      System.out.print("Digite o nome do "+i+" aluno: ");
      
      String aluno = sc.nextLine();
      if(aluno.isEmpty()){
          System.out.println("Nome não pode ser vazio. Tente novamente.");
          i--; // decrementa para repetir a entrada
      } else {  
      nomes[i] = aluno;
      } 
    }
    }

    public static void cadastrarNota(){
   
    for(int i=0;i<nomes.length;i++){
        System.out.println("\nAluno: " + nomes[i]);

        for(int j = 0;j<materias.length;j++){
            System.out.println("Matéria: " + materias[j]);

            for(int k=0;k<3;k++){
                double nota;

                while (true) {
                    System.out.print("Digite a nota " + (k+1) + ": ");
                    String entrada = sc.next(); // lê como texto

                    try {
                        nota = Double.parseDouble(entrada);

                        if(nota >= 0 && nota <= 10){
                            break; // válido
                        } else {
                            System.out.println("Nota deve ser entre 0 e 10.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida! Digite um número.");
                    }
                }

                notas[i][j][k] = nota;
            }
        }
    }
}
     public static void tabela(){
       sc.nextLine();
      for(int i=0;i<nomes.length;i++){
        System.out.println("\naluno :"+nomes[i]);
         System.out.print("Aluno   N1    N2    N3    média\n");

        for(int j = 0;j<materias.length;j++){

          double media = (notas[i][j][0]+notas[i][j][1]+notas[i][j][2])/3;
          System.out.println(
            materias[j]+ "  "+
            notas[i][j][0]+ "  "+
            notas[i][j][1]+ "  "+
            notas[i][j][2]+ "  "+
            media
          );
            }
            System.out.println("precione Enter para continuar...");
            sc.nextLine();
            sc.nextLine();
    }
}
     public static void menu(){
        boolean loop = true;
        while(loop){
           
             System.out.println("-----------------------------------");
             System.out.println("Bem Vindo ao  Menu Principal");
             System.out.println("Escolha a opçao desejada");
             System.out.println("1- Cadastrar aluno");
             System.out.println("2- Cadastrar notas dos alunos");
             System.out.println("3- Mostrar tabela de notas ");
             System.out.println("4- Alunos aprovados");
             System.out.println("5- Aluno com maior média");
             System.out.println("6- média geral da turma");
             System.out.println("7- Disciplina com maior média");
             System.out.println("8- Aprovados em ordem alfabética");
             System.out.println("9- Reprovados em ordem alfabética");
             System.out.println("0- sair");
             System.out.println("-----------------------------------");
             int decision = sc.nextInt();
             switch (decision) {
                case 1:
                  cadastrarNome();  
                    break;
                case 2:
                  cadastrarNota();
                    break;
                case 3:
                    tabela();
                    break;
                case 4:
                    alunoAprovados();
                    break;
                case 5 :
                    maiorMedia();
                    break;
                case 6 :
                    mediaTurma();
                    break;
                case 7:
                    disciplinaMaiorMedia();
                    break;
                case 8:
                    ordemAfbCrescente();
                    break;
                case 9:
                    reproAfbCrescente();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    break;
             }
        }
     }
    public static void main(String[] args) {
        menu();
    }
}
