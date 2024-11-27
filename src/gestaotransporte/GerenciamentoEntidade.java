package gestaotransporte;

import java.util.ArrayList;
import java.util.List;

public abstract class GerenciamentoEntidade<T> {
    protected List<T> entidades = new ArrayList<>();

    public void listarEntidades() {
        if (entidades.isEmpty()) {
            System.out.println("Nenhuma entidade cadastrada.");
        } else {
            entidades.forEach(System.out::println);
        }
    }

    public abstract void cadastrarEntidade();

    public abstract void editarEntidade();

    public void removerEntidade(int id) {
        entidades.removeIf(entidade -> getId(entidade) == id);
    }

    public T buscarPorId(int id) {
        return entidades.stream().filter(entidade -> getId(entidade) == id).findFirst().orElse(null);
    }
    
    protected abstract int getId(T entidade);
}
