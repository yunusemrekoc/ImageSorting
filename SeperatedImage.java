import java.awt.image.BufferedImage;

public class SeperatedImage {
	public BufferedImage bufferedImage;
	public double I;

	public void intens() {
		int r = 0, b = 0, g = 0;
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				int intens_rgb = bufferedImage.getRGB(y, x);
				r += (intens_rgb >> 16) & 0xFF;
				b += intens_rgb & 0xFF;
				g += (intens_rgb >> 8) & 0xFF;

			}
		}
		I = 0.298 * r + 0.587 * g + 0.114 * b;
	}
}
