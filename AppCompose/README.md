# Calculadora de Desconto

Aplicativo Android feito com Jetpack Compose. O usuário informa o preço de um produto e o percentual de desconto. Ao tocar em **CALCULAR**, o aplicativo mostra o preço final.

## Perguntas

### 1. O que é entrada em um sistema computacional? Dê dois exemplos.

Entrada é qualquer dado fornecido ao sistema para que ele possa processá-lo. Nesta aplicação, o preço do produto e o percentual de desconto são entradas. Outros exemplos são um texto digitado em um campo ou uma opção selecionada em um menu.

### 2. Qual é a diferença entre processamento e saída?

Processamento é a operação realizada sobre os dados de entrada. Nesta aplicação, o sistema calcula o valor do desconto e subtrai esse valor do preço. Saída é o resultado apresentado ao usuário, neste caso, o preço final formatado em reais.

### 3. Por que o valor digitado em um TextField é inicialmente tratado como texto?

O `TextField` recebe e exibe caracteres digitados, inclusive enquanto o usuário ainda está preenchendo o campo. Por isso, seu valor é armazenado como `String`. Antes de fazer cálculos, o aplicativo converte esse texto para número e verifica se a conversão foi válida.

### 4. Qual é a finalidade de remember e mutableStateOf?

`mutableStateOf` cria um estado observável pelo Compose. `remember` mantém esse estado durante as recomposições da tela, evitando que os valores sejam reiniciados a cada atualização. Nesta aplicação, eles guardam os textos digitados e a mensagem de resultado.

### 5. O que é um evento? Cite os eventos utilizados nesta aplicação.

Evento é uma ação ou ocorrência à qual o aplicativo pode responder. Nesta aplicação, a digitação ou alteração dos campos é recebida por `onValueChange`, e o toque no botão é tratado pela ação `onClick`.

### 6. O que significa recomposição no Jetpack Compose?

Recomposição é a atualização das partes da interface que dependem de um estado alterado. Por exemplo, quando o usuário digita ou o resultado muda, o Compose atualiza a tela para refletir o novo estado.

### 7. Qual é a responsabilidade da MainActivity neste projeto?

A `MainActivity` é o ponto de entrada da interface Android. Ela configura o conteúdo da tela usando `setContent` e apresenta `CalculadoraDescontoScreen`.

### 8. Qual é a responsabilidade de CalculadoraDescontoScreen?

`CalculadoraDescontoScreen` descreve a interface da calculadora. Ela mantém os estados dos campos e do resultado, recebe as ações do usuário, valida os valores e solicita o cálculo do preço final.

### 9. Por que calcularPrecoComDesconto foi colocada em outro arquivo?

A função foi separada para deixar a regra de cálculo independente da tela. Isso organiza o código e facilita localizar ou reutilizar a lógica de negócio.

### 10. Qual é a vantagem de uma função de regra de negócio não depender do Compose?

Uma função sem dependência do Compose pode ser usada em outros contextos sem precisar da interface, como em outra tela ou em outro tipo de aplicativo. Também fica mais simples entender e verificar a regra matemática separadamente.
