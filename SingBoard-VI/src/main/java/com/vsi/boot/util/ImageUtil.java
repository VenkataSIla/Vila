package com.vsi.boot.util;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;

public class ImageUtil 
{
	public static final String IMAGE_SMALL_WIDTH = "100";
	public static final String IMAGE_SMALL_HEIGHT = "75";

	public static final String IMAGE_MEDIUM_WIDTH = "200";
	public static final String IMAGE_MEDIUM_HEIGHT = "150";
	
	public static final String IMAGE_LARGE_WIDTH = "300";
	public static final String IMAGE_LARGE_HEIGHT = "225";

	public static final String IMAGE_XLARGE_WIDTH = "500";
	public static final String IMAGE_XLARGE_HEIGHT = "375";

	/**
	 * Returns a BufferedImage as the result of decoding a supplied File path
	 * 
	 * @param filePath	a File path to read from
	 * @return			a BufferedImage containing the decoded contents of the input, or null. 
	 * @throws IOException 
	 */
	public static BufferedImage getBufferedImage(String filePath) throws IOException
	{
		BufferedImage bufferedImage = null;

		File imgFile = new File(filePath);

		if(imgFile.isFile())
		{
			InputStream is = new FileInputStream( imgFile );
			bufferedImage = ImageIO.read(is);
			is.close();
		}
		
		return bufferedImage;
	}

	/**
	 * Returns new image width for given BufferedImage by maintaining original aspect ratio
	 * 
	 * @param bufferedImage		BufferedImage to be checked for width
	 * @param displayWidth		Expected new width of image
	 * @param displayHeight		Expected new height of image
	 * @return					New image width by maintaining original aspect ratio
	 * @throws Exception
	 */
	public static int getDisplayImageWidth(BufferedImage bufferedImage, int displayWidth, int displayHeight)
	{
		int srcWidth = displayWidth;
		int srcHeight = displayHeight;

		if( bufferedImage != null )
		{
			srcWidth = bufferedImage.getWidth();
			srcHeight = bufferedImage.getHeight();
		}

		return getDisplayImageWidth(srcWidth, srcHeight, displayWidth, displayHeight);
	}

	/**
	 * Returns new image height for given BufferedImage by maintaining original aspect ratio
	 * 
	 * @param bufferedImage		BufferedImage to be checked for height
	 * @param displayWidth		Expected new width of image
	 * @param displayHeight		Expected new height of image
	 * @return					New image height by maintaining original aspect ratio
	 * @throws Exception
	 */
	public static int getDisplayImageHeight(BufferedImage bufferedImage, int displayWidth, int displayHeight)
	{
		int srcWidth = displayWidth;
		int srcHeight = displayHeight;

		if( bufferedImage != null )
		{
			srcWidth = bufferedImage.getWidth();
			srcHeight = bufferedImage.getHeight();
		}

		return getDisplayImageHeight(srcWidth, srcHeight, displayWidth, displayHeight);
	}

	/**
	 * Returns new width for given expected displayWidth/displayHeight by maintaining original (srcWidth/srcHeight) aspect ratio
	 * 
	 * @param srcWidth			Original Width
	 * @param srcHeight			Original Height
	 * @param displayWidth		Expected Width
	 * @param displayHeight		Expected Height
	 * @return					New width  by maintaining original (srcWidth/srcHeight) aspect ratio
	 * @throws Exception
	 */
	private static int getDisplayImageWidth(int srcWidth, int srcHeight, int displayWidth, int displayHeight)
	{
		int retWidth = displayWidth;

		double displayAspectRatio = (double)displayWidth / (double)displayHeight;
		double imageAspectRatio = (double)srcWidth / (double)srcHeight;

		// Modify the width
		if (displayAspectRatio >= imageAspectRatio)
		{
			retWidth = (int)(displayHeight * imageAspectRatio);
		} 

		return retWidth;
	}

	/**
	 * Returns new height for given expected displayWidth/displayHeight by maintaining original (srcWidth/srcHeight) aspect ratio
	 * 
	 * @param srcWidth			Original Width
	 * @param srcHeight			Original Height
	 * @param displayWidth		Expected Width
	 * @param displayHeight		Expected Height
	 * @return					New height  by maintaining original (srcWidth/srcHeight) aspect ratio
	 * @throws Exception
	 */
	private static int getDisplayImageHeight(int srcWidth, int srcHeight, int displayWidth, int displayHeight)
	{
		int retHeight = displayHeight;

		double displayAspectRatio = (double)displayWidth / (double)displayHeight;
		double imageAspectRatio = (double)srcWidth / (double)srcHeight;

		// Modify the height
		if (displayAspectRatio < imageAspectRatio)
		{
			retHeight = (int)(displayWidth / imageAspectRatio);
		} 

		return retHeight;
	}

