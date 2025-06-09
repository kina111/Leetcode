/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Task: Given a list of classes with [pass, total] students and a number of extraStudents (who always pass),
distribute the extra students across classes to maximize the average pass ratio.

Hint: Distribute EACH student is better than distribute MANY to a class at time.(prove by Math) 
*/
public class MaximumAveragePassRatio {
    public class Ratio{
        double tu;
        double mau;
        double delta;
        public Ratio(double tu, double mau){
            this.tu = tu;
            this.mau = mau;
            this.delta = getDelta();
        }

        public double getDelta(){
            return (mau-tu)/(mau * (mau+1));
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Ratio> queue = new PriorityQueue<>(new Comparator<Ratio>(){
            public int compare(Ratio r1, Ratio r2){
                return (r2.delta - r1.delta <= 0) ? -1 : 1;
            }
        });
        
        //initial priorityQueue
        int nofClasses = classes.length;
        for (int i = 0; i < nofClasses; i++){
            Ratio temp = new Ratio((double)classes[i][0], (double)classes[i][1]);
            queue.offer(temp);
        }

        //for each time, distribute 1 student to peek class
        while (extraStudents != 0){
            extraStudents--;
            Ratio peek = queue.poll();
            queue.add(new Ratio(peek.tu+1, peek.mau+1));
        }

        //get the result
        double res = 0;
        while (!queue.isEmpty()){
            Ratio peek = queue.poll();
            res += peek.tu / peek.mau;
        }

        return res / nofClasses;
    }
}
