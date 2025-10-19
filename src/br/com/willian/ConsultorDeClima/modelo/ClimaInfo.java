package br.com.willian.ConsultorDeClima.modelo;

public record ClimaInfo(
        String cidade,
        double temperatura,
        String condicao,
        int umidade
) {
    @Override
    public String toString() {
        return String.format(
                "🌍 Cidade: %s%n🌡️ Temperatura: %.1f°C%n☁️ Clima: %s%n💧 Umidade: %d%%",
                cidade, temperatura, condicao, umidade
        );
    }
}
