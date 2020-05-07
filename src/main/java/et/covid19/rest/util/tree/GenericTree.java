package et.covid19.rest.util.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//FIXME may need sync not to use build and find together
public class GenericTree<T> {

	private TreeNode<T> root;
	
	public GenericTree() {
		//
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
		childNodesToVisit.add(this.root);
	}

	public TreeNode<T> get(T position) {
		if(position == null)
			return null;
		
		return find(position);
	}
	
	public List<TreeNode<T>> getChildrenAt(T position) {
		return getChildren(position);
	}
	
	public void addChild(T data) {
		TreeNode<T> node = new TreeNode<>(data);
		addChildAt(root, node);
	}
	
	public void addChildAt(TreeNode<T> child, T position) {
		TreeNode<T> parent = find(position);
		if(parent != null) {
			parent.getChildren().add(child);
		}
	}
	
	/**
	 *  Given list of TreeNode<T> having parent child relation, build a tree starting from a specific parent
	 *  e.g. [a->b, b->c] , [c->e], [d->f] get [a->b, b->c, c->e], [d->f]
	 *  don't forget to override toString() in the class to build tree for
	 * 
	 * Note: the object should {@code Override} toString() with key field
	 * 
	 * @param parent
	 * @param theRest
	 * @return
	 */
	public GenericTree<T> buildTree(TreeNode<T> parent, List<TreeNode<T>> theRest) {
		setRoot(parent);
		Map<String, TreeNode<T>> map = theRest.stream().collect(Collectors.toMap(TreeNode::toString, Function.identity()));
		
		while(childNodesToVisit.iterator().hasNext()) {
			findInternalFromMap(childNodesToVisit.poll(), map);
		}
		
		return this;
	}
	
	/**
	 * Get json representation of the tree
	 * 
	 * @return json string
	 * @throws JsonProcessingException 
	 */
	public String getJSON() throws JsonProcessingException {
		ObjectMapper gson = new ObjectMapper();
		return gson.writeValueAsString(this.root);
	}
	
	// ====== helpers =====
	private LinkedList<TreeNode<T>> childNodesToVisit = new LinkedList<>();
	
	private void addChildAt(TreeNode<T> parent, TreeNode<T> child) {
		TreeNode<T> prt = find(parent.getData());
		if(prt != null) {
			prt.getChildren().add(child);
		}
	}
	
	private List<TreeNode<T>> getChildren(T data) {
		TreeNode<T> prtNode = find(data);
		if(prtNode == null)
			return new ArrayList<>();
		
		return prtNode.getChildren();
	}
	
	/** 
	 * Use a deque to get items since this is queue, 
	 * search starts from root 
	 */
	private TreeNode<T> find(T toFind) {
		if(toFind == null)
			return null;
		
		TreeNode<T> nodeToVisit = childNodesToVisit.poll();
		TreeNode<T> result = findInternal(nodeToVisit, toFind);
		if(result != null)
			return result;
		
		if(nodeToVisit != null && nodeToVisit.getDegree() > 0) {
			childNodesToVisit.addAll(nodeToVisit.getChildren());
			find(toFind);
		}
		
		return null;
	}
	
	// breadth first
	private TreeNode<T> findInternal(TreeNode<T> node, T toFind) {
		if(node == null)
			return null;
		
		if(node.getData().equals(toFind))
			return node;
		for(TreeNode<T> leaf : node.getChildren()) {
			if(leaf.getData().equals(toFind))
				return leaf;
		}
		return null;
	}
	
	private void findInternalFromMap(TreeNode<T> parent, Map<String, TreeNode<T>> map) {
		if(Objects.isNull(parent) || Objects.isNull(map) || map.isEmpty())
			return;
		
		for(TreeNode<T> child : parent.getChildren()) {
			//no self reference
			if(child.getData().equals(parent.getData()))
				continue;
			
			if(map.containsKey(child.getData().toString())) {
				// attach node and add to nodeToVisit
				child.setChildren(map.get(child.getData().toString()).getChildren());
				childNodesToVisit.add(child);
			}
		}
	}
}
