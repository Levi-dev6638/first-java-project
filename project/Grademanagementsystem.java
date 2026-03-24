package project;

// import para usar arraylist, collections e scanner
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grademanagementsystem {
    // variáveis globais para armazenar as matérias, nomes dos alunos, notas e listas de aprovados e reprovados
    static String[] materias = {
        "matemática","português","ciências","história","geografia"
    };
    static Scanner sc = new Scanner(System.in);
    static String[] nomes = new String[5];
    static double[][][] notas = new double[5][5][3];
    static ArrayList<String> aprovados = new ArrayList<>();
    static ArrayList<String> reprovados = new ArrayList<>();
       
    //funçao para calcular qual disciplina teve a maior media

    public static void disciplinaMaiorMedia(){
    double maiorMedia = 0;
    String melhorMateria = "";

    for(int i = 0; i < materias.length; i++){ // percorre matérias
        double soma = 0;
        int total = 0;

        for(int j = 0; j < nomes.length; j++){ // percorre alunos
            for(int k = 0; k < 3; k++){ // percorre provas
                soma += notas[j][i][k]; // aluno j, matéria i
                total++;
            }
        }
         // soma dos valores / pela quantidade de valores que foram inseridos
        double media = soma / total;
        // se a media for maior que a maior media , media passa a ser a maior media
        if(media > maiorMedia){
            maiorMedia = media;
            // pega o nome da matéria que tem a maior media
            melhorMateria = materias[i];
        }
    }
    // print das informaçoes
    System.out.println("Disciplina com maior media: " + melhorMateria);
    System.out.printf("Media : %.2f\\", maiorMedia);
    System.out.println("\nPressione Enter para continuar...");
    sc.nextLine();
    sc.nextLine();
}
       //funçao para mostrar a media da turma em cada disciplina
      static public void mediaTurma(){
         
        for(int i=0;i<5;i++){
            double total = 0;
            double soma = 0;
             for(int j=0;j<5;j++){
                for(int k=0;k<3;k++){
                  soma += notas[j][i][k]; // aluno j, matéria i, roda as 3 notas de 5 alunos em cada materia
                  total++;
             }       
            }
            double media = soma / total;// divide para saber a media dessa materia
            System.out.printf("media da turma em %s é %.2f\n", materias[i], media);
    }
      }

         //funçao para calcular a situação de cada aluno (aprovado ou reprovado)
        public static void calcularSituacao(){
        aprovados.clear();
        reprovados.clear();
        // i alunos ,j materia
        for(int i=0;i<nomes.length;i++){
        double soma = 0;

        for(int j=0;j<materias.length;j++){
            double somaM =0;
        // ver a nota de cada materia
            for(int k=0;k<3;k++){
                somaM += notas[i][j][k];
            }
            //armazenar no soma  a junçao das 3 notas /3
            soma += (somaM / 3);
        }
         // media final do aluno , soma das medias de cada materia / quantidade de materias
        double mediaF = soma / materias.length;

        if(mediaF >= 7){
            aprovados.add(nomes[i]);
        }else{
            reprovados.add(nomes[i]);
        }
    }
}  

        //funçao para mostrar os reprovados em ordem alfabética
        public static void reproAfbCrescente(){
        calcularSituacao();
        //funçao que guarda os aprovados e reprovados
        System.out.println("reprovados em ordem crescente");
        Collections.sort(reprovados);
        //funçao sort ja deixa em ordem alfabetica
        for(String a: reprovados){
            //percorrer a lista (para cada aluno dentro da lista printa ele )
            System.out.println(a);
        }
        System.out.println("precione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }    


       //funçao para mostrar os aprovados 
       public static void alunoAprovados(){
        aprovados.clear();
        reprovados.clear();
        //basicamente o mesmo que a de cima porem sem utilizar o sort
        calcularSituacao();
         System.out.println("Alunos aprovados");
         for(String n : aprovados){
               System.out.println(n);
         }
        System.out.println("precione Enter para continuar...");
         sc.nextLine();
         sc.nextLine();
     }
            

    //funçao para mostrar os aprovados em ordem alfabética
      public static void ordemAfbCrescente(){
        calcularSituacao();
        System.out.println("Aprovados em ordem crescente");
        Collections.sort(aprovados);
        //para cada aluno aprovado print ele
        for(String a: aprovados){
            System.out.println(a);
        }
        System.out.println("precione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }
    //funçao para mostrar aluno com a maior media
     public static void maiorMedia(){
        String alunoMaiormedia = "";
         double maior = 0;

        for(int i=0;i<5;i++){
             double soma = 0;
             for(int j=0;j<5;j++){//materia
                    for(int k=0;k<3;k++){//notas por materia
                        soma += notas[i][j][k];
                    }  
                }
                double media = soma / (5 * 3);
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
    
    //funçao para cadastrar o nome dos alunos
    public static void cadastrarNome(){
      sc.nextLine(); //limpa buffer

      for(int i=0;i<5;i++){
        System.out.print("Digite o nome do "+(i+1)+" aluno: ");
      try{
        String aluno = sc.nextLine();
        if(aluno.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser vazio");// exeção "forçada" para evitar que o nome seja vazio
            
        }
        if(!aluno.matches("[\\p{L} ]+")){
                throw new IllegalArgumentException("Nome inválido! Não use números.");
        }
        nomes[i] = aluno;
      }catch(IllegalArgumentException e){
        System.out.println("Erro: " + e.getMessage()); //e.getMessage() faz pegar o exception especifico
        i--;
     } 
    }
   }
   // funçao para cadastrar as notas
    public static void cadastrarNota(){

        for(int i=0;i<nomes.length;i++){//aluno
            System.out.println("\naluno :"+nomes[i]);
            for(int j = 0;j<materias.length;j++){//materias
                System.out.println("materia :"+ materias[j]);
                for(int k=0;k<3;k++){//notas

                    while (true) {
                       try{
                           System.out.print("Digite a " +(k+1)+ " nota do aluno "+ nomes[i] + " : ");
                           double nota = sc.nextDouble();
                            //verificar se a nota é valida (entre 0 e 10)
                            if(nota < 0 || nota > 10){
                                 System.out.println("Digite uma nota entre 0 e 10");
                                 continue; // faz voltar para o inicio do while
                            }
                            notas[i][j][k] = nota;
                            break;

                       }catch(Exception e){
                           System.out.println("Digite um numero valido");
                           sc.nextLine();
                       }
                        
                    }
                   
                
             }
        }
    }
}
    // funçao para mostrar a tabela
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
            // vai printar a materia e suas respectivas notas

            String.format("%.2f", media)
          );
            }
            System.out.println("precione Enter para continuar...");
            sc.nextLine();
            // pede para dar enter e vai para o proximo aluno
    }
}

     // menu principal com switch case para escolher as opções
     public static void menu(){
        int decision;
        do{
             System.out.println("_______________________________________");
             System.out.println("|----Bem Vindo ao  Menu Principal-----|");
             System.out.println("|------Escolha a opção desejada-------|");
             System.out.println("|_____________________________________|");
             System.out.println("|1- Cadastrar aluno-------------------|");
             System.out.println("|2- Cadastrar notas dos alunos--------|");
             System.out.println("|3- Mostrar tabela de notas ----------|");
             System.out.println("|4- Alunos aprovados------------------|");
             System.out.println("|5- Aluno com maior média-------------|");
             System.out.println("|6- média geral da turma--------------|");
             System.out.println("|7- Disciplina com maior média--------|");
             System.out.println("|8- Aprovados em ordem alfabética-----|");
             System.out.println("|9- Reprovados em ordem alfabética----|");
             System.out.println("|0- sair------------------------------|");
             System.out.println("|_____________________________________|");

             try{
             decision = sc.nextInt();

             if(decision != 0 && (decision < 1 || decision > 9)){// quando nao for zero , for menor que 1 e maior que 9
             System.out.println("Opção inválida!");
             decision = -1;
            }

             }catch(Exception e){
             System.out.println("Digite um numero valido");
             sc.nextLine();
             //volta a para o "começo"
             decision = -1;
             }
             
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
                    decision = 0;
                    break;
                default:
                    break;
             }
        }while(decision != 0);
     }
    public static void main(String[] args) {
        menu();
    }
}
