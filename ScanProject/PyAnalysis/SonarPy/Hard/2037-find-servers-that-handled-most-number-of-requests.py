#https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
#You have k servers numbered from 0 to k-1 that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time. The requests are assigned to servers according to a specific algorithm:
#The ith (0-indexed) request arrives.
#If all servers are busy, the request is dropped (not handled at all).
#If the (i % k)th server is available, assign the request to that server.
#Otherwise, assign the request to the next available server (wrapping around the list of servers and starting from 0 if necessary). For example, if the ith server is busy, try to assign the request to the (i+1)th server, then the (i+2)th server, and so on.
#You are given a strictly increasing array arrival of positive integers, where arrival[i] represents the arrival time of the ith request, and another array load, where load[i] represents the load of the ith request (the time it takes to complete). Your goal is to find the busiest server(s). A server is considered busiest if it handled the most number of requests successfully among all the servers.
#Return a list containing the IDs (0-indexed) of the busiest server(s). You may return the IDs in any order.


class Solution(object):
    def busiestServers(self, k, arrival, load):
        """
        :type k: int
        :type arrival: List[int]
        :type load: List[int]
        :rtype: List[int]
        """       
        q = []
        res = [0] * k
        count = 0
        for i in range(len(arrival)):
            while q and q[0][0] <= arrival[i]:
                heapq.heappush(q, (q[0][1], q[0][2]))
                heapq.heappop(q)
            if len(q) < k:
                heapq.heappush(q, (arrival[i] + load[i], count, count))
                res[count] += 1
                count += 1
            else:
                _, _, idx = heapq.heappop(q)
                heapq.heappush(q, (arrival[i] + load[i], idx, idx))
                res[idx] += 1
        maxv = max(res)
        return [i for i in range(k) if res[i] == maxv]
        
        
        
    