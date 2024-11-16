public class OBST {
    // Функц түлхүүрүүдийн хамгийн бага хайлтын өртгийг олоход ашиглана
    public static int optimalBST(int[] keys, int[] freq, int n) {
        // cost[i][j] массив нь түлхүүрүүд i-ээс j хүртэл хамгийн бага өртгийг хадгална
        int[][] cost = new int[n][n];

        // Давтамжийн массивын утга
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i]; // нэг түлхүүртэй модны өртөг нь түүний давтамж
        }

        // Хоёр ба түүнээс дээш түлхүүртэй модны өртгийг тооцоолно
        for (int L = 2; L <= n; L++) { // түлхүүрүүдийн тоо
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Бүх түлхүүрийг үндэс болгон сонгож, хамгийн бага өртгийг тооцоолно
                for (int r = i; r <= j; r++) {
                    // зүүн болон баруун талын дэд модны өртөгийг тооцоолно
                    int c = ((r > i) ? cost[i][r - 1] : 0) + 
                            ((r < j) ? cost[r + 1][j] : 0) + 
                            sum(freq, i, j);

                    // Хэрэв шинэ өртөг бага байвал хадгална
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        // Эцсийн үр дүн нь cost[0][n-1] байх ёстой
        return cost[0][n - 1];
    }

    // freq[i] - freq[j] массивын нийлбэрийг олох функц
    private static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int keys[] = {5, 6};  // Түлхүүрүүд
        int freq[] = {17, 25};  // Түлхүүр бүрийн хайлтын давтамж
        int n = keys.length;
        System.out.println("Хайлтын хамгийн бага өртөг: " + optimalBST(keys, freq, n));
    }
}
