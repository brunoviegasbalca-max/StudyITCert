package gestaoCertificacoes;

import java.time.LocalDate;

/**
 * Classe abstrata que representa uma meta de estudo.
 * Aplica ABSTRAÇÃO e prepara para HERANÇA.
 */
public abstract class Meta {
    protected String titulo;
    protected String descricao;
    protected int horasNecessarias;
    protected int horasRealizadas;
    protected LocalDate prazo;
    protected boolean concluida;
    
    public Meta(String titulo, String descricao, int horasNecessarias, LocalDate prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horasNecessarias = horasNecessarias;
        this.horasRealizadas = 0;
        this.prazo = prazo;
        this.concluida = false;
    }
    
    // Método para registrar horas estudadas
    public void registrarHoras(int horas) {
        if (horas > 0) {
            horasRealizadas += horas;
            if (horasRealizadas >= horasNecessarias) {
                concluida = true;
                System.out.println("🎉 Parabéns! Meta '" + titulo + "' concluída!");
            }
        }
    }
    
    // Método abstrato - será implementado pelas subclasses (POLIMORFISMO)
    public abstract void exibirTipoMeta();
    
    // Método para calcular progresso
    public double calcularProgresso() {
        return (double) horasRealizadas / horasNecessarias * 100;
    }
    
    public void exibirStatus() {
        exibirTipoMeta();
        System.out.println("📌 " + titulo + " - " + descricao);
        System.out.println("⏳ Progresso: " + String.format("%.1f", calcularProgresso()) + "%");
        System.out.println("📅 Prazo: " + prazo);
        System.out.println("✅ Concluída: " + (concluida ? "Sim" : "Não"));
        System.out.println("------------------------");
    }
    
    // Getters
    public String getTitulo() { return titulo; }
    public boolean isConcluida() { return concluida; }
}