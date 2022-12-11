import java.util.Scanner;
import java.util.Arrays;

public class Matrix {
    double[][] matrix;
    int m,n;

    public Matrix(int n, int m) {
        init_matrix(n, m);
    }

    public Matrix(int n) {
        init_matrix(n, n);
    }

    public Matrix() {
        init_matrix(0,0);
    }

    public Matrix(double[][] mat) {
        copy_matrix(mat);
    }

    public Matrix(Matrix mat) {
        copy_matrix(mat.matrix);
    }

    private void copy_matrix(double[][] mat) {
        if (mat == null) {
            this.matrix =  null;
        }
        else {
            init_matrix(mat.length, mat[0].length);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    this.matrix[i][j] = mat[i][j];
                }
            }
        }
    }

    private void init_matrix(int n, int m) {
        this.n = n;
        this.m = m;
        if (n != 0 && m != 0) {
            this.matrix = new double[n][m];
        }
        else {
            this.matrix = null;
        }
    }

    public void print_matrix() {

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void input_matrix() {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = sc.nextInt();
            }
        }
    }


    public void matrix_of_size() {
        init_matrix(n, m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public String size_of_matrix() {
        return this.n +"x"+this.m;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Matrix mx = (Matrix) o;
        return n == mx.n && m == mx.m && Arrays.deepEquals(matrix, mx.matrix);
    }

    public double return_element(int n, int m) {
        return this.matrix[n][m];
    }

    public String return_rows(int n) {
        String row = new String();
        for (int j = 0; j < this.m; j++) {
            row += this.matrix[n][j] + " ";
        }
        return row;
    }

    public String return_columns(int m) {
        String column = new String();
        for (int i = 0; i < this.n; i++) {
            column += this.matrix[i][m] + " ";
        }
        return column;
    }



    public void transposed_matrix() {
        Matrix trans = new Matrix(this);
        init_matrix(this.m, this.n);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = trans.matrix[j][i];
            }
        }
    }

    public void generation_matrix() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = Math.round(Math.random() * 2001 - 1000);
            }
        }
    }

    public void generation_matrix(int n, int m) {
        init_matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = Math.round(Math.random() * 2001 - 1000);
            }
        }
    }

    public void generation_matrix(int n) {
        generation_matrix(n, n);
    }

    public void generation_of_matrixclumn(int n) {
        generation_matrix(n, 1);
    }

}