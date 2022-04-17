class Solution{
    public static int mazepaths(int sr,int sc,int er,int ec,String psf){
        if(sr==er && sc==ec){
            System.out.println(psf);
            return 1;
        }
        int count=0;

        if(sc+1<=ec){
            count+=mazepaths(sr,sc+1,er,ec,psf+"h");
        }

        if(sr+1<=er){
            count+=mazepaths(sr+1,sc,er,ec,psf+"v");
        }

        if(sr+1<=er && sc+1<=ec ){
            count+=mazepaths(sr+1, sc+1, er, ec, psf+"d");
        }

        return count;
    }


    public static int mazepaths2(int sr,int sc,int er,int ec,int[][] dir,String[] dirS,String psf){
        if(sr==er && sc==ec){
            System.out.println(psf);
            return 1;
        }
        
        int count=0;
        for(int d=0;d<dir.length;d++){
           int r=sr+ dir[d][0];
           int c=sc+ dir[d][1];

           if(r>=0 && c>=0 && r<=er && c<=ec){
                count+=mazepaths2(r, c, er, ec, dir,dirS,psf+dirS[d]);
           }
            
        }
        return count;
    }

    public static int mazepathsJumps(int sr,int sc,int er,int ec,int[][] dir,String[] dirS,String psf){
        if(sr==er && sc==ec){
            System.out.println(psf);
            return 1;
        }
        
        int count=0;
        for(int d=0;d<dir.length;d++){
            for(int rad=1;rad<=Math.max(er,ec);rad++){
           int r=sr+ rad*dir[d][0];
           int c=sc+ rad*dir[d][1];

           if(r>=0 && c>=0 && r<=er && c<=ec){
                count+=mazepathsJumps(r, c, er, ec, dir,dirS,psf+dirS[d]+rad);
           }
            
        }
      }
        return count;
    }

    public static int floodfill(int sr,int sc,int er,int ec,int[][] dir,String[] dirS,boolean[][] visitedString psf){
        if(sr==er && sc==ec){
            System.out.println(psf);
            return 1;
        }
        
        visited[sr][sc]=true;
        int count=0;
        for(int d=0;d<dir.length;d++){
           int r=sr+ dir[d][0];
           int c=sc+ dir[d][1];

           if(r>=0 && c>=0 && r<=er && c<=ec &&!visited[r][c]){
                count+=floodfill(r, c, er, ec, dir,dirS,psf+dirS[d]);
           }
            
        }

        
        visited[sr][sc]=false;
        return count;
    }


    public static void main(String[] args){
        int[][] dir={{0,1},{1,1},{1,0}};
        String[] dirS={"h","v","d"};
        System.out.println(mazepaths2(0,0,2,2,dir,dirS,""));
    }


}