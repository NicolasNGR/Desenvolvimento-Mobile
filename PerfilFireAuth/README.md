# Perfil FireAuth

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose e Firebase Authentication. Permite criar contas e gerenciar a própria sessão usando e-mail e senha.

## Funcionalidades

- Cadastro com `createUserWithEmailAndPassword`.
- Login com `signInWithEmailAndPassword`.
- Envio de link para redefinição de senha com `sendPasswordResetEmail`.
- Logout.
- Exclusão da própria conta autenticada. Dependendo da sessão, o Firebase pode exigir que o usuário entre novamente antes da exclusão.
- Validação básica dos campos e apresentação de erros do Firebase na interface.

## Organização do projeto

```text
PerfilFireAuth/
├── app/
│   ├── google-services.json
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       └── java/com/example/perfilfireauth/
│           ├── MainActivity.kt
│           ├── data/AuthRepository.kt
│           └── ui/
│               ├── FireAuthApp.kt
│               ├── screens/
│               │   ├── AuthFields.kt
│               │   ├── ForgotPasswordScreen.kt
│               │   ├── LoginScreen.kt
│               │   ├── ProfileScreen.kt
│               │   └── RegisterScreen.kt
│               └── theme/Theme.kt
├── gradle/wrapper/
├── build.gradle.kts
├── gradle.properties
└── settings.gradle.kts
```

## Requisitos

- Android Studio com Android SDK 35 instalado.
- JDK 17 (o JDK incluído no Android Studio pode ser selecionado nas configurações do Gradle).
- Acesso à internet no dispositivo ou emulador.

## Firebase

O projeto já inclui `app/google-services.json`, associado ao app Android `com.example.perfilfireauth` no projeto Firebase `perfilfireauth`. O arquivo contém identificadores públicos de configuração do Firebase; regras de segurança e controles do Firebase devem proteger os dados e serviços usados pelo projeto.

Para usar outro projeto Firebase:

1. Registre um app Android com o pacote `com.example.perfilfireauth` no Firebase Console.
2. Baixe o arquivo `google-services.json` desse app e substitua `app/google-services.json`.
3. Em **Authentication → Sign-in method**, habilite **E-mail/senha**.
4. Sincronize o projeto com os arquivos Gradle no Android Studio.

## Abrir e executar

1. No Android Studio, escolha **Open** e abra a pasta `PerfilFireAuth`.
2. Aguarde a sincronização do Gradle.
3. Selecione um dispositivo Android ou emulador (API 24 ou superior).
4. Clique em **Run** para instalar e iniciar o app.

## Fluxo de teste

1. Crie uma conta usando um endereço de e-mail que você consiga acessar e uma senha com pelo menos 6 caracteres.
2. Saia da conta e teste o login com as mesmas credenciais.
3. Na tela de login, use **Esqueci minha senha** para solicitar o e-mail de redefinição.
4. Teste **Excluir conta** na tela de perfil. A operação remove a conta do Firebase Authentication e não pode ser desfeita pelo app.

## Tecnologias

- Kotlin e Jetpack Compose.
- Firebase Authentication.
- Gradle Kotlin DSL.
