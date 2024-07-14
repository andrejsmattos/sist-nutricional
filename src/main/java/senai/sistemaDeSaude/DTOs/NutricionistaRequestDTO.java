package senai.sistemaDeSaude.DTOs;

import java.util.Set;

public class NutricionistaRequestDTO {
    private String nome;
    private int anosDeExperiencia;
    private Set<String> certificacoes;

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
}