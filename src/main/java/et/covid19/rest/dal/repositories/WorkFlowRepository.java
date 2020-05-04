package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.Workflow;
import et.covid19.rest.dal.model.WorkflowPK;

@Repository
public interface WorkFlowRepository extends JpaRepository<Workflow, WorkflowPK> {
    
}
