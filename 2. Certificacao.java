package gestaoCertificacoes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma certificação de TI (AWS, CompTIA, Scrum, etc.)
 */
public class Certificacao {
    private String nome;
    private String area; // Cloud, Segurança, Agile, etc.
    private int cargaHorariaRecomendada; // em horas
    private List<String> topicosPrincipais;
    
    // Construtor
    public Certificacao(String nome, String area, int cargaHorariaRecomendada) {
        this.nome = nome;
        this.area = area;
        this.cargaHorariaRecomendada = cargaHorariaRecomendada;
        this.topicosPrincipais = new ArrayList<>();
    }
    
    // Método para adicionar tópico de estudo
    public void adicionarTopico(String topico) {
        topicosPrincipais.add(topico);
    }
    
    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getArea() {
        return area;
    }
    
    public int getCargaHorariaRecomendada() {
        return cargaHorariaRecomendada;
    }
    
    public List<String> getTopicosPrincipais() {
        return topicosPrincipais;
    }
    
    // Exibir detalhes da certificação
    public void exibirDetalhes() {
        System.out.println("📜 Certificação: " + nome + " | Área: " + area);
        System.out.println("⏱️  Carga horária recomendada: " + cargaHorariaRecomendada + " horas");
        System.out.println("📚 Tópicos principais: " + String.join(", ", topicosPrincipais));
    }
}