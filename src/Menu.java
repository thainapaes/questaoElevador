import controllers.ElevadorController;
import controllers.PassageiroController;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /**public static void Menu() {
     Scanner input = new Scanner(System.in);
     ElevadorController elevador =  new ElevadorController();

     System.out.println("Deseja: "
     + "\n 1- Adicionar um novo predio" + "\n 2- Trabalhar com os predios");

     int opcao = input.nextInt();

     switch (opcao) {
     case 1:
     Opcao1();
     break;

     case 2:
     Opcao2();
     break;

     default:
     break;
     }
     input.close();

     }*/

    public static ArrayList<Integer> Opcao1(ArrayList<Integer> lista) {
        Scanner inputOpcUm = new Scanner(System.in);
        ArrayList<Integer> passageiroList = lista;

        System.out.println("Insira um passageiro \n1-Qual andar ele está? ");
        int origem = inputOpcUm.nextInt();
        passageiroList.add(origem);
        System.out.println("Qual andar deseja ir?");
        int destino = inputOpcUm.nextInt();
        passageiroList.add(destino);

        System.out
                .println("Deseja: \n1- Inserir outro\n2- Calcular o tempo de locomocao do elevador?");
        int m = inputOpcUm.nextInt();
        do {
            if (m == 1) {
                Opcao1(passageiroList);
            } else {
                break;
            }
        } while (m != 1 && m != 2);

        inputOpcUm.close();
        return passageiroList;
    }


    /**public static void Opcao2() {
     Scanner inputOpcDois = new Scanner(System.in);
     PassageiroController passageiro = new PassageiroController();
     ElevadorController elevador = new ElevadorController();

     System.out.println("Selecione a operação desejada:" + "\n1- Buscar os predios"
     + "\n2- Adicionar Passageiro" + "\n3- Voltar ao menu principal");
     int opcao = inputOpcDois.nextInt();


     switch (opcao) {
     case 1:
     PredioElevador[] arrayPredio = elevador.buscarPredios();
     for (int i = 0; i < arrayPredio.length; i++) {
     System.out.println(arrayPredio[i].toString());
     }
     System.out.println("Deseja: \n1-Adicionar outro passageiro?\n2-Retornar ao Menu Principal?");
     int n = inputOpcDois.nextInt();

     do {
     if (n == 1) {
     Opcao2();
     } else {
     Menu();
     }
     } while (n != 1 && n != 2);
     break;

     case 2:
     System.out.println("Qual o predio?");
     int predio = inputOpcDois.nextInt();
     System.out.println("Qual o andar que o passaeiro está?");
     int atual = inputOpcDois.nextInt();
     System.out.println("Para qual andar o passageiro deseja ir?");
     int destino = inputOpcDois.nextInt();
     passageiro.selecionarAndar(atual, destino);

     System.out.println("Deseja: \n1-Adicionar outro passageiro?\n2-Retornar ao Menu Principal?");
     int mm = inputOpcDois.nextInt();

     do {
     if (mm == 1) {
     Opcao2();
     } else {
     Menu();
     }
     } while (mm != 1 && mm != 2);
     break;

     case 3:
     Menu();
     break;

     default:
     break;
     }
     inputOpcDois.close();
     }*/

    public static void OpcaoGeral() {
        Scanner inputGeral = new Scanner(System.in);
        ElevadorController elevador = new ElevadorController();
        PassageiroController passageiro = new PassageiroController();
        ArrayList<Integer> passageiroList = new ArrayList<>();

        System.out.println("Números de andares?");
        int andares = inputGeral.nextInt();
        System.out.println("Em qual andar o elevador deve iniciar?");
        int inicial = inputGeral.nextInt();
        System.out.println("Insira um passageiro \n1-Qual andar ele está? ");
        int origem = inputGeral.nextInt();
        passageiroList.add(origem);
        System.out.println("Qual andar deseja ir?");
        int destino = inputGeral.nextInt();
        passageiroList.add(destino);

        System.out.println("Deseja: 1-Adicionar um novo passageiro \n 2- Calcular o tempo de locomocao");
        int opcao = inputGeral.nextInt();
        switch(opcao){
            case 1:
                passageiroList = Opcao1(passageiroList);
                System.out.println("Tempo total de locomocao " + passageiro.selecionarAndar(andares, inicial, passageiroList));
                System.out.println("\n---------------------------------------");

                System.out.println("Deseja: \n1- Encerrar\n2-Realizar outra operacao");
                int enc = inputGeral.nextInt();
                do {
                    if (enc == 1) {
                        System.out.println("Encerrado!");
                    } else {
                        OpcaoGeral();
                    }
                } while (enc != 1 && enc != 2);
                break;
            case 2:
                System.out.println("Tempo total de locomocao " + passageiro.selecionarAndar(andares, inicial, passageiroList));
                System.out.println("\n---------------------------------------");

                System.out.println("Deseja: \n1- Encerrar\n 2-Realizar outra operacao");
                int opcaoFinal = inputGeral.nextInt();
                do {
                    if (opcaoFinal == 1) {
                        System.out.println("Encerrado!");
                    } else {
                        OpcaoGeral();
                    }
                } while (opcaoFinal != 1 && opcaoFinal != 2);
                break;
            default:
                break;
        }

        inputGeral.close();
    }

    public static void main(String[] args)  {
        try {
            OpcaoGeral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
