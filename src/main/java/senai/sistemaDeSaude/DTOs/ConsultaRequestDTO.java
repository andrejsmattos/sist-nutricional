package senai.sistemaDeSaude.DTOs;

import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDateTime;

public class ConsultaRequestDTO {
    @NotNull
    private LocalDateTime dataHora;
    private Long nutricionistaId;
    private Long pacienteId;


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getNutricionistaId() {
        return nutricionistaId;
    }

    public void setNutricionistaId(Long nutricionistaId) {
        this.nutricionistaId = nutricionistaId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}