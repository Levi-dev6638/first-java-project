package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grademanagementsystem {
    static Scanner sc = new Scanner(System.in);
    static String[] nomes = new String[5];
    static double[][] notas = new double[5][3];
    static ArrayList<String> aprovados = new ArrayList<>();
    static ArrayList<String> reprovados = new ArrayList<>();

      static public void mediaTurma(){
        double media = 0;
         double soma = 0;
        for(int i=0;i<5;i++){
             for(int j=0;j<notas[i].length;j++){
                soma += notas[i][j];
             }   
             media = soma / 15;    
            }
            System.out.println("media da turma e "+ media);
    }

        public static void reproAfbCrescente(){
        System.out.println("reprovados em ordem crescente");
        Collections.sort(reprovados);
        for(String d: reprovados){
            System.out.println(d);
        }
    }    

       public static void alunoAprovados(){
      for(int i=0;i<5;i++){
            double soma = 0;
            double media = 0;

                for(int j=0;j<notas[i].length;j++){
                    soma += notas[i][j];
                    }
                     media = soma / 3;

                     if(media >= 7){
                        aprovados.add(nomes[i]);   
                        }else{reprovados.add(nomes[i]);
                    }
                }
                System.out.println("Alunos aprovados");
                for(int i = 0;i<aprovados.size();i++){
                    System.out.println(aprovados.get(i));
                }
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
             for(int j=0;j<notas[i].length;j++){
                soma += notas[i][j];  
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
    }
    public static void cadastrarNome(){
      sc.nextLine();
      for(int i=0;i<5;i++){
      System.out.print("Digite o nome do "+i+" aluno: ");
      
      String aluno = sc.nextLine();
      nomes[i] = aluno;
      } 
    }

    public static void cadastrarNota(){
        for(int i=0;i<5;i++){
            for(int j = 0;j<notas[i].length;j++){
                System.out.print("Digite a "+j+ " nota do "+nomes[i]+  " aluno : ");
               
                notas[i][j] = sc.nextDouble();
             }
        }
    }
     public static void tabela(){
       sc.nextLine();
      for(int i=0;i<nomes.length;i++){
          double media = (notas[i][0]+notas[i][1]+notas[i][2])/3;
          System.out.print("Aluno   N1    N2    N3    média\n");
          System.out.print(nomes[i] +  " "   + notas[i][0]+  " "  + notas[i][1]+  " "  +notas[i][2]+  " "  + media+  "\n");
         
            }
            System.out.println("precione Enter para continuar...");
            sc.nextLine();
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
