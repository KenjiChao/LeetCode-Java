c class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) >> 1);

        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(i++, n), newIndex(left++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(i, n), newIndex(right--, n));
            } else {
                i++;
            }
        }
    }

    private int newIndex(int i, int n) {
        return (1 + (i << 1)) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k--;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int start = lo;
            for (int i = lo; i < hi; i++) {
                if (nums[i] > nums[hi]) {
                    swap(nums, start++, i);
                }
            }
            swap(nums, start, hi);

            if (start < k) {
                lo = start + 1;
            } else if (start > k) {
                hi = start - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        final Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }
}
