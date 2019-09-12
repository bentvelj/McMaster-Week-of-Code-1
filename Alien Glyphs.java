import java.util.*;
import java.io.*;
public class AlienGlyphs {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(1001);
    static HashMap<Integer,Set<Integer>> mem = new HashMap<Integer,Set<Integer>>();
    static boolean vis[];
    
    public static boolean BFS(int a,int b) {
        vis = new boolean[1001];
        vis[a] = true;
        int s = a;
        Queue<Integer> todo = new LinkedList<Integer>();
        todo.add(s);
        while(!todo.isEmpty()) {
            s = todo.poll();
            for(int i : graph.get(s)) {
                if(!vis[i]) {
                    vis[i] = true; 
                    todo.add(i);
                }
            }
        }
        return vis[b];
    }
    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G,M,N,L,K=0,a,b;
        
        
        String in[] = br.readLine().split(" ");
        G = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        N = Integer.parseInt(in[2]);
        
        for(int i = 0; i < G; i++) graph.add(new ArrayList<Integer>());
            
        for(int i = 0; i < M;i++) {
            in = br.readLine().split(" ");
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            if(graph.get(a) == null) graph.add(new ArrayList<Integer>());
            if(graph.get(b) == null) graph.add(new ArrayList<Integer>());
            
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int p = 0; p < G;p++) {
            
            vis = new boolean[1001];
            vis[p] = true;
            int s = p;
            Queue<Integer> todo = new LinkedList<Integer>();
            todo.add(s);
            while(!todo.isEmpty()) {
                s = todo.poll();
                for(int i : graph.get(s)) {
                    if(!vis[i]) {
                        vis[i] = true; 
                        todo.add(i);
                        if(mem.get(p) == null) mem.put(p,new HashSet<Integer>());
                        mem.get(p).add(i);
                    }
                }
            }
            
        }
        
        boolean flag = true;
        for(int i = 0; i < N;i++) {
            L = Integer.parseInt(br.readLine());
            int w1[] = new int[L];
            int w2[] = new int[L];

            in = br.readLine().split(" ");
            for(int j = 0; j < L; j++) {
                w1[j] = Integer.parseInt(in[j]);
            }
            
            in = br.readLine().split(" ");
            for(int j = 0; j < L; j++) {
                w2[j] = Integer.parseInt(in[j]);
            }
            for(int j = 0; j < L;j++) {
                if(w1[j] == w2[j]) continue;
                
                if(mem.get(w1[j]) == null || !mem.get(w1[j]).contains(w2[j])) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                K++;
            }
            flag = true;
            
        }
        
        System.out.println(K);
        
    }
}
