import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
    static int numChild[] = new int[10001];
    static boolean def[] = new boolean[10001];
    
    public static void defineChildren(int x) {
        def[x] = true;
        for(int i : g.get(x)) {
            if(!def[i]) {
                defineChildren(i);
                numChild[x] += numChild[i] + 1;
            }
        }
            
    }
    // Complete the evenForest function below.
    
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        int ans = 0;
        for(int i = 0; i <= t_nodes;i++) g.add(new ArrayList<Integer>());
        
        for(int i = 0; i < t_edges;i++){
            g.get(t_from.get(i)).add(t_to.get(i));
            g.get(t_to.get(i)).add(t_from.get(i));
        }
        
        defineChildren(1);
        
        for(int i = t_nodes;i > 1;i--) if(numChild[i]%2 != 0) ans++;
        
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
