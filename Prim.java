package cn.jyuyang.blogger;

import java.util.*;
public class Prim {
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] map = new int[][] {
               /* {0,380,230,200},
                {380,0,230,580},
                {230,230,0,260},
                {200,580,260,9}*/
                { 0 ,300,360,210,590,475,500,690},
                { 300, 0,380,270,230, 285, 200,390},
                {360,380,0,510,230,765,580,770},
                {210,270,510,0,470,265,450,640},
                {590,230,230,470,0,515,260,450},
                {475,285,765,265,515,0,460,650},
                {500,200,580,450,260,460,0,190},
                {690,390,760,640,450,650,190,0}
        };
        prim(map, map.length);
    }
    public static void prim(int[][] graph, int n){

        char[] c = new char[]{'A','B','C','D','E','F','G','E'};
        int[] lowcost = new int[n];  //到新集合的最小权
        int[] mid= new int[n];//存取前驱结点
        List<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序
        int i, j, min, minid , sum = 0;
        //初始化辅助数组
        for(i=1;i<n;i++)
        {
            lowcost[i]=graph[0][i];
            mid[i]=0;
        }
        list.add(c[0]);
        //一共需要加入n-1个点
        for(i=1;i<n;i++)
        {
            min=MAX;
            minid=0;
            //每次找到距离集合最近的点
            for(j=1;j<n;j++)
            {
                if(lowcost[j]!=0&&lowcost[j]<min)
                {
                    min=lowcost[j];
                    minid=j;
                }
            }

            if(minid==0) return;
            list.add(c[minid]);
            lowcost[minid]=0;
            sum+=min;
            System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);
            //加入该点后，更新其它点到集合的距离
            for(j=1;j<n;j++)
            {
                if(lowcost[j]!=0&&lowcost[j]>graph[minid][j])
                {
                    lowcost[j]=graph[minid][j];
                    mid[j]=minid;
                }
            }
        }
        System.out.println("sum:" + sum);

    }

}