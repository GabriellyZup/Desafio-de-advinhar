# Desafio-de-advinhar

## Descrição do Projeto

Este é um jogo interativo desenvolvido em Java, em que o sistema sorteia numeros de forma randômica e compara com o palpite do usuário.
Inclui pontuação e níveis de dificuldade o que torna a experiência mais desafiadora.

## Requisitos de Sistema
- **Java Development Kit (JDK)**: versão 8 ou superiro
- **Sistema Operacional**: Windowna, masOS, Linux
- **Editor de IDE** (opcional): IntelliJ IDEA, VSCode ou qualquer outro
- **GitHub** para clonagem e verificação de versionamento
- **Terminal ou Console** PAra executar o programa

## Funcionalidades
- **Sorteio de Número Aleatório** 
  - sistema sorteia 1 número por vez dentro de um intervalo restrito e decidido pelo usuário.

- **Pontuação**
  - 10 pontos por acerto;
  - 5 pontos por erro com diferença de +1 ou -1;
  - 0 pontos no caso de erro.

-**Rodadas**
    -O jogo permite rodadsa consecutivas e acumula pontuação.

-**Niveis de dificuldade**
    -Fácil: Númeors entre 1 e 10.
    -Médio: Números entre 1 e 50.
    -Dificil: Númerso entre 1 e 100.

-**Mudança Automática de Nível**
    -Ao atingir 50 pontos, o jogador é automaticamente questionado em qual nível deseja prosseguir e se deseja prosseguir.

-**Resumo Final**
    -O jogo exibe a pontuação final, números acertados e errados.

##Como Usar
1. Ao iniciar o programa, escolha um nivel de dificuldade: **Fácil**, **Médio** ou **Dificil**.
2. Digite um palpite dentro dos limites definidos pelo nível escolhido
3. O sistema informará se o palpite foi errado, errado por um ou correto.
4. A pontuação será acumulada automaticamente.
5. Ao atingir 50 pontos, o jogo pernguntará se deseja alterar o nível.
6. Continue jogando até decidir sair do jogo apertando "n" quando perguntado. 

### Observação
1. A linha 19 que exibe o númeor sorteado esta ativa para que possa testar o jogo. Caso queira jogar com mais emoção, basta comentar a linha.
'System.out.println("Número sorteado para teste " + numeroSorteado);'

2. Inclui a funcionalidade de mudança automática de nível a cada 50 pontos.

3. Esse trabalho é parte de um estudo teorico de **Paradigma de Programação Procedural**, onde o código é organizado em funções para resolver o problema de forma modular.
E também é um trabalho pratico desenvolvido para reforçar o uso de condicionais, manipulação de dados, organização modular
Assim como a prática de desenvolvimento em Java com o uso do IntelliJ IDEA e versionamento pelo GitHub. 

Foi muito divertido! 
