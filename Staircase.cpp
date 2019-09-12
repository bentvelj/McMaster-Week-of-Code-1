#include <bits/stdc++.h>

using namespace std;

// Complete the staircase function below.
void staircase(int n) {
    
for (int k = 1; k <= n; k++) {
        for (int i = n-k-1; i >= 0; i--) cout<<" ";
        for (int i = 0; i < k; i++) cout << "#";
        cout << "\n";
    }
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    staircase(n);

    return 0;
}
