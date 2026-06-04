package gestaoCertificacoes;

import java.time.LocalDate;

/**
 * Subclasse que representa metas de curto prazo (até 30 dias).
 * Aplica HERANÇA e POLIMORFISMO.
 */
public class MetaCurtoPrazo extends Meta {
    
    public MetaCurtoPrazo(String titulo, String descricao, int horasNecessarias, LocalDate prazo) {
        super(titulo, descricao, horasNecessarias, prazo);
    }
    
    @Override
    public void exibirTipoMeta() {
        System.out.println("🎯 [META DE CURTO PRAZO - até 30 dias]");
    }
}