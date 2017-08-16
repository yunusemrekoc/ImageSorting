import java.util.ArrayList;

public class BubbleSortOperation {
	public static void sort(ArrayList<SeperatedImage> arr1) {
		SeperatedImage tmp;
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr1.size(); j++) {
				if (arr1.get(i).I < arr1.get(j).I) {
					tmp = arr1.get(j);
					arr1.set(j, arr1.get(i));
					arr1.set(i, tmp);
				}
			}
		}
	}
}