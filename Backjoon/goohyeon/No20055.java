package goohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20055 {
	public static int N;
    public static int K;
    public static int[] belt;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2 * N];
        robot = new boolean[N];

        st = new java.util.StringTokenizer(br.readLine());
        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(func(0));

        br.close();
    }

    public static int func(int cnt) {
        while (isOK()) {
            int temp = belt[belt.length - 1]; 
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {   
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) { 
                if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    belt[i]--;
                }
            }

            if (belt[0] > 0) { 
                robot[0] = true;
                belt[0]--;
            }
            
            cnt++;
        }

        return cnt;
    }

    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}