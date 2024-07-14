package senai.sistemaDeSaude.DTOs;

public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private int idade;
    private EnderecoResponseDTO endereco;

    public PacienteResponseDTO(Long id, String nome, int idade, EnderecoResponseDTO enderecoResponseDTO) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = enderecoResponseDTO;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }


}