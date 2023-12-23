package bar.api.service;

import bar.api.model.Cliente;
import bar.api.model.Venda;
import bar.api.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;;
    public List<Venda> getAll() {
        return repository.findAll();
    }
    @Transactional
    public Venda gravar(Venda venda) {
        return repository.save(venda);
    }
    public Optional<Venda> getId(Integer id) {
        return repository.findById(id);
    }
    @Transactional
    public void deletar(Optional<Venda> venda) {
        repository.delete(venda.get());
    }

    public List<Venda> findByCliente(Cliente cliente) {
        return repository.findByFkCliente(cliente);
    }

    public List<Venda> findByClienteAndStatus(Cliente cliente, Boolean status) {
        return repository.findByFkClienteAndStatus(cliente, status);
    }
}
