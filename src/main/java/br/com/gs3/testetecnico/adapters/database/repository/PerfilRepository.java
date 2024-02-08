package br.com.gs3.testetecnico.adapters.database.repository;

import br.com.gs3.testetecnico.adapters.database.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, UUID> {
}
