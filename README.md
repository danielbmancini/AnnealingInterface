# Framework para simulated annealing

Este repositório contém uma implementação genérica (template) do algoritmo de *Simulated Annealing* (Arrefecimento Simulado),
projetada para ser extensível e aplicável a diferentes problemas de otimização. Ele fornece uma classe abstrata chamada
`Arrefecimento<T>`, que define o esqueleto do algoritmo, enquanto problemas específicos podem ser implementados como
classes derivadas.

## Estrutura do Projeto

### Classe Base: `Arrefecimento<T>`

A classe abstrata [Arrefecimento&lt;T&gt;](https://github.com/danielbmancini/AnnealingInterface/blob/master/src/Arrefecimento.java) faz operações com o tipo T (exemplo, Integer no caso de minimização de função numérica) e encapsula os elementos principais do algoritmo de arrefecimento simulado,

## Implementações de `Arrefecimento<T>`

Aqui estão algumas implementações da classe `Arrefecimento<T>`:

- **MinimizeQuadratic** ([Classe](https://github.com/danielbmancini/AnnealingInterface/blob/master/src/MinimizeQuadratic.java))  
   * Tenta obter o mínimo global da função descrita em `evaluator(Integer solution)`. (neste caso, `(x-3)² + 4`)
- **KnapsackProblem** ([Classe](https://github.com/danielbmancini/AnnealingInterface/blob/master/src/KnapsackProblem.java))
  * Tenta resolver o Problema da Mochila.

