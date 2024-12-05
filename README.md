# Framework para simulated annealing

Este repositório contém uma implementação genérica (template) do algoritmo de *Simulated Annealing* (Arrefecimento Simulado),
projetada para ser extensível e aplicável a diferentes problemas de otimização. Ele fornece uma classe abstrata chamada
`Arrefecimento<T>`, que define o esqueleto do algoritmo, enquanto problemas específicos podem ser implementados como
classes derivadas.

## Estrutura do Projeto

### Classe Base: `Arrefecimento<T>`

A classe abstrata `Arrefecimento<T>` faz operações com o tipo T (exemplo, Integer no caso de minimização de função numérica) e encapsula os elementos principais do algoritmo de arrefecimento simulado, incluindo:

#### **Método `anneal`**

Realiza o processo de arrefecimento simulado.  
**Parâmetros:**

- `initialSolution`: A solução inicial.
- `temperature`: A temperatura inicial.
- `minTemperature`: A temperatura mínima para finalizar o processo.

O método:

1. Perturba a solução atual.
2. Avalia se a solução perturbada deve ser aceita.
3. Ajusta a temperatura de acordo com uma estratégia de resfriamento.
4. Para o processo caso a condição de parada seja atingida.

#### **Método `evaluateSolution`**

Decide se uma solução perturbada deve ser aceita com base na diferença de avaliação (*fitness*) entre a solução atual e
a perturbada, ajustada pela temperatura.

**Parâmetros:**

- `solution`: A solução atual.
- `s`: A solução perturbada.
- `temperature`: A temperatura atual.

**Lógica:**

- Se a solução perturbada for melhor, aceita diretamente.
- Caso contrário, aceita com uma probabilidade dependente da diferença de avaliação e da temperatura.

#### Métodos Abstratos

Os seguintes métodos devem ser implementados pelas classes derivadas para adaptarem-se a problemas específicos:

1. **`stop(T solution)`**  
   Define a condição de parada do algoritmo.
    - Retorna `true` para parar o processo, `false` caso contrário.

2. **`solutionPerturber(T solution)`**  
   Aplica uma perturbação à solução atual.

3. **`coolingSchedule(int temperature)`**  
   Define a estratégia de resfriamento para reduzir a temperatura.

4. **`evaluator(T solution)`**  
   Avalia a qualidade de uma solução específica (*fitness function*).

## Implementações de `Arrefecimento<T>`

Aqui estão algumas implementações da classe `Arrefecimento<T>`:

- **MinimizeQuadratic** ([Classe](https://github.com/danielbmancini/AnnealingInterface/blob/master/src/MinimizeQuadratic.java))  
   * Tenta obter o mínimo global da função descrita em `evaluator(Integer solution)`. (neste caso, `(x-3)² + 4`)