	/**
	 * Resizes given image (as byte array) if its larger than expected size (resolution)
	 * 
	 * @param imageBytes	Image bytes to be resized
	 * @param width			Maximum allowed Width
	 * @param height		Maximum allowed Height
	 * @return				New image (as byte array) if the original image is larger that expected size, otherwise original image (as byte array)
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static byte[] resizeImage(byte[] imageBytes, int width, int height) throws IOException, InterruptedException
	{
		System.setProperty("java.awt.headless","true");
		Image image = Toolkit.getDefaultToolkit().createImage(imageBytes);

		MediaTracker mediaTracker = new MediaTracker(new Container());
		mediaTracker.addImage(image, 0);
		mediaTracker.waitForID(0);

		double imageResolution = image.getWidth(null) * image.getHeight(null);
		double maxResolution = width * height;

		// resize only if larger
		if (imageResolution > maxResolution)
		{
			return createImageFromBytes(imageBytes, width, height, 100);
		}

		return imageBytes;
	}

	/**
	 * Creates new resized image from given input file name as new given file name to given Width and Height by keeping given quality
	 *   
	 * @param inFilename	File path to be resized
	 * @param outFilename	File path to be used to create new resized image
	 * @param maxWidth		New expected width of resized image
	 * @param maxHeight		New expected height of resized image
	 * @param imgQuality	Quality of resulting resized image
	 * @throws Exception
	 */
	public static void createImage(String inFilename, String outFilename, int maxWidth, int maxHeight, int imgQuality) throws Exception 
	{
		// load image from INFILE
		System.setProperty("java.awt.headless","true");
		Image image = Toolkit.getDefaultToolkit().getImage(inFilename);

		byte[] imageBytes = getReziseImageBytes(image, maxWidth, maxHeight, imgQuality);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));

		out.write(imageBytes);
		out.flush();
		out.close();
	}

	/**
	 * Resizes given image (as byte array) to given Width and Height by keeping given quality
	 * 
	 * @param imageBytes	Image (as byte array) to be resized
	 * @param imgWidth		New expected Width of resulting image
	 * @param imgHeight		New expected Height of resulting image
	 * @param imgQuality	Quality of resulting resized image
	 * @return				Resized image as byte array
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static byte[] createImageFromBytes(byte[] imageBytes, int imgWidth, int imgHeight, int imgQuality) throws IOException, InterruptedException 
	{
		// load image from byte array
		System.setProperty("java.awt.headless","true");
		Image image = Toolkit.getDefaultToolkit().createImage(imageBytes);

		return getReziseImageBytes(image, imgWidth, imgHeight, imgQuality);
	}

	/**
	 * Resizes given image (that represents awt graphical images) to given Width and Height by keeping given quality
	 * 
	 * @param image			Image (that represents awt graphical images) to be resized
	 * @param maxWidth		New expected Width of resulting image
	 * @param maxHeight		New expected Height of resulting image
	 * @param imgQuality	Quality of resulting resized image 
	 * @return				Resized image as byte array
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static byte[] getReziseImageBytes(Image image, int maxWidth, int maxHeight, int imgQuality) throws IOException, InterruptedException 
	{
		// load image from INFILE
		System.setProperty("java.awt.headless","true");
		MediaTracker mediaTracker = new MediaTracker(new Container());
		mediaTracker.addImage(image, 0);
		mediaTracker.waitForID(0);

		double maxRatio = (double)maxWidth / (double)maxHeight;
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);
		double imageRatio = (double)imageWidth / (double)imageHeight;
		if (maxRatio < imageRatio) 
		{
			maxHeight = (int)(maxWidth / imageRatio);
		}
		else 
		{
			maxWidth = (int)(maxHeight * imageRatio);
		}

		// draw original image to thumbnail image object and
		// scale it to the new size on-the-fly
		BufferedImage outImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = outImage.createGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2D.drawImage(image, 0, 0, maxWidth, maxHeight, null);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.
		getDefaultJPEGEncodeParam(outImage);
		int quality = imgQuality;
		quality = Math.max(0, Math.min(quality, 100));
		param.setQuality((float)quality / 100.0f, false);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(outImage);

		byte[] resizeImgBytes = out.toByteArray();
		out.close(); 

		return resizeImgBytes;
	}
}