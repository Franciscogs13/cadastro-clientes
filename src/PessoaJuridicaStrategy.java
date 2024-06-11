public class PessoaJuridicaStrategy implements ClienteStrategy {
  @Override
  public void processarCliente(Cliente cliente) {
      // Verificar se o CNPJ é válido
      if (!isValidCNPJ(cliente.getCnpj())) {
          throw new RuntimeException("CNPJ inválido");
      }

      // Verificar se a razão social é válida
      if (cliente.getRazaoSocial().trim().isEmpty()) {
          throw new RuntimeException("Razão social inválida");
      }

      // Verificar se o nome fantasia é válido
      if (cliente.getNomeFantasia().trim().isEmpty()) {
          throw new RuntimeException("Nome fantasia inválido");
      }

      // Processar outros dados específicos de pessoa jurídica
      //...

      System.out.println("Pessoa jurídica cadastrada com sucesso!");
  }

  private boolean isValidCNPJ(String cnpj) {
      // Lógica de validação de CNPJ
      if (cnpj == null || cnpj.trim().isEmpty()) {
        return false;
    }

    cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");

    if (cnpj.length()!= 14) {
        return false;
    }

    int[] digits = new int[14];
    for (int i = 0; i < 14; i++) {
        digits[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
    }

    int sum = 0;
    int weight = 5;
    for (int i = 0; i < 12; i++) {
        sum = sum + (digits[i] * weight);
        weight = weight - 1;
        if (weight < 2) {
            weight = 9;
        }
    }

    int verifyingDigit = sum % 11;
    if (verifyingDigit < 2) {
        verifyingDigit = 0;
    } else {
        verifyingDigit = 11 - verifyingDigit;
    }

    if (verifyingDigit!= digits[12]) {
        return false;
    }

    sum = 0;
    weight = 6;
    for (int i = 0; i < 13; i++) {
        sum = sum + (digits[i] * weight);
        weight = weight - 1;
        if (weight < 2) {
            weight = 9;
        }
    }

    verifyingDigit = sum % 11;
    if (verifyingDigit < 2) {
        verifyingDigit = 0;
    } else {
        verifyingDigit = 11 - verifyingDigit;
    }

    if (verifyingDigit!= digits[13]) {
        return false;
    }

      return true; // ou false se o CNPJ for inválido
  }
}
