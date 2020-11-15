# 学习笔记

不同路径 II 的 dp方程：

假设 dp[i][j] 表示走到 (i,j) 上的方法数, obstacleGrid[i][j] = 1 表示 (i,j) 上有障碍，obstacleGrid[i][j] = 0 表示 (i,j) 上无障碍。
那么dp方程为：
```java
    if (obstacleGrid[i][j] == 0) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    } else {
        dp[i][j] = 0;
    }
```

|题目|类型|
|-|-|
|[387.字符串中的第一个唯一字符](./387.字符串中的第一个唯一字符.java)|字符串|
|[541.反转字符串-ii](./541.反转字符串-ii.java)|字符串|
