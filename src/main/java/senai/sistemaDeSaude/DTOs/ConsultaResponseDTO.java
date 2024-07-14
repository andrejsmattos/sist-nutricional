package senai.sistemaDeSaude.DTOs;

import java.time.LocalDateTime;

public class ConsultaResponseDTO {
    private Long id;
    private LocalDateTime dataHora;
    private NutricionistaResponseDTO nutricionista;
    private PacienteResponseDTO paciente;

    public ConsultaResponseDTO() {
    }

    public ConsultaResponseDTO(Long id, LocalDateTime dataHora, NutricionistaResponseDTO nutricionista, PacienteResponseDTO paciente) {
        this.id = id;
        this.dataHora = dataHora;
        this.nutricionista = nutricionista;
        this.paciente = paciente;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public NutricionistaResponseDTO getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(NutricionistaResponseDTO nutricionista) {
        this.nutricionista = nutricionista;
    }

    public PacienteResponseDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteResponseDTO paciente) {
        this.paciente = paciente;
    }

}