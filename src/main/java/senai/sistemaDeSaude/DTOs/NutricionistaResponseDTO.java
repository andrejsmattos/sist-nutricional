package senai.sistemaDeSaude.DTOs;

import java.util.Set;

public class NutricionistaResponseDTO {
    private Long id;
        private String nome;
        private int anosDeExperiencia;
        private Set<String> certificacoes;

    public NutricionistaResponseDTO(Long id, String nome, int anosDeExperiencia, Set<String> certificacoes) {
        this.id = id;
        this.nome = nome;
        this.anosDeExperiencia = anosDeExperiencia;
        this.certificacoes = certificacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public Set<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(Set<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    @Override
    public String toString() {
        return "NutricionistaResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anosDeExperiencia=" + anosDeExperiencia +
                ", certificacoes=" + certificacoes +
                '}';
    }

}