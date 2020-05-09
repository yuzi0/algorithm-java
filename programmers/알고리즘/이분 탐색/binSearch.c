// 선형탐색, 2진탐색
// https://www.youtube.com/watch?v=dOu6_3BLxVI

// 문제 : 숫자가 나열된 배열 arr에서 특정 숫자를 찾는 방법


// 선형탐색 - arr 배열의 데이터가 정렬되어 있지 않아도 됨
int linSearch(int arr[], int len, int x) {
    int i;

    for (int i =0; i < len; i++) {
        if (arr[i] == x) {
            return i;
        }
    }

    return -1;
}

// 2진탐색 - arr 배열의 데이터가 정렬되어 있어야 함
int binSearch(int arr[], int len, int x) {
    // initialzation
    int l = 0;
    int r = len - 1;
    int m;

    while (l <= r) {
        // m = (l+r)/2; 
        // 위에 경우는 overflow가 발생하는 경우가 있기 때문에 아래 방법을 권장
        m = l + (r-l)/2;

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