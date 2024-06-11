public class Cliente {
  private String nome;
  private String cpf; // ou cnpj para pessoa jurídica
  private String cnpj;
  private String dataNascimento; // apenas para pessoa física
  private String razaoSocial; // apenas para pessoa jurídica
  private String nomeFantasia; // apenas para pessoa jurídica

  public Cliente(String nome, String cpf) {
      this.nome = nome;
      this.cpf = cpf;
  }

  public Cliente(String nome, String cpf, String dataNascimento) {
      this.nome = nome;
      this.cpf = cpf;
      this.dataNascimento = dataNascimento;
  }

  public Cliente(String nome, String cnpj, String razaoSocial, String nomeFantasia) {
      this.nome = nome;
      this.cpf = cnpj; // armazenar CNPJ em vez de CPF
      this.razaoSocial = razaoSocial;
      this.nomeFantasia = nomeFantasia;
  }

  public String getNome() {
      return nome;
  }

  public String getCpf() {
      return cpf;
  }

  public String getDataNascimento() {
      return dataNascimento;
  }

  public String getRazaoSocial() {
      return razaoSocial;
  }

  public String getNomeFantasia() {
      return nomeFantasia;
  }
  
  public String getCnpj(){
    return cnpj;
  }
}