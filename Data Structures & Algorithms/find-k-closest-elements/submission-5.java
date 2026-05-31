class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = -1;
        int right = -1;
        for(int i=0;i<arr.length;i++) {
            if(x <= arr[i]) {
                left = i-1;
                right = i;
                break;
            }
        }

        /*if() {
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<k;i++) {
                ans.add(arr[i]);
            }
            return ans;
        }*/

        if((left == -1 && right == -1) || (left < 0 && right == 0)) {
            List<Integer> ans = new ArrayList<>();
            if(x < arr[0]) {
                for(int i=0;i<k;i++) {
                    ans.add(arr[i]);
                }
                return ans;
            }
            for(int i=arr.length-1;i>=arr.length-k;i--) {
                ans.add(0, arr[i]);
            }
            return ans;
        }

        List<Integer> ans = new ArrayList<>();

        while(left >= 0 && right < arr.length && ans.size() < k) {
            if(Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                ans.add(arr[right]);
                right++;
            } else {
                ans.add(0, arr[left]);
                left--;
            }
        }

        while(left >= 0 && ans.size() < k) {
            ans.add(arr[left--]);
        }

        while(right < arr.length && ans.size() < k) {
            ans.add(arr[right++]);
        }

        return ans;
    }
}