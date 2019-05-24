package GraphImpl;
import graph.Graph;
import graph.Vertex;
import graph.Edge;
import graph.DirectedEdge;
import graph.UndirectedEdge;

public class GraphImpl{
	private static final int MAX_SIZE =100;
	private int nbVertex;
	private int nbEdge;
	private Vertex[] tabVertex;
	private Edge[] tabEdge;
	private boolean[][] matAdj;
	public GraphImpl(){
		this.nbVertex=0;
		this.tabVertex = new Vertex[MAX_SIZE];
		this.matAdj = new boolean[MAX_SIZE][MAX_SIZE];
	}

	public void addEdge(Edge e, Vertex v1, Vertex v2){
		boolean estv1=false;
		boolean estv2=false;
		int abs=0;
		int ord=0;
		int i;
		//On verifie l'existence des 2 vertex dans le graph
		for(i=0;i<this.nbVertex;i++){
			if(v1==this.tabVertex[i]){
				estv1=true;
				abs=i;
			}
			if(v2==this.tabVertex[i]){
				estv2=true;
				ord=i;
			}
		}
		//SI il existe on ajoute le edge + on l'ajoute dans la matAdg
		if(estv1 && estv2){
			this.matAdj[abs][ord]=true;
			this.matAdj[ord][abs]=true;
		}
		else{
			System.out.print("Ces vertex n existe pas");
		}
	}

	public void addVertex(Vertex v){
		this.tabVertex[this.nbVertex]=v;
		this.nbVertex++;
	}
	public void deleteEdge(Edge e, Vertex v1, Vertex v2){
		int i;
		int j;
		int ord=0;
		int abs=0;
		boolean estv1=false;
		boolean estv2=false;
		//Est ce que l'edge est dans la mat Adj
		for(i=0;i<this.nbVertex;i++){
			if(v1==this.tabVertex[i]){
				abs=i;
				estv1=true;
			}
			if(v2==this.tabVertex[i]){
				ord=i;
				estv2=true;
			}
		}
		if(estv1 && estv2){
			//Si il existe on l'enleve
			this.matAdj[abs][ord]=false;
			this.matAdj[ord][abs]=false;
		}
		
	}
	public void deleteVertex(Vertex v){
		int i;
		int j;
		int k;
		int l;
		int nb=0;
		boolean estla= false;
		//On verifie que le vertex existe on recupere sa 'coordonee' de matAdj
		for(i=0;i<nbVertex;i++){	
			if(v==this.tabVertex[i]){
				nb=i;
				estla=true;
				for(j=nb;j<nbVertex-1;j++){
					this.tabVertex[j]=this.tabVertex[j+1];
					this.nbVertex=this.nbVertex-1;
				}
			}
		}
		if(estla){
			//On supprime la colone de ce vertex dans matAdj 
			for(k=nb;k<this.nbVertex;k++){
				for(l=0;l<this.nbVertex+1;l++){
					matAdj[k][l]=matAdj[k+1][l];
				}
			}
			//On supprime la ligne de ce vertex dans matAdj 
			for(k=nb;k<this.nbVertex;k++){
				for(l=0;l<this.nbVertex;l++){
					matAdj[l][k]=matAdj[l][k+1];
				}
			}
		}
	}

	public boolean existsEdge(Vertex v1, Vertex v2){
		int ord=0;
		int abs=0;
		boolean estv1=false;
		boolean estv2=false;
		int i;
		for(i=0;i<this.nbVertex;i++){
			if(v1==this.tabVertex[i]){
				abs=i;
				estv1=true;
			}
			if(v2==this.tabVertex[i]){
				ord=i;
				estv2=true;
			}
		}
		if(estv1 && estv2){
			return this.matAdj[abs][ord] || this.matAdj[ord][abs];
		}
		return false;
	}

	public boolean existsVertex(Vertex v){
		int i;
		for(i=0;i<this.nbVertex;i++){
			if(v==this.tabVertex[i]){
				return true;
			}
		}
		return false;
	}
}