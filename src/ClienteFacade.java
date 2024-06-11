import java.util.List;

public class ClienteFacade {
  private ClienteSingleton clienteSingleton;
  private ClienteStrategy clienteStrategy;

  public ClienteFacade(ClienteStrategy clienteStrategy) {
      this.clienteStrategy = clienteStrategy;
      this.clienteSingleton = ClienteSingleton.getInstance();
  }

  public void cadastrarCliente(Cliente cliente) {
      clienteStrategy.processarCliente(cliente);
      clienteSingleton.addCliente(cliente);
  }

  public List<Cliente> getClientes() {
      return clienteSingleton.getClientes();
  }
}
