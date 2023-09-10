package escalonador;

public class Processo implements Comparable<Processo> {
    String nome;
    int chegada;
    int duracao;
    int tempoExecutado;

    public Processo(String nome, int chegada, int duracao){
        this.nome = nome;
        this.chegada = chegada;
        this.duracao = duracao;
        this.tempoExecutado = 0;
    }

    @Override
    public int compareTo(Processo outro){
        return Integer.compare(this.duracao, outro.duracao);
    }
}
