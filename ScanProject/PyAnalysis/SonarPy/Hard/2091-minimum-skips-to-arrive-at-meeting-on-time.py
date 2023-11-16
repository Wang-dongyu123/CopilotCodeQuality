#https://leetcode.com/problems/minimum-skips-to-arrive-at-meeting-on-time/
#You are given an integer hoursBefore, the number of hours you have to travel to your meeting. To arrive at your meeting, you have to travel through n roads. The road lengths are given as an integer array dist of length n, where dist[i] describes the length of the ith road in kilometers. In addition, you are given an integer speed, which is the speed (in km/h) you will travel at.
#After you travel road i, you must rest and wait for the next integer hour before you can begin traveling on the next road. Note that you do not have to rest after traveling the last road because you are already at the meeting.
#For example, if traveling a road takes 1.4 hours, you must wait until the 2 hour mark before traveling the next road. If traveling a road takes exactly 2 hours, you do not need to wait.
#However, you are allowed to skip some rests to be able to arrive on time, meaning you do not need to wait for the next integer hour. Note that this means you may finish traveling future roads at different hour marks.
#For example, suppose traveling the first road takes 1.4 hours and traveling the second road takes 0.6 hours. Skipping the rest after the first road will mean you finish traveling the second road right at the 2 hour mark, letting you start traveling the third road immediately.
#Return the minimum number of skips required to arrive at the meeting on time, or -1 if it is impossible.


class Solution(object):
    def minSkips(self, dist, speed, hoursBefore):
        """
        :type dist: List[int]
        :type speed: int
        :type hoursBefore: int
        :rtype: int
        """
        n = len(dist)
        dp = [[float('inf')] * (n+1) for _ in range(n+1)]
        dp[0][0] = 0
        for i in range(1, n+1):
            dp[i][0] = math.ceil(dp[i-1][0] + dist[i-1] / speed)
            for j in range(1, i+1):
                dp[i][j] = min(math.ceil(dp[i-1][j] + dist[i-1] / speed), dp[i-1][j-1] + (dist[i-1] + speed - 1) // speed)
        for i in range(n+1):
            if dp[n][i] <= hoursBefore:
                return i
        return -1
        
        
    