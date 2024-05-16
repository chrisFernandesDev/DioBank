package main;

import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balanceClient = 0;
        int suggestedOption;
        boolean inputReceived;
        double amountDeposited;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Encerrar");

            System.out.print("Digite o número da opção desejada: ");
            suggestedOption = scanner.nextInt();

            switch (suggestedOption) {
                case 1:
                    inputReceived = false;
                    while (!inputReceived) {
                        System.out.println("Qual valor você gostaria de depositar?");

                        if (scanner.hasNextDouble()) {
                            amountDeposited = scanner.nextDouble();
                            balanceClient += amountDeposited;
                            System.out.println("Novo saldo: " + balanceClient);
                            inputReceived = true;
                        } else {
                            System.out.println("Por favor, digite um valor valido.");
                            scanner.next();
                        }
                    }
                    break;
                case 2:
                    inputReceived = false;
                    while (!inputReceived) {
                        System.out.println("Qual valor você gostaria de sacar?");

                        while (!scanner.hasNextDouble()) {
                            System.out.println("Valor inválido. Por favor, digite um valor numérico.");
                            scanner.next();
                        }

                        if (scanner.hasNextDouble()) {
                            amountDeposited = scanner.nextDouble();
                            if (balanceClient == 0) {
                                System.out.println("Desculpe, o valor solicitado para saque é maior do que seu saldo!");
                                System.out.println("Se deseja voltar ao menu principal digite 0, se deseja tentar sacar novamente digite qualquer outro número:");

                                String optionNextDraw = scanner.next();
                                if ("0".equals(optionNextDraw)) {
                                    inputReceived = true;
                                }
                            } else {
                                balanceClient -= amountDeposited;
                                System.out.println("Novo saldo: " + balanceClient);
                                inputReceived = true;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (suggestedOption != 4);

        scanner.close();
    }
}
