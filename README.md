# 🌤️ Consultor de Clima

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![WeatherAPI](https://img.shields.io/badge/WeatherAPI-🌦️-4A90E2?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Ativo-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

Um consultor meteorológico completo desenvolvido em **Java**, consumindo a **[WeatherAPI](https://www.weatherapi.com/)** para fornecer informações de **clima atual** e **previsões futuras** de qualquer cidade do mundo.

*Desenvolvido como prática de consumo de APIs REST, manipulação de JSON e uso de records no Java moderno.*

</div>

---

## 🧭 Funcionalidades

### ☀️ Recursos Principais
- ✅ **Clima Atual** - Consulte as condições meteorológicas em tempo real de qualquer cidade
- ✅ **Previsão Futura** - Obtenha previsões para datas específicas (formato AAAA-MM-DD)
- ✅ **Interface Amigável** - Menu interativo e informações formatadas no console
- ✅ **Dados Completos** - Temperatura, condições climáticas, umidade e localização

### 📊 Exemplo de Saída
```
🌍 Cidade: Teresina
🌡️ Temperatura: 35.3°C
☁️ Clima: Parcialmente nublado
💧 Umidade: 39%
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **☕ Java 17+** | Linguagem principal do projeto |
| **🌐 HttpClient** | Requisições HTTP nativas do Java |
| **📦 Gson** | Biblioteca para parsing de JSON |
| **🧱 Records** | Estruturas imutáveis para dados |
| **🔗 WeatherAPI** | API REST para dados meteorológicos |

---

## 🧩 Estrutura do Projeto
```
ConsultorDeClima/
├── src/
│   └── br/com/willian/ConsultorDeClima/
│       ├── http/
│       │   └── ClienteHttp.java          # Gerenciamento de requisições HTTP
│       ├── modelo/
│       │   ├── ClimaInfo.java            # Record para clima atual
│       │   └── ClimaFuturo.java          # Record para previsão futura
│       └── principal/
│           └── Principal.java            # Aplicação principal
└── README.md
```

---

## 🚀 Como Executar o Projeto

### 1️⃣ Clone o Repositório
```bash
git clone https://github.com/willianbrendo-dev/ConsultorDeClima.git
cd ConsultorDeClima
```

### 2️⃣ Configure sua API Key
1. Crie uma conta gratuita em [WeatherAPI](https://www.weatherapi.com/)
2. Copie sua API Key
3. Insira no arquivo `Principal.java`:
```java
private static final String API_KEY = "SUA_CHAVE_AQUI";
```

### 3️⃣ Execute o Projeto

**Usando Maven:**
```bash
mvn compile exec:java -Dexec.mainClass="br.com.willian.ConsultorDeClima.principal.Principal"
```

**Ou execute diretamente pela sua IDE** (IntelliJ IDEA, Eclipse, VS Code)

---

## 🖥️ Exemplo de Execução
```
╔════════════════════════════════════════╗
║     🌤️ CONSULTOR DE CLIMA 🌤️          ║
╚════════════════════════════════════════╝

1️⃣  Clima atual
2️⃣  Previsão futura
0️⃣  Sair

👉 Escolha uma opção: 1

🏙️  Digite o nome da cidade: São Paulo

═══════════════════════════════════════
         📊 Clima Atual
═══════════════════════════════════════
🌍 Cidade: São Paulo
🌡️ Temperatura: 27.5°C
☁️ Clima: Parcialmente nublado
💧 Umidade: 65%
═══════════════════════════════════════
```

---

## 💾 Estrutura dos Records

### 🔹 Clima Atual
```java
public record ClimaInfo(String cidade, double temperatura, String condicao, int umidade) {
    @Override
    public String toString() {
        return String.format(
            "🌍 Cidade: %s%n🌡️ Temperatura: %.1f°C%n☁️ Clima: %s%n💧 Umidade: %d%%",
            cidade, temperatura, condicao, umidade
        );
    }
}
```

### 🔹 Previsão Futura
```java
public record ClimaFuturo(String cidade, String data, double temperatura, String condicao, int umidade) {
    @Override
    public String toString() {
        return String.format(
            "🌍 Cidade: %s%n📅 Data: %s%n🌡️ Temperatura Média: %.1f°C%n☁️ Clima: %s%n💧 Umidade: %d%%",
            cidade, data, temperatura, condicao, umidade
        );
    }
}
```

---

## 💡 Conceitos Praticados

- ✨ **HttpClient** para chamadas REST em Java
- 📦 **Parse de JSON** com a biblioteca Gson
- 🧱 **Estruturação de dados** com records (Java 14+)
- 🔄 **Controle de fluxo** com laços e menus interativos
- ⚠️ **Tratamento de exceções** (try/catch)
- 📂 **Organização modular** de pacotes (http, modelo, principal)
- 🎨 **Interface de usuário** no console
- 🌐 **Consumo de APIs REST** externas

---

## 🎯 Próximas Melhorias

- [ ] Adicionar previsão de 7 dias
- [ ] Implementar histórico de consultas
- [ ] Adicionar suporte para múltiplos idiomas
- [ ] Criar interface gráfica (GUI) com JavaFX
- [ ] Implementar cache de requisições
- [ ] Adicionar gráficos de temperatura
- [ ] Permitir busca por coordenadas geográficas
- [ ] Exportar dados em JSON/CSV

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🧑‍💻 Autor

<div align="center">

**Willian Brendo**  
*📚 Estudante de Java | Desenvolvedor em Formação*

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/willianbrendo-dev)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/willian-brendo-alves-batista)

*💼 Projeto desenvolvido com propósito educacional — desafio pessoal inspirado pela Alura*

</div>

---

## ⭐ Contribua

<div align="center">

**Se este projeto foi útil para você, considere deixar uma estrela!** ⭐

Isso me ajuda a continuar desenvolvendo e compartilhando conhecimento 🚀

---

*Feito com ❤️ e ☕ por Willian Brendo*

</div>
