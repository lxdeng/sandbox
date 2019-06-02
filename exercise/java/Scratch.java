
import java.util.*;
import java.math.*;

public class Scratch {

	static List<String> result;
	
	public static void main(String[] args) {
		
		//List<Integer> f[] = new List[10];
		
		//f[0] = new ArrayList<Integer>();
		
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(2, "test2");
		tm.put(1, "test1");
		
		for (int key : tm.descendingKeySet())
			System.out.println(key);
		
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(2);
		tset.add(1);
		
		for (int x : tset.descendingSet())
			System.out.println(x);
		 
		/*Dog[] dogs = new Dog[2];
		dogs[0] = new Dog("dog1");
		dogs[1] = new Dog("dog2");
		
		ArrayList<Dog> gDogs = new ArrayList<>();
		gDogs.add(new Dog("dog3"));
		careAnimals2(gDogs);
		
		System.out.println(dogs[0]);
		
		careAnimals(dogs);
		
		System.out.println(dogs[0]);*/
		
		//System.out.println(isPerfectSquare(14));
		
		//backspaceCompare("bxj##tw", "bxo#j##tw");
		
		//findErrorNums(new int[] {1, 1});
		
		//maxDistToClosest(new int[] {1, 0, 1});
		
		//String s = "aabbcccd";
		//compress(s.toCharArray());
		
		//System.out.println(judgeSquareSum(2147483646));
		
		//System.out.println(customSortString("cba", "abcd"));
		//int [] p = {0,0,1,0,0};
		
		//canPlaceFlowers(p, 1);
		//repeatedSubstringPattern("abaababaab");
		
		//int[][] graph = {{1,2},{3},{3},{}};
		//List<List<Integer>> r = allPathsSourceTarget(graph);
		//System.out.println(uniquePaths(23,12));
		
		//int[] deck = {17,13,11,2,3,5,7};
		//int[] r = deckRevealedIncreasing(deck);
		
		//int[] nums = {1, 2, 2, 3, 4, 5, 6};
		//System.out.println(leftmost(nums, 2));
		

		//String y[] = "1+2i".split("\\+|i");
		//System.out.println(y);
		
		/*
		int[] a = new int[] {1, 2, 3, 4};
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int x: a) list.add(x);
		
		List<List<Integer>> perms = permute(list);
		System.out.println(perms.size());
		print(perms);
		*/
		//System.out.println(hammingWeight(0b00000000000000000000000000001011));

		//int[] A = {5,4,0,3,1,6,2};
		//System.out.println(arrayNesting(A));
		
		//restoreIpAddresses("010010");
		//System.out.println(1.3/3);
		
		
		//System.out.println(threeSum(new int[]{3,0,-2,-1,1,2}));
		//System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
		
		//System.out.println(combinationSum(new int[] {2, 3, 6, 7}, 7));
		//int nums[] = {1, 1, 0};
		//System.out.println(isOneBitCharacter(nums));
		//System.out.println(checkRecord("LALL"));
		
		//System.out.println(convert("PAYPALISHIRING",3));
		//System.out.println(multiply("19", "28"));
		


		//System.out.println(new Scratch().numSquares(4));

		//System.out.println(f(10));
		//System.out.println(hasAlternatingBits(3));
		

		//thirdMax(new int[] {2,2,3,1});
       
		//kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 2);
		
		//int a[] = {4,5,6,7,0,1,2};
		//System.out.println(new Scratch().search(a, 0));
		
		//System.out.println(Integer.toBinaryString(-1));
		
		/*
		int[] commands = {4,-1,4,-2,4};
		int[][] obstacles = {{2, 4}};
		
		System.out.println(robotSim(commands, obstacles));
		*/
		
		//int[] nums = {-2, -2, 1};
		
		//dominantIndex(nums);
		
		//System.out.println(sqrt(8));
		
		//System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
		
		//System.out.println(findMin2(new int[] {3, 3, 1, 3}));
		
		/*
		int [] nums = {1, 2, 2, 3, 4};
		
		System.out.println(diffKBrute(nums, 0));
		System.out.println(diffK(nums, 0));
		*/
		//int [] nums = {0, 0, 1, 0, 0, 0, 1, 1};
		//findMaxLength(nums);
		
		/*
		
		HashSet<List<Integer>> set = new HashSet<>();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		System.out.println("l1 hash=" + l1.hashCode());
		set.add(l1);
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		System.out.println("l2 hash=" + l2.hashCode());
		set.add(l2);
		
		System.out.println(set.size());
		*/
		
		//threeSum(new int[] {2,2,-4,2,2,-4});
		
		/*
		int[] colors = {2, 0, 2, 1, 1, 0};
		sortColor(colors);
		for (int c : colors)
			System.out.print(c + " ");
		System.out.println();
		*/
		
		//System.out.println(nextGreaterElement(12443322));
		/*
		int[] nums = {3,7,8,4};
		int[] ple = previousLessElement(nums);
		for (int x : ple)
			System.out.print(x + " ");
		System.out.println();
		
		int[] nle = nextLessElement(nums);
		for (int x : nle)
			System.out.print(x + " ");
		System.out.println();*/
		

		
	}	
	
