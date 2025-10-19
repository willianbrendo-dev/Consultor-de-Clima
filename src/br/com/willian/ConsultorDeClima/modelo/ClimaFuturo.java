package br.com.willian.ConsultorDeClima.modelo;

public record ClimaFuturo(
        String cidade,
        String data,
        double temperaturaMedia,
        String condicao,
        int umidadeMedia
) {
    @Override
    public String toString() {
        return String.format(
                "📅 Data: %s%n🌍 Cidade: %s%n🌡️ Temperatura média: %.1f°C%n☁️ Clima: %s%n💧 Umidade média: %d%%",
                data, cidade, temperaturaMedia, condicao, umidadeMedia
        );
    }
}
