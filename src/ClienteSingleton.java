import java.util.*;

public class ClienteSingleton {
  private static ClienteSingleton instance;
  private List<Cliente> clientes;

  private ClienteSingleton() {
      clientes = new ArrayList<>();
  }

  public static ClienteSingleton getInstance() {
      if (instance == null) {
          instance = new ClienteSingleton();
      }
      return instance;
  }

  public List<Cliente> getClientes() {
      return clientes;
  }

  public void addCliente(Cliente cliente) {
      clientes.add(cliente);
  }
}