	public static int[] previousLessElement(int[] nums) {
		int r[] = new int[nums.length];
		Deque<Integer> stack = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				stack.pop();
			}
			
			r[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
			stack.push(i);
		}
		
		return r;
	}
	
	public static int[] nextLessElement(int[] nums) {
		int r[] = new int[nums.length];
		Deque<Integer> stack = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				r[stack.pop()] = nums[i];
			}
			
			r[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			r[stack.pop()] = -1;
		}
		
		return r;
	}
	
	public static int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();   
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i-1]) {
                swapAndSort(s, i);
            
                long x = Long.parseLong(new String(s));
                if (x > Integer.MAX_VALUE)
                    return -1;
                else
                    return (int)x;
            }
        }
        
        return -1;
    }
    
    // 
    static void swapAndSort(char[] s, int pos) {
        
        char temp = s[pos-1];
        s[pos-1] = s[pos];
        s[pos] = temp;
        
        System.out.println(pos);
        Arrays.sort(s, pos+1, s.length);   
    }
	
	public static void sortColor(int[] nums) {
		int lt = 0, i = 0, gt = nums.length - 1;
		
		while (i <= gt) {
			if (nums[i] == 2) {
				swap(nums, i, gt--);
			} else if (nums[i] == 0) {
				swap(nums, lt++, i++);
			} else {
				i++;
			}
			
		}
		
	}
	
	static void swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) {
                	List<Integer> l = Arrays.asList(nums[i],nums[j++],nums[k--]);
                	System.out.println(l.hashCode());
                	res.add(l);
                	System.out.println(res.size());
                } else if ( sum >0) 
                	k--;
                else if (sum<0) 
                	j++;
            }

        }
        return new ArrayList<>(res);
    }
	
	public static  int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
	
	public static boolean diffKBrute(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++)
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] - nums[i] == k) return true;
				if (nums[j] - nums[i] > k) break;
			}
		
		return false;
	}
	
	public static boolean diffK(int[] nums, int k) {
		
		int i = 0;
		int j = i + 1;
		
	    while( i < nums.length && j<nums.length && i < j) {
	        if (nums[j] - nums[i] == k)
	        	return true;
	        
	        if (nums[j] - nums[i] > k)
	        	i++;
	        else
	        	j++;
	        
	        if (i == j)
	        	j++;
	    }
	    
	    return false;
		/*
		 int i=0;
	     int j=1;
	     while (j < nums.length && i < nums.length) {
	 
	         int diff = nums[j] - nums[i];
	           
	         if (diff == k && i != j )
	            return true;
	         
	         //if (nums[j] - nums[i] < k)
	         if (diff < k)
	        	 j++;
	         else 
	        	 i++;
	    }
	        
	     return false;
	     */
	}
	
	public static int search(int[] nums, int target) {
	    
	    
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int middle = l + (r - l)/2;
            if (nums[middle] == target) return middle;
            
            // when split from the middle, one of the halves, including the middle, is always sorted
            if (nums[l] <= nums[middle]) { //the left part is sorted
                if (nums[0] <= target && target < nums[middle]) // target is in this sorted part
                    r = middle - 1;
                else
                    l = middle + 1;
            } else { // the right part is sorted
                if (nums[middle] < target && target <= nums[r]) // target is in this sorted part
                    l = middle + 1;
                else
                    r = middle - 1;
            }
        } //end of while loop
        
        return -1;
    }
	
	public static int findMin2(int[] nums) {
	       int lo = 0;
	        int hi = nums.length - 1;
	        
	        while (lo < hi) {
	            int middle = lo + (hi - lo)/2;
	            
	            if (nums[middle] <= nums[hi]) // the min is at the left part, from middle to right, it's sorted
	                hi = middle;
	            else
	                lo = middle + 1;
	        }
	        
	        return nums[lo]; 
	    }
	
	public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        
        if (nums[h] > nums[l]) // no rotation
            return nums[0];
        
        while (l < h) {
            int middle = l + (h - l)/2;
            
            if (nums[middle] >= nums[0])
                l = middle + 1;
            else
                h = middle;
        }
        return nums[l];
    }
	
	static int sqrt(int x) {
		int l = 0;
		int h = x;
		
		while (l < h) {
			int m = l + (h-l)/2;
			
			if (m * m == x) return m;
			if (m * m > x)
				h = m - 1;
			else
				l = m + 1;
		}
		
		return l;
	}
	
	static int[] rearrangeArray(int[] nums) {
		int[] result = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++)
			result[i] = nums[nums[i]];
		
		return result;
	}
	
	
	public static int dominantIndex(int[] nums) {

        int one = Integer.MIN_VALUE, two = Integer.MIN_VALUE, index = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(one < nums[i]) {
                two = one;
                one = nums[i];
                index = i;
            } else if (two < nums[i]) {
                two = nums[i];
            }
        }
        return one >= 2 * two ? index : -1;
    }
	
	
    public static int robotSim2(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        
        
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
	
	
	
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		// min queue, sorted by pair sum
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        List<int[]> res = new ArrayList();
        int N1 = nums1.length, N2 = nums2.length;
        
        if (N1 == 0 || N2 == 0) return res; // no pairs to form, just return an empty res list
        
        // offer initial pairs {num1, num2, index_of_num2}
        for (int i = 0; i < Math.min(N1, k); i++) 
        	q.offer(new int[]{nums1[i], nums2[0], 0});
        
        // get 1st k elem into result, each time, offer potential better pairs into queue
        // if there r not enough pair, just return all pairs
        for (int i = 0; i < Math.min(N1 * N2, k); i++) {
            // get the best pair and put into res
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
            // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
            // for B, it might be a better choice, so we offer it into queue
            if (cur[2] < N2 - 1 ) { // still at least one elem after num2 in array nums2
                int idx = cur[2] + 1;
                q.offer(new int[]{cur[0], nums2[idx], idx});
            }
        }
        return res;
        
    }
	
	
	public static int thirdMax(int[] nums) {
        
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        
        for (int n : nums) {
            if (n > max1) max1 = n;

            if (n > max2 && n != max1)
                max2 = n;
        
            if (n > max3 && n != max1 && n != max2)
                max3 = n;
        }
        
        if (max3 == Long.MIN_VALUE || max2 == Long.MIN_VALUE)
            return (int)max1;
        
        return (int)max3;
    }

	public static  List<Integer> topKFrequent(int[] nums, int k) {
		// build hash map : character and how often it appears
	    HashMap<Integer, Integer> count = new HashMap();
	    for (int n: nums) {
	      count.put(n, count.getOrDefault(n, 0) + 1);
	    }

	    // init heap 'the less frequent element first'
	    PriorityQueue<Integer> heap =
	            new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

	    // keep k top frequent elements in the heap
	    for (int n: count.keySet()) {
	      heap.add(n);
	      if (heap.size() > k)
	        heap.poll();
	    }

	    // build output list
	    List<Integer> top_k = new LinkedList();
	    while (!heap.isEmpty())
	      top_k.add(heap.poll());
	    Collections.reverse(top_k);
	    return top_k;
    }
	
	
	public static boolean hasAlternatingBits(int n) {
        
        int flag = 1 << 31;
        
        boolean seenOne = false;
        int prev = 0;
        for (int i = 0; i < 32; i++) {
            if (!seenOne) {
                int bit = n & flag;
                n <<= 1;          
                if ((bit & flag) == 0) {
                    continue;
                } else {
                    //System.out.println("set seenOne " + i);
                    seenOne = true;
                    prev = 1;
                }  
            } else {
                int bit = n & flag;
                n <<= 1;
                if (bit == prev)
                    return false;
                else
                    prev = bit;
            }
        }
        
        return true;
    }
	
	
	
	public static int f(int n) {
		if (n == 1) 
			return 0;
		
		int n1 = -1, n2 = -1;
		
		if (n % 3 == 0)	n1 = f(n/3) + 1;
		
		if (n % 2 == 0) n2 = f(n/2) + 1;

		int n3 = f(n-1) + 1;
		
		if (n1 > 0)
			n3 = Math.min(n3,  n1);
		
		if (n2 > 0)
			n3 = Math.min(n3,  n2);
		
		return n3;
	}
	

	
	
  
	
	public int numSquares(int n) {
        int dp[] = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            System.out.println("sqrt=" + sqrt);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[1];
                
                for (int j = i-2; j > i/2; j--) {
                    if (dp[j] + dp[i-j] < dp[i])
                        dp[i] = dp[j] + dp[i-j];
                }    
            }
            
        }
        
        return dp[n];
    }
	static void testBig() {
		String s = "123456789";
		BigInteger bg = new BigInteger(s);
		
		BigInteger sum = new BigInteger("0");
		
		for (int i = 1; i <=9; i++) {
			
			String x = "";
			for (int j = 1; j < i; j++) 
				x += "0";
			
			BigInteger v = new BigInteger(i + x);
			BigInteger r = bg.multiply(v);
			
			System.out.println(r);
			
			sum = sum.add(r);
			System.out.println("bg part sum=" + sum);
		}
		
		System.out.println("sum=" + sum);
	}
	
	public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        
        StringBuilder sb = new StringBuilder("0");
        
        char[] n2 = num2.toCharArray();
        for (int i = n2.length-1; i >= 0; i--) {
            char c = n2[i];
            if (c >= '1') {
                StringBuilder sb1 = new StringBuilder(num1);
                sb1.reverse();   
                for (int j = 1; j < n2.length - i; j++) 
                    sb1.insert(0, '0');
               
                StringBuilder test = new StringBuilder("0");
                
                for (int j = 0; j < c - '0'; j++) {
                    //sb = add(sb, sb1);
                    test = add(test, sb1, true);
                }    
                
                //System.out.println(test.reverse() + " " + c);
                sb = add(sb, test, false);
            }
        }

        return sb.reverse().toString();
    }
    
    // nums are stored in reversed order, result is also stored in reversed order
    private StringBuilder add(StringBuilder sb1, StringBuilder sb2, boolean skip) {
    	if (!skip) System.out.println("add=" + new StringBuilder(sb1).reverse() + " " + new StringBuilder(sb2).reverse());
    	
        StringBuilder r = new StringBuilder();
        
        int len = Math.max(sb1.length(), sb2.length());
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (i < sb1.length())
                sum = sb1.charAt(i) - '0';
            
            if (i < sb2.length())
                sum += sb2.charAt(i) - '0';
            
            sum += carry;
            
            r.append(sum % 10);
            carry = sum / 10;
        }
        
        if (carry > 0) r.append(carry);
        
        if (!skip) System.out.println("part sum=" + new StringBuilder(r).reverse());
        	
        return r;
    }
	
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder sb[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();
        
        int index = 0;
        int inc = 1;
        for (char c : s.toCharArray()) {
        	System.out.println("index=" + index);
            sb[index].append(c);
            index += inc;
            
            if (index == numRows-1) {
                inc = -1;
                index += inc;
            } else if (index == 0) {
                        inc = 1;
                        index += inc;
                    }
        }
        
        System.out.println(sb[0].toString());
        for (int i = 1; i < numRows; i++)
            sb[0].append(sb[i]);
        
        return sb[0].toString();
    }
	
	public static boolean checkRecord(String s) {
		char[] str = s.toCharArray();
        
        int countA = 0, countL = 0;
        for (char c: str) {
            if (c == 'A') {
                ++countA;
                countL = 0;
            } else if (c == 'L') {
                ++countL;
            }  else {
                countL = 0;
            }
        }
        
        if (countA > 1 || countL > 2) return false;
        return true;
    }
	
	public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n-1] == 1) return false;
        
        if (n == 1 && bits[0] == 0) return true;
        
        if (bits[n-1] == 0 && bits[n-2] == 0) return true;
        
        return !decodable(bits, n - 2); // ... 1, 0 case       
    }
    
    static boolean decodable(int[] bits, int n) {
        if (n<=0) return true;
        
        if (bits[n-1] == 1)
            return decodable(bits, n - 2);
        
        if (bits[n-1] == 0) {
            if (n-2 >=0 && bits[n-2] == 1)
                return decodable(bits, n-2);
            else
                return decodable(bits, n-1);
        }
        
        return false;
    }
	
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    //Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) 
	    	return;
	    
	    if(remain == 0) {
	    	list.add(new ArrayList<>(tempList));
	    } else { 
	    	for(int i = start; i < nums.length; i++) {
	    		tempList.add(nums[i]);
	    		backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	    		tempList.remove(tempList.size() - 1);
	    	}
	    }
	}
	

	
    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
        result = new ArrayList<String>();
        if (len < 4 || len > 12) return result;

        search(s.toCharArray(), 0, new StringBuilder(), 0);
        return result;
    }
    
    static void search(char[] s, int start, StringBuilder sb, int ipParts) {
    	System.out.println("start="+start + ",sb=" + sb + ",ipParts=" +ipParts);
    			
        if (ipParts == 4) {
            if (start > s.length-1) {
                result.add(sb.substring(1));
            }
            return;
        }
        
        for (int i = 1; i < 4; i++) {
            if (start+i <= s.length) {
                String sIp = new String(s, start, i);
                if (sIp.equals("0") || !sIp.startsWith("0") && Integer.parseInt(sIp) < 256) {
                    search(s, start + i, sb.append(".").append(sIp), ipParts+1);
                    //restore
                    //System.out.println("restore");
                    sb.delete(sb.length() - sIp.length() - 1, sb.length());
                    System.out.println("restore sb=" + sb);
                }
            }    
        }
    }
	
	
	public static int arrayNesting(int[] nums) {
        int longest = 0;
        
        boolean[] visited = new boolean[nums.length];
        //HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            int count = 0;
            int start = i;
            do {
                ++count;               
                visited[start] = true;
                start = nums[start];
            } while (start != i);
            
            if (count > longest) longest = count;
        }
        
        return longest;
    }

	
	public static int hammingWeight(int n) {
        int count = 0;
        
        int x = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & x) == 1) count++;
            x = x << 1;
        }
            
        return count;       
    }
	
	static void print(List<List<Integer>> perms) {
		for (List<Integer> list : perms) {
			for(int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> permute(List<Integer> list) {
		int size = list.size();
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		if (size == 1) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(list.get(0));
			result.add(l);
			return result;
		}
			
		for (int i = 0; i < list.size(); i++) {
			int x = list.remove(i);
			
			List<List<Integer>> perms = permute(list);
			
			for (List<Integer> l : perms) {
				l.add(0, x);
				result.add(l);
			}
			
			list.add(i, x);
		}
		
		return result;
	}
	
	
	public static int leftmost(int[] nums, int target) {
		
		int start  = 0;
		int end = nums.length;
		
		while (start < end) {
			//if (start == end)  {
			//	return nums[start] == target ? start : -1;
			//}
			int middle = start + (end - start)/2;
			if (target > nums[middle])
				start = middle + 1;
			else
				end = middle;
		}
		
		return start;
	}
	
	
    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deck.length; i++) q.offer(i);
        
        int idx = 0;
        while(!q.isEmpty()) {
            res[q.poll()] = deck[idx++];
            if(!q.isEmpty()) 
                q.offer(q.poll());
        }
        return res;
    }
    
    public static int uniquePaths(int m, int n) { // m is columns, n is rows
        if (m < 1 || n < 1) return 0;
        return paths(0, 0, m-1, n-1);
     }
     
     static int paths(int startX, int startY, int endX, int endY) {
         if (startX > endX || startY > endY) return 0;
         
         if (startX == endX && startY == endY)
             return 1;
         
         return paths(startX+1, startY, endX, endY) + paths(startX, startY+1, endX, endY);
     }
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        return getPaths(graph, 0, graph.length - 1);       
    }
    
    static List<List<Integer>> getPaths(int[][] graph, int start, int target) {
    
        ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
        if (start == target) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(target);
            r.add(list);
            return r;
        }
            
        int[] interms = graph[start];
        
        for (int x : interms) {
            List<List<Integer>> paths = getPaths(graph, x, target);
            for (List<Integer> p : paths) {
                p.add(0, x);
            }
            r.addAll(paths);
        }
        return r;
    }
	
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        char[] buf = s.toCharArray();
        
        for (int i = 1; i <= len/2; i++) {
            if (len % i != 0) break;
            if (isRepeated(buf, i)) return true; 
        }
        return false;
    }
    
    static boolean isRepeated(char[] buf, int n) {
        System.out.println(n);
        for (int i = 1; i < buf.length/n; i++) {
            for (int j = 0; j < n; j++) {
                if (buf[j] != buf[n * i + j])
                    return false;
            }
        }
        return true;
    }
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;

            if ((i == 0 || flowerbed[i-1] == 0) && 
                (i == flowerbed.length -1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                --n;
            }
            
        }
    
        return n == 0;
    }
	
	public static String customSortString(String S, String T) {
        
        //HashMap<Character, Integer> order = new HashMap<>();
        //for (int i = 0; i < S.length(); i++)
        //    order.put(S.charAt(i), i);
        
        int[] order = new int[26];
        Arrays.fill(order, -1);
        for (int i = 0; i < S.length(); i++)
            order[S.charAt(i) - 'a'] = i;
        
        StringBuilder sb = new StringBuilder();   
        int[] counts = new int[S.length()];

        for (char c : T.toCharArray()) {
            int pos = c -'a';
            if (order[pos] == -1) {
                sb.append(c);
            } else {
                ++counts[order[pos]];
            }
        }
        
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++)
                sb.append(S.charAt(i));
        }
        
        return new String(sb);
    }
	/*
    public static boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        if (max*max == c) 
            return true;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            int p = i*i;
            if (set.contains(c-p) || p+p == c)
                return true;
            else {
                set.add(p);
            }    
        }
      
        return false;
    
    }*/
    
    public static boolean judgeSquareSum(int c) {
        for (long i = 0; i*i <= c; i++) {
        	System.out.println(i);
            double x = Math.sqrt(c-i*i);
            if (x == (int)x)
                return true;
        }
        return false;
    }
	
    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
	
    public static int maxDistToClosest(int[] seats) {
        int max = 1;
        
        int prev = -1;
        for (int i = 0; i < seats.length; i++) {
            if (i < seats.length - 1 && seats[i] == 0) continue;
            
            int dist;
            if (i != seats.length - 1) {
                if (prev >= 0)
                    dist = (i-prev)/2;
                else
                    dist = i;
            } else {
                if (prev >= 0)
                    dist = i - prev;
                else
                    dist = i;
            }
            
            prev = i;
            if (dist > max)
                    max = dist;  
        }
        return max;
    }
	
    public static int[] findErrorNums(int[] nums) {
        int dup = 0;
        
        for (int n : nums) {
            int nn = Math.abs(n);
            if (nums[nn-1] > 0)
                nums[nn-1] = -nums[nn-1];
            else
               dup = Math.abs(nn); 
        }
        
        int missing = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
	

	    public static boolean backspaceCompare(String S, String T) {
	        int i = S.length() - 1, j = T.length() - 1;
	        int skipS = 0, skipT = 0;

	        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
	            while (i >= 0) { // Find position of next possible char in build(S)
	                if (S.charAt(i) == '#') {skipS++; i--;}
	                else if (skipS > 0) 
	                	   {skipS--; i--;}
	                    else 
	                    	break;
	            }
	            while (j >= 0) { // Find position of next possible char in build(T)
	                if (T.charAt(j) == '#') {skipT++; j--;}
	                else if (skipT > 0) 
	                	{skipT--; j--;}
	                else 
	                	break;
	            }
	            // If two actual characters are different
	            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
	                return false;
	            // If expecting to compare char vs nothing
	            if ((i >= 0) != (j >= 0))
	                return false;
	            i--; j--;
	        }
	        return true;
	    }

	
    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        
        while (start <= num) {
            int middle = start + (end - start)/2;
            System.out.println(middle);
            long prod = (long)middle * middle;
            if (prod == num)
                return true;
            
            if (prod < num) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
                
        }
        return false;
    }
	
	public static void careAnimals(Animal[] animals) {
		animals[0] = new Cat("cat1");
	}
	
	public static void careAnimals2(List<? extends Animal> animals) {
		int x = animals.size();
		//animals.add(new Dog("test"));
	}
}


class Animal {
	private String name;
	Animal(String name) {
		this.name = name;
	}
	
}

class Dog extends Animal {

	Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	Cat(String name) {
		super(name);
	}
}