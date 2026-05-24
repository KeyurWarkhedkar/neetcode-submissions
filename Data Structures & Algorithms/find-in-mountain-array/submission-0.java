/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeak(mountainArr, length);
        int foundEle = searchAscending(mountainArr, target, 0, peakIndex);
        if(foundEle == -1) {
            foundEle = searchDescending(mountainArr, target, peakIndex + 1, length - 1);
        }

        return foundEle;
    }
    public int searchAscending(MountainArray mountainArray, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            int midEle = mountainArray.get(mid);
            if(midEle == target) {
                return mid;
            } else if(target < midEle) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public int searchDescending(MountainArray mountainArray, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            int midEle = mountainArray.get(mid);
            if(midEle == target) {
                return mid;
            } else if(target < midEle) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public int findPeak(MountainArray mountainArray, int length) {
        int start = 0;
        int end = length-1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int midEle = mountainArray.get(mid);
            if(mid + 1 < length && mid - 1 >= 0 && mountainArray.get(mid-1) < midEle && mountainArray.get(mid+1) < midEle) {
                return mid;
            } else if(mid + 1 < length && mountainArray.get(mid + 1) < midEle) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}