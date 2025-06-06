/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;
import java.util.Arrays;
/*
* Task: Given n events with events[i] = [start, end, value].
* You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
* eg: events = [[1,3,2],[4,5,2],[3,4,3]]
*     result = 2 + 2 = 4;
*/
public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        // Bước 1: Sắp xếp các sự kiện theo thời điểm kết thúc tăng dần
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int[] dp = new int[n]; // dp[i]: giá trị lớn nhất của 1 sự kiện trong [0..i]
        dp[0] = events[0][2];  // sự kiện đầu tiên

        int result = dp[0]; // kết quả lớn nhất khi chọn 1 hoặc 2 sự kiện

        for (int i = 1; i < n; i++) {
            int currentValue = events[i][2];

            // Tìm sự kiện trước gần nhất không trùng thời gian
            int idx = findLatestNonConflict(events, i);

            // Nếu tìm được thì tính tổng giá trị 2 sự kiện
            if (idx != -1) {
                result = Math.max(result, dp[idx] + currentValue);
            }

            // Cập nhật dp[i] là giá trị tối đa 1 sự kiện từ 0..i
            dp[i] = Math.max(dp[i - 1], currentValue);
        }

        // Trả về kết quả lớn nhất giữa:
        // - chọn 2 sự kiện không trùng
        // - chọn 1 sự kiện có giá trị lớn nhất
        return Math.max(result, dp[n - 1]);
    }

    // Tìm chỉ số sự kiện gần nhất có endTime < startTime của sự kiện tại vị trí idx
    private int findLatestNonConflict(int[][] events, int idx) {
        int low = 0, high = idx - 1;
        int targetStart = events[idx][0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Nếu sự kiện mid kết thúc trước thời gian bắt đầu của idx
            if (events[mid][1] < targetStart) {
                // Kiểm tra xem mid + 1 có còn thỏa mãn không
                if (mid + 1 <= high && events[mid + 1][1] < targetStart) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        // Không tìm thấy
        return -1;
    }
}
