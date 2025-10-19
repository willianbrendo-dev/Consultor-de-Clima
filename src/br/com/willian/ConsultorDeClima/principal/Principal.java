package br.com.willian.ConsultorDeClima.principal;

import br.com.willian.ConsultorDeClima.http.ClienteHttp;
import br.com.willian.ConsultorDeClima.modelo.ClimaFuturo;
import br.com.willian.ConsultorDeClima.modelo.ClimaInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    private static final String API_KEY = "SUA_CHAVE_AQUI"; // <-- coloque sua chave aqui
    private static final String BASE_URL = "https://api.weatherapi.com/v1/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gson gson = new Gson();
        ClienteHttp clienteHttp = new ClienteHttp();

        while (true) {
            System.out.println("\n=== 🌤️ CONSULTA DE CLIMA ===");
            System.out.println("1️⃣  Clima atual");
            System.out.println("2️⃣  Previsão futura");
            System.out.println("0️⃣  Sair");
            System.out.print("👉 Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (opcao == 0) {
                System.out.println("👋 Encerrando... até a próxima!");
                break;
            }

            System.out.print("🏙️  Digite o nome da cidade: ");
            String cidade = sc.nextLine().trim();

            String url;
            String data = null;
            switch (opcao) {
                case 1 -> url = BASE_URL + "current.json?key=" + API_KEY + "&q=" + cidade + "&lang=pt";
                case 2 -> {
                    System.out.print("📅 Digite a data desejada (AAAA-MM-DD): ");
                    data = sc.nextLine().trim();
                    url = BASE_URL + "forecast.json?key=" + API_KEY + "&q=" + cidade + "&lang=pt&dt=" + data;
                }
                default -> {
                    System.out.println("❌ Opção inválida, tente novamente.");
                    continue;
                }

            }

            try {
                String resposta = clienteHttp.buscarDados(url);
                JsonObject root = JsonParser.parseString(resposta).getAsJsonObject();
                JsonObject location = root.getAsJsonObject("location");

                if (opcao == 1) {
                    JsonObject current = root.getAsJsonObject("current");
                    JsonObject condition = current.getAsJsonObject("condition");

                    ClimaInfo clima = new ClimaInfo(
                            location.get("name").getAsString(),
                            current.get("temp_c").getAsDouble(),
                            condition.get("text").getAsString(),
                            current.get("humidity").getAsInt()
                    );

                    System.out.println("\n" + clima);
                } else {
                    JsonObject forecastDay = root.getAsJsonObject("forecast")
                            .getAsJsonArray("forecastday")
                            .get(0).getAsJsonObject()
                            .getAsJsonObject("day");

                    JsonObject condition = forecastDay.getAsJsonObject("condition");

                    ClimaFuturo futuro = new ClimaFuturo(
                            location.get("name").getAsString(),
                            data,
                            forecastDay.get("avgtemp_c").getAsDouble(),
                            condition.get("text").getAsString(),
                            forecastDay.get("avghumidity").getAsInt()
                    );

                    System.out.println("\n" + futuro);
                }
            } catch (Exception e) {
                System.out.println("⚠️ Erro ao buscar dados: " + e.getMessage());
            }
        }
    }



}
