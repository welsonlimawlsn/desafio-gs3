package br.com.gs3.testetecnico.adapters.database.repository;

import br.com.gs3.testetecnico.adapters.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
}
