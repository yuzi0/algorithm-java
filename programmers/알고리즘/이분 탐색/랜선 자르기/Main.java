import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingLanCable {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cables = new int[K];

		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		bw.write(binSearch(K, N, cables) + "\n");
		bw.flush();
		br.close();
		bw.close();

		return;
	}

	public static long binSearch(int K, int N, int[] arr) {
		Arrays.sort(arr);

		long l = 1;
		long r = arr[K - 1];
		long m;

		while (l <= r) {
			m = l + (r - l) / 2;
			
			if (N <= getNum(arr, m)) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}

		return r;
	}

	public static int getNum(int[] arr, long leng) {
		int num = 0;
		for (int a : arr)
			num += a / leng;
		return num;
	}
}
