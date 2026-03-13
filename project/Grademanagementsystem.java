package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grademanagementsystem {
    static Scanner sc = new Scanner(System.in);
    static String[] nomes = new String[5];
    static double[][] notas = new double[5][4];
    static ArrayList<String> aprovados = new ArrayList<>();
    static ArrayList<String> reprovados = new ArrayList<>();
    
      public static void ordemAfbCrescente(){
        System.out.println("Aprovados em ordem crescente");
        Collections.sort(aprovados);
        for(String d: aprovados){
            System.out.println(d);
        }
    }

    public static void cadastrarNome(){
      for(int i=0;i<5;i++){
      System.out.print("Digite o nome do "+i+1+" aluno");
      String aluno = sc.nextLine();
      nomes[i] = aluno;
      } 
    }

    public static void cadastrarNota(){
        for(int i=0;i<5;i++){
            for(int j = 0;i<nomes.length;j++){
                System.out.print("Digite a "+j+1+ " nota do "+i+1+ "aluno");
                notas[i][j] = sc.nextDouble();
             }
        }
    }
     public static void tabela(){
      
      for(int i=0;i<nomes.length;i++){
           double media = (notas[i][0]+notas[i][1]+notas[i][2])/3;
          System.out.print("Aluno   N1   N2   N3 ");
          System.out.print(nomes[i] +" "+ notas[i][0]+ " "+ notas[i][1]+" "+notas[i][3]+" "+ media);
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
                    break;
                case 5 :
                    break;
                case 6 :
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    break;
                default:
                    break;
             }
        }
     }
    
}
