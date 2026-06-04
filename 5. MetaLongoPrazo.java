package gestaoCertificacoes;

import java.time.LocalDate;

/**
 * Subclasse que representa metas de longo prazo (acima de 30 dias).
 * Aplica HERANÇA e POLIMORFISMO.
 */
public class MetaLongoPrazo extends Meta {
    
    public MetaLongoPrazo(String titulo, String descricao, int horasNecessarias, LocalDate prazo) {
        super(titulo, descricao, horasNecessarias, prazo);
    }
    
    @Override
    public void exibirTipoMeta() {
        System.out.println("🏆 [META DE LONGO PRAZO - certificação completa]");
    }
}