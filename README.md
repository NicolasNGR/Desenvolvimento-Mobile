# 📱 Desenvolvimento Mobile

Repositório com os aplicativos Android desenvolvidos para a disciplina de **Desenvolvimento Mobile** — FATEC, Ciclo 4.

Todos os apps foram construídos em **Kotlin**, utilizando o **Android Studio**, com foco em componentes básicos de interface (`EditText`, `Button`, `TextView`) e lógica de negócio simples.

---

## 🗂️ Índice

- [Sobre o repositório](#-sobre-o-repositório)
- [Apps](#-apps)
  - [1. Calculadora](#1️⃣-calculadora)
  - [2. Conversor de Temperatura](#2️⃣-conversor-de-temperatura)
  - [3. Primeira Lei de Ohm](#3️⃣-primeira-lei-de-ohm)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Como executar](#-como-executar)
- [Estrutura do repositório](#-estrutura-do-repositório)
- [Autor](#-autor)

---

## 📖 Sobre o repositório

Este repositório reúne três aplicativos Android independentes, cada um em sua própria pasta, desenvolvidos como parte das atividades práticas da disciplina de Desenvolvimento Mobile. Cada app é um projeto completo do Android Studio, pronto para ser aberto e executado individualmente.

---

## 📲 Apps

### 1️⃣ Calculadora

Aplicativo com as **4 operações fundamentais da matemática** (adição, subtração, multiplicação e divisão).

**Funcionalidades:**
- Dois campos numéricos para entrada dos valores
- Botões para somar, subtrair, multiplicar e dividir
- Exibição do resultado em tempo real
- Aviso (Toast) caso algum campo esteja vazio
- Proteção contra divisão por zero

📁 [`/Calculadora`](./Calculadora)

---

### 2️⃣ Conversor de Temperatura

Aplicativo simples de conversão de temperatura de **Celsius para Fahrenheit**.

**Funcionalidades:**
- Campo de texto para digitar a temperatura em °C
- Botão de conversão
- Exibição do resultado em °F
- Aviso (Toast) caso o campo esteja vazio

📁 [`/ConversorTemperatura`](./ConversorTemperatura)

---

### 3️⃣ Primeira Lei de Ohm

Aplicativo que calcula tensão, resistência ou corrente elétrica, com base na fórmula:

```
V = R × I
```

**Funcionalidades:**
- Três campos: Tensão (V), Resistência (Ω) e Corrente (A)
- Cálculo automático da grandeza faltante, a partir das outras duas:
  - Tensão + Resistência → calcula a Corrente
  - Tensão + Corrente → calcula a Resistência
  - Resistência + Corrente → calcula a Tensão
- Aviso (Toast) caso menos ou mais de 2 campos estejam preenchidos
- Proteção contra divisão por zero

📁 [`/CalculoLeiOhm`](./CalculoLeiOhm)

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Uso |
|---|---|
| **Kotlin** | Linguagem principal de desenvolvimento |
| **Android Studio** | IDE utilizada para todo o desenvolvimento |
| **XML** | Construção das interfaces (layouts) |
| **Gradle (Kotlin DSL)** | Gerenciamento de build e dependências |

---

## ▶️ Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/NicolasNGR/Desenvolvimento-Mobile.git
   ```
2. Abra o **Android Studio**.
3. Selecione **Open** e escolha a pasta do app que deseja rodar (ex: `Calculadora`, `ConversorTemperatura` ou `CalculoLeiOhm`).
4. Aguarde a sincronização do Gradle.
5. Conecte um celular Android (com Depuração USB ativada) ou crie um emulador.
6. Clique em **▶️ Run** para instalar e testar o app.

---

## 📁 Estrutura do repositório

```
Desenvolvimento-Mobile/
├── Calculadora/
│   └── (projeto completo do Android Studio)
├── ConversorTemperatura/
│   └── (projeto completo do Android Studio)
├── CalculoLeiOhm/
│   └── (projeto completo do Android Studio)
└── README.md
```

---

## 👤 Autor

**Nicolas Gomes Ruiz**
FATEC — Ciclo 4 — Desenvolvimento Mobile

[![GitHub](https://img.shields.io/badge/GitHub-NicolasNGR-181717?style=flat&logo=github)](https://github.com/NicolasNGR)
