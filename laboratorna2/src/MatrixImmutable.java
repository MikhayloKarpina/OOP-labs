import java.util.Arrays;

final class MatrixImmutable {

    private final double[][] matrix;
    private final int m,n;

    public MatrixImmutable(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new double[n][m];
    }

    public MatrixImmutable(int n) {
        this(n, n);
    }

    public MatrixImmutable() {
        this(0,0);
    }

    public MatrixImmutable(double[][] mat) {
        this(mat.length, mat[0].length);
        copy_matrix(mat);
    }

    public MatrixImmutable(Matrix mat) {
        this(mat.n, mat.m);
        copy_matrix(mat.matrix);
    }

    private void copy_matrix(double[][] mat) {

        if (mat != null) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    this.matrix[i][j] = mat[i][j];
                }
            }
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

    public String size_of_matrix() {
        return this.n +"x"+this.m;
    }

    public MatrixImmutable matrix_of_size() {
        MatrixImmutable mat = new MatrixImmutable(this.n, this.m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = 0;
            }
        }
        return mat;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        MatrixImmutable mx = (MatrixImmutable) o;
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

    public MatrixImmutable generation_matrix(int n, int m) {
        MatrixImmutable mat = new MatrixImmutable(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = Math.round(Math.random() * 2001 - 1000);
            }
        }
        return mat;
    }

    public MatrixImmutable generation_matrix() {
        MatrixImmutable mat = new MatrixImmutable(this.n, this.m);
        for (int i = 0; i < mat.n; i++) {
            for (int j = 0; j < mat.m; j++) {
                mat.matrix[i][j] = Math.round(Math.random() * 2001 - 1000);
            }
        }
        return mat;
    }

    public MatrixImmutable generation_matrix(int n) {
        return generation_matrix(n, n);
    }

    public MatrixImmutable generation_of_matrixclumn(int n) {
        return generation_matrix(n, 1);
    }

    public MatrixImmutable transposed_matrix() {
        MatrixImmutable trans = new MatrixImmutable(this.n, this.m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = trans.matrix[j][i];
            }
        }
        return trans;
    }
}