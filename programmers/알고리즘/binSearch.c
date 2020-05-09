// 선형탐색, 2진탐색
// https://www.youtube.com/watch?v=dOu6_3BLxVI

int linSearch(int arr[], int len, int x) {
    int i;

    for (int i =0; i < len; i++) {
        if (arr[i] == x) {
            return i;
        }

    }

    return -1;
}

int binSearch(int arr[], int len, int x) {
    // initialzation
    int l = 0;
    int r = len - 1;
    int m;

    while (l <= r) {
        m = l + (r-1)/2;

        if (m == arr[m]) {
            return m;
        } else if (x < arr[m]) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    return -1;
}