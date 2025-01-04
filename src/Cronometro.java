import java.util.Scanner;

public class Cronometro {
    private static boolean rodando = false;
    private static long inicio;
    private static long tempoPausado = 0;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        System.out.println("Bem vindo, ao cronometro!");

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Iniciar");
            System.out.println("2 - Pausar");
            System.out.println("3 - Continuar");
            System.out.println("4 - Resetar");
            System.out.println("5 - Sair");

            System.out.println("Opcao: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    iniciar();
                    break;
                case "2":
                    pausar();
                    break;
                case "3":
                    continuar();
                    break;
                case "4":
                    resetar();
                    break;
                case "5":
                    System.out.println("Encerrando...");
                    break;
            }
        } while (!opcao.equals("5"));

        scanner.close();
    }

    private static void iniciar() {
        if (rodando){
            System.out.println("O cronometro já está rodando!");
            return;
    }

    inicio = System.currentTimeMillis();
    rodando = true;
    tempoPausado = 0;
    System.out.println("Cronometro iniciado!");
    }

    private static void pausar() {
       if (!rodando) {
        System.out.println("O cronometro não está funcionando!");
       }
       long agora = System.currentTimeMillis();
       tempoPausado += (agora - inicio);
       System.out.println("Cronometro pausado!");
    }

    private static void continuar() {
        if (rodando) {
            System.out.println("O cronometro já está funcionando!");
        }
        inicio = System.currentTimeMillis();
        rodando =true;
        System.out.println("O cronometro foi despausado!");
    }

    private static void resetar() {
        rodando = false;
        inicio = 0;
        tempoPausado = 0;
        System.out.println("O cronometro foi resetado!");
    }


    private static String formatarTempo(long tempoMillis) {
        long segundos = tempoMillis / 1000 % 60;
        long minutos = tempoMillis / 1000 / 60;
        return String.format("%02d:%02d", minutos, segundos);
}
}