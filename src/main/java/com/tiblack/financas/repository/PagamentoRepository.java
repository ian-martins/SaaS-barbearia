package com.tiblack.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiblack.financas.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
