# Simulated Annealing Generalist Framework

Este repositório contém uma implementação genérica (template) do algoritmo de *Simulated Annealing* (Arrefecimento Simulado),
projetada para ser extensível e aplicável a diferentes problemas de otimização. Ele fornece uma classe abstrata chamada
`Arrefecimento`, que define o esqueleto do algoritmo, enquanto problemas específicos podem ser implementados como
classes derivadas.

## Estrutura do Projeto

### Classe Base: `Arrefecimento`

A classe abstrata `Arrefecimento` encapsula os elementos principais do algoritmo de arrefecimento simulado, incluindo:

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

1. **`stop(Object solution)`**  
   Define a condição de parada do algoritmo.
    - Retorna `true` para parar o processo, `false` caso contrário.

2. **`solutionPerturber(Object solution)`**  
   Aplica uma perturbação à solução atual.

3. **`coolingSchedule(int temperature)`**  
   Define a estratégia de resfriamento para reduzir a temperatura.

4. **`evaluator(Object solution)`**  
   Avalia a qualidade de uma solução específica (*fitness function*).