import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteFacade clienteFacade = new ClienteFacade(new PessoaFisicaStrategy());

        Cliente cliente1 = new Cliente("Francisco", "123.456.789-01", "1996-07-13");
        clienteFacade.cadastrarCliente(cliente1);

        clienteFacade = new ClienteFacade(new PessoaJuridicaStrategy());
        Cliente cliente2 = new Cliente("Empresa XYZ", "98765432100", "Empresa XYZ Ltda", "XYZ");
        clienteFacade.cadastrarCliente(cliente2);

        List<Cliente> clientes = clienteFacade.getClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - " + cliente.getCpf());
        }
    }
}
