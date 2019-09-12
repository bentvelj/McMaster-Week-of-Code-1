#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
bool vis[100001];
vector<vector<int>> g(100001);
int main() {
    
    int N, M, A, B, x, y;

    cin >> N >> M;

    while (M) {
        cin >> x >> y;
        g[x].push_back(y);
        g[y].push_back(x);
        M--;
    }
    cin >> A >> B;
    queue<int> todo;
    int s = A;
    todo.push(s);
    vis[A] = true;

    while (!todo.empty()) {
        s = todo.front();
        todo.pop();
        for (int i = 0; i < g[s].size();i++) {
            if (!vis[g[s][i]]) {
                vis[g[s][i]] = true;
                todo.push(g[s][i]);
            }
        }

    }
    printf(vis[B] ? "YES" : "NO");


    return 0;
}