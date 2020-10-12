/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    /**
     * 为什么向左转不用减法？因为directions是个数组，左转和右转其实就是索引的后退-1和前进+1，
     * 故你在索引为0的时候后退变成了-1，处理起来就比较麻烦。数组的前进和后退求索引，
     * 可以用公式硬套，后退： （curIndex + array.length - 1）% array.length，
     * 前进 （curIndex + 1）% array.length。套入此题就是后退（左转）：（direction + 4-1）% 4，前进（右转）（direction +1）% 4。
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        Set<String> obstacleSets = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSets.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistance = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                direction = (direction + 1) % 4;
            } else if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            } else {
                int step = 0;
                while (step < commands[i] && !obstacleSets
                        .contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
                maxDistance = Math.max(maxDistance, x * x + y * y);
            }
        }
        return maxDistance;
    }
}
// @lc code=end
