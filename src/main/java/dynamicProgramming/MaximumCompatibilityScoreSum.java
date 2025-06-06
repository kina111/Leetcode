/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/**
Task: Give m students (each student have a task with n question), each student will be marked by one specific teacher with their own answer
* ex: students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
* Return maximum score of all students.
* 
* Sol: Calculating each student-mentor pair into 2D-array, so this question become putNQueen problems.
 */
public class MaximumCompatibilityScoreSum {
    int res = -1;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int nofStudents = students.length;
        int nofTests = students[0].length;

        // calculate mark of each student-teacher pair
        int[][] mark = new int[nofStudents][nofStudents]; 
        for (int i = 0; i < nofStudents; i++){
            for (int j = 0; j < nofStudents; j++){
                mark[i][j] = calculate(students, mentors, i, j);
            }
        }

        boolean[] used = new boolean[nofStudents] ;// to check marked students
        backtrack(mark, 0, 0, used);
        return res;
    }

    private void backtrack(int[][] mark, int row, int tempPoint, boolean[] used){
        if (row == mark.length){
            res = Math.max(res, tempPoint);
            return;
        }

        for (int i = 0; i < mark.length; i++){
            if (!used[i]){
                used[i] = true;
                backtrack(mark, row+1, tempPoint + mark[row][i], used);
                used[i] = false;
            }
        }
    }

    private int calculate(int[][] students, int[][] mentors, int s, int m){
        int point = 0;
        for (int i = 0; i < students[0].length; i++){
            if (students[s][i] == mentors[m][i]) point++;
        }
        return point;
    }
}
