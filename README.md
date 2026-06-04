[Estrutura do projeto.txt](https://github.com/user-attachments/files/28609086/Estrutura.do.projeto.txt)

gestao-certificacoes/
├── src/
│   ├── Main.java                 # Classe principal com menu interativo
│   ├── Usuario.java              # Encapsulamento dos dados do usuário
│   ├── Certificacao.java         # Representa uma certificação (AWS, CompTIA, etc.)
│   ├── Meta.java                 # Classe base abstrata (herança + polimorfismo)
│   ├── MetaCurtoPrazo.java       # Subclasse de Meta
│   ├── MetaLongoPrazo.java       # Subclasse de Meta
│   ├── Progresso.java            # Registro de evolução do usuário
│   └── TrilhaDeEstudos.java      # Gerenciamento das metas
└── README.md
