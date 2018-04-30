package cn.jyuyang.blogger;

/**
 * @Author PaulMrzhang
 * @Version 2016年11月21日 下午6:59:19
 * @DESC 说明：这份代码是同时给我的，在这里感谢代码的原作者！
 */
public class HamiltonPath {

    public static void main(String[] args) {
        HamiltonPath obj = new HamiltonPath();

        int[][] res ={
                { 0 ,300,360,210,590,475,500,690},
                {300, 0, 380,270,230, 285, 200,390},
                {360,380,0,  510,230,765,580,770},
                {210,270,510, 0,470,265,450,640},
                {590,230,230,470,0,515,260,450},
                {475,285,765,265,515,0,460,650},
                {500,200,580,450,260,460,0,190},
                {690,390,770,640,450,650,190,0}
        };

        int[][] z = {
                {0 ,1 ,1 ,1, 0 ,0, 0, 0},
                {1 ,0, 1 ,1 ,1, 1, 1, 0},
                {1, 1 ,0 ,0, 1, 0 ,0, 0},
                {1 ,1 ,0 ,0, 0, 1, 0, 1},
                {0 ,1, 1, 0 ,0 ,0, 1 ,0},
                { 0 ,1, 0, 1 ,0 ,0, 1, 0},
                {0 ,1 ,0 ,0 ,1, 1, 0, 1},
                {0, 0 ,0 ,1, 0 ,0 ,1, 0}};


         obj.HamiltonPath(z,1,res);
        System.out.println("最短路程：" + obj.minRes);


    }

    static int len;
    static int[] path;
    static int count = 0;

    public void allHamiltonPath(int[][] x,int[][] res) {

        len = x.length;
        path = new int[len];
        int i;
        for (i = 0; i < len; i++) {
            path[0] = i + 1;
            findHamiltonpath(x, 0, i, 0,res);
        }
    }

  public void HamiltonPath(int[][] x, int start,int[][] res) {
      len = x.length;
      path = new int[len];
      int i;
     for (i = start - 1; i < start; i++) {
         path[0] = i + 1;
          findHamiltonpath(x, 0, i, 0,res);
      }
  }

    private void findHamiltonpath(int[][] M, int x, int y, int l,int[][] res) {

        int i;
        for (i = x; i < len; i++) {

            if (M[i][y] != 0) {

                if (detect(path, i + 1))

                    continue;

                l++;
                path[l] = i + 1;

                if (l == len - 1) {
                    count++;
                    if (count == 1)
                        System.out.println("Hamilton path of graph: ");

                    display(path,res);
                    l--;
                    continue;
                }

                M[i][y] = M[y][i] = 0;
                findHamiltonpath(M, 0, i, l, res);

                l--;
                M[i][y] = M[y][i] = 1;
            }
        }
        path[l + 1] = 0;
    }
    int minRes = 10000;
    public void display(int[] x,int[][] res) {


        if(x[x.length-1] == 8) {

            int temp =0;
            for (int i : x) {

                if(i<=7) {
                    int m = x[i-1] - 1;
                    int n = x[i] - 1;
                    temp = temp + res[m][n];

                }

                System.out.print(i + " ");

            }
            if(temp <minRes) {
                minRes = temp;
            }
            System.out.println("路程长度："+temp);

        }

    }

    private boolean detect(int[] x, int target) {
        // Halmilton path
        boolean t = false;
        for (int i : x) {
            if (i == target) {
                t = true;
                break;
            }
        }
        return t;
    }
}