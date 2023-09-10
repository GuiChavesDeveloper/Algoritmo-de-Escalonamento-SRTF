//Made by: Guilherme Chaves

package escalonador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SRTF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        int quatidadeProcessos;
        int chegada, duracao, tempoAtual;

        System.out.print("Quantidade de processos: ");
        quatidadeProcessos = scanner.nextInt();
        System.out.println();
        scanner.nextLine();

        List<Processo> processos = new ArrayList<>();
        for (int cont = 1; cont <= quatidadeProcessos; cont++){
            System.out.println("Informe o nome, tempo de chegada e tempo de duração do Processo <" + cont + "> :");
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            System.out.print("Tempo de Chegada: ");
            chegada = scanner.nextInt();
            System.out.print("Tempo de Duração: ");
            duracao = scanner.nextInt();
            System.out.println();

            processos.add(new Processo(nome, chegada, duracao));
            scanner.nextLine();
        }

        tempoAtual = 0;

        while (!processos.isEmpty()){
            List<Processo> chegados = new ArrayList<>();
            for (Processo processo : processos){
                if (processo.chegada <= tempoAtual){
                    chegados.add(processo);
                }
            }

            if (!chegados.isEmpty()){
                Collections.sort(chegados);
                Processo processoAtual = chegados.get(0);
                processoAtual.tempoExecutado++;

                if (processoAtual.tempoExecutado == processoAtual.duracao){
                    System.out.println("Processo " + processoAtual.nome + " concluido em t = " + (tempoAtual + 1));
                    processos.remove(processoAtual);
                }
            }
            tempoAtual++;
        }
    }
}
