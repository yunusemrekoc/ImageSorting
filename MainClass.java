import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) throws IOException {
		//the path which i use for executing the code please enter your own path.
		File data = new File(
				"C:\\Users\\yunus\\Desktop\\Sample Files\\aurora.jpg");
		BufferedImage bfr_img = ImageIO.read(data);
		ArrayList<SeperatedImage> elements = new ArrayList<SeperatedImage>();
		int row = bfr_img.getWidth() / 10;
		int column = bfr_img.getHeight() / 10;
		for (int a = 0; a < row; a++) {
			for (int b = 0; b < column; b++) {
				SeperatedImage temp = new SeperatedImage();
				temp.bufferedImage = bfr_img.getSubimage(a * 10, b * 10, 10, 10);
				temp.intens();
				elements.add(temp);
			}
		}
		BubbleSortOperation.sort(elements);
		BufferedImage final_result = new BufferedImage(bfr_img.getWidth(),
				bfr_img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics conbined_image = final_result.getGraphics();
		for (int a = 0; a < row; a++) {
			for (int b = 0; b < column; b++) {
				int location = b*row+a;
				conbined_image.drawImage(elements.get(location).bufferedImage, a * 10, b * 10, null);
			}
		}
		ImageIO.write(final_result, "PNG", new File(data.getParent(),
				"aurora_sorted.png"));
	}
}
