package gestaoCertificacoes;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia as metas do usuário (aplicando composição).
 */
public class TrilhaDeEstudos {
    private Usuario usuario;
    private Certificacao certificacaoAlvo;
    private List<Meta> listaMetas;
    
    public TrilhaDeEstudos(Usuario usuario, Certificacao certificacaoAlvo) {
        this.usuario = usuario;
        this.certificacaoAlvo = certificacaoAlvo;
        this.listaMetas = new ArrayList<>();
    }
    
    public void adicionarMeta(Meta meta) {
        listaMetas.add(meta);
        System.out.println("✅ Meta '" + meta.getTitulo() + "' adicionada à trilha!");
    }
    
    public void exibirProgressoGeral() {
        System.out.println("\n========== TRILHA DE ESTUDOS ==========");
        usuario.exibirInfo();
        System.out.println("🎯 Certificação alvo: " + certificacaoAlvo.getNome());
        System.out.println("----------------------------------------");
        
        if (listaMetas.isEmpty()) {
            System.out.println("Nenhuma meta cadastrada ainda.");
        } else {
            for (Meta meta : listaMetas) {
                meta.exibirStatus();
            }
        }
        
        // Estatísticas gerais
        long totalMetas = listaMetas.size();
        long metasConcluidas = listaMetas.stream().filter(Meta::isConcluida).count();
        System.out.println("\n📊 RESUMO: " + metasConcluidas + "/" + totalMetas + " metas concluídas");
    }
    
    public Meta buscarMeta(String titulo) {
        for (Meta meta : listaMetas) {
            if (meta.getTitulo().equalsIgnoreCase(titulo)) {
                return meta;
            }
        }
        return null;
    }
}