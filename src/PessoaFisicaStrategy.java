public class PessoaFisicaStrategy implements ClienteStrategy {
  @Override
  public void processarCliente(Cliente cliente) {
      // Verificar se o CPF é válido
      if (!isValidCPF(cliente.getCpf())) {
          throw new RuntimeException("CPF inválido");
      }

      // Verificar se a data de nascimento é válida
      if (!isValidDate(cliente.getDataNascimento())) {
          throw new RuntimeException("Data de nascimento inválida");
      }

      // Verificar se o nome é válido
      if (cliente.getNome().trim().isEmpty()) {
          throw new RuntimeException("Nome inválido");
      }

      // Processar outros dados específicos de pessoa física
      //...

      System.out.println("Pessoa física cadastrada com sucesso!");
  }

  private boolean isValidCPF(String cpf) {
      // Lógica de validação de CPF
      if (cpf == null || cpf.trim().isEmpty()) {
        return false;
    }

    cpf = cpf.replace(".", "").replace("-", "");

    if (cpf.length()!= 11) {
        return false;
    }

    int[] digits = new int[11];
    for (int i = 0; i < 11; i++) {
        digits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
    }

    int sum = 0;
    int weight = 10;
    for (int i = 0; i < 9; i++) {
        sum = sum + (digits[i] * weight);
        weight = weight - 1;
    }

    int verifyingDigit = (sum * 10) % 11;
    if (verifyingDigit == 10 || verifyingDigit == 11) {
        verifyingDigit = 0;
    }

    if (verifyingDigit!= digits[9]) {
        return false;
    }

    sum = 0;
    weight = 11;
    for (int i = 0; i < 10; i++) {
        sum = sum + (digits[i] * weight);
        weight = weight - 1;
    }

    verifyingDigit = (sum * 10) % 11;
    if (verifyingDigit == 10 || verifyingDigit == 11) {
        verifyingDigit = 0;
    }

    if (verifyingDigit!= digits[10]) {
        return false;
    }
      return true; // ou false se o CPF for inválido
  }

  private boolean isValidDate(String dataNascimento) {
      // Lógica de validação de data de nascimento
      if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
        return false;
    }

    String[] parts = dataNascimento.split("-");
    if (parts.length!= 3) {
        return false;
    }

    int dia = Integer.parseInt(parts[2]);
    int mes = Integer.parseInt(parts[1]);
    int ano = Integer.parseInt(parts[0]);

    if (dia < 1 || dia > 31) {
        return false;
    }

    if (mes < 1 || mes > 12) {
        return false;
    }

    if (ano < 1900 || ano > 2100) {
        return false;
    }

    if (mes == 2) {
        if (ano % 4 == 0 && (ano % 100!= 0 || ano % 400 == 0)) {
            if (dia > 29) {
                return false;
            }
        } else {
            if (dia > 28) {
                return false;
            }
        }
    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
        if (dia > 30) {
            return false;
        }
    }

    return true; // ou false se a data for inválida
  }
}