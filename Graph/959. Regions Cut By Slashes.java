class Solution {
    
    int regions=0; //initially
    
    public int regionsBySlashes(String[] grid) {
        
        /* tThis ii the very start of the intuition of the problem that we have to convert this string[] grid 
        into a matrix of side=grid.length+1, as we will be dealing w vertices now and not edges
        Hence apply dsu on the vertices
        */
        int n=grid.length+1; 
        
        //initialising rank and parent array
        int[] rank=new int[n*n];
        int[] par=new int[n*n];
        
        for(int i=0;i<n*n;i++){ // as there will be n*n vertices in the graph
            par[i]=i;
            rank[i]=1;
        }
        
        //doing union on the points lying on the sqaure border
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    int v=i*n+j;
                    union(0,v,par,rank);
                }
            }
        }
        
        //now doing union on the points joined by slashes
        for(int i=0;i<grid.length;i++){
            char[] ch=grid[i].toCharArray();
            for(int j=0;j<ch.length;j++){
                
                if(ch[j]=='/'){
                    int v1=(i+1)*n+j;
                    int v2=i*n+j+1;
                    union(v1,v2,par,rank);
                }
                else if(ch[j]=='\\'){
                    int v1=i*n+j;
                    int v2=(i+1)*n+(j+1);
                    union(v1,v2,par,rank);
                }
            }
        }
        return regions;
    }
    
    public void union(int x, int y, int[] par, int[] rank){
        
        int leader_x=find(x,par);
        int leader_y=find(y,par);
        
        if(leader_x!=leader_y){
            //then unite these 2 dsu's
            if(rank[leader_x]>rank[leader_y])
                par[leader_y]=leader_x;
            
            else if(rank[leader_x]<rank[leader_y])
                par[leader_x]=leader_y;
            
            else{
                par[leader_y]=leader_x;
                rank[leader_x]++;
            }
        }
        else
            regions++; //this is vv imp case, because a region will be made only if there exists a cycle 
                        //and cycle will be only made if they leader_x and leader_y are already in the same set
    }
    
    public int find(int x, int[] par){
        
        if(x==par[x])
            return x;
        
        int ans=find(par[x],par);
        par[x]=ans;
        return ans;
    }
}
