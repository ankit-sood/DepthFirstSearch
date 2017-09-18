import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
	enum VertexState {
        White, Grey, Black 
    }
	private int[][] adjecencyMatrix;
	private int numberOfNodes = 5;
	public List<Integer> traversedNodes = new ArrayList<>(); 
	private List<VertexState> vertexStatusList = new ArrayList<>();
	
	public DepthFirstSearch(){
		this.adjecencyMatrix = getAdjcencyMatix();
		for(int i=0;i<numberOfNodes;i++){
			vertexStatusList.add(VertexState.White);
		}
	}
	
	private int[][] getAdjcencyMatix(){
		int[][] inputAdjecencyMatrix = {{0,0,0,1,0},{0,0,0,1,1},{0,0,0,0,1},{1,1,0,0,1},{0,1,1,1,0}};
		return inputAdjecencyMatrix;
	}
	
	private boolean isEdgePresent(int u, int v){
		boolean isEdgePresent=false;
		if(adjecencyMatrix[u][v]==1){
			isEdgePresent = true;
		}
		return isEdgePresent;
	}
	
	private void performDFS(int source){
		//changing the status to grey as processing has started
		vertexStatusList.set(source, VertexState.Grey);
		for(int destination=0;destination<numberOfNodes;destination++){
			if(source!=destination && isEdgePresent(source, destination) && vertexStatusList.get(destination)==VertexState.White){
				traversedNodes.add(destination);
				performDFS(destination);
			}
		}
		//changing the status to grey as no other node is possible from the current node
		vertexStatusList.set(source, VertexState.Black);
	}
	
	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.traversedNodes.add(0);
		dfs.performDFS(0);
		System.out.println(dfs.traversedNodes);
	}
}
