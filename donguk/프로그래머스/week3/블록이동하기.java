package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class 블록이동하기 {
    static class Solution{
        public int solution(int[][] board) {
            int answer = 0;
            ArrayDeque<Robot> q = new ArrayDeque<>();
            int n = board.length;
            int[][][] map = new int[board.length][board[0].length][2];
            boolean[][][] visited = new boolean[board.length][board[0].length][2];
            int[] dx = {0,0, 1, -1};
            int[] dy = {1, -1, 0, 0};



//            가로: 0 , 세로: 1

            Robot start = new Robot(new int[]{0, 0}, new int[]{0, 1}, 0);
            q.add(start);
            visited[0][0][0] = true;
            map[0][0][0] = 0;

            while(!q.isEmpty()){
                Robot current = q.pop();
                int leftX = current.leftPosition[0];
                int leftY = current.leftPosition[1];

                int rightX = current.rightPosition[0];
                int rightY = current.rightPosition[1];

                int direction = current.direction;

//                회전 x -> 평행 이동만 따진다
                for(int k =0 ; k<4; k++){
                    int leftNx = leftX + dx[k];
                    int leftNy = leftY + dy[k];

                    int rightNx = rightX + dx[k];
                    int rightNy = rightY + dy[k];

                    if(0<= leftNx && leftNx <n && 0<= leftNy && leftNy<n && 0<= rightNx && rightNx<n && 0<= rightNy && rightNy<n){
                        if(!visited[leftNx][leftNy][direction] && board[leftNx][leftNy] != 1 && board[rightNx][rightNy] != 1){
                            if((leftNx == n-1 && leftNy == n-1) || (rightNx == n-1 && rightNy == n-1)){
                                return map[leftX][leftY][direction] + 1;
                            }else{
                                visited[leftNx][leftNy][direction] = true;
                                map[leftNx][leftNy][direction] = map[leftX][leftY][direction] + 1;
                                Robot newRobot = new Robot(new int[]{leftNx,leftNy}, new int[]{rightNx,rightNy}, direction);
                                q.add(newRobot);
                            }
                        }
                    }
                }

//            (가로)4방향 평행이동 (회전 시키고 , 다시 기준을 왼쪽에 맞추고, 그거 기준으로 방문체크 + 거리계산+범위 )

                if(direction == 0){
//                    왼쪽 기준 + 반시계 방향 (rightX-1, rightY-1), (rightX-1 , rightY)
                    if(0<= rightX-1 && rightX-1< n && 0<= rightY-1 && rightY-1<n && 0<= rightX-1 && rightX-1< n){
                        if(board[rightX-1][rightY-1] != 1 && board[rightX-1][rightY]!=1){
                            if(!visited[rightX-1][rightY-1][1]){
                                map[rightX - 1][rightY - 1][1] = map[leftX][leftY][direction] + 1;
                                Robot newRobot = new Robot(new int[]{rightX-1,rightY-1}, new int[]{leftX,leftY}, 1);
                                q.add(newRobot);
                                visited[rightX-1][rightY-1][1] = true;
                            }
                        }
                    }
//                    왼쪽 기준 + 시계 방향 (rightX+1,rightY-1) , (rightX+1,rightY+1)
                    if(0<= rightX+1 && rightX+1< n && 0<= rightY-1 && rightY-1<n && 0<= rightY+1 && rightY+1< n){
                        if(board[rightX+1][rightY-1] != 1 && board[rightX+1][rightY+1]!=1){
                            if(!visited[leftX][leftY][1]){
                                map[leftX][leftY][1] = map[leftX][leftY][direction] + 1;
                                Robot newRobot = new Robot(new int[]{leftX,leftY}, new int[]{rightX+1,rightY-1}, 1);
                                q.add(newRobot);
                                visited[leftX][leftY][1] = true;
                            }
                        }
                    }

//                    오른쪽 기준 + 시계 방향 (leftX-1 , leftY) , (leftX-1, leftY+1)
                    if(0<= rightX+1 && rightX+1< n && 0<= rightY-1 && rightY-1<n && 0<= rightY+1 && rightY+1< n){
                        if(board[rightX+1][rightY-1] != 1 && board[rightX+1][rightY+1]!=1){
                            if(!visited[leftX][leftY][1]){
                                map[leftX][leftY][1] = map[leftX][leftY][direction] + 1;
                                Robot newRobot = new Robot(new int[]{leftX,leftY}, new int[]{rightX+1,rightY-1}, 1);
                                q.add(newRobot);
                                visited[leftX][leftY][1] = true;
                            }
                        }
                    }


//                    오른쪽 기준 + 반 시계 방향
                }


//            왼쪽 기준 시계

//            오른쪽 기준 반시계
//            오른쪽 기준 시계

            }





            return answer;
        }
    }
    static class Robot {
        int[] leftPosition;
        int[] rightPosition;
        int direction;

        Robot(int[] leftPosition, int[] rightPosition, int direction) {
            this.leftPosition = leftPosition;
            this.rightPosition = rightPosition;
            this.direction = direction;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] board = {{0,0,0,1,1}, {0,0,0,1,0}, {0,1,0,1,1}, {1,1,0,0,1}, {0,0,0,0,0}};

        System.out.println(sol.solution(board));
    }
}
