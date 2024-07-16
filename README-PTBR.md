# Bootcamp Management System

## Índice
- [Descrição do Projeto](#descrição-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Execução do Projeto](#execução-do-projeto)
- [Autor](#autor)
- [Licença](#license)

## Descrição do Projeto

Este projeto implementa um sistema de gerenciamento de bootcamps para desenvolvedores, onde é possível matricular
desenvolvedores em bootcamps, gerenciar seu progresso nos conteúdos e calcular XP total conquistado. Utiliza interfaces
gráficas simples para interação com o usuário.

## Tecnologias Utilizadas

- Java
- Lombok
- Swing (para interface gráfica)
- IDE: IntelliJ IDEA

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **Pacote Principal (`com.bootcamp`):**
    - `dominio`: Contém as classes de domínio como `Bootcamp`, `Conteudo`, `Dev`, etc.
    - `service`: Contém a classe `BootcampService` para gerenciar operações relacionadas aos bootcamps e
      desenvolvedores.
    - `util`: Contém a classe `JOptionPaneUtil` para facilitar a interação com JOptionPane.

## Funcionalidades Implementadas

1. **Classe `Bootcamp`:**
    - Permite adicionar conteúdos e desenvolvedores a um bootcamp.
    - Métodos para obter conteúdos e desenvolvedores de um bootcamp.

2. **Classe `Dev`:**
    - Permite inscrever um desenvolvedor em um bootcamp.
    - Método para progredir nos conteúdos do bootcamp.
    - Método para calcular XP total baseado nos conteúdos concluídos.

3. **Classe `BootcampService`:**
    - Gerencia a adição de bootcamps.
    - Matricula desenvolvedores em bootcamps.
    - Controla o progresso dos desenvolvedores nos conteúdos.
    - Mostra os conteúdos inscritos e concluídos por um desenvolvedor.

4. **Interface Gráfica (`JOptionPaneUtil`):**
    - Utiliza JOptionPane para selecionar data e hora.

## Execução do Projeto

Para executar o projeto, importe-o para sua IDE (como IntelliJ IDEA) e execute a classe `BootcampApplication`.

## Autor

Desenvolvido por Lucas Santos

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
