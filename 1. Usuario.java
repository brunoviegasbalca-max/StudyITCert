package gestaoCertificacoes;

/**
 * Classe que representa um usuário do sistema.
 * Aplica ENCAPSULAMENTO: atributos privados com getters e setters.
 */
public class Usuario {
    private String nome;
    private String email;
    private String nivelExperiencia; // Iniciante, Intermediário, Avançado
    
    // Construtor
    public Usuario(String nome, String email, String nivelExperiencia) {
        this.nome = nome;
        this.email = email;
        this.nivelExperiencia = nivelExperiencia;
    }
    
    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNivelExperiencia() {
        return nivelExperiencia;
    }
    
    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
    
    // Método para exibir informações do usuário
    public void exibirInfo() {
        System.out.println("👤 Usuário: " + nome + " | Email: " + email + " | Nível: " + nivelExperiencia);
    }
}