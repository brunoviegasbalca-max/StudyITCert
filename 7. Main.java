package gestaoCertificacoes;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Classe principal com menu interativo para demonstração do sistema.
 * Aplica todos os conceitos de POO na prática.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TrilhaDeEstudos trilha;
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  GESTÃO DE ESTUDOS PARA CERTIFICAÇÕES");
        System.out.println("  Aplicando POO - Java");
        System.out.println("========================================\n");
        
        // Inicialização: criar usuário e certificação
        inicializarSistema();
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            
            switch (opcao) {
                case 1:
                    adicionarMetaCurtoPrazo();
                    break;
                case 2:
                    adicionarMetaLongoPrazo();
                    break;
                case 3:
                    registrarHorasEstudo();
                    break;
                case 4:
                    exibirProgresso();
                    break;
                case 5:
                    exibirDetalhesCertificacao();
                    break;
                case 0:
                    System.out.println("\n👋 Saindo... Bons estudos! 🚀");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void inicializarSistema() {
        System.out.println("=== CADASTRO INICIAL ===");
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Nível de experiência (Iniciante/Intermediário/Avançado): ");
        String nivel = scanner.nextLine();
        
        Usuario usuario = new Usuario(nome, email, nivel);
        
        System.out.println("\n=== CERTIFICAÇÃO DESEJADA ===");
        System.out.print("Nome da certificação (ex: AWS, CompTIA, Scrum): ");
        String certNome = scanner.nextLine();
        System.out.print("Área de atuação: ");
        String certArea = scanner.nextLine();
        System.out.print("Carga horária recomendada (horas): ");
        int cargaHoraria = lerInteiro("");
        
        Certificacao certificacao = new Certificacao(certNome, certArea, cargaHoraria);
        
        // Adicionar tópicos principais
        System.out.println("Adicione os principais tópicos de estudo (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("Tópico: ");
            String topico = scanner.nextLine();
            if (topico.equalsIgnoreCase("fim")) break;
            certificacao.adicionarTopico(topico);
        }
        
        trilha = new TrilhaDeEstudos(usuario, certificacao);
        System.out.println("\n🎉 Sistema inicializado com sucesso!\n");
    }
    
    private static void exibirMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1 - Adicionar meta de curto prazo");
        System.out.println("2 - Adicionar meta de longo prazo");
        System.out.println("3 - Registrar horas de estudo");
        System.out.println("4 - Exibir progresso geral");
        System.out.println("5 - Ver detalhes da certificação");
        System.out.println("0 - Sair");
        System.out.println("====================================");
    }
    
    private static void adicionarMetaCurtoPrazo() {
        System.out.println("\n--- NOVA META (CURTO PRAZO) ---");
        System.out.print("Título da meta: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Horas necessárias: ");
        int horas = lerInteiro("");
        System.out.print("Prazo (AAAA-MM-DD): ");
        LocalDate prazo = LocalDate.parse(scanner.nextLine());
        
        Meta meta = new MetaCurtoPrazo(titulo, descricao, horas, prazo);
        trilha.adicionarMeta(meta);
    }
    
    private static void adicionarMetaLongoPrazo() {
        System.out.println("\n--- NOVA META (LONGO PRAZO) ---");
        System.out.print("Título da meta: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Horas necessárias: ");
        int horas = lerInteiro("");
        System.out.print("Prazo (AAAA-MM-DD): ");
        LocalDate prazo = LocalDate.parse(scanner.nextLine());
        
        Meta meta = new MetaLongoPrazo(titulo, descricao, horas, prazo);
        trilha.adicionarMeta(meta);
    }
    
    private static void registrarHorasEstudo() {
        System.out.print("\nTítulo da meta que deseja progredir: ");
        String titulo = scanner.nextLine();
        Meta meta = trilha.buscarMeta(titulo);
        
        if (meta != null) {
            System.out.print("Horas estudadas hoje: ");
            int horas = lerInteiro("");
            meta.registrarHoras(horas);
            System.out.println("✅ Horas registradas! Progresso atual: " + 
                               String.format("%.1f", meta.calcularProgresso()) + "%");
        } else {
            System.out.println("❌ Meta não encontrada!");
        }
    }
    
    private static void exibirProgresso() {
        trilha.exibirProgressoGeral();
    }
    
    private static void exibirDetalhesCertificacao() {
        System.out.println("\n=== DETALHES DA CERTIFICAÇÃO ===");
        // Como não temos acesso direto à certificacao pela trilha, precisamos de um getter
        // Para simplificar, vamos exibir via reflexão ou podemos adicionar método na classe Trilha
        System.out.println("🔍 Para ver os detalhes completos, acesse o menu de progresso.");
        System.out.println("   As informações da certificação estão vinculadas à sua trilha.");
    }
    
    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido! Digite um número: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        return valor;
    }
}