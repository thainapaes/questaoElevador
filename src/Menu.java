import controllers.ElevadorController;
import controllers.PassageiroController;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


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
