#  🔍Buscador de CEPs e endereços🔍

## Visão geral do projeto:
O objetivo foi criar um programa que possibilite que o usuário receba um endereço baseado no **CEP** digitado, ou uma lista de endereços baseados nos atributos **UF**, **Cidade** e **Logradouro**,
a fim de praticar os princípios da **Programação Orientada a Objetos aplicada em Java**, o **consumo de APIs** para requisições HTTP e o **gerenciamento de exceções**, além da **manipulação de arquivos JSON** utilizando um serializador.

### Ferramentas utilizadas:
- **Linguagem:** [Java (21.0.2)](https://www.java.com/pt-BR/)

- **IDE:** [IntelliJ Community Edition](https://www.jetbrains.com/idea/)

- **JSON Serializer**: [Gson](https://github.com/google/gson)

- **API Rest**: [ViaCEP](https://viacep.com.br)

## Funcionamento:
Ao ser executado, o programa exibe o seguinte menu:

```
Selecione uma opção:  

1. Consulta por CEP
2. Consulta por Endereço
3. Sair
```
#

###  **-> Opção 1:** Procurar por detalhes de um CEP específico
Ao selecionar a opção "1", o programa solicitará que o CEP seja digitado. O CEP digitado deve conter **apenas números e separador** (ex: 01010100 ou 01010-100), caso contrário o programa exibirá a mensagem **`CEP em formato inválido!`** e retornará ao menu principal.

Caso a entrada esteja no formato correto, o programa retornará os resultados encontrados:

**Entrada:**
```
Digite o CEP:
01001000
```
**Saída:**
```
1 resultado(s) encontrado(s): 

CEP: 01001-000
Praça da Sé - Sé
São Paulo, SP
São Paulo
```
#
### **-> Opção 2:** Procurar por um conjunto de endereços
Caso o CEP seja desconhecido, a segunda opção pode ser utilizada para receber uma lista de CEPs e endereços dadas as informações de **UF, cidade e logradouro**:

**Entrada:**
```
Digite a UF:
RJ

Digite a cidade:
Rio de Janeiro

Digite o logradouro:
Meier
```
**Saída:**
```
14 resultado(s) encontrado(s): 

CEP: 20720-150
Largo do Meier - Méier
Rio de Janeiro, RJ
Rio de Janeiro

CEP: 20710-125
Rua Joaquim Meier - Lins de Vasconcelos
Rio de Janeiro, RJ
Rio de Janeiro

CEP: 20725-050
Rua Joaquim Meier - Méier
Rio de Janeiro, RJ
Rio de Janeiro

...

```
#
- ### Nenhum resultado encontrado
Caso a pesquisa não retorne resultados, a uma mensagem será exibida e o programa retornará ao menu:
```
Digite o CEP:
78945612
A pesquisa não retornou resultados...

Selecione uma opção:

1. Consulta por CEP
2. Consulta por endereço
3. Sair
```
#
- ### Salvar resultados
Após exibir os resultados encontrados, o programa solicitará uma confirmação para salvar os resultados em um arquivo JSON no mesmo diretório de execução do programa:

```
...

CEP: 20710-015
Comunidade Urbana Joaquim Meier - Méier
Rio de Janeiro, RJ
Rio de Janeiro

Pressione enter para salvar os resultados em "ConsultaDeEnderecos_1.json"..
```

Ao pressionar ***Enter***, o arquivo será salvo e será dada a escolha de realizar outra consulta ou encerrar o programa:
```
Pressione enter para salvar os resultados em "ConsultaDeEnderecos_1.json"..

Consulta salva em "X:\caminho\BuscadorDeCeps\ConsultaDeEnderecos_1.json"
Pressione Enter para continuar ou digite "Sair" para encerrar o programa..
```

---
## Referências de estudo/pesquisa:


- **[Formação - Aprenda a Programar em Java com Orientação a Objetos](https://www.alura.com.br/formacao-java) - Alura**

- **[Apostila - Java e Orientação a Objetos](https://www.alura.com.br/apostila-java-orientacao-objetos) - Alura**

- **[Java Doc](https://docs.oracle.com/en/java/) - Oracle**

- **[Gson User Guide](https://github.com/google/gson/blob/main/UserGuide.md) - Google**
