package RoSIIT.Project.repo;

import RoSIIT.Project.model.Company;
import RoSIIT.Project.model.Decl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaDeclRepository extends JpaRepository<Decl, UUID> {
    @Override
    List<Decl> findAll();
}
