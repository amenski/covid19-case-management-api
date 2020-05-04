package et.covid19.rest.services.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.Workflow;
import et.covid19.rest.dal.repositories.WorkFlowRepository;
import et.covid19.rest.services.IWorkFlowService;
import et.covid19.rest.util.exception.EthException;

@Service
public class WorkFlowServiceImpl extends AbstractService implements IWorkFlowService {

    @Autowired
    private WorkFlowRepository workflowRepository;
    
    @Override
    @EthLoggable
    public boolean transitionAllowed(Integer startState, Integer endState) throws EthException {
        List<Workflow> workflowList = workflowRepository.findAll();
        Graph<Integer, DefaultEdge> transitionGraph = buildGraph(workflowList);
        return findPath(startState, endState, transitionGraph);
    }

    private boolean findPath(Integer source, Integer destination, Graph<Integer, DefaultEdge> transitionGraph) {
        if(Objects.isNull(source) || Objects.isNull(destination) || Objects.isNull(transitionGraph) || transitionGraph.edgeSet().isEmpty())
            return false;
        
        if(source.equals(destination))
            return true;
        
        //depth first is assumed good if there are StrongConnectedComponents
        Iterator<Integer> iterator = new DepthFirstIterator<>(transitionGraph, source);
        while(iterator.hasNext()) {
            if(destination.equals(iterator.next()))
                return true;
        }
        
        return false;
    }
    
    private Graph<Integer, DefaultEdge> buildGraph(List<Workflow> list) {
        Graph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        for(Workflow state : list) {
            graph.addVertex(state.getId().getStartState());
            graph.addVertex(state.getId().getEndState());
            graph.addEdge(state.getId().getStartState(), state.getId().getEndState());
        }
        return graph;
    }
}
