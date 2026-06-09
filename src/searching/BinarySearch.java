package searching;

public class BinarySearch {

    public static String generateDryRun(int[] arr, int target) {

        StringBuilder sb = new StringBuilder();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            sb.append("Low = ")
              .append(low)
              .append("\n");

            sb.append("High = ")
              .append(high)
              .append("\n");

            sb.append("Mid = ")
              .append(mid)
              .append("\n");

            sb.append("Value = ")
              .append(arr[mid])
              .append("\n\n");

            if (arr[mid] == target) {

                sb.append("FOUND AT INDEX ")
                  .append(mid);

                return sb.toString();
            }

            if (arr[mid] < target) {

                sb.append("Move Right\n\n");
                low = mid + 1;

            } else {

                sb.append("Move Left\n\n");
                high = mid - 1;
            }
        }

        sb.append("Target Not Found");

        return sb.toString();
    }
}